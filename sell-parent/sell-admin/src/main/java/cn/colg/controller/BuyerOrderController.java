package cn.colg.controller;

import static cn.colg.core.util.ValidUtil.isMoblePhone;
import static cn.colg.util.CheckUtil.check;
import static cn.colg.util.CheckUtil.notEmpty;
import static cn.colg.util.ResultVOUtil.success;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.colg.core.BaseController;
import cn.colg.dto.OrderDto;
import cn.colg.form.OrderForm;
import cn.colg.vo.ResultVO;
import cn.hutool.core.lang.Dict;
import cn.hutool.db.Page;

/**
 * 买家订单 Controller
 *
 * @author colg
 */
@RestController
@RequestMapping("/buyer/order")
public class BuyerOrderController extends BaseController {

    /*
     * colg [业务]
     *  创建订单
     *  订单列表
     *  订单详情
     *  取消订单
     */
    /**
     * 创建订单
     *
     * @param orderForm
     * @return
     */
    @PostMapping("/create")
    public ResultVO create(OrderForm orderForm) {
        // 校验数据
        notEmpty(orderForm.getName(), "姓名必填");
        check(isMoblePhone(orderForm.getPhone()), "手机号码格式不正确");
        notEmpty(orderForm.getAddress(), "地址必填");
        notEmpty(orderForm.getOpenid(), "微信openid必填");
        notEmpty(orderForm.getItems(), "购物车不能为空");

        // 包装参数
        OrderDto orderDto = new OrderDto(orderForm);
        // 创建订单
        OrderDto createResult = orderService.create(orderDto);

        // 返回orderId
        Dict dict = new Dict(1).set("orderId", createResult.getOrderId());
        return success(dict);
    }

    /**
     * 订单列表
     * 
     * @param openid 微信openid
     * @param page 页码
     * @param size 每页结果数
     * @return
     */
    @GetMapping("/list")
    public ResultVO list(String openid,
                         @RequestParam(defaultValue = "0") Integer page,
                         @RequestParam(defaultValue = "10") Integer size
                        ) {
        notEmpty(openid, "微信openid必填");
        Page p = new Page(page, size);
        // TODO colg [fastjson 定制日期字段序列化格式]
        return success(orderService.findList(openid, p));
    }
    
    /**
     * 订单详情
     *
     * @param openid
     * @param orderId
     * @return
     */
    @GetMapping("/detail")
    public ResultVO detail(String openid, String orderId) {
        notEmpty(openid, "微信openid必填");
        notEmpty(orderId, "订单id必填");
        
        // TODO colg [不安全的做法，改进]
        OrderDto orderDto = orderService.findOne(orderId);
        return success(orderDto);
    }
    
    /**
     * 取消订单
     *
     * @param openid
     * @param orderId
     * @return
     */
    @PostMapping("/cancel")
    public ResultVO cancel(String openid, String orderId) {
        notEmpty(openid, "微信openid必填");
        notEmpty(orderId, "订单id必填");

        buyerService.cancelOrder(openid, orderId);
        return success();
    }
}
