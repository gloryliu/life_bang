package com.glory.shenghuo.api.collection.param;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @QQ 1031807749
 * @create 2017-11-09 10:32
 **/
public class AddCollectionParam implements Serializable {


    @ApiModelProperty("用户id")
    private int userId;

    @ApiModelProperty("产品id")
    private int productId;

    @ApiModelProperty("产品类型1为建材2为服务")
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


    public int getProductType() {
        return productType;
    }

    public void setProductType(int productType) {
        this.productType = productType;
    }
}
