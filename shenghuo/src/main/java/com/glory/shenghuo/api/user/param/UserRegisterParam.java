package com.glory.shenghuo.api.user.param;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class UserRegisterParam implements Serializable {

    @ApiModelProperty("电话号码")
    private String phone;

    @ApiModelProperty("验证码")
    private String checkCode;

    @ApiModelProperty("密码")
    private String pwd;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
