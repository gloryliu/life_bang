package com.glory.shenghuo.api.user.param;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class UpdateNameParam implements Serializable{

    @ApiModelProperty("用户id")
    private int userId;

    @ApiModelProperty("用户名称")
    private String userName;

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
}
