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

    /** 商品id */
    @JSONField(name = "id")
    private String productId;
    /** 商品名称 */
    @JSONField(name = "name")
    private String productName;
    /** 商品单价 */
    @JSONField(name = "price")
    private BigDecimal productPrice;
    /** 商品描述 */
    @JSONField(name = "description")
    private String productDescription;
    /** 商品小图 */
    @JSONField(name = "icon")
    private String productIcon;

}
