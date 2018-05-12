package cn.colg.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 商品详情
 *
 * @author colg
 */
@Data
@Accessors(chain = true)
public class ProductInfoVO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @JSONField(name = "id")
    private String productId;
    @JSONField(name = "name")
    private String productName;
    @JSONField(name = "price")
    private BigDecimal productPrice;
    @JSONField(name = "description")
    private String productDescription;
    @JSONField(name = "icon")
    private String productIcon;

}
