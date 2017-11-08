package com.glory.shenghuo.api.order.param;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @QQ 1031807749
 * @create 2017-11-08 16:13
 **/
public class SubmitOrderListParam implements Serializable {

    @ApiModelProperty("用户id")
    private int userId;
}
