package cn.colg.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import cn.colg.BaseTest;
import cn.colg.entity.ProductCategory;
import cn.hutool.core.collection.CollUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 *
 * @author colg
 */
@Slf4j
public class ProductCategoryServiceTest extends BaseTest {
    
    /**
     * Test method for {@link cn.colg.service.ProductCategoryService#findOne(java.lang.String)}.
     */
    @Test
    public void testFindOne() {
        String categoryId = "c791cbaa68204b5a81e1985186e44d1d";
        ProductCategory productCategory = productCategoryService.findOne(categoryId);
        assertNotNull(productCategory);
    }

    /**
     * Test method for {@link cn.colg.service.ProductCategoryService#findAll()}.
     */
    @Test
    public void testFindAll() {
        List<ProductCategory> list = productCategoryService.findAll();
        assertNotNull(list);
    }

    /**
     * Test method for {@link cn.colg.service.ProductCategoryService#selectByCategoryType(java.util.List)}.
     */
    @Test
    public void testSelectByCategoryType() {
        List<Integer> categoryTypeList = CollUtil.newArrayList(1);
        List<ProductCategory> list = productCategoryService.selectByCategoryType(categoryTypeList);
        assertNotNull(list);
    }

    /**
     * Test method for {@link cn.colg.service.ProductCategoryService#save(cn.colg.entity.ProductCategory)}.
     */
    @Ignore
    @Test
    public void testSave() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("儿童专享").setCategoryType(3);
        ProductCategory category = productCategoryService.save(productCategory);
        log.info("ProductCategoryServiceTest.testSave() >> category : {}", category);
    }

}
