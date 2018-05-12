package cn.colg.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 支付状态枚举
 *
 * @author colg
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum PayStatusEnum {

    /** 支付状态：等待支付 */
    WAIT                                        (0, "等待支付"),
    /** 支付状态：支付成功 */
    SUCCESS                                     (1, "支付成功")
    ;
    
    private Integer status;
    private String msg;
}
