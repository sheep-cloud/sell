package cn.colg.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.colg.core.BaseController;
import cn.colg.exception.CheckException;
import cn.colg.weixin.WeixinUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 微信Controller
 *
 * @author colg
 */
@Slf4j
@RestController
@RequestMapping("/weixin")
public class WeixinController extends BaseController {

    /**
     * 微信服务器认证
     *
     * @param signature
     * @param timestamp
     * @param nonce
     * @param echostr
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/portal", method = {RequestMethod.GET, RequestMethod.POST})
    public void config(String signature, String timestamp, String nonce, String echostr, HttpServletResponse response) throws IOException {
        log.info("接收到来自微信服务器的认证消息 : [{}, {}, {}, {}]", signature, timestamp, nonce, echostr);
        
        if (StrUtil.hasBlank(signature, timestamp, nonce, echostr)) {
            throw new CheckException("请求参数非法，请核实!");
        }
        
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        if (WeixinUtil.checkSignature(signature, timestamp, nonce)) {
            log.info("微信服务器认证成功 : {}", DateUtil.now());
            response.getWriter().println(echostr);
        }

    }

    @RequestMapping(value = "/auth", method = {RequestMethod.GET, RequestMethod.POST})
    public void auth(String code, String state) {
        log.info("WeixinController.auth() >> : {}", "进入auth方法..");
        log.info("WeixinController.auth() >> code : {}", code);
        log.info("WeixinController.auth() >> state : {}", state);
    }
}
