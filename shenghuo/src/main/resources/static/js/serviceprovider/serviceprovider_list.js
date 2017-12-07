$(function () {
    /*初始化查询*/
    serviceProviderObj.getServiceProviderList();
    $("#searchButton").on("click",function () {
        serviceProviderObj.getServiceProviderList();
    });
    /**
     * 扩展jquery方法，调用公共分页
     */
    jQuery.extend({
        'pageList':function(){
            serviceProviderObj.getServiceProviderList();//调用分页查询接口
        }
    });
});

var serviceProviderObj = {
    "getCondition": function () {/*获取查询条件*/
        var param = {};
        var serviceproviderid = $("#serviceproviderid").val();
        if(serviceproviderid)  param["id"] = serviceproviderid;

        param["pageSize"] = basePageObj.pageObj.pageSize;
        param["pageNum"] = basePageObj.pageObj.pageNo;
        return param;
    },
    "getServiceProviderList": function () {/*获取组合列表信息*/
        var params = serviceProviderObj.getCondition();
        var ajaxObj = {url: '/resource/serviceprovider/serviceProviderList', async:true, param:params, method: "POST"};
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
/**
 * 根据服务商id号审核服务商
 **/
function checkStatus(checkid){
    layer.confirm('是否通过该服务商审核？', {
        btn: ['通过','不通过', '取消'] //按钮
    }, function () {
        var ajaxObj = {url: '/resource/serviceprovider/serviceProviderCheck?checkid=' + checkid, async:true, method: "POST"};
        commonJS.sendAjaxRequest(ajaxObj, function (value) {
            serviceProviderObj.getServiceProviderList();
            layer.closeAll();
        });
    }, function () {
        alert('不通过');
    },function () {
        alert('取消');
    });
}