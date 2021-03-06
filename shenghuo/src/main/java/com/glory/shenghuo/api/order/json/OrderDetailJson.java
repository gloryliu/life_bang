package com.glory.shenghuo.api.order.json;

import com.glory.shenghuo.api.order.pojo.ProductOfOrderPojo;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @QQ 1031807749
 * @create 2017-12-12 15:10
 **/
public class OrderDetailJson implements Serializable {

    @ApiModelProperty("主键")
    private int id;

    @ApiModelProperty("用户id")
    private int userId;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("收货人姓名")
    private String receiveName;

    @ApiModelProperty("收货人电话")
    private String receivePhone;

    @ApiModelProperty("收货地址")
    private String receiveAddress;

    @ApiModelProperty("配送方式1为快递2为携带")
    private int transportType;

    @ApiModelProperty("服务时间")
    private String serviceTime;

    @ApiModelProperty("订单状态")
    private int orderState;

    @ApiModelProperty("订单状态文字描述")
    private String orderStateCn;

    @ApiModelProperty("商户订单号")
    private String outTradeNo;

    @ApiModelProperty("服务商id")
    private int serviceProviderId;

    @ApiModelProperty("订单类型1为建材2为服务")
    private int orderType;

    @ApiModelProperty("订单总金额")
    private int orderAmount;

    @ApiModelProperty("订单中的产品")
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

    public String getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(String serviceTime) {
        this.serviceTime = serviceTime;
    }

    public int getOrderState() {
        return orderState;
    }

    public void setOrderState(int orderState) {
        this.orderState = orderState;
    }

    public String getOrderStateCn() {
        return orderStateCn;
    }

    public void setOrderStateCn(String orderStateCn) {
        this.orderStateCn = orderStateCn;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public int getServiceProviderId() {
        return serviceProviderId;
    }

    public void setServiceProviderId(int serviceProviderId) {
        this.serviceProviderId = serviceProviderId;
    }

    public int getOrderType() {
        return orderType;
    }

    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }

    public List<ProductOfOrderPojo> getProducts() {
        return products;
    }

    public void setProducts(List<ProductOfOrderPojo> products) {
        this.products = products;
    }
}
