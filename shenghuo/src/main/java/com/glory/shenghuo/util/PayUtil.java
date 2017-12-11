package com.glory.shenghuo.util;


import com.github.pagehelper.StringUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

/**
 * 创建时间：2016年11月2日 下午7:12:44
 * 
 * @author andy
 * @version 2.2
 */

public class PayUtil {

	/**
	 * 生成订单号
	 * 
	 * @return
	 */
	public static String getTradeNo() {
		// 自增8位数 00000001
		return "TNO" + DatetimeUtil.formatDate(new Date(), DatetimeUtil.TIME_STAMP_PATTERN) + "00000001";
	}

	/**
	 * 退款单号
	 * 
	 * @return
	 */
	public static String getRefundNo() {
		// 自增8位数 00000001
		return "RNO" + DatetimeUtil.formatDate(new Date(), DatetimeUtil.TIME_STAMP_PATTERN) + "00000001";
	}

	/**
	 * 退款单号
	 * 
	 * @return
	 */
	public static String getTransferNo() {
		// 自增8位数 00000001
		return "TNO" + DatetimeUtil.formatDate(new Date(), DatetimeUtil.TIME_STAMP_PATTERN) + "00000001";
	}

	/**
	 * 返回客户端ip
	 * 
	 * @param request
	 * @return
	 */
	public static String getRemoteAddrIp(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		if (StringUtil.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
			// 多次反向代理后会有多个ip值，第一个ip才是真实ip
			int index = ip.indexOf(",");
			if (index != -1) {
				return ip.substring(0, index);
			} else {
				return ip;
			}
		}
		ip = request.getHeader("X-Real-IP");
		if (StringUtil.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
			return ip;
		}
		return request.getRemoteAddr();
	}

	/**
	 * 获取服务器的ip地址
	 * 
	 * @param request
	 * @return
	 */
	public static String getLocalIp(HttpServletRequest request) {
		return request.getLocalAddr();
	}

	/**
	 * 创建支付随机字符串
	 * 
	 * @return
	 */
	public static String getNonceStr() {
		return RandomUtil.randomString(RandomUtil.LETTER_NUMBER_CHAR, 32);
	}

	/**
	 * 支付时间戳
	 * 
	 * @return
	 */
	public static String payTimestamp() {
		return Long.toString(System.currentTimeMillis() / 1000);
	}


}
