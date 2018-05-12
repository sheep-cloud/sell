package cn.colg.vo;

import java.io.Serializable;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 商品（包含类目）
 *
 * @author colg
 */
@Data
@Accessors(chain = true)
public class ProductVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 商品类目名称 */
    @JSONField(name = "name")
    private String categoryName;
    /** 商品类目编号 */
    @JSONField(name = "type")
    private Integer categoryType;

    /** 商品信息列表 */
    @JSONField(name = "foods")
    private List<ProductInfoVO> productInfoVOList;
}
