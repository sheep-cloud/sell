package cn.colg.service;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import cn.colg.BaseTest;
import cn.colg.dto.OrderDto;
import cn.colg.entity.OrderDetail;
import cn.hutool.core.collection.CollUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 订单Service 测试
 *
 * @author colg
 */
@Slf4j
public class OrderServiceTest extends BaseTest {
    
    
    public static final String BUYER_OPENID = "1101110";

    /**
     * Test method for {@link cn.colg.service.OrderService#create(cn.colg.dto.OrderDto)}.
     */
    @Ignore
    @Test
    public void testCreate() {
        OrderDto orderDto = new OrderDto();
        orderDto.setBuyerName("快乐风男")
                .setBuyerAddress("MSI 全球冠军总决赛/FNC/蓝方中单")
                .setBuyerPhone("18727019900")
                .setBuyerOpenid(BUYER_OPENID)
                .setOrderDetailList(CollUtil.newArrayList(
                    // 购物车
                    new OrderDetail("7fae82066844431bb7d52da845c52f9c", 2),
                    new OrderDetail("dccf82ad408f4fa8bd0cd495825ce27d", 3),
                    new OrderDetail("e26b356109f546aeb25c8044a62e93dd", 1)
                ));
        
        OrderDto result = orderService.create(orderDto);
        log.info("OrderServiceTest.testCreate() >> result : {}", result);
    }

    /**
     * Test method for {@link cn.colg.service.OrderService#findOne(java.lang.String)}.
     */
    @Test
    public void testFindOne() {
        String orderId = "c55e55028a8c48a2b623ae02a01e091f";
        OrderDto orderDto = orderService.findOne(orderId);
        log.info("OrderServiceTest.testFindOne() >> orderDto : {}", orderDto);
    }

    /**
     * Test method for {@link cn.colg.service.OrderService#findList(java.lang.String, cn.hutool.PageBean.Page)}.
     */
    @Test
    public void testFindList() {
        List<OrderDto> orderDtoList = orderService.findList(BUYER_OPENID, 1, 10);
        log.info("OrderServiceTest.testFindList() >> orderDtoList : {}", orderDtoList);
    }

    /**
     * Test method for {@link cn.colg.service.OrderService#cancel(cn.colg.dto.OrderDto)}.
     */
    @Ignore
    @Test
    public void testCancel() {
        String orderId = "5aca32acd86f4be586b197b2d9aa0f6c";
        OrderDto orderDto = orderService.findOne(orderId);
        OrderDto dto = orderService.cancel(orderDto );
        log.info("OrderServiceTest.testCancel() >> 取消订单 : {}", dto);
    }

    /**
     * Test method for {@link cn.colg.service.OrderService#finish(cn.colg.dto.OrderDto)}.
     */
    @Ignore
    @Test
    public void testFinish() {
        String orderId = "c55e55028a8c48a2b623ae02a01e091f";
        OrderDto orderDto = orderService.findOne(orderId);
        OrderDto dto = orderService.finish(orderDto);
        log.info("OrderServiceTest.testFinish() >> 完结订单 : {}", dto);
    }

    /**
     * Test method for {@link cn.colg.service.OrderService#paid(cn.colg.dto.OrderDto)}.
     */
    @Ignore
    @Test
    public void testPaid() {
        String orderId = "c55e55028a8c48a2b623ae02a01e091f";
        OrderDto orderDto = orderService.findOne(orderId);
        OrderDto dto = orderService.paid(orderDto);
        log.info("OrderServiceTest.testPaid() >> 支付订单 : {}", dto);
    }
    
}
