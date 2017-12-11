package com.glory.shenghuo.api.image.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class ImagePojo implements Serializable {

    @ApiModelProperty("主键")
    private int id;
    @ApiModelProperty("图片地址")
    private String url;
    @ApiModelProperty("产品id")
    private int productId;
    @ApiModelProperty("产品类型 1为建材2为服务")
    private int productType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
}
