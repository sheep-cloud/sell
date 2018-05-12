package cn.colg.mapper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.colg.BaseTest;
import cn.colg.entity.ProductCategory;
import cn.hutool.core.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 测试通用mapper、分页插件
 *
 * @author colg
 */
@Slf4j
public class MapperAndPageHelperTest extends BaseTest {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Test
    public void testInsert() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(RandomUtil.simpleUUID())
                       .setCategoryName("女生最爱")
                       .setCategoryType(1);
        productCategoryMapper.insertSelective(productCategory);
    }
    
    @Test
    public void testUpdate() {
        ProductCategory productCategory = productCategoryMapper.selectAll().get(0);
        productCategory.setCategoryName("男生最爱");
        productCategoryMapper.updateByPrimaryKeySelective(productCategory);
    }
    
    @Test
    public void testSelectAll() {
        Page<Object> page = PageHelper.startPage(1, 10).doSelectPage(() -> productCategoryMapper.selectAll());
        log.info("MapperAndPageHelperTest.testSelectAll() >> page : {}", page);
    }

}
