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

    @JSONField(name = "name")
    private String categoryName;
    @JSONField(name = "type")
    private Integer categoryType;

    @JSONField(name = "foods")
    private List<ProductInfoVO> productInfoVOList;
}
