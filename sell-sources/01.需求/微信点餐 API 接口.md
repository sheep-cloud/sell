# 微信点餐系统 API 接口

## 1、商品列表

- 接口：GET http://localhost:8001/sell/buyer/product/list
- 入参：
- 出参：

```json
{
    "code": 0,
    "msg": "success",
    "data": [
        {
            "name": "男生专享",
            "type": 2,
            "foods": [
                {
                    "description": "清蒸皮皮虾，一道海鲜类菜品，以虾为主料。皮皮虾又叫虾蛄，因为皮皮虾一离水尾部会有液体流出，因而又叫濑尿虾，它的肉质非常鲜甜可口。",
                    "icon": "http://ww1.sinaimg.cn/large/005PjuVtgy1fr85jngsjxj30l40duhbm.jpg",
                    "id": "7fae82066844431bb7d52da845c52f9c",
                    "name": "清蒸皮皮虾",
                    "price": 3.5
                },
                {
                    "description": "皮蛋瘦肉粥是一种广东省的地方传统名小吃。皮蛋瘦肉粥营养丰富，以切成小块的皮蛋及咸瘦肉为配料。不同地区的配料有所不同，有人会在进食前加上香油及葱花，也有加葱花或薄脆。",
                    "icon": "http://ww1.sinaimg.cn/large/005PjuVtgy1fr85kggb1qj30h909en5b.jpg",
                    "id": "e26b356109f546aeb25c8044a62e93dd",
                    "name": "皮蛋瘦肉粥",
                    "price": 3.2
                }
            ]
        },
        {
            "name": "女生专享",
            "type": 1,
            "foods": [
                {
                    "description": "芒果冰，是台湾的一款夏日冰品。它加入的是新鲜的芒果、炼乳以及芒果冰激凌覆盖在挫冰或绵绵冰上面，有着清凉解暑的功用。",
                    "icon": "http://ww1.sinaimg.cn/large/005PjuVtgy1fr85i03o1sj30g70b0dws.jpg",
                    "id": "dccf82ad408f4fa8bd0cd495825ce27d",
                    "name": "芒果冰",
                    "price": 4.5
                }
            ]
        }
    ]
}
```

## 2、创建订单

- 接口：POST  http://localhost:8001/sell/buyer/order/create
- 入参：

```json
name:快乐风男
phone:18727019900
address:MSI 全球冠军总决赛/FNC/蓝方中单
openid:1101110
items:[{"productId":"e26b356109f546aeb25c8044a62e93dd","productQuantity":2},{"productId":"7fae82066844431bb7d52da845c52f9c","productQuantity":1}]
```



- 出参：

```json
{
    "code": 0,
    "msg": "success",
    "data": {
        "orderId": "2bc75c68ed6e4ba882e4e0c7c0cd17f4"
    }
}
```

## 3、订单列表

-   接口：GET http://localhost:8001/sell/buyer/order/list
-   入参：

```json
openid:1101110
page:1
size:10
```



-   出参：

