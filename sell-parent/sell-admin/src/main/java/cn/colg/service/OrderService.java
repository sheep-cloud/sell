package cn.colg.service;

import java.util.List;

import cn.colg.dto.OrderDto;

/**
 * 订单Service
 *
 * @author colg
 */
public interface OrderService {

    /**
     * 创建订单
     *
     * @param orderDto
     * @return
     */
    OrderDto create(OrderDto orderDto);

    /**
     * 根据id查询订单
     *
     * @param orderId
     * @return
     */
    OrderDto findOne(String orderId);

    /**
     * 根据买家微信openid分页查询订单列表
     *
     * @param buyerOpenid
     * @param page
     * @param size
     * @return
     */
    List<OrderDto> findList(String buyerOpenid, Integer page, Integer size);

    /**
     * 取消订单
     *
     * @param orderDto
     * @return
     */
    OrderDto cancel(OrderDto orderDto);

    /**
     * 完结订单
     *
     * @param orderDto
     * @return
     */
    OrderDto finish(OrderDto orderDto);

    /**
     * 支付订单
     *
     * @param orderDto
     * @return
     */
    OrderDto paid(OrderDto orderDto);
}
