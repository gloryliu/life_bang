package com.glory.shenghuo.api.cart.param;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @QQ 1031807749
 * @create 2017-11-06 17:26
 **/
public class AddCartParam implements Serializable {

    @ApiModelProperty("用户id")
    private int userId;

    @ApiModelProperty("产品id")
    private int productId;

    @ApiModelProperty("产品数量")
    private int productCount;

    @ApiModelProperty("产品类型1为建材、2为服务")
    private int productType;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public int getProductType() {
        return productType;
    }

    public void setProductType(int productType) {
        this.productType = productType;
    }
}
