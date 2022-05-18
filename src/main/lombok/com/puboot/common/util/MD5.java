// Generated by delombok at Wed Apr 13 12:12:31 CST 2022
package com.puboot.common.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5工具类
 *
 * @author Linzhaoguan
 * @version V1.0
 * @date 2019年9月11日
 */
public final class MD5 {
    @java.lang.SuppressWarnings("all")
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(MD5.class);

    public static String getMessageDigest(byte[] buffer) {
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(buffer);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char[] str = new char[j * 2];
            int k = 0;
            for (byte byte0 : md) {
                str[k++] = hexDigits[byte0 >>> 4 & 15];
                str[k++] = hexDigits[byte0 & 15];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }

    public static String hex(byte[] array) {
        StringBuilder sb = new StringBuilder();
        for (byte b : array) {
            sb.append(Integer.toHexString(b & 255 | 256).substring(1, 3));
        }
        return sb.toString();
    }

    public static String md5Hex(String message) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        return hex(md.digest(message.getBytes("CP1252")));
    }

    @java.lang.SuppressWarnings("all")
    private MD5() {
        throw new java.lang.UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}