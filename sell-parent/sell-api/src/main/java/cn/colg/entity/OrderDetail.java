package cn.colg.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.colg.config.UUIdGenId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import tk.mybatis.mapper.annotation.KeySql;

/**
 * - @mbg.generated
 *
 * @author colg
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
@Table(name = "order_detail")
public class OrderDetail implements Serializable {
    /**
     * 订单明细id
     */
    @Id
    @KeySql(genId = UUIdGenId.class)
    @Column(name = "orere_detail_id")
    private String orereDetailId;

    /**
     * 订单id
     */
    @Column(name = "order_id")
    private String orderId;

    /**
     * 商品id
     */
    @Column(name = "product_id")
    private String productId;

    /**
     * 商品名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 商品价格
     */
    @Column(name = "product_price")
    private BigDecimal productPrice;

    /**
     * 商品数量
     */
    @Column(name = "product_quantity")
    private Integer productQuantity;

    /**
     * 商品图片
     */
    @Column(name = "product_icon")
    private String productIcon;

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

    /// ----------------------------------------------------------------------------------------------------

    public OrderDetail(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}