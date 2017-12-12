package com.glory.shenghuo.api.order.param;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @QQ 1031807749
 * @create 2017-11-08 16:13
 **/
public class SubmitOrderListParam implements Serializable {

    @ApiModelProperty("用户id")
    private int userId;

    @ApiModelProperty("收货人姓名")
    private String receiveName;

    @ApiModelProperty("收货人电话")
    private String receivePhone;

    @ApiModelProperty("收货人详细地址")
    private String receiveAddress;

    @ApiModelProperty("产品")
    List<OrderListItemParam> products;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public String getReceivePhone() {
        return receivePhone;
    }

    public void setReceivePhone(String receivePhone) {
        this.receivePhone = receivePhone;
    }

    public String getReceiveAddress() {
        return receiveAddress;
    }

    public void setReceiveAddress(String receiveAddress) {
        this.receiveAddress = receiveAddress;
    }

    public List<OrderListItemParam> getProducts() {
        return products;
    }

    public void setProducts(List<OrderListItemParam> products) {
        this.products = products;
    }
}
