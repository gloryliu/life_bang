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

    /**
     * 产品的分类
     */
    public static final class ProductType{
        public static final int GOODS = 1;//建材类
        public static final int SERVICE = 2;//服务类
    }

    /**
     * 订单支付状态
     */
    public static final class PayState{

        public static final int WAIT_PAY = 1;//待支付

        public static final String WAIT_PAY_CN = "待支付";

        public static final int COMPLETE_PAY = 2;//已支付

        public static final String COMPLETE_PAY_CN = "已支付";
    }


    /**
     * 服务状态
     */
    public static final class ServiceState{

        public static final int WAIT_SERVICE = 1;//待服务
        public static final String WAIT_SERVICE_CN = "等待服务";

        public static final int CONFIRM_SERVICE = 2;//确认服务
        public static final String CONFIRM_SERVICE_CN = "确认服务";//确认服务

        public static final int SEND_SERVICE = 3;//派单中
        public static final String SEND_SERVICE_CN = "派单中";

        public static final int SERVICEING = 4;//服务中
        public static final String SERVICEING_CN = "服务中";

        public static final int COMPLETE_SERVICE = 5;//结束
        public static final String COMPLETE_SERVICE_CN = "结束";
    }
}