```json
{
    "code": 0,
    "msg": "success",
    "data": [
        {
            "buyerAddress": "MSI 全球冠军总决赛/FNC/蓝方中单",
            "buyerName": "快乐风男",
            "buyerOpenid": "1101110",
            "buyerPhone": "18727019900",
            "createTime": 1526166122,
            "orderAmount": 9.9,
            "orderId": "2bc75c68ed6e4ba882e4e0c7c0cd17f4",
            "orderStatus": 0,
            "payStatus": 0,
            "updateTime": 1526166122,
            "orderDetailList": [
                {
                    "createTime": "2018-05-13 07:02:02",
                    "orderId": "2bc75c68ed6e4ba882e4e0c7c0cd17f4",
                    "orereDetailId": "95b25b705ca0496690e22cd4d5fa5a14",
                    "productIcon": "http://ww1.sinaimg.cn/large/005PjuVtgy1fr85jngsjxj30l40duhbm.jpg",
                    "productId": "7fae82066844431bb7d52da845c52f9c",
                    "productName": "清蒸皮皮虾",
                    "productPrice": 3.5,
                    "productQuantity": 1,
                    "updateTime": "2018-05-13 07:02:02"
                },
                {
                    "createTime": "2018-05-13 07:02:02",
                    "orderId": "2bc75c68ed6e4ba882e4e0c7c0cd17f4",
                    "orereDetailId": "a03b49a2f74f4af5bfc1ef15123143f4",
                    "productIcon": "http://ww1.sinaimg.cn/large/005PjuVtgy1fr85kggb1qj30h909en5b.jpg",
                    "productId": "e26b356109f546aeb25c8044a62e93dd",
                    "productName": "皮蛋瘦肉粥",
                    "productPrice": 3.2,
                    "productQuantity": 2,
                    "updateTime": "2018-05-13 07:02:02"
                }
            ]
        },
        {
            "buyerAddress": "MSI 全球冠军总决赛/FNC/蓝方中单",
            "buyerName": "快乐风男",
            "buyerOpenid": "1101110",
            "buyerPhone": "18727019900",
            "createTime": 1526084934,
            "orderAmount": 4.5,
            "orderId": "5aca32acd86f4be586b197b2d9aa0f6c",
            "orderStatus": 2,
            "payStatus": 0,
            "updateTime": 1526088600,
            "orderDetailList": [
                {
                    "createTime": "2018-05-12 08:28:54",
                    "orderId": "5aca32acd86f4be586b197b2d9aa0f6c",
                    "orereDetailId": "ee22526e53be4e9e9fd092727bac059b",
                    "productIcon": "http://ww1.sinaimg.cn/large/005PjuVtgy1fr85i03o1sj30g70b0dws.jpg",
                    "productId": "dccf82ad408f4fa8bd0cd495825ce27d",
                    "productName": "芒果冰",
                    "productPrice": 4.5,
                    "productQuantity": 1,
                    "updateTime": "2018-05-12 08:28:54"
                }
            ]
        },
        {
            "buyerAddress": "MSI 全球冠军总决赛/FNC/蓝方中单",
            "buyerName": "快乐风男",
            "buyerOpenid": "1101110",
            "buyerPhone": "18727019900",
            "createTime": 1526165848,
            "orderAmount": 9.9,
            "orderId": "a97203b41ff041adad57330aaf4b6c69",
            "orderStatus": 0,
            "payStatus": 0,
            "updateTime": 1526165848,
            "orderDetailList": [
                {
                    "createTime": "2018-05-13 06:57:25",
                    "orderId": "a97203b41ff041adad57330aaf4b6c69",
                    "orereDetailId": "4aa1ca85f67b4b1eb78048a0a41b9e8e",
                    "productIcon": "http://ww1.sinaimg.cn/large/005PjuVtgy1fr85jngsjxj30l40duhbm.jpg",
                    "productId": "7fae82066844431bb7d52da845c52f9c",
                    "productName": "清蒸皮皮虾",
                    "productPrice": 3.5,
                    "productQuantity": 1,
                    "updateTime": "2018-05-13 06:57:25"
                },
                {
                    "createTime": "2018-05-13 06:57:11",
                    "orderId": "a97203b41ff041adad57330aaf4b6c69",
                    "orereDetailId": "60ddbaa91a234176b60eb161f83e0412",
                    "productIcon": "http://ww1.sinaimg.cn/large/005PjuVtgy1fr85kggb1qj30h909en5b.jpg",
                    "productId": "e26b356109f546aeb25c8044a62e93dd",
                    "productName": "皮蛋瘦肉粥",
                    "productPrice": 3.2,
                    "productQuantity": 2,
                    "updateTime": "2018-05-13 06:57:11"
                }
            ]
        },
        {
            "buyerAddress": "MSI 全球冠军总决赛/FNC/蓝方中单",
            "buyerName": "快乐风男",
            "buyerOpenid": "1101110",
            "buyerPhone": "18727019900",
            "createTime": 1526085293,
            "orderAmount": 23.7,
            "orderId": "c55e55028a8c48a2b623ae02a01e091f",
            "orderStatus": 0,
            "payStatus": 1,
            "updateTime": 1526159404,
            "orderDetailList": [
                {
                    "createTime": "2018-05-12 08:34:53",
                    "orderId": "c55e55028a8c48a2b623ae02a01e091f",
                    "orereDetailId": "5dffeb089a1d486fad5fe23780fb592b",
                    "productIcon": "http://ww1.sinaimg.cn/large/005PjuVtgy1fr85i03o1sj30g70b0dws.jpg",
                    "productId": "dccf82ad408f4fa8bd0cd495825ce27d",
                    "productName": "芒果冰",
                    "productPrice": 4.5,
                    "productQuantity": 3,
                    "updateTime": "2018-05-12 08:34:53"
                },
                {
                    "createTime": "2018-05-12 08:34:53",
                    "orderId": "c55e55028a8c48a2b623ae02a01e091f",
                    "orereDetailId": "851e53e057654f2b9f8f57bf064f92b0",
                    "productIcon": "http://ww1.sinaimg.cn/large/005PjuVtgy1fr85jngsjxj30l40duhbm.jpg",
                    "productId": "7fae82066844431bb7d52da845c52f9c",
                    "productName": "清蒸皮皮虾",
                    "productPrice": 3.5,
                    "productQuantity": 2,
                    "updateTime": "2018-05-12 08:34:53"
                },
                {
                    "createTime": "2018-05-12 08:34:53",
                    "orderId": "c55e55028a8c48a2b623ae02a01e091f",
                    "orereDetailId": "cf64010c770a4f2ea3bbc4c4663f8e4c",
                    "productIcon": "http://ww1.sinaimg.cn/large/005PjuVtgy1fr85kggb1qj30h909en5b.jpg",
                    "productId": "e26b356109f546aeb25c8044a62e93dd",
                    "productName": "皮蛋瘦肉粥",
                    "productPrice": 3.2,
                    "productQuantity": 1,
                    "updateTime": "2018-05-12 08:34:53"
                }
            ]
        }
    ]
}
```

