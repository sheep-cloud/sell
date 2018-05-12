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
            ],
            "name": "男生专享",
            "type": 2
        },
        {
            "foods": [
                {
                    "description": "芒果冰，是台湾的一款夏日冰品。它加入的是新鲜的芒果、炼乳以及芒果冰激凌覆盖在挫冰或绵绵冰上面，有着清凉解暑的功用。",
                    "icon": "http://ww1.sinaimg.cn/large/005PjuVtgy1fr85i03o1sj30g70b0dws.jpg",
                    "id": "dccf82ad408f4fa8bd0cd495825ce27d",
                    "name": "芒果冰",
                    "price": 4.5
                }
            ],
            "name": "女生专享",
            "type": 1
        }
    ]
}
```

## 2、创建订单

- 接口：POST  http://localhost:8001/sell/buyer/order/create
- 入参：

```json
{
    "name": "Jack",
    "phone": "18868822111",
    "address": "MSI总决赛",
    "openid": "ew3euwhd7sjw9diwkq",
    "items": [
        {
            "productId": "1423113435324",
            "productQuantity": 2
        }
    ]
}
```



- 出参：

```json
{
    "code": 0,
    "msg": "success",
    "data": {
        "orderId": "5aca32acd86f4be586b197b2d9aa0f6c"
    }
}
```

