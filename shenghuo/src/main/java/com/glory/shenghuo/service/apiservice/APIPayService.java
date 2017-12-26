package com.glory.shenghuo.service.apiservice;

import com.glory.shenghuo.api.pay.alipay.PayParam;
import com.glory.shenghuo.common.BusinessException;
import com.glory.shenghuo.util.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @QQ 1031807749
 * @create 2017-12-26 11:05
 **/
@Service
public class APIPayService {

    @Autowired
    AlipayService alipayService;

    @Autowired
    WXPayService wxPayService;

    public ResponseEntity<Object> payConfirm(PayParam payParam) throws BusinessException {

        ResponseEntity responseEntity = null;

        switch (payParam.getPayType()){
            case ConstantUtils.PayType.AliPay:
                responseEntity = alipayService.aliPay(payParam);
                break;
            case ConstantUtils.PayType.WeiXIn:
                responseEntity = wxPayService.wxPay(payParam);
                break;
                default:
                    throw new BusinessException("支付方式不对 1为支付宝2为微信");
        }
        return responseEntity;
    }
}
