package cn.colg.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 购物车（加减库存）
 *
 * @author colg
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class CartDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String productId;
    private Integer productQuantity;

}
