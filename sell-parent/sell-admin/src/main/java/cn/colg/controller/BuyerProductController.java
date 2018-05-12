package cn.colg.controller;

import static cn.colg.util.ResultVOUtil.success;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.colg.core.BaseController;
import cn.colg.entity.ProductCategory;
import cn.colg.entity.ProductInfo;
import cn.colg.vo.ProductInfoVO;
import cn.colg.vo.ProductVO;
import cn.colg.vo.ResultVO;
import cn.hutool.core.bean.BeanUtil;

/**
 * 买家商品 Controller
 *
 * @author colg
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController extends BaseController {

    /**
     * 买家商品列表（包含类目）
     *
     * @return
     */
    @GetMapping("/list")
    public ResultVO list() {
        // 1. 查询所有的上架商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();

        /*
         * map：                接收Lambda，将元素转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
         * collect:  对集合数据进行抽取，
         */

        // 2. 查询类目（一次性查询）

        // 传统方法
        // List<Integer> categoryTypeList = new ArrayList<>();
        // for (ProductInfo productInfo : productInfoList) {
        // categoryTypeList.add(productInfo.getCategoryType());
        // }

        // 精简方法（Jva8，Lambda表达式）
        List<Integer> categoryTypeList = productInfoList.stream()
                                                        .map(e -> e.getCategoryType())
                                                        .collect(Collectors.toList());
        List<ProductCategory> productCategoryList = productCategoryService.selectByCategoryType(categoryTypeList);

        // 3. 数据拼接
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            String categoryName = productCategory.getCategoryName();
            Integer categoryType = productCategory.getCategoryType();

            // 封装商品（包含类目）
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(categoryName).setCategoryType(categoryType);

            // 封装详情
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(categoryType)) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    // 复制Bean对象属性
                    BeanUtil.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return success(productVOList);
    }
}
