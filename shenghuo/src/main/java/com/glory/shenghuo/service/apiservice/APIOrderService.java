package com.glory.shenghuo.service.apiservice;

import com.glory.shenghuo.api.goods.pojo.GoodsPojo;
import com.glory.shenghuo.api.order.param.SubmitOrderParam;
import com.glory.shenghuo.api.order.pojo.OrderPojo;
import com.glory.shenghuo.api.order.pojo.ProductOfOrderPojo;
import com.glory.shenghuo.api.service.pojo.ServicePojo;
import com.glory.shenghuo.common.BusinessException;
import com.glory.shenghuo.common.MyResponseUtil;
import com.glory.shenghuo.mapper.GoodsMapper;
import com.glory.shenghuo.mapper.OrderMapper;
import com.glory.shenghuo.mapper.ProductOfOrderMapper;
import com.glory.shenghuo.mapper.ServiceMapper;
import com.glory.shenghuo.util.ConstantUtils;
import com.glory.shenghuo.util.PayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @QQ 1031807749
 * @create 2017-11-08 14:03
 **/
@Service
public class APIOrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ProductOfOrderMapper productOfOrderMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private ServiceMapper serviceMapper;


    /**
     * 单品购买提交订单
     * @param orderParam
     * @return
     */
    @Transactional
    public ResponseEntity<Object> addOrder(SubmitOrderParam orderParam) throws BusinessException {

        ResponseEntity<Object> responseEntity = null;
        OrderPojo orderPojo = new OrderPojo();

        //订单基础信息初始化
        orderPojo.setUserId(orderParam.getUserId());//用户id
        orderPojo.setCreateTime(new Date());//创建时间
        orderPojo.setReceiveName(orderParam.getReceiveName());//收货姓名
        orderPojo.setReceivePhone(orderParam.getReceivePhone());//收货人电话
        orderPojo.setReceiveAddress(orderParam.getReceiveAddress());//收货人地址
        orderPojo.setTransportType(orderParam.getTransportType());//配送方式1为快递2为携带上门
        //orderPojo.setServiceTime(orderParam.getServiceTime());//
        orderPojo.setOrderState(ConstantUtils.PayState.WAIT_PAY);//订单状态
        orderPojo.setOrderStateCn(ConstantUtils.PayState.WAIT_PAY_CN);//订单状态文字描述
        orderPojo.setOutTradeNo(PayUtil.getTradeNo());//商户订单号
        //
        switch (orderParam.getProductType()){
            case ConstantUtils.ProductType.GOODS:
                orderPojo.setOrderType(ConstantUtils.ProductType.GOODS);//订单类型
                GoodsPojo goodsPojo = goodsMapper.getDetail(orderParam.getProductId());
                if(goodsPojo==null){
                    throw new BusinessException("商品不存在");
                }
                int goodsAmount = orderParam.getProductCount() * goodsPojo.getGoodsPrice();
                orderPojo.setOrderAmount(goodsAmount);//订单总金额
                break;
            case ConstantUtils.ProductType.SERVICE:
                orderPojo.setOrderType(ConstantUtils.ProductType.SERVICE);//订单类型
                ServicePojo servicePojo = serviceMapper.getDetail(orderParam.getProductId());
                if(servicePojo==null){
                    throw new BusinessException("此服务不存在");
                }
                int serviceAmount = orderParam.getProductCount() * servicePojo.getServicePrice();
                orderPojo.setOrderAmount(serviceAmount);//订单总金额
                break;
                default:
                    throw new BusinessException("产品类型不合法");
        }

        if(orderMapper.add(orderPojo)>0){
            responseEntity = addProductOfOrder(orderPojo,orderParam);
        }else {
            responseEntity = MyResponseUtil.error("生成订单失败");
        }

        return responseEntity;
    }


    /**
     * 批量购买提交订单
     * @param orderParamList
     * @return
     */
    public ResponseEntity<Object> addOrderList(List<SubmitOrderParam> orderParamList){
        ResponseEntity<Object> responseEntity = null;

//        OrderPojo orderPojo = new OrderPojo();
//        orderPojo.setUserId(orderParam.getUserId());
//        orderPojo.setCreateTime(new Date());
//        orderPojo.setReceiveName(orderParam.getReceiveName());
//        orderPojo.setReceivePhone(orderParam.getReceivePhone());
//        orderPojo.setReceiveAddress(orderParam.getReceiveAddress());
//        orderPojo.setTransportType(orderParam.getTransportType());
//        orderPojo.setServiceTime(orderParam.getServiceTime());
//        orderPojo.setOrderState(ConstantUtils.PayState.WAIT_PAY);
//        orderPojo.setOrderStateCn(ConstantUtils.PayState.WAIT_PAY_CN);
//
//        if(orderMapper.add(orderPojo)>0){
//            responseEntity = addProductOfOrder(orderPojo,orderParam);
//        }else {
//            responseEntity = MyResponseUtil.error("生成订单失败");
//        }

        return responseEntity;
    }

    /**
     * 向订单中添加商品
     * @param orderPojo
     * @param orderParam
     * @return
     */
    private ResponseEntity<Object> addProductOfOrder(OrderPojo orderPojo,SubmitOrderParam orderParam){

        ResponseEntity<Object> responseEntity = null;

        ProductOfOrderPojo product = new ProductOfOrderPojo();
        product.setOrderId(orderPojo.getId());
        product.setUserId(orderParam.getUserId());
        switch (orderParam.getProductType()){
            case 1:
                GoodsPojo goodsPojo = goodsMapper.getDetail(orderParam.getProductId());
                if(goodsPojo!=null){
                    product.setProductId(goodsPojo.getId());
                    product.setProductType(1);
                    product.setProductPrice(goodsPojo.getGoodsPrice());
                    product.setProductName(goodsPojo.getGoodsName());
                    product.setProductCount(orderParam.getProductCount());
                    product.setProductImg(goodsPojo.getGoodsImg());

                    if(productOfOrderMapper.add(product)>0){
                        responseEntity = MyResponseUtil.ok("订单生成成功");
                    }else{
                        responseEntity = MyResponseUtil.error("订单生成失败");
                    }
                }else {
                    responseEntity = MyResponseUtil.error("商品不存在");
                }
                break;
            case 2:
                ServicePojo servicePojo = serviceMapper.getDetail(orderParam.getProductId());
                if(servicePojo!=null){
                    product.setProductId(servicePojo.getId());
                    product.setProductType(2);
                    product.setProductPrice(servicePojo.getServicePrice());
                    product.setProductName(servicePojo.getServiceName());
                    product.setProductCount(orderParam.getProductCount());
                    product.setProductImg(servicePojo.getServiceImg());

                    if(productOfOrderMapper.add(product)>0){
                        responseEntity = MyResponseUtil.ok("订单生成成功");
                    }else {
                        responseEntity = MyResponseUtil.error("订单生成失败");
                    }
                }else{
                    responseEntity = MyResponseUtil.error("服务不存在");
                }

                break;
            default:
                responseEntity = MyResponseUtil.error("产品类型不正确");
        }

        return responseEntity;
    }

}
