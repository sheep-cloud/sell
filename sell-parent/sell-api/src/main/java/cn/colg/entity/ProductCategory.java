package cn.colg.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.colg.config.UuidGenId;
import cn.colg.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import tk.mybatis.mapper.annotation.KeySql;

/**
 * 商品类目 - @mbg.generated
 *
 * @author colg
 */
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "product_category")
public class ProductCategory extends BaseEntity {
    /**
     * 商品类目id
     */
    @Id
    @Column(name = "category_id")
    @KeySql(genId = UuidGenId.class)
    private String categoryId;

    /**
     * 类目名称
     */
    @Column(name = "category_name")
    private String categoryName;

    /**
     * 类目编号（唯一））
     */
    @Column(name = "category_type")
    private Integer categoryType;

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