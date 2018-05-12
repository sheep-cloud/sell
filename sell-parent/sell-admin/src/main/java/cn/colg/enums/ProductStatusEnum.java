package cn.colg.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 商品状态枚举
 *
 * @author colg
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum ProductStatusEnum {

    /** 商品状态：正常 */
    UP                                          (0, "正常"),
    /** 商品状态：下架 */
    DOWN                                        (1, "下架")
    ;
    
    private Integer status;
    private String msg;
}
