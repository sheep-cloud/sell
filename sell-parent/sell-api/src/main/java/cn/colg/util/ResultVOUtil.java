package cn.colg.util;

import cn.colg.vo.ResultVO;

/**
 * http请求 工具类
 *
 * @author colg
 */
public class ResultVOUtil {

    public static ResultVO success(Object data) {
        return new ResultVO(ResultVO.SUCCESS, ResultVO.MSG_SUCCESS, data);
    }

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO fail(Integer code, String msg) {
        return new ResultVO(code, msg, null);
    }
}
