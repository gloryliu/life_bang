package com.glory.shenghuo.service.apiservice;

import com.glory.shenghuo.api.cart.param.AddCartParam;
import com.glory.shenghuo.api.cart.pojo.CartPojo;
import com.glory.shenghuo.api.goods.pojo.GoodsPojo;
import com.glory.shenghuo.api.service.pojo.ServicePojo;
import com.glory.shenghuo.common.MyResponseUtil;
import com.glory.shenghuo.mapper.CartMapper;
import com.glory.shenghuo.mapper.GoodsMapper;
import com.glory.shenghuo.mapper.ServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @QQ 1031807749
 * @create 2017-11-06 17:44
 **/

@Service
public class CartService {

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private ServiceMapper serviceMapper;


    /**
     * 根据id获取购物车
     * @param userId
     * @return
     */
    public ResponseEntity<Object> getCartList(int userId){
        return MyResponseUtil.ok(cartMapper.getCartList(userId));
    }


    /**
     * 添加购物车
     * @param param
     * @return
     */
    public ResponseEntity<Object> addCart(AddCartParam param){

        ResponseEntity<Object> responseEntity = null;
        CartPojo cartPojo = new CartPojo();

        switch (param.getProductType()){
            case 1:
                GoodsPojo goodsPojo = goodsMapper.getDetail(param.getProductId());
                if(goodsPojo!=null){
                    cartPojo.setProductId(param.getProductId());
                    cartPojo.setProductCount(param.getProductCount());
                    cartPojo.setUserId(param.getUserId());
                    cartPojo.setProductType(param.getProductType());
                    cartPojo.setProductName(goodsPojo.getGoodsName());
                    cartPojo.setProductPrice(goodsPojo.getGoodsPrice());
                    cartPojo.setProductImg(goodsPojo.getGoodsImg());
                    if(cartMapper.add(cartPojo)>0){
                        responseEntity = MyResponseUtil.ok("添加成功");
                    }else {
                        responseEntity = MyResponseUtil.error("添加失败");
                    }
                }else {
                    responseEntity = MyResponseUtil.error("建材不存在");
                }
                break;
            case 2:
                ServicePojo servicePojo = serviceMapper.getDetail(param.getProductId());
                if(servicePojo!=null){
                    cartPojo.setProductCount(param.getProductCount());
                    cartPojo.setUserId(param.getUserId());
                    cartPojo.setProductType(param.getProductType());

                    cartPojo.setProductName(servicePojo.getServiceName());
                    cartPojo.setProductPrice(servicePojo.getServicePrice());
                    cartPojo.setProductImg(servicePojo.getServiceImg());
                    if(cartMapper.add(cartPojo)>0){
                        responseEntity = MyResponseUtil.ok("添加成功");
                    }else {
                        responseEntity = MyResponseUtil.error("添加失败");
                    }
                }else{
                    responseEntity = MyResponseUtil.error("服务不存在");
                }
                cartPojo.setProductId(param.getProductId());
                break;
                default:
                    responseEntity = MyResponseUtil.error("类型不合法");
        }

        return responseEntity;
    }

    /**
     * 删除购物车
     * @param id
     * @return
     */
    public ResponseEntity<Object> deleteCart(int id){
        if(cartMapper.delete(id)>0){
            return MyResponseUtil.ok("删除成功");
        }else{
            return MyResponseUtil.error("删除失败");
        }
    }
}
