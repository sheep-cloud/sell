package cn.colg.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import cn.colg.util.ResultVoUtil;
import cn.colg.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;

/**
 * 异常处理 - 针对系统内部异常
 *
 * @author colg
 */
@Slf4j
@RestControllerAdvice
public class HandlerException {
    
    /**
     * 未知异常
     *
     * @param e
     * @param request
     * @return
     * @author colg
     */
    @ResponseStatus
    @ExceptionHandler(Exception.class)
    public Object systemExceptionHandler(Exception e, HttpServletRequest request) {
        log.error("未知异常： {}", e);
        return ResultVoUtil.fail(ResultVo.UNKNOWN_FAIL, "未知异常: " + request.getRequestURI());
    }

    /**
     * 接口不存在 - Not Found
     *
     * @param e
     * @param request
     * @return
     * @author colg
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResultVo notFoundExceptionHandler(NoHandlerFoundException e, HttpServletRequest request) {
        return ResultVoUtil.fail(HttpStatus.NOT_FOUND.value(), "无效接口: " + request.getRequestURI().toString());
    }

    /**
     * 请求方法错误 - Method Not Allowed
     *
     * @param e
     * @param request
     * @return
     * @author colg
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResultVo requestMethodExcpetionHandler(HttpRequestMethodNotSupportedException e, HttpServletRequest request) {
        return ResultVoUtil.fail(HttpStatus.METHOD_NOT_ALLOWED.value(), "请求异常: " + request.getMethod());
    }

    /**
     * 缺少参数 - Payment Required
     *
     * @param e
     * @return
     * @author colg
     */
    @ResponseStatus(HttpStatus.PAYMENT_REQUIRED)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResultVo handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        return ResultVoUtil.fail(HttpStatus.PAYMENT_REQUIRED.value(), "缺少参数: " + e.getParameterName() + ":" + e.getParameterType() + "");
    }
}
