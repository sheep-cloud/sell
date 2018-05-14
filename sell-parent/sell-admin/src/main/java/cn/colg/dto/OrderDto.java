package cn.colg.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

import cn.colg.core.BaseEntity;
import cn.colg.core.exception.CheckException;
import cn.colg.entity.OrderDetail;
import cn.colg.form.OrderForm;
import cn.colg.serializer.DateSerializer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

/**
 * 订单详情
 *
 * @author colg
 */
@Slf4j
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class OrderDto extends BaseEntity {

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
    @JSONField(serializeUsing = DateSerializer.class)
    private Date createTime;
    /** 修改时间 */
    @JSONField(serializeUsing = DateSerializer.class)
    private Date updateTime;

    /** 订单详情 */
    @JSONField(ordinal = 1)
    private List<OrderDetail> orderDetailList;

    /// ----------------------------------------------------------------------------------------------------

    /**
     * 包装创建订单的表单数据
     *
     * @param orderForm
     */
    public OrderDto(OrderForm orderForm) {
        // 转换购物车格式
        List<OrderDetail> orderDetailList = new ArrayList<>();
        String items = orderForm.getItems();
        try {
            orderDetailList = JSON.parseArray(items, OrderDetail.class);
        } catch (Exception e) {
            log.error("OrderDto.OrderDto(orderForm) >> 对象转换异常 : {}", items);
            throw new CheckException("【创建订单】参数不正确 : " + items);
        }

        this.buyerName = orderForm.getName();
        this.buyerPhone = orderForm.getPhone();
        this.buyerAddress = orderForm.getAddress();
        this.buyerOpenid = orderForm.getOpenid();
        this.orderDetailList = orderDetailList;
    }

}
