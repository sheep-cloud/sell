package cn.colg.service.impl;

import static cn.colg.util.CheckUtil.check;
import static cn.colg.util.CheckUtil.notNull;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.colg.core.BaseServiceImpl;
import cn.colg.dto.CartDto;
import cn.colg.entity.ProductInfo;
import cn.colg.enums.ProductStatusEnum;
import cn.colg.service.ProductInfoService;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 *
 * @author colg
 */
@Slf4j
@Service
public class ProductInfoServiceImpl extends BaseServiceImpl implements ProductInfoService {

    @Override
    public ProductInfo findOne(String productId) {
        return productInfoMapper.selectByPrimaryKey(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoMapper.findUpAll(ProductStatusEnum.UP.getStatus());
    }

    @Override
    public List<ProductInfo> findAll(Integer page, Integer size) {
        return PageHelper.startPage(page, size)
                         .doSelectPage(() -> productInfoMapper.selectAll());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ProductInfo save(ProductInfo productInfo) {
        productInfoMapper.insertSelective(productInfo);
        log.info("ProductInfoServiceImpl.save() >> 保存的商品ID : {}", productInfo.getProductId());

        return this.findOne(productInfo.getProductId());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void increasStock(List<CartDto> cartDtoList) {
        for (CartDto cartDto : cartDtoList) {
            ProductInfo productInfo = this.findOne(cartDto.getProductId());
            // 校验
            notNull(productInfo, "商品不存在");
            
            // 加库存
            Integer result = productInfo.getProductStock() + cartDto.getProductQuantity();
            
            productInfo.setProductStock(result);
            productInfoMapper.updateByPrimaryKeySelective(productInfo);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void decreaseStock(List<CartDto> cartDtoList) {
        for (CartDto cartDto : cartDtoList) {
            ProductInfo productInfo = this.findOne(cartDto.getProductId());
            // 校验
            notNull(productInfo, "商品不存在");

            // 减库存
            Integer result = productInfo.getProductStock() - cartDto.getProductQuantity();
            check(result > 0, "商品库存不正确");

            productInfo.setProductStock(result);
            productInfoMapper.updateByPrimaryKeySelective(productInfo);
        }

    }

}
