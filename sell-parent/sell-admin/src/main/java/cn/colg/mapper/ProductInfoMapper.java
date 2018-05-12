package cn.colg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.colg.entity.ProductInfo;

/**
 * - @mbg.generated
 *
 * @author colg
 */
public interface ProductInfoMapper extends tk.mybatis.mapper.common.Mapper<ProductInfo> {

    /**
     * 根据商品状态获取商品列表
     *
     * @param status
     * @return
     */
    List<ProductInfo> findUpAll(@Param("status") Integer status);
}