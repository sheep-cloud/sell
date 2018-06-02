package cn.colg.util;

import cn.colg.vo.ResultVo;

/**
 * http请求 工具类
 *
 * @author colg
 */
public class ResultVoUtil {

    public static ResultVo success(Object data) {
        ResultVo resultVO = new ResultVo();
        resultVO.setCode(ResultVo.SUCCESS)
                .setMsg(ResultVo.MSG_SUCCESS)
                .setData(data);
        return resultVO;
    }

    public static ResultVo success() {
        return success(null);
    }

    public static ResultVo fail(Integer code, String msg) {
        ResultVo resultVO = new ResultVo();
        resultVO.setCode(code)
                .setMsg(msg);
        return resultVO;
    }
}
