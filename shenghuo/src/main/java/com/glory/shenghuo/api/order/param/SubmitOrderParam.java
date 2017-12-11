package com.glory.shenghuo.api.order.param;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @QQ 1031807749
 * @create 2017-11-08 13:44
 **/
public class SubmitOrderParam implements Serializable {

    @ApiModelProperty("用户id")
    private int userId;

    @ApiModelProperty("商品类型1为建材2为服务")
    private int productType;

    @ApiModelProperty("产品id")
    private int productId;

    @ApiModelProperty("商品数量")
    private int productCount;

    @ApiModelProperty("配送方式1为快递2为携带上门")
    private int transportType;

    @ApiModelProperty("收货人姓名")
    private String receiveName;

    @ApiModelProperty("收货人电话")
    private String receivePhone;

    @ApiModelProperty("收货人详细地址")
    private String receiveAddress;

//    @ApiModelProperty("服务时间，只有服务有这个字段")
//    private String serviceTime;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductType() {
        return productType;
    }

    public void setProductType(int productType) {
        this.productType = productType;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public int getTransportType() {
        return transportType;
    }

    public void setTransportType(int transportType) {
        this.transportType = transportType;
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

//    public String getServiceTime() {
//        return serviceTime;
//    }
//
//    public void setServiceTime(String serviceTime) {
//        this.serviceTime = serviceTime;
//    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
