package com.glory.shenghuo.api.deliveryaddress.param;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @create 2017-06-21 21:42
 **/
public class DeliveryAddressParam implements Serializable{

    @ApiModelProperty("收货人姓名")
    private String name;

    @ApiModelProperty("详细地址")
    private String detail;

    @ApiModelProperty("收货人电话")
    private String phone;

    @ApiModelProperty("用户id")
    private int userId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}
