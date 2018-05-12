package cn.colg.service.impl;

import static cn.colg.util.CheckUtil.check;
import static cn.colg.util.CheckUtil.notNull;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.colg.core.BaseServiceImpl;
import cn.colg.dto.CartDto;
import cn.colg.dto.OrderDto;
import cn.colg.entity.OrderDetail;
import cn.colg.entity.OrderMaster;
import cn.colg.entity.ProductInfo;
import cn.colg.enums.OrderStatusEnum;
import cn.colg.enums.PayStatusEnum;
import cn.colg.service.OrderService;
import cn.colg.service.ProductInfoService;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.db.Page;
import lombok.extern.slf4j.Slf4j;

/**
 * 订单ServiceImpl
 *
 * @author colg
 */
@Slf4j
@Service
public class OrderServiceImpl extends BaseServiceImpl implements OrderService {

    @Autowired
    private ProductInfoService productInfoService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public OrderDto create(OrderDto orderDto) {
        /*
         * colg  创建订单逻辑
         *  1. 查询商品（数量，价格）
         *  2. 计算订单总价（商品单价*商品数量 + 每个订单的总价）
         *  3. 写入数据库（OrderMaster&OrderDetail）
         *  4. 扣库存
         */

        // 定义一个总价
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
        // 定义一个订单id（不能用自动生成的）
        String orderId = RandomUtil.simpleUUID();

        // 1. 查询商品（数量，价格）
        List<OrderDetail> orderDetailList = orderDto.getOrderDetailList();
        for (OrderDetail orderDetail : orderDetailList) {
            ProductInfo productInfo = productInfoService.findOne(orderDetail.getProductId());
            notNull(productInfo, "商品不存在");
            log.info("OrderServiceImpl.create() >> 商品ID : {}", productInfo.getProductId());

            // 2. 计算订单总价（商品单价*商品数量 + 每个订单的总价）
            orderAmount = productInfo.getProductPrice()
                                     .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                                     .add(orderAmount);
            
            // 订单详情入库
            BeanUtil.copyProperties(productInfo, orderDetail);
            orderDetail.setOrderId(orderId);
            orderDetailMapper.insertSelective(orderDetail);
        }

        // 3. 写入数据库（OrderMaster&OrderDetail）
        OrderMaster orderMaster = new OrderMaster();
        BeanUtil.copyProperties(orderDto, orderMaster);
        orderMaster.setOrderId(orderId)
                   .setOrderAmount(orderAmount);
        orderMasterMapper.insertSelective(orderMaster);

        // 4. 扣库存
        List<CartDto> cartDtoList = orderDetailList.stream()
                                                   .map(e -> new CartDto(e.getProductId(), e.getProductQuantity()))
                                                   .collect(Collectors.toList());
        productInfoService.decreaseStock(cartDtoList);
        return orderDto;
    }

    @Override
    public OrderDto findOne(String orderId) {
        OrderMaster orderMaster = orderMasterMapper.selectByPrimaryKey(orderId);
        notNull(orderMaster, "订单不存在");
        log.info("OrderServiceImpl.findOne() >> 订单ID : {}", orderMaster.getOrderId());
        
        List<OrderDetail> orderDetailList = orderDetailMapper.selectByOrderId(orderId);
        check(CollUtil.isNotEmpty(orderDetailList), "订单详情不存在");
        log.info("OrderServiceImpl.findOne() >> 订单明细数量 : {}", orderDetailList.size());
        
        OrderDto orderDto = new OrderDto();
        BeanUtil.copyProperties(orderMaster, orderDto);
        orderDto.setOrderDetailList(orderDetailList);
        
        return orderDto;
    }

    @Override
    public List<OrderDto> findList(String buyerOpenid, Page page) {
        List<OrderMaster> orderMasterList = PageHelper.startPage(page.getPageNumber(), page.getPageSize())
                                                      .doSelectPage(() -> orderMasterMapper.findList(buyerOpenid));

        List<OrderDto> orderDtoList = orderMasterList.stream()
                                                     .map(e -> this.findOne(e.getOrderId()))
                                                     .collect(Collectors.toList());
        
        return orderDtoList;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public OrderDto cancel(OrderDto orderDto) {
        /*
         * colg  取消订单逻辑
         *  1. 判断订单状态
         *  2. 修改订单状态
         *  3. 返回库存
         *  4. 如果已支付，需要退款
         */
        
        // 判断订单状态
        check(orderDto.getOrderStatus().intValue() == OrderStatusEnum.NEW.getStatus().intValue(), "订单状态不正确");
        log.info("OrderServiceImpl.cancel() >> 订单ID : {}, 订单状态 : {}", orderDto.getOrderId(), orderDto.getOrderStatus());
        
        // 修改订单状态
        OrderMaster orderMaster = new OrderMaster();
        BeanUtil.copyProperties(orderDto, orderMaster);
        orderMaster.setOrderStatus(OrderStatusEnum.CANCEL.getStatus());
        orderMasterMapper.updateByPrimaryKeySelective(orderMaster);
        
        // 返回库存（加库存）
        List<OrderDetail> orderDetailList = orderDto.getOrderDetailList();
        check(CollUtil.isNotEmpty(orderDetailList), "订单中无商品详情");
        
        List<CartDto> cartDtoList = orderDetailList.stream()
                                                   .map(e -> new CartDto(e.getProductId(), e.getProductQuantity()))
                                                   .collect(Collectors.toList());
        productInfoService.increasStock(cartDtoList);
        
        // 如果已支付，需要退款
        if (orderDto.getPayStatus().equals(PayStatusEnum.SUCCESS.getStatus())) {
            // TODO colg [支付]
        }
        
        return orderDto;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public OrderDto finish(OrderDto orderDto) {
        return null;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public OrderDto paid(OrderDto orderDto) {
        return null;
    }

}
