$(function () {
    /*初始化查询*/
    buyObj.getOrderList();
    $("#searchButton").on("click",function () {
        buyObj.getOrderList();
    });
    /**
     * 扩展jquery方法，调用公共分页
     */
    jQuery.extend({
        'pageList':function(){
            buyObj.getOrderList();//调用分页查询接口
        }
    });
});

var buyObj = {
    "getCondition": function () {/*获取查询条件*/
        var param = {};
        var servicestate = $("#servicestate").val();
        if(servicestate) {
            param["serviceState"] = servicestate;
        }
        // else{
        //     param["serviceState"] = "";
        // }

        param["pageSize"] = basePageObj.pageObj.pageSize;
        param["pageNum"] = basePageObj.pageObj.pageNo;
        return param;
    },
    "getOrderList": function () {/*获取组合列表信息*/
        var params = buyObj.getCondition();
        var ajaxObj = {url: '/resource/order/serviceOrderList', async:true, param:params, method: "POST"};
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
    }
};