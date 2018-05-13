package cn.colg.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.colg.config.UUIdGenId;
import cn.colg.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import tk.mybatis.mapper.annotation.KeySql;

/**
 * - @mbg.generated
 *
 * @author colg
 */
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "product_info")
public class ProductInfo extends BaseEntity {
    /**
     * 商品id
     */
    @Id
    @Column(name = "product_id")
    @KeySql(genId = UUIdGenId.class)
    private String productId;

    /**
     * 商品类目编号
     */
    @Column(name = "category_type")
    private Integer categoryType;

    /**
     * 名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 单价
     */
    @Column(name = "product_price")
    private BigDecimal productPrice;

    /**
     * 库存
     */
    @Column(name = "product_stock")
    private Integer productStock;

    /**
     * 描述
     */
    @Column(name = "product_description")
    private String productDescription;

    /**
     * 小图
     */
    @Column(name = "product_icon")
    private String productIcon;

    /**
     * 状态（0正常，1下架；默认0）
     */
    @Column(name = "product_status")
    private Integer productStatus;

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