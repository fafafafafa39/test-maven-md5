package com.md5.service;

import com.md5.MD5Util;

/**
 * @author xz
 * 2022/7/11
 */
public class MD5Service {
    public String getMD5(String input) {
        return MD5Util.getMD5(input.getBytes());
    }
}
