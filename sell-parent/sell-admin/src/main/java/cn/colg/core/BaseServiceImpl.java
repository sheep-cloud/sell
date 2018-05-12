package cn.colg.core;

import org.springframework.beans.factory.annotation.Autowired;

import cn.colg.mapper.*;

/**
 * ServiceImpl 基础类
 *
 * @author colg
 */
public abstract class BaseServiceImpl {

    @Autowired
    protected OrderDetailMapper orderDetailMapper;
    @Autowired
    protected OrderMasterMapper orderMasterMapper;
    @Autowired
    protected ProductCategoryMapper productCategoryMapper;
    @Autowired
    protected ProductInfoMapper productInfoMapper;
}
