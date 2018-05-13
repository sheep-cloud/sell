package cn.colg.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.colg.core.BaseServiceImpl;
import cn.colg.entity.ProductCategory;
import cn.colg.entity.ProductInfo;
import cn.colg.service.ProductCategoryService;
import cn.colg.service.ProductInfoService;
import cn.colg.vo.ProductInfoVO;
import cn.colg.vo.ProductVO;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 *
 * @author colg
 */
@Slf4j
@Service
public class ProductCategoryServiceImpl extends BaseServiceImpl implements ProductCategoryService {
    
    @Autowired
    private ProductInfoService productInfoService;

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

    @Override
    public List<ProductVO> list() {
        /*
         * colg [获取买家商品列表（包含类目）]
         *  1. 查询所有的上架商品
         *  2. 查询上架商品的所有类目（一次性查询）
         *  3. 数据拼接
         *      3.1 封装商品（包含类目）
         *      3.2 封装详情
         */
        
        // 查询所有的上架商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();
        
        // 查询上架商品的所有类目（一次性查询）
        
        // 传统方法
        /*
        List<Integer> categoryTypeList = new ArrayList<>();
        for (ProductInfo productInfo : productInfoList) {
            categoryTypeList.add(productInfo.getCategoryType());
        }
        */
        
        // 精简方法（Jva8，Lambda表达式）
        List<Integer> categoryTypeList = productInfoList.stream()
                                                        .map(e -> e.getCategoryType())
                                                        .collect(Collectors.toList());
        // 数据拼接
        List<ProductVO> productVOList = new ArrayList<>();
        
        if (CollUtil.isNotEmpty(categoryTypeList)) {
            // 通过类目编号批量查询
            List<ProductCategory> productCategorieList = this.selectByCategoryType(categoryTypeList);
            for (ProductCategory productCategory : productCategorieList) {
                String categoryName = productCategory.getCategoryName();
                Integer categoryType = productCategory.getCategoryType();
                
                // 封装商品（包含类目）
                ProductVO productVO = new ProductVO();
                productVO.setCategoryName(categoryName)
                         .setCategoryType(categoryType);
                
                // 封装详情
                List<ProductInfoVO> productInfoVOList = new ArrayList<>();
                for (ProductInfo productInfo : productInfoList) {
                    if (productInfo.getCategoryType().intValue() == categoryType.intValue()) {
                        ProductInfoVO productInfoVO = new ProductInfoVO();
                        // 复制Bean的对象属性
                        BeanUtil.copyProperties(productInfo, productInfoVO);
                        productInfoVOList.add(productInfoVO);
                    }
                }
                productVO.setProductInfoVOList(productInfoVOList);
                productVOList.add(productVO);
            }
        }
        
        return productVOList;
    }

}
