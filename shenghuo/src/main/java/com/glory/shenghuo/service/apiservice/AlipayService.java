package com.glory.shenghuo.service.apiservice;

import com.alibaba.fastjson.JSON;
import com.glory.shenghuo.api.order.pojo.OrderPojo;
import com.glory.shenghuo.api.pay.alipay.APPAlipayParam;
import com.glory.shenghuo.api.pay.alipay.PayParam;
import com.glory.shenghuo.api.pay.bean.AliPayResponseBean;
import com.glory.shenghuo.api.pay.bean.PayNetBean;
import com.glory.shenghuo.common.BusinessException;
import com.glory.shenghuo.common.MyResponseUtil;
import com.glory.shenghuo.mapper.OrderMapper;
import com.glory.shenghuo.util.HttpUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AlipayService {

    private static final Logger log = Logger.getLogger(AlipayService.class);

    @Autowired
    PayNetBean payNetBean;

    @Autowired
    OrderMapper orderMapper;

    public ResponseEntity<Object> aliPay(PayParam payParam) throws BusinessException {
        APPAlipayParam param = new APPAlipayParam();

        OrderPojo orderPojo = orderMapper.getOrderDetail(payParam.getOrderId());
        if (orderPojo==null){
            throw new BusinessException("订单不存在");
        }
        param.setBody("支付宝测试支付");
        param.setSubject("支付宝测试支付");
        param.setOutTradeNo(orderPojo.getOutTradeNo());
        param.setTotalAmount(orderPojo.getOrderAmount()+"");
        param.setPassbackParams(JSON.toJSONString(orderPojo));

        String result = HttpUtils.post(payNetBean.getAlinet(),JSON.toJSONString(param));
        AliPayResponseBean responseBean = JSON.parseObject(result,AliPayResponseBean.class);
        log.info("re=="+result);
        return MyResponseUtil.ok(responseBean.getData());
    }


}
