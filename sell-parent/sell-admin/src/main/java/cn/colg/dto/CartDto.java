package cn.colg.dto;

import cn.colg.core.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 购物车（加减库存）
 *
 * @author colg
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class CartDto extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 商品id */
    private String productId;
    /** 商品数量 */
    private Integer productQuantity;
}
