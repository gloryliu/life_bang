package com.glory.shenghuo.api.serviceprovider.param;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @QQ 1031807749
 * @create 2017-12-07 11:40
 **/
public class ServiceProviderParam implements Serializable {

    @ApiModelProperty("用户id")
    private int userId;
    @ApiModelProperty("负责人")
    private String controller;
    @ApiModelProperty("联系人")
    private String contacts;
    @ApiModelProperty("公司地址")
    private String companyAddress;
    @ApiModelProperty("服务内容id")
    private List<Integer> typeIds;

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

    public List<Integer> getTypeIds() {
        return typeIds;
    }

    public void setTypeIds(List<Integer> typeIds) {
        this.typeIds = typeIds;
    }
}
