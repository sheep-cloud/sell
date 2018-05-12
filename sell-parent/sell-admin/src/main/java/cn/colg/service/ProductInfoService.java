package cn.colg.service;

import java.util.List;

import cn.colg.dto.CartDto;
import cn.colg.entity.ProductInfo;
import cn.hutool.db.Page;

/**
 * 商品信息Service
 *
 * @author colg
 */
public interface ProductInfoService {

    /**
     * 根据商品信息id查询
     *
     * @param productId
     * @return
     */
    ProductInfo findOne(String productId);

    /**
     * 查询所有已上架商品列表
     *
     * @return
     */
    List<ProductInfo> findUpAll();

    /**
     * 分页查询商品列表
     *
     * @param page
     * @return
     */
    List<ProductInfo> findAll(Page page);

    /**
     * 新增商品
     *
     * @param productInfo
     * @return
     */
    ProductInfo save(ProductInfo productInfo);

    /**
     * 加库存
     *
     * @param cartDtoList
     */
    void increasStock(List<CartDto> cartDtoList);

    /**
     * 减库存
     *
     * @param cartDtoList
     */
    void decreaseStock(List<CartDto> cartDtoList);
}
