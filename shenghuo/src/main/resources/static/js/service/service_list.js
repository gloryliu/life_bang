$(function () {
    /*初始化查询*/
    serviceListObj.getServiceList();
    $("#insert").on("click",function () {
        window.location.href="/controller/service/serviceAdd";
    });

    $("#searchButton").on("click",function () {
        serviceListObj.getServiceList();
    });

    /**
     * 扩展jquery方法，调用公共分页
     */
    jQuery.extend({
        'pageList':function(){
            serviceListObj.getServiceList();//调用分页查询接口
        }
    });
});

var serviceListObj = {
    "getCondition": function () {/*获取查询条件*/
        var param = {};

        var name = $("#serviceName").val();
        if(name)  param["serviceName"] = name;

        param["pageSize"] = basePageObj.pageObj.pageSize;
        param["pageNum"] = basePageObj.pageObj.pageNo;
        return param;
    },
    "getServiceList": function () {/*获取组合列表信息*/
        var params = serviceListObj.getCondition();
        var ajaxObj = {url: '/resource/service/getServiceList', async:true, param:params, method: "POST"};
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
//根据id改变服务删除状态
function changeServiceDeleteFlag(serviceid, deleteflag){
    var infostr = '是否删除该服务？';
    if(deleteflag == 1){
        infostr = '是否恢复该服务？'
    }
    layer.confirm(infostr, {
        btn: ['确定','取消'] //按钮
    }, function () {
        var ajaxObj = {url: '/resource/service/changeServiceDeleteFlag?serviceId=' + serviceid, async:true, method: "POST"};
        commonJS.sendAjaxRequest(ajaxObj, function (value) {
            serviceListObj.getServiceList();
            layer.closeAll();
        });
    }, function () {

    });
}