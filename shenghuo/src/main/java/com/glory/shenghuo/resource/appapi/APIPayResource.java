package com.glory.shenghuo.resource.appapi;

import com.glory.shenghuo.api.pay.alipay.PayParam;
import com.glory.shenghuo.common.BusinessException;
import com.glory.shenghuo.service.apiservice.APIPayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pay")
@Api(value = "pay", description = "支付相关接口")
public class APIPayResource {

    private static final Logger LOG = Logger.getLogger(APIPayResource.class);

    @Autowired
    private APIPayService apiPayService;


    @ApiOperation("支付确认")
    @RequestMapping(value = "/payConfirm",method = RequestMethod.POST)
    public ResponseEntity<Object> payConfirm(@RequestBody PayParam payParam) throws BusinessException {
        return apiPayService.payConfirm(payParam);
    }

//    @RequestMapping(value = "/aliPay_notify",method = RequestMethod.POST)
//    public void aliPay_notify(HttpServletRequest request, HttpServletResponse response){
//        try {
//            request.setCharacterEncoding("UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        LOG.info("============aliPay notify start===========================");
//        // 获取到返回的所有参数 先判断是否交易成功trade_status 再做签名校验
//        // 1、商户需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号，
//        // 2、判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），
//        // 3、校验通知中的seller_id（或者seller_email) 是否为out_trade_no这笔单据的对应的操作方（有的时候，一个商户可能有多个seller_id/seller_email），
//        // 4、验证app_id是否为该商户本身。上述1、2、3、4有任何一个验证不通过，则表明本次通知是异常通知，务必忽略。在上述验证通过后商户必须根据支付宝不同类型的业务通知，正确的进行不同的业务处理，并且过滤重复的通知结果数据。在支付宝的业务通知中，只有交易通知状态为TRADE_SUCCESS或TRADE_FINISHED时，支付宝才会认定为买家付款成功。
//        if ("TRADE_SUCCESS".equals(request.getParameter("trade_status"))) {
//            Enumeration<?> pNames = request.getParameterNames();
//            Map<String, String> param = new HashMap<String, String>();
//            try {
//                while (pNames.hasMoreElements()) {
//                    String pName = (String) pNames.nextElement();
//                    param.put(pName, request.getParameter(pName));
//                    LOG.info(pName+" = "+param.get(pName));
//                }
//
//                PayNotifyParam payNotifyParam = JSON.parseObject(param.get("body"),PayNotifyParam.class);
//                if(payNotifyParam!=null){
//                    if(!StringUtil.isEmpty(param.get("out_trade_no"))&&param.get("out_trade_no").equals(payNotifyParam.getOut_trade_no())){
//                        payNotifyParam.setTrade_no(param.get("trade_no"));
//                        payNotifyParam.setPayamount((int)(Float.parseFloat(param.get("total_amount"))*100)+"");
//
//                        if(alipayService.alipayNotifyChangeOrderStatus(payNotifyParam)>0){
//                            LOG.info("order status changes success!");
//                        }else{
//                            LOG.info("order status changes failed!");
//                        }
//                    }
//                }
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//        LOG.info("============aliPay notify end===========================");
//    }
//
//
//    @RequestMapping(value = "/weixin_notify",method = RequestMethod.POST)
//    public void weixin_notify(HttpServletRequest request, HttpServletResponse response){
//
//        LOG.info("============weixin notify start===========================");
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("text/xml");
//        try {
//            ServletInputStream in = request.getInputStream();
//            String resxml = FileUtil.readInputStream2String(in);
//            Map<String, String> restmap = XmlUtil.xmlParse(resxml);
//            LOG.info("支付结果通知：" + restmap);
//            if ("SUCCESS".equals(restmap.get("return_code"))) {
//                // 订单支付成功 业务处理
//                String out_trade_no = restmap.get("out_trade_no"); // 商户订单号
//                // 通过商户订单判断是否该订单已经处理 如果处理跳过 如果未处理先校验sign签名 再进行订单业务相关的处理
//
//                String sing = restmap.get("sign"); // 返回的签名
//                restmap.remove("sign");
//                //String signnow = PayUtil.getSign(restmap, API_SECRET);
////                if (signnow.equals(sing)) {
////                    // 进行业务处理
////                    LOG.info("订单支付通知： 支付成功，订单号" + out_trade_no);
////                } else {
////                    LOG.info("订单支付通知：签名错误");
////                }
//                String transaction_id = restmap.get("transaction_id");
//                LOG.info("transaction_id="+transaction_id);
//                LOG.info("订单支付通知： 支付成功，订单号" + out_trade_no);
//                String attach = restmap.get("attach");
//                PayNotifyParam payNotifyParam = JSON.parseObject(attach,PayNotifyParam.class);
//                if(payNotifyParam!=null){
//                    payNotifyParam.setTransactionId(transaction_id);
//                    payNotifyParam.setPayamount(restmap.get("total_fee"));
//
//                    if(!StringUtil.isEmpty(out_trade_no)&&out_trade_no.equals(payNotifyParam.getOut_trade_no())){
//                        if(wxPayService.weixinNotifyChangeOrderStatus(payNotifyParam)>0){
//                            LOG.info("order status changes success!");
//                        }else{
//                            LOG.info("order status changes failed!");
//                        }
//                    }
//                }
//            } else {
//                LOG.info("订单支付通知：支付失败，" + restmap.get("err_code") + ":" + restmap.get("err_code_des"));
//            }
//        } catch (Exception e) {
//            LOG.error(e.getMessage(), e);
//        }
//
//        LOG.info("============weixin notify start===========================");
//    }

}
