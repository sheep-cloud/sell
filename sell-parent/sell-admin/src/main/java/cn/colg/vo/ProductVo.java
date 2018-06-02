package cn.colg.vo;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

import cn.colg.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 商品（包含类目）
 *
 * @author colg
 */
@Getter
@Setter
@Accessors(chain = true)
public class ProductVo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 商品类目名称 */
    @JSONField(name = "name")
    private String categoryName;
    /** 商品类目编号 */
    @JSONField(name = "type")
    private Integer categoryType;

    /** 商品信息列表 */
    @JSONField(name = "foods", ordinal = 1)
    private List<ProductInfoVo> productInfoVOList;
}
