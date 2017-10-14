package com.glory.shenghuo.api.deliveryaddress.pojo;
/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @create 2017-06-18 11:22
 **/
public class DeliveryAddressPojo {
    private Integer id;

    private String name;

    private String detail;

    private String phone;

    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}