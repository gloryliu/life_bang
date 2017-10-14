package com.glory.shenghuo.api.user.param;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class UpdatePwdParam implements Serializable {

    @ApiModelProperty("用户id")
    private int userId;

    @ApiModelProperty("旧密码")
    private String oldPwd;

    @ApiModelProperty("新密码")
    private String newPwd;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getOldPwd() {
        return oldPwd;
    }

    public void setOldPwd(String oldPwd) {
        this.oldPwd = oldPwd;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }
}
