package com.glory.shenghuo.handler;

import com.glory.shenghuo.common.MyResponseUtil;
import com.glory.shenghuo.util.LogUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liuzhenrong
 * @email liuzhenrong008@gmail.com
 * @QQ 1031807749
 * @create 2017-12-07 20:31
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseEntity<Object> jsonErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        String msg = e.getMessage();
        LogUtils.info(msg);
        return MyResponseUtil.error(msg);
    }
}
