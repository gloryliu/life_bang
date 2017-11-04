package com.glory.shenghuo.api.goods.param;

import java.io.Serializable;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @create 2017-11-04 13:24
 **/
public class ChangeRecGoodsStateParam implements Serializable {

    //商品id
    private int goodsId;

    //状态
    private int state;

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
