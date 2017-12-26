package com.glory.shenghuo.api.pay.alipay;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @QQ 1031807749
 * @create 2017-12-26 11:08
 **/
public class PayParam implements Serializable{

    @ApiModelProperty("用户id")
    private int userId;
    @ApiModelProperty("订单id")
    private int orderId;
    @ApiModelProperty("支付方式:1为支付宝、2为微信")
    private int payType;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }
}
