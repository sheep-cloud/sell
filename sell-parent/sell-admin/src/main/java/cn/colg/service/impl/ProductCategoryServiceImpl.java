package cn.colg.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.colg.core.BaseServiceImpl;
import cn.colg.entity.ProductCategory;
import cn.colg.service.ProductCategoryService;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 *
 * @author colg
 */
@Slf4j
@Service
public class ProductCategoryServiceImpl extends BaseServiceImpl implements ProductCategoryService {

    @Override
    public ProductCategory findOne(String categoryId) {
        return productCategoryMapper.selectByPrimaryKey(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryMapper.selectAll();
    }

    @Override
    public List<ProductCategory> selectByCategoryType(List<Integer> categoryTypeList) {
        return productCategoryMapper.selectByCategoryType(categoryTypeList);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ProductCategory save(ProductCategory productCategory) {
        productCategoryMapper.insertSelective(productCategory);
        log.info("ProductCategoryServiceImpl.save() >> 保存的商品类目ID : {}", productCategory.getCategoryId());
        
        return this.findOne(productCategory.getCategoryId());
    }

}
