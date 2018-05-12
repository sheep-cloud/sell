package cn.colg.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import cn.colg.entity.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 订单详情
 *
 * @author colg
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class OrderDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 订单id */
    private String orderId;
    /** 买家姓名 */
    private String buyerName;
    /** 买家电话 */
    private String buyerPhone;
    /** 买家地址 */
    private String buyerAddress;
    /** 买家微信openid */
    private String buyerOpenid;
    /** 订单总金额 */
    private BigDecimal orderAmount;
    /** 订单状态（0新订单，1完结，2取消；默认0） */
    private Integer orderStatus;
    /** 支付状态（0等待支付，1支付成功；默认0） */
    private Integer payStatus;
    /** 创建时间 */
    private Date createTime;
    /** 修改时间 */
    private Date updateTime;

    /** 订单详情 */
    private List<OrderDetail> orderDetailList;
}
