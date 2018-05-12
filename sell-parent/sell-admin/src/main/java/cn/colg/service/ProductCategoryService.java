package cn.colg.service;

import java.util.List;

import cn.colg.entity.ProductCategory;

/**
 * 商品类目Service
 *
 * @author colg
 */
public interface ProductCategoryService {

    /**
     * 根据id查询商品类目
     *
     * @param categoryId
     * @return
     */
    ProductCategory findOne(String categoryId);

    /**
     * 查询所有商品类目
     *
     * @return
     */
    List<ProductCategory> findAll();

    /**
     * 通过类目编号批量查询
     *
     * @param categoryTypeList
     * @return
     */
    List<ProductCategory> selectByCategoryType(List<Integer> categoryTypeList);

    /**
     * 新增商品类目
     *
     * @param productCategory
     * @return
     */
    ProductCategory save(ProductCategory productCategory);

}
