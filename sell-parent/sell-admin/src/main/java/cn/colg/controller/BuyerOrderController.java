package cn.colg.controller;

import static cn.colg.util.CheckUtil.check;
import static cn.colg.util.CheckUtil.notNull;
import static cn.colg.util.ResultVoUtil.success;
import static cn.colg.util.ValidUtil.isMoblePhone;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.colg.core.BaseController;
import cn.colg.dto.OrderDto;
import cn.colg.form.OrderForm;
import cn.colg.vo.ResultVo;
import cn.hutool.core.lang.Dict;

/**
 * 买家订单 Controller
 *
 * @author colg
 */
@RestController
@RequestMapping("/buyer/order")
public class BuyerOrderController extends BaseController {

    /**
     * 创建订单
     *
     * @param orderForm 订单表单数据
     * @return
     */
    @PostMapping("/create")
    public ResultVo create(OrderForm orderForm) {
        // 校验数据
        notNull(orderForm.getName(), "姓名必填");
        check(isMoblePhone(orderForm.getPhone()), "手机号码格式不正确");
        notNull(orderForm.getAddress(), "地址必填");
        notNull(orderForm.getOpenid(), "微信openid必填");
        notNull(orderForm.getItems(), "购物车不能为空");

        // 包装参数
        OrderDto orderDto = new OrderDto(orderForm);
        // 创建订单
        OrderDto createResult = orderService.create(orderDto);

        // 返回orderId
        return success(new Dict(2).set("orderId", createResult.getOrderId()));
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
    public ResultVo list(@RequestParam String openid,
                         @RequestParam Integer page,
                         @RequestParam Integer size) {
        // TODO colg [fastjson 定制日期字段序列化格式]
        return success(orderService.findList(openid, page, size));
    }
    
    /**
     * 订单详情
     *
     * @param openid 微信openid
     * @param orderId 订单id
     * @return
     */
    @GetMapping("/detail")
    public ResultVo detail(@RequestParam String openid,
                           @RequestParam String orderId) {
        // notNull(openid, "微信openid必填");
        // notNull(orderId, "订单id必填");
        
        // TODO colg [不安全的做法，改进]
        OrderDto orderDto = orderService.findOne(orderId);
        return success(orderDto);
    }
    
    /**
     * 取消订单
     *
     * @param openid 微信openid
     * @param orderId 订单id
     * @return
     */
    @PostMapping("/cancel")
    public ResultVo cancel(@RequestParam String openid,
                           @RequestParam String orderId) {
        // notNull(openid, "微信openid必填");
        // notNull(orderId, "订单id必填");

        buyerService.cancelOrder(openid, orderId);
        return success();
    }
}
