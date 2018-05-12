package cn.colg.vo;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * http请求返回的最外层对象
 *
 * @author colg
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class ResultVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 成功 */
    public static final int SUCCESS = 0;
    /** 字段校验，参数非法异常 */
    public static final int CHECK_FAIL = 1;
    /** 未知异常 */
    public static final int UNKNOWN_FAIL = -99;

    /** 成功，默认提示消息 */
    public static final String MSG_SUCCESS = "success";
    /** 失败，默认提示消息 */
    public static final String MSG_FAIL = "fail";

    /// ----------------------------------------------------------------------------------------------------

    /** 错误码 */
    @JSONField(ordinal = 1)
    private Integer code;
    /** 提示信息 */
    @JSONField(ordinal = 2)
    private String msg;
    /** 具体内容 */
    @JSONField(ordinal = 3)
    private Object data;

    /// ----------------------------------------------------------------------------------------------------

    /**
     * 未知异常
     *
     * @param e
     */
    public ResultVO(Throwable e) {
        this.msg = e.toString();
        this.code = UNKNOWN_FAIL;
    }
}
