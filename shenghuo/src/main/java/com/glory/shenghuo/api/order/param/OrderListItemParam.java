package com.glory.shenghuo.api.order.param;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @QQ 1031807749
 * @create 2017-11-08 16:14
 **/
public class OrderListItemParam implements Serializable {


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

    @ApiModelProperty("服务时间，只有服务有这个字段")
    private String serviceTime;
}
