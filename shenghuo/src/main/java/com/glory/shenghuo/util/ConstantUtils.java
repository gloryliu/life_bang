package com.glory.shenghuo.util;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @create 2017-11-05 16:06
 **/
public class ConstantUtils {

    public static final boolean isDebug = false;
    public static String getBaseHost(){

        if(!isDebug){
            return "http://47.92.24.138:8080";
        }else {
            return "http://localhost:8080";
        }
    }

    public static class PayState{

        public static final int WAIT_PAY = 1;

        public static final String WAIT_PAY_CN = "待支付";

        public static final int COMPLETE_PAY = 2;

        public static final String COMPLETE_PAY_CN = "已支付";
    }
}
