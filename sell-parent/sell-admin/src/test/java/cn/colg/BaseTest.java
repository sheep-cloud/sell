package cn.colg;

import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.colg.service.*;
import lombok.extern.slf4j.Slf4j;

/**
 * 测试基础类
 *
 * @author colg
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public abstract class BaseTest {

    @Autowired
    protected ProductCategoryService productCategoryService;
    @Autowired
    protected ProductInfoService productInfoService;
    @Autowired
    protected OrderService orderService;

    @After
    public void tearDown() throws Exception {
        log.info("----------------------------------------------------------------------------------------------------\n");
    }
}