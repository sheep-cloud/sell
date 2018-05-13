package cn.colg.core;

import org.springframework.beans.factory.annotation.Autowired;

import cn.colg.service.*;

/**
 * Controller 基础类
 *
 * @author colg
 */
public abstract class BaseController {

    @Autowired
    protected ProductCategoryService productCategoryService;
    @Autowired
    protected ProductInfoService productInfoService;
    @Autowired
    protected OrderService orderService;
    @Autowired
    protected BuyerService buyerService;
}
