package com.glory.shenghuo.api.collection.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @QQ 1031807749
 * @create 2017-11-09 10:15
 **/
public class CollectionPojo implements Serializable {

    @ApiModelProperty("收藏id")
    private int id;

    @ApiModelProperty("产品id")
    private int productId;

    @ApiModelProperty("产品名称")
    private String productName;

    @ApiModelProperty("产品价格")
    private int productPrice;

    @ApiModelProperty("产品图片")
    private String productImg;

    @ApiModelProperty("用户id")
    private int userId;

    @ApiModelProperty("产品类型1为建材2为服务")
    private int productType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
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

    public int getProductType() {
        return productType;
    }

    public void setProductType(int productType) {
        this.productType = productType;
    }
}
