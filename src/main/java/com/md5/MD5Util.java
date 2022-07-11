package com.md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author xz
 * 2022/7/11
 */
public class MD5Util {
    public static String getMD5(String source) {
        return getMD5(source.getBytes());
    }

    public static String getMD5(byte[] source) {
        String s = null;
        char hexDigits[] ={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte tmp[];
            synchronized (MD5Util.class) {
                md.update(source);
                tmp = md.digest();
            }
            char str[] = new char[16 * 2];
            int k = 0;
            for (int i = 0; i < 16; i++) {
                byte byte0 = tmp[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            s = new String(str);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return s;
    }
}
