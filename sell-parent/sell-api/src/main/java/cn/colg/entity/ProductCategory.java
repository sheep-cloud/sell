package cn.colg.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import cn.colg.config.UUIdGenId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import tk.mybatis.mapper.annotation.KeySql;

/**
 * 商品类目 - @mbg.generated
 *
 * @author colg
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
@Table(name = "product_category")
public class ProductCategory implements Serializable {
    /**
     * 商品类目id
     */
    @Id
    @Column(name = "category_id")
    @KeySql(genId = UUIdGenId.class)
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