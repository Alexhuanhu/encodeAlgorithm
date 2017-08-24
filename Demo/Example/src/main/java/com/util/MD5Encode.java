package com.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Alexhu on 2017/7/14.
 */
public class MD5Encode {

    /**
     * 32位小写MD5
     * @param str
     * @return
     */
    public static String parseStrToMd5L32(String str) {
        String reStr = null;

        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(str.getBytes());

            StringBuffer stringBuffer = new StringBuffer();

            for (byte b:bytes) {
                int bt = b & 0xff;    // 与, b 和 255 做 与 运算
                if (bt < 16) {
                    stringBuffer.append(0);
                }
                stringBuffer.append(Integer.toHexString(bt));   // 转换为 十六进制，否则无法正常显示加密后的结果
            }
            reStr = stringBuffer.toString();

        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return reStr;
    }

    /**
     * 16位大写MD5
     * @param str
     * @return
     */
    public static String parseStrToMd5U16(String str) {
        String reStr = parseStrToMd5L32(str);

        if (null != reStr) {
            reStr = reStr.toUpperCase().substring(8, 24);
        }

        return reStr;
    }

    /**
     * 16位小写MD5
     * @param str
     * @return
     */
    public static String parseStrToMd5L16(String str) {
        String reStr = parseStrToMd5L32(str);

        if (null != reStr) {
            reStr = reStr.substring(8, 24);
        }

        return reStr;
    }

    public static void main(String[] args) {
        String inputStr = "201602";

        // 16位大写MD5加密结果
        String outputStr = MD5Encode.parseStrToMd5U16(inputStr);

        // 16位小写MD5加密结果
        String outputStr16L = MD5Encode.parseStrToMd5L16(inputStr);

        // 32位小写MD5加密结果
        String outputStr32L = MD5Encode.parseStrToMd5L32(inputStr);

        System.out.println(outputStr + "\n" + outputStr16L + "\n" + outputStr32L);

    }

}
