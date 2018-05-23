package cn.colg.service;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import cn.colg.BaseTest;
import cn.colg.entity.ProductInfo;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 *
 * @author colg
 */
@Slf4j
public class ProductInfoServiceTest extends BaseTest {

    /**
     * Test method for {@link cn.colg.service.ProductInfoService#findOne(java.lang.String)}.
     */
    @Test
    public void testFindOne() {
        String productId = "e26b356109f546aeb25c8044a62e93dd";
        ProductInfo productInfo = productInfoService.findOne(productId);
        log.info("ProductInfoServiceTest.testFindOne() >> productInfo : {}", productInfo);
        assertNotNull(productInfo);
    }

    /**
     * Test method for {@link cn.colg.service.ProductInfoService#findUpAll()}.
     */
    @Test
    public void testFindUpAll() {
        List<ProductInfo> list = productInfoService.findUpAll();
        log.info("ProductInfoServiceTest.testFindUpAll() >> list : {}", list);
        assertNotNull(list);
    }

    /**
     * Test method for {@link cn.colg.service.ProductInfoService#findAll(cn.hutool.PageBean.Page)}.
     */
    @Test
    public void testFindAll() {
        List<ProductInfo> list = productInfoService.findAll(1, 10);
        log.info("ProductInfoServiceTest.testFindAll() >> list : {}", list);
        assertNotNull(list);
    }

    /**
     * Test method for {@link cn.colg.service.ProductInfoService#save(cn.colg.entity.ProductInfo)}.
     */
    @Ignore
    @Test
    public void testSave() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setCategoryType(2)
                   .setProductName("皮蛋瘦肉粥")
                   .setProductPrice(new BigDecimal(3.2))
                   .setProductStock(100)
                   .setProductDescription("皮蛋瘦肉粥是一种广东省的地方传统名小吃。皮蛋瘦肉粥营养丰富，以切成小块的皮蛋及咸瘦肉为配料。不同地区的配料有所不同，有人会在进食前加上香油及葱花，也有加葱花或薄脆。")
                   .setProductIcon("http://ww1.sinaimg.cn/large/005PjuVtgy1fr85kggb1qj30h909en5b.jpg")
                   ;
        
        ProductInfo productInfo2 = new ProductInfo();
        productInfo2.setCategoryType(2)
                   .setProductName("清蒸皮皮虾")
                   .setProductPrice(new BigDecimal(3.5))
                   .setProductStock(100)
                   .setProductDescription("清蒸皮皮虾，一道海鲜类菜品，以虾为主料。皮皮虾又叫虾蛄，因为皮皮虾一离水尾部会有液体流出，因而又叫濑尿虾，它的肉质非常鲜甜可口。")
                   .setProductIcon("http://ww1.sinaimg.cn/large/005PjuVtgy1fr85jngsjxj30l40duhbm.jpg")
                   ;
        
        ProductInfo productInfo3 = new ProductInfo();
        productInfo3.setCategoryType(1)
                   .setProductName("芒果冰")
                   .setProductPrice(new BigDecimal(4.5))
                   .setProductStock(100)
                   .setProductDescription("芒果冰，是台湾的一款夏日冰品。它加入的是新鲜的芒果、炼乳以及芒果冰激凌覆盖在挫冰或绵绵冰上面，有着清凉解暑的功用。")
                   .setProductIcon("http://ww1.sinaimg.cn/large/005PjuVtgy1fr85i03o1sj30g70b0dws.jpg")
                   ;
        ProductInfo info = productInfoService.save(productInfo3);
        log.info("ProductInfoServiceTest.testSave() >> info : {}", info);
    }

}
