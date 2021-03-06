package com.glory.shenghuo.api.serviceprovider.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @QQ 1031807749
 * @create 2017-12-07 11:35
 * 服务商信息
 **/
public class ServiceProviderPoJo implements Serializable{

    @ApiModelProperty("主键")
    private int id;
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
    @ApiModelProperty("审核状态0为未审核1为审核通过2为审核未通过")
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
