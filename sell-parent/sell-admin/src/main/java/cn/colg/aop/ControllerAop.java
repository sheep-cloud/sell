package cn.colg.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import cn.colg.exception.CheckException;
import cn.colg.vo.ResultVo;
import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * aop 处理、包装异常
 * 
 * @author colg
 */
@Slf4j
@Aspect
@Component
public class ControllerAop {

    @Pointcut("execution(public cn.colg.vo.ResultVO *(..))")
    private void controllerMethod() {}

    @Around("controllerMethod()")
    public ResultVo handlerControllerMethod(ProceedingJoinPoint point) {
        long preTime = System.currentTimeMillis();

        ResultVo resultVO = new ResultVo();
        try {
            // 执行目标方法
            resultVO = (ResultVo)point.proceed();
            log.info(point.getSignature() + " >> use time: [{}ms]", DateUtil.spendMs(preTime));
        } catch (Throwable e) {
            // 执行目标方法异常，包装异常
            resultVO = handlerException(point, e);
        }
        return resultVO;
    }

    /**
     * 包装异常信息
     *
     * @param point
     * @param e
     * @return
     */
    private ResultVo handlerException(ProceedingJoinPoint point, Throwable e) {
        ResultVo resultVO = new ResultVo();

        // 已知异常
        if (e instanceof CheckException || e instanceof IllegalArgumentException) {
            log.info(point.getSignature() + " 校验异常/参数非法 : {}", e.getLocalizedMessage());
            // 校验出错，参数非法
            resultVO.setMsg(e.getLocalizedMessage()).setCode(ResultVo.CHECK_FAIL);
        }
        // 未知异常
        else {
            log.error(point.getSignature() + " ERROR : {}", e);
            resultVO.setMsg(e.toString()).setCode(ResultVo.UNKNOWN_FAIL);
        }

        return resultVO;
    }
}
