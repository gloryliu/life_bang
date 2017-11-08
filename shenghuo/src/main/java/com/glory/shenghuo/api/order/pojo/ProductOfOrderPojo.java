package com.glory.shenghuo.api.order.pojo;

import java.io.Serializable;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @QQ 1031807749
 * @create 2017-11-07 16:25
 **/
public class ProductOfOrderPojo implements Serializable {

    //主键
    private int id;

    //订单id
    private int orderId;

    //用户id
    private int userId;

    //产品id
    private int productId;

    //产品类型1为建材2为服务
    private int productType;

    //产品价格
    private int productPrice;

    //产品名称
    private String productName;

    //产品数量
    private int productCount;

    //产品图片
    private String productImg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductType() {
        return productType;
    }

    public void setProductType(int productType) {
        this.productType = productType;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
