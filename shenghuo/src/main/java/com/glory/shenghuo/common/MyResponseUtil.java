package com.glory.shenghuo.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class MyResponseUtil {
    public static final int SUCCESS = 1000;
    public static final int FAIL = 1001;

    public static ResponseEntity<Object> error(int code,String msg){
        return new ResponseEntity<Object>(new SuperBean(code,msg,null), HttpStatus.OK);
    }

    public static ResponseEntity<Object> error(String msg){
        return new ResponseEntity<Object>(new SuperBean(FAIL,msg,null), HttpStatus.OK);
    }

    public static ResponseEntity<Object> ok(Object object){
        return new ResponseEntity<Object>(new SuperBean(SUCCESS,"成功",object), HttpStatus.OK);
    }

    public static ResponseEntity<Object> ok(String msg){
        return new ResponseEntity<Object>(new SuperBean(SUCCESS,msg,null), HttpStatus.OK);
    }
}
