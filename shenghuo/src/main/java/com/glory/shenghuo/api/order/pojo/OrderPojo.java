package com.glory.shenghuo.api.order.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @QQ 1031807749
 * @create 2017-11-07 16:21
 **/
public class OrderPojo implements Serializable{

    //主键
    private int id;

    //用户id
    private int userId;

    //创建时间
    private Date createTime;

    //收货人姓名
    private String receiveName;

    //收货人电话
    private String receivePhone;

    //收货地址
    private String receiveAddress;

    //配送方式1为快递2为携带
    private int transportType;

    //订单里边的商品
    private List<ProductOfOrderPojo> products;

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public String getReceivePhone() {
        return receivePhone;
    }

    public void setReceivePhone(String receivePhone) {
        this.receivePhone = receivePhone;
    }

    public String getReceiveAddress() {
        return receiveAddress;
    }

    public void setReceiveAddress(String receiveAddress) {
        this.receiveAddress = receiveAddress;
    }

    public int getTransportType() {
        return transportType;
    }

    public void setTransportType(int transportType) {
        this.transportType = transportType;
    }

    public List<ProductOfOrderPojo> getProducts() {
        return products;
    }

    public void setProducts(List<ProductOfOrderPojo> products) {
        this.products = products;
    }
}
