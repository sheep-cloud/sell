package cn.colg.service.impl;

import static cn.colg.util.CheckUtil.check;
import static cn.colg.util.CheckUtil.notNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.colg.core.BaseServiceImpl;
import cn.colg.dto.OrderDto;
import cn.colg.service.BuyerService;
import cn.colg.service.OrderService;
import lombok.extern.slf4j.Slf4j;

/**
 * 买家ServiceImpl
 *
 * @author colg
 */
@Slf4j
@Service
public class BuyerServiceImpl extends BaseServiceImpl implements BuyerService {

    @Autowired
    private OrderService orderService;

    @Override
    public OrderDto findOrderOne(String openid, String orderId) {
        return checkOrderOwner(openid, orderId);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public OrderDto cancelOrder(String openid, String orderId) {
        OrderDto orderDto = checkOrderOwner(openid, orderId);
        notNull(orderDto, "查不到该订单");
        log.info("BuyerServiceImpl.findOrderOne() >> 查询到的订单ID : {}", orderDto.getOrderId());
        
        return orderService.cancel(orderDto);
    }

    /**
     * 校验订单的openid是否和用户的一致
     *
     * @param openid
     * @param orderId
     * @return
     */
    private OrderDto checkOrderOwner(String openid, String orderId) {
        OrderDto orderDto = orderService.findOne(openid);
        if (orderDto == null) {
            return null;
        }
        // 判断是否是自己的订单
        check(openid.equalsIgnoreCase(orderDto.getBuyerOpenid()), "订单的openid不一致");
        log.info("BuyerServiceImpl.findOrderOne() >> 订单的openid : {}", orderId);
        return orderDto;
    }

}
