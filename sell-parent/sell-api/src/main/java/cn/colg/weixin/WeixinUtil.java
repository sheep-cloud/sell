package cn.colg.weixin;

import java.util.Arrays;

import cn.hutool.crypto.SecureUtil;

/**
 * 微信工具
 *
 * @author colg
 */
public class WeixinUtil {

    private static String token = "colg";

    /**
     * 通过检验微信加密签名对请求进行校验
     *
     * @param signature
     * @param timestamp
     * @param nonce
     * @return
     */
    public static boolean checkSignature(String signature, String timestamp, String nonce) {
        String[] arr = new String[] {token, timestamp, nonce};
        boolean flag = false;

        // 将token、timestamp、nonce三个参数进行字典排序
        Arrays.sort(arr);

        StringBuffer sb = new StringBuffer();
        for (String str : arr) {
            sb.append(str);
        }

        // 进行sha1加密
        String temp = SecureUtil.sha1(sb.toString());

        flag = temp.equals(signature);
        return flag;
    }
}
