package cn.colg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.colg.entity.OrderDetail;

/**
 * - @mbg.generated
 *
 * @author colg
 */
public interface OrderDetailMapper extends tk.mybatis.mapper.common.Mapper<OrderDetail> {

    /**
     * 根据订单id查询订单明细列表
     *
     * @param orderId
     * @return
     */
    List<OrderDetail> selectByOrderId(@Param("orderId") String orderId);
}