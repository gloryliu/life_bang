package com.glory.shenghuo.api.user.json;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class UserJson implements Serializable {

    @ApiModelProperty("用户id")
    private int userId;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("电话")
    private String phone;

    @ApiModelProperty("头像")
    private String headImg;

    @ApiModelProperty("用户类型 1为普通用户 2为物业用户 3为服务商")
    private int userType;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
}
