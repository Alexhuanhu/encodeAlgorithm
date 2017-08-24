package com.util;

import java.security.MessageDigest;

/**
 * Created by Alexhu on 2017/7/14.
 */
public class SHA1Encode {

    /**
     * SHA-1 加密算法
     * @param data
     * @return
     * @throws Exception
     */
    public static String encryptSHA(byte[] data) throws Exception {
        MessageDigest sha = MessageDigest.getInstance("SHA");
        sha.update(data);

        return SHA1Encode.byte2hex(sha.digest());
    }

    /**
     * 转换为十六进制
     * @param b
     * @return
     */
    private static String byte2hex(byte[] b) {
        String hs = "";
        String stmp = "";

        for (int n = 0; n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0xFF);
            if (stmp.length() == 1) {
                hs = hs + "0" + stmp;
            }
            else {
                hs = hs + stmp;
            }
        }

        return hs.toUpperCase();
    }


    public static void main(String[] args) {
        try {
            String inputStr = "201602";

            byte[] inputData = inputStr.getBytes();
            String outputData = SHA1Encode.encryptSHA(inputData);
            System.out.println(outputData);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
