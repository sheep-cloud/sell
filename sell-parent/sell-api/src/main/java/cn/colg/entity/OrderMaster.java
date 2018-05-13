package cn.colg.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.colg.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * - @mbg.generated
 *
 * @author colg
 */
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "order_master")
public class OrderMaster extends BaseEntity {

    // TODO colg [不能使用自动生成主键，因为要先创建订单明细表，由订单明细表里的订单id，来决定订单表的id是什么]
    /**
     * 订单id
     */
    @Id
    @Column(name = "order_id")
    private String orderId;

    /**
     * 买家名称
     */
    @Column(name = "buyer_name")
    private String buyerName;

    /**
     * 买家电话
     */
    @Column(name = "buyer_phone")
    private String buyerPhone;

    /**
     * 买家地址
     */
    @Column(name = "buyer_address")
    private String buyerAddress;

    /**
     * 买家微信openid
     */
    @Column(name = "buyer_openid")
    private String buyerOpenid;

    /**
     * 订单总金额
     */
    @Column(name = "order_amount")
    private BigDecimal orderAmount;

    /**
     * 订单状态（0新订单，1完结，2取消；默认0）
     */
    @Column(name = "order_status")
    private Integer orderStatus;

    /**
     * 支付状态（0等待支付，1支付成功；默认0）
     */
    @Column(name = "pay_status")
    private Integer payStatus;

    /**
     * 创建时间
     */
    @Column(name = "create_time", insertable = false, updatable = false)
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time", insertable = false, updatable = false)
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}