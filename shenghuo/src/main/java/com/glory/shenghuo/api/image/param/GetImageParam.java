package com.glory.shenghuo.api.image.param;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @QQ 1031807749
 * @create 2017-12-11 11:00
 **/
public class GetImageParam implements Serializable {

    @ApiModelProperty("产品id")
    private int productId;
    @ApiModelProperty("产品类型 1为建材2为服务")
    private int productType;

    public GetImageParam(int productId, int productType) {
        this.productId = productId;
        this.productType = productType;
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
