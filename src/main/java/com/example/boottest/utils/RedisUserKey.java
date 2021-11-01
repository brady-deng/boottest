package com.example.boottest.utils;

import com.example.boottest.Constant.Constant;

import javax.servlet.http.HttpServletRequest;

public class RedisUserKey {
    private RedisUserKey(){

    }

    public static String loginUserKey(HttpServletRequest request, String token){
        return new StringBuilder()
                .append(token)
                .append("|")
                .append(request.getRemoteAddr()).append("|")
                .append("bytedance.pmo|login").toString();
    }

    public static String funcPermKey(String token){
        return new StringBuilder()
                .append(token)
                .append("|")
                .append(Constant.FUNCTION_PERMISSION_PREFIX_TOKEN).toString();
    }

    public static String dataPermKey(String token){
        return new StringBuilder()
                .append(token)
                .append("|")
                .append(Constant.DATA_PERMISSION_PREFIX_TOKEN).toString();
    }
}
