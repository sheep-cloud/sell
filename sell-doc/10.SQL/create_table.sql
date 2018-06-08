DROP TABLE IF EXISTS order_detail;

DROP TABLE IF EXISTS order_master;

DROP TABLE IF EXISTS product_category;

DROP TABLE IF EXISTS product_info;

/*==============================================================*/
/* Table: order_detail                                          */
/*==============================================================*/
CREATE TABLE order_detail
(
   orere_detail_id      VARCHAR(64) NOT NULL COMMENT '订单明细id',
   order_id             VARCHAR(64) COMMENT '订单id',
   product_id           VARCHAR(64) COMMENT '商品id',
   product_name         VARCHAR(64) COMMENT '商品名称',
   product_price        DECIMAL(10,2) COMMENT '商品价格',
   product_quantity     INT COMMENT '商品数量',
   product_icon         VARCHAR(512) COMMENT '商品图片',
   create_time          TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   update_time          TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
   PRIMARY KEY (orere_detail_id)
);

ALTER TABLE order_detail COMMENT '订单明细表';

/*==============================================================*/
/* Index: idx_product_id                                        */
/*==============================================================*/
CREATE INDEX idx_product_id ON order_detail
(
   product_id
);

/*==============================================================*/
/* Index: idx_order_id                                          */
/*==============================================================*/
CREATE INDEX idx_order_id ON order_detail
(
   order_id
);

/*==============================================================*/
/* Table: order_master                                          */
/*==============================================================*/
CREATE TABLE order_master
(
   order_id             VARCHAR(64) NOT NULL COMMENT '订单id',
   buyer_name           VARCHAR(64) COMMENT '买家名称',
   buyer_phone          VARCHAR(32) COMMENT '买家电话',
   buyer_address        VARCHAR(256) COMMENT '买家地址',
   buyer_openid         VARCHAR(64) COMMENT '买家微信openid',
   order_amount         DECIMAL(10,2) COMMENT '订单总金额',
   order_status         TINYINT DEFAULT 0 COMMENT '订单状态（默认0新下单）',
   pay_status           TINYINT DEFAULT 0 COMMENT '支付状态（默认0未支付）',
   create_time          TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   update_time          TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
   PRIMARY KEY (order_id)
);

ALTER TABLE order_master COMMENT '订单表';

/*==============================================================*/
/* Index: index_buyer_openid                                    */
/*==============================================================*/
CREATE INDEX index_buyer_openid ON order_master
(
   buyer_openid
);

/*==============================================================*/
/* Table: product_category                                      */
/*==============================================================*/
CREATE TABLE product_category
(
   category_id          VARCHAR(64) NOT NULL COMMENT '商品类目id',
   category_name        VARCHAR(64) COMMENT '类目名称',
   category_type        INT NOT NULL COMMENT '类目编号（唯一））',
   create_time          TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   update_time          TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
   PRIMARY KEY (category_id),
   KEY AK_uqe_category_type (category_type)
);

ALTER TABLE product_category COMMENT '商品类目表';

/*==============================================================*/
/* Index: uqe_category_type                                     */
/*==============================================================*/
CREATE UNIQUE INDEX uqe_category_type ON product_category
(
   category_type
);

/*==============================================================*/
/* Table: product_info                                          */
/*==============================================================*/
CREATE TABLE product_info
(
   product_id           VARCHAR(64) NOT NULL COMMENT '商品id',
   category_type        INT COMMENT '商品类目编号',
   product_name         VARCHAR(64) COMMENT '名称',
   product_price        DECIMAL(10,2) COMMENT '单价',
   product_stock        INT COMMENT '库存',
   product_description  VARCHAR(512) COMMENT '描述',
   product_icon         VARCHAR(512) COMMENT '小图',
   product_status       TINYINT DEFAULT 0 COMMENT '状态（0正常，1下架；默认0）',
   create_time          TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   update_time          TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
   PRIMARY KEY (product_id)
);

ALTER TABLE product_info COMMENT '商品信息表';

ALTER TABLE order_detail ADD CONSTRAINT FK_Reference_3 FOREIGN KEY (product_id)
      REFERENCES product_info (product_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE product_info ADD CONSTRAINT FK_Reference_1 FOREIGN KEY (category_type)
      REFERENCES product_category (category_type) ON DELETE RESTRICT ON UPDATE RESTRICT;
