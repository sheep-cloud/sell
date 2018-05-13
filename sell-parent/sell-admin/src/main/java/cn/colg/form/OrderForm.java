package cn.colg.form;

import cn.colg.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 订单表单数据
 *
 * @author colg
 */
@Getter
@Setter
public class OrderForm extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 买家姓名 */
    private String name;
    /** 买家电话 */
    private String phone;
    /** 买家地址 */
    private String address;
    /** 买家微信openid */
    private String openid;
    /** 购物车（买家商品） */
    private String items;
}
