package cn.colg.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 订单状态枚举
 *
 * @author colg
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum OrderStatusEnum {
    
    /** 订单状态：新订单 */
    NEW                                         (0, "新订单"),
    /** 订单状态：完结 */
    FINISHED                                    (1, "完结"),
    /** 订单状态：已取消 */
    CANCEL                                      (2, "已取消")
    ;

    private Integer status;
    private String msg;
}
