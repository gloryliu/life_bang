package com.glory.shenghuo.api.serviceprovider.json;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @QQ 1031807749
 * @create 2017-12-08 13:48
 **/
public class ServiceProvideJson implements Serializable {

    @ApiModelProperty("用户id")
    private int userId;
    @ApiModelProperty("负责人")
    private String controller;
    @ApiModelProperty("联系人电话")
    private String contacts;
    @ApiModelProperty("公司地址")
    private String companyAddress;
    @ApiModelProperty("服务范围")
    private String serviceRange;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getController() {
        return controller;
    }

    public void setController(String controller) {
        this.controller = controller;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getServiceRange() {
        return serviceRange;
    }

    public void setServiceRange(String serviceRange) {
        this.serviceRange = serviceRange;
    }
}
