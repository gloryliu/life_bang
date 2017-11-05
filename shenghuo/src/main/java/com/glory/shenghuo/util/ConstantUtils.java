package com.glory.shenghuo.util;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @create 2017-11-05 16:06
 **/
public class ConstantUtils {

    public static final boolean isDebug = true;
    public static String getBaseHost(){

        if(!isDebug){
            return "http://47.92.24.138:8080";
        }else {
            return "http://localhost:8080";
        }
    }
}
