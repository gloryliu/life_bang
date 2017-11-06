package com.glory.shenghuo.mapper;

import com.glory.shenghuo.api.cart.pojo.CartPojo;

import java.util.List;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @create 2017-06-18 11:22
 **/
public interface CartMapper extends BaseMapper{

    //添加购物车
    int add(CartPojo pojo);

    //删除购物车
    int delete(int id);

    //根据用户id获取购物车
    List<CartPojo> getCartList(int userId);
}
