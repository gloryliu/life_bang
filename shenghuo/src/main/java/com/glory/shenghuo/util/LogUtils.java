package com.glory.shenghuo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志工具类
 */
public class LogUtils {

    private static final Logger LOG = LoggerFactory.getLogger(LogUtils.class);

    public static void info(String msg){
        LOG.info(msg);
    }

}
