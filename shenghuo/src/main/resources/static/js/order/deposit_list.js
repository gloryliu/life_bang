$(function () {
    /*初始化查询*/
    depositObj.getAllDeposit();
    /**
     * 扩展jquery方法，调用公共分页
     */
    jQuery.extend({
        'pageList':function(){
            depositObj.getAllDeposit();//调用分页查询接口
        }
    });
});

var depositObj = {
    "getCondition": function () {/*获取查询条件*/
        var param = {};
        

        var userid = $("#userid").val();
        if(userid)  param["userid"] = userid;

        param["pageSize"] = basePageObj.pageObj.pageSize;
        param["pageNum"] = basePageObj.pageObj.pageNo;
        return param;
    },
    "getAllDeposit": function () {/*获取组合列表信息*/
        var params = depositObj.getCondition();
        var ajaxObj = {url: '/resource/zuorder/getAllDeposit', async:true, param:params, method: "POST"};
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
    "retreatDeposit":function (id) {
        //询问框
        layer.confirm('确认退还押金？', {
            btn: ['确定','取消'] //按钮
        }, function(){
            var ajaxObj = {url: '/resource/zuorder/retreatDeposit?orderType=0&id='+id, async:true,method: "Get"};
            commonJS.sendAjaxRequest(ajaxObj, function (value) {
                depositObj.getAllDeposit();
            });
            layer.closeAll('dialog');
        }, function(){
            layer.closeAll('dialog');
        });
    }
};