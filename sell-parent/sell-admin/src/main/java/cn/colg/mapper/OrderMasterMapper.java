package cn.colg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.colg.entity.OrderMaster;

/**
 * - @mbg.generated
 *
 * @author colg
 */
public interface OrderMasterMapper extends tk.mybatis.mapper.common.Mapper<OrderMaster> {

    /**
     * 根据微信operid查询订单列表
     *
     * @param buyerOpenid
     * @return
     */
    List<OrderMaster> findList(@Param("buyerOpenid") String buyerOpenid);
}