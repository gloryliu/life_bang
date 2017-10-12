var commonJS = {//commonJS
    "sendAjaxRequest" : function(ajaxObj, callbackFn,callExceptionFn){//调用公用异步请求方法   ajaxObj对象主要包含请求参数(封装成对象)、请求地址url
        var url = ajaxObj.url;
        var param = ajaxObj.param;
        var async = ajaxObj.async;//true、false 判断异步请求的类型，同步还是异步
        if(!ajaxObj.hasOwnProperty("async")) async = true;
        var method = ajaxObj.method;
        if(!method) method = "GET";
        if(!param) param = {};//参数不存在 就给一个默认的参数
        param["_j"] = Math.floor((Math.random() * (9999 - 1000) + 1000));//清IE浏览器缓存用
        $.ajax({
            type : method,
            url : url,
            data : param,
            async : async,
            dataType : 'json',
            success : function(json){
                if(callbackFn && typeof callbackFn === 'function'){
                    callbackFn(json);
                }
            },
            error : function(jqXHR, textStatus, errorThrown){
                if(callExceptionFn && typeof callExceptionFn === 'function'){
                    callExceptionFn(data);
                }
            }
        });
    },
    "sendAjaxRequestException" : function(ajaxObj, callbackFn,callExceptionFn){//调用公用异步请求方法   ajaxObj对象主要包含请求参数(封装成对象)、请求地址url
        var url = ajaxObj.url;
        var param = ajaxObj.param;
        var async = ajaxObj.async;//true、false 判断异步请求的类型，同步(false)还是异步(true)
        if(!ajaxObj.hasOwnProperty("async")) async = true;
        var method = ajaxObj.method;
        if(!method) method = "GET";
        if(!param) param = {};//参数不存在 就给一个默认的参数
        // param["random"] = Math.random();//清IE浏览器缓存用
        $.ajax({
            type : method,
            url : url,
            data : param,
            async : async,
            contentType: 'application/json; charset=UTF-8',
            success : function(json){
                if(callbackFn && typeof callbackFn === 'function'){
                    callbackFn(json);
                }
            },
            error : function(data){
                if(callExceptionFn && typeof callExceptionFn === 'function'){
                    callExceptionFn(data);
                }
            }
        });
    },
    "getParameter" : function(param){
		var query = window.location.search;
	    var iLen = param.length;
	    var iStart = query.indexOf(param);
	    if (iStart == -1)
	        return ""; 
	    iStart += iLen + 1; 
	    var iEnd = query.indexOf("&", iStart); 
	    if (iEnd == -1)
	        return query.substring(iStart); 
	    return query.substring(iStart, iEnd); 
	},
    "index": '',
    "loading": function (type) {
        var index;
        if (type == "open") {
            index = layer.load(0, {
                shade: [0.5, '#C1C1C1'],
                time: 100000,//显示1秒自动关闭
                offset: '36%'
            });
            this.index = index;
        } else {
            var that = this;
            setTimeout(function () {/*延迟0.5秒关闭*/
                layer.close(that.index);
            }, 500)

        }
    },
    "confirm": function (msg, callbackYes, callbackNo) {/*提示框*/
        layer.confirm(msg, {
            btn: ['确定', '取消'] //按钮
        }, function () {
            callbackYes();
        }, function () {
            if (callbackNo != '') {
                callbackNo();
            }
        });
    },
    "alert": function(msg,callbackYes) {
    	if (callbackYes) {
    		layer.alert(msg,{icon: 1,time:10000},callbackYes);
    	} else {
    		layer.alert(msg,{icon: 1});
    	}
    	
    },
    "msg":function (msg,callbackYes) {
        layer.msg(msg,{icon: 1,time:2000},callbackYes);
    }

};


/*
 * 日期格式化
 */
Date.prototype.format = function(fmt) { // author: meizz
    var o = {
        "M+" : this.getMonth() + 1, // 月份
        "d+" : this.getDate(), // 日
        "h+" : this.getHours(), // 小时
        "m+" : this.getMinutes(), // 分
        "s+" : this.getSeconds(), // 秒
        "q+" : Math.floor((this.getMonth() + 3) / 3), // 季度
        "S" : this.getMilliseconds()
// 毫秒
    };
    if (/(y+)/.test(fmt))
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
            .substr(4 - RegExp.$1.length));
    for ( var k in o)
        if (new RegExp("(" + k + ")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k])
                : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
};
$.views.converters("format", function(time) {
    return new Date(time).format("yyyy-MM-dd hh:mm:ss")//使用
});

$(function() {
    //支持jquery的ajax函数跨域请求
    jQuery.support.cors = true;
    //修改右侧主内容区太小，多个滚动条的问题
    jQuery("#iframeWarp").css("overflow","inherit");
    jQuery(".data-table").css("max-height","100%");
});
