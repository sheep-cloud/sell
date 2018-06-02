package cn.colg.service;

import cn.colg.dto.OrderDto;

/**
 * 买家Service
 *
 * @author colg
 */
public interface BuyerService {

    /**
     * 查询一个订单
     *
     * @param openid 微信openid
     * @param orderId 订单id
     * @return 订单详情
     */
    OrderDto findOrderOne(String openid, String orderId);

    /**
     * 取消订单
     *
     * @param openid 微信openid
     * @param orderId 订单id
     * @return 订单详情
     */
    OrderDto cancelOrder(String openid, String orderId);
}
