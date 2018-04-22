package com.glory.shenghuo.common;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @create 2017-07-01 13:14
 **/
public class SuperBean<T> implements Serializable {

    @ApiModelProperty("1000为成功，1001为失败")
    private int code;
    @ApiModelProperty("失败信息")
    private String msg;
    @ApiModelProperty("数据")
    private T data;

    public SuperBean(){

    }

    public SuperBean(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
