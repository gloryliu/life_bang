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

    @ApiModelProperty("省id")
    private String provinceId;

    @ApiModelProperty("省")
    private String provinceCn;

    @ApiModelProperty("市id")
    private String cityId;

    @ApiModelProperty("市")
    private String cityCn;

    @ApiModelProperty("区县id")
    private String areaId;

    @ApiModelProperty("区县")
    private String areaCn;

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

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceCn() {
        return provinceCn;
    }

    public void setProvinceCn(String provinceCn) {
        this.provinceCn = provinceCn;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityCn() {
        return cityCn;
    }

    public void setCityCn(String cityCn) {
        this.cityCn = cityCn;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAreaCn() {
        return areaCn;
    }

    public void setAreaCn(String areaCn) {
        this.areaCn = areaCn;
    }
}