## 4、订单详情

-   接口：GET http://localhost:8001/sell/buyer/order/detail
-   入参

```json
openid:1101110
orderId:2bc75c68ed6e4ba882e4e0c7c0cd17f4
```

-   出参

```json
{
    "code": 0,
    "msg": "success",
    "data": {
        "buyerAddress": "MSI 全球冠军总决赛/FNC/蓝方中单",
        "buyerName": "快乐风男",
        "buyerOpenid": "1101110",
        "buyerPhone": "18727019900",
        "createTime": 1526166122,
        "orderAmount": 9.9,
        "orderId": "2bc75c68ed6e4ba882e4e0c7c0cd17f4",
        "orderStatus": 0,
        "payStatus": 0,
        "updateTime": 1526166122,
        "orderDetailList": [
            {
                "createTime": "2018-05-13 07:02:02",
                "orderId": "2bc75c68ed6e4ba882e4e0c7c0cd17f4",
                "orereDetailId": "95b25b705ca0496690e22cd4d5fa5a14",
                "productIcon": "http://ww1.sinaimg.cn/large/005PjuVtgy1fr85jngsjxj30l40duhbm.jpg",
                "productId": "7fae82066844431bb7d52da845c52f9c",
                "productName": "清蒸皮皮虾",
                "productPrice": 3.5,
                "productQuantity": 1,
                "updateTime": "2018-05-13 07:02:02"
            },
            {
                "createTime": "2018-05-13 07:02:02",
                "orderId": "2bc75c68ed6e4ba882e4e0c7c0cd17f4",
                "orereDetailId": "a03b49a2f74f4af5bfc1ef15123143f4",
                "productIcon": "http://ww1.sinaimg.cn/large/005PjuVtgy1fr85kggb1qj30h909en5b.jpg",
                "productId": "e26b356109f546aeb25c8044a62e93dd",
                "productName": "皮蛋瘦肉粥",
                "productPrice": 3.2,
                "productQuantity": 2,
                "updateTime": "2018-05-13 07:02:02"
            }
        ]
    }
}
```

## 5、取消订单

-   接口：POST http://localhost:8001/sell/buyer/order/cancel
-   入参：

```json
openid:1101110
orderId:a97203b41ff041adad57330aaf4b6c69
```

-   出参：

```json
{
    "code": 0,
    "msg": "success",
    "data": null
}
```

## 6、获取openid

-   接口：重定向到 /sell/wechat/authorize
-   入参：

```json
returnUrl: http://xxx.com/abc  //【必填】
```

-   出参：

```json
http://xxx.com/abc?openid=oZxSYw5ldcxv6H0EU67GgSXOUrVg
```

