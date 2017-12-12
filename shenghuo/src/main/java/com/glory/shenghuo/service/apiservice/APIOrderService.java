package com.glory.shenghuo.service.apiservice;

import com.glory.shenghuo.api.goods.pojo.GoodsPojo;
import com.glory.shenghuo.api.order.json.OrderDetailJson;
import com.glory.shenghuo.api.order.json.OrderListItemJson;
import com.glory.shenghuo.api.order.param.OrderListItemParam;
import com.glory.shenghuo.api.order.param.SubmitOrderListParam;
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
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
        orderPojo.setServiceTime(orderParam.getServiceTime());//服务时间
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
     * @param orderListParam
     * @return
     */
    @Transactional
    public ResponseEntity<Object> addOrderList(SubmitOrderListParam orderListParam) throws BusinessException {
        ResponseEntity<Object> responseEntity = null;

        OrderPojo orderPojo = new OrderPojo();
        orderPojo.setUserId(orderListParam.getUserId());
        orderPojo.setCreateTime(new Date());
        orderPojo.setReceiveName(orderListParam.getReceiveName());
        orderPojo.setReceivePhone(orderListParam.getReceivePhone());
        orderPojo.setReceiveAddress(orderListParam.getReceiveAddress());
        orderPojo.setTransportType(getOrderTypeByproducts(orderListParam.getProducts()));
        orderPojo.setOrderAmount(getOrderAmount(orderListParam.getProducts()));//订单总价
        //orderPojo.setServiceTime(orderParam.getServiceTime());//服务时间暂定
        orderPojo.setOrderState(ConstantUtils.PayState.WAIT_PAY);
        orderPojo.setOrderStateCn(ConstantUtils.PayState.WAIT_PAY_CN);

        if(orderMapper.add(orderPojo)>0){
            for (OrderListItemParam bean:orderListParam.getProducts()) {
                responseEntity = addProduct(orderPojo,bean);
            }
        }else {
            responseEntity = MyResponseUtil.error("生成订单失败");
        }

        return responseEntity;
    }

    /**
     * 根据购物车里边的商品判断订单的类型
     * @param products
     * @return
     */
    private int getOrderTypeByproducts(List<OrderListItemParam> products){

        int result = ConstantUtils.ProductType.GOODS;
        //如果提交的产品中有一个属于服务那么这个订单的类型就是服务类型的订单
        for (OrderListItemParam param:products) {
            if(param.getProductType()==ConstantUtils.ProductType.SERVICE){
                result = ConstantUtils.ProductType.SERVICE;
                break;
            }
        }
        return result;
    }

    /**
     * 计算订单总价格
     * @param products
     * @return
     */
    private int getOrderAmount(List<OrderListItemParam> products) throws BusinessException {
        int result = 0;
        for (OrderListItemParam param:products) {
            switch (param.getProductType()){
                case ConstantUtils.ProductType.GOODS:
                    GoodsPojo goodsPojo = goodsMapper.getDetail(param.getProductId());
                    if(goodsPojo==null){
                        throw new BusinessException("商品不存在");
                    }
                    result += param.getProductCount() * goodsPojo.getGoodsPrice();
                    break;
                case ConstantUtils.ProductType.SERVICE:
                    ServicePojo servicePojo = serviceMapper.getDetail(param.getProductId());
                    if(servicePojo==null){
                        throw new BusinessException("服务不存在");
                    }
                    result += param.getProductCount() * servicePojo.getServicePrice();
                    break;
                    default:
                        throw new BusinessException("产品类型有误");
            }
        }
        return result;
    }

    /**
     * 向订单中添加产品
     * @param orderPojo
     * @param orderListItemParam
     * @return
     */
    private ResponseEntity<Object> addProduct(OrderPojo orderPojo,OrderListItemParam orderListItemParam) throws BusinessException {
        SubmitOrderParam param = new SubmitOrderParam();
        param.setUserId(orderPojo.getUserId());
        param.setProductType(orderListItemParam.getProductType());
        param.setProductId(orderListItemParam.getProductId());
        param.setProductCount(orderListItemParam.getProductCount());
        return addProductOfOrder(orderPojo,param);
    }

    /**
     * 向订单中添加商品
     * @param orderPojo
     * @param orderParam
     * @return
     */
    private ResponseEntity<Object> addProductOfOrder(OrderPojo orderPojo,SubmitOrderParam orderParam) throws BusinessException {

        ResponseEntity<Object> responseEntity = null;

        ProductOfOrderPojo product = new ProductOfOrderPojo();
        product.setOrderId(orderPojo.getId());
        product.setUserId(orderParam.getUserId());

        switch (orderParam.getProductType()){
            case ConstantUtils.ProductType.GOODS:
                GoodsPojo goodsPojo = goodsMapper.getDetail(orderParam.getProductId());
                if(goodsPojo==null){
                    throw new BusinessException("商品不存在");
                }
                product.setProductId(goodsPojo.getId());
                product.setProductType(ConstantUtils.ProductType.GOODS);
                product.setProductPrice(goodsPojo.getGoodsPrice());
                product.setProductName(goodsPojo.getGoodsName());
                product.setProductCount(orderParam.getProductCount());
                product.setProductImg(goodsPojo.getGoodsImg());

                if(productOfOrderMapper.add(product)>0){
                    responseEntity = MyResponseUtil.ok(new Integer(orderPojo.getId()));
                }else{
                    responseEntity = MyResponseUtil.error("订单生成失败");
                }
                break;
            case ConstantUtils.ProductType.SERVICE:
                ServicePojo servicePojo = serviceMapper.getDetail(orderParam.getProductId());
                if(servicePojo==null){
                    throw new BusinessException("服务不存在");
                }
                product.setProductId(servicePojo.getId());
                product.setProductType(ConstantUtils.ProductType.SERVICE);
                product.setProductPrice(servicePojo.getServicePrice());
                product.setProductName(servicePojo.getServiceName());
                product.setProductCount(orderParam.getProductCount());
                product.setProductImg(servicePojo.getServiceImg());

                if(productOfOrderMapper.add(product)>0){
                    responseEntity = MyResponseUtil.ok(new Integer(orderPojo.getId()));
                }else {
                    responseEntity = MyResponseUtil.error("订单生成失败");
                }
                break;
            default:
                responseEntity = MyResponseUtil.error("产品类型不正确");
        }

        return responseEntity;
    }

    /**
     * 根据用户id获取订单
     * @param userId
     * @return
     */
    public ResponseEntity<Object> getOrderListByUserId(int userId){
        List<OrderListItemJson> jsonList = new ArrayList<>();
        List<OrderPojo> orderPojos = orderMapper.getAllOrderByUserId(userId);
        OrderListItemJson json = null;
        for (OrderPojo pojo:orderPojos) {
            json = new OrderListItemJson();
            BeanUtils.copyProperties(pojo,json);
            jsonList.add(json);
        }
        return MyResponseUtil.ok(jsonList);
    }

    /**
     * 获取订单详情
     * @param orderId
     * @return
     * @throws BusinessException
     */
    public ResponseEntity<Object> getOrderDetail(int orderId) throws BusinessException {
        OrderDetailJson detailJson = new OrderDetailJson();
        OrderPojo orderPojo = orderMapper.getOrderDetail(orderId);
        if (orderPojo==null){
            throw new BusinessException("订单不存在");
        }
        BeanUtils.copyProperties(orderId,detailJson);
        List<ProductOfOrderPojo> products = productOfOrderMapper.getAllProductByOrderId(orderId);
        detailJson.setProducts(products);
        return MyResponseUtil.ok(detailJson);
    }

}
