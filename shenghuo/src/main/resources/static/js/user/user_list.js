$(function () {
    /*初始化查询*/
    userObj.getUserList();
    /**
     * 扩展jquery方法，调用公共分页
     */
    jQuery.extend({
        'pageList':function(){
            userObj.getUserList();//调用分页查询接口
        }
    });
});

var userObj = {
    "getCondition": function () {/*获取查询条件*/
        var param = {};
        
        // var endtimeStart = $("#endtimeStart").val();
        // if(endtimeStart)  param["endtimeStart"] = endtimeStart;
        //
        // var endtimeEnd = $("#userLoginTimeEnd").val();
        // if(endtimeEnd)  param["endtimeEnd"] = endtimeEnd;
        //
        // var phone = $("#phone").val();
        // if(phone)  param["phone"] = phone;

        param["pageSize"] = basePageObj.pageObj.pageSize;
        param["pageNum"] = basePageObj.pageObj.pageNo;
        return param;
    },
    "getUserList": function () {/*获取组合列表信息*/
        var params = userObj.getCondition();
        var ajaxObj = {url: '/resource/user/getUserList', async:true, param:params, method: "POST"};
        commonJS.loading("open");
        commonJS.sendAjaxRequest(ajaxObj, function (value) {
            $("#data").html($("#dataTemplate").render(value.data));
            $("#totalCount").html(value.totalCount);
            $("#pageCount").html(value.pageCount);
            basePageObj.pageObj.pageCount=value.pageCount;
            if(value.totalCount<value.pageSize){
                basePageObj.pagination(value.totalCount,value.pageCount);
            }else{
                basePageObj.pagination(value.pageSize,value.pageCount);
            }
        });
        commonJS.loading("close");
    },
    "userAuth":function (id,status) {
        var urlstr = '/resource/user/userAuth?id='+id+'&status='+status;
        var ajaxObj = {url: urlstr, async:true,method: "GET"};
        commonJS.loading("open");
        commonJS.sendAjaxRequest(ajaxObj, function (value) {
            userObj.getUserList();
        });
        commonJS.loading("close");
    }
};