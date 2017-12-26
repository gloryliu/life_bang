package com.glory.shenghuo.service.apiservice;

import com.glory.shenghuo.api.pay.alipay.PayParam;
import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class WXPayService {

    private static final Logger LOG = Logger.getLogger(WXPayService.class);

    /**
     * 微信支付
     * @param payParam
     * @return
     */
    public ResponseEntity<Object> wxPay(PayParam payParam){
        return null;
    }


}
