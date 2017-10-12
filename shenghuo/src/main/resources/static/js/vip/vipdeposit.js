$(function () {
    /*初始化查询*/
    vipDepositObj.getAllList();
    /**
     * 扩展jquery方法，调用公共分页
     */
    jQuery.extend({
        'pageList':function(){
            vipDepositObj.getAllList();//调用分页查询接口
        }
    });
});

var vipDepositObj = {
    "getCondition": function () {/*获取查询条件*/
        var param = {};

        param["pageSize"] = basePageObj.pageObj.pageSize;
        param["pageNum"] = basePageObj.pageObj.pageNo;
        return param;
    },
    "getAllList": function () {/*获取组合列表信息*/
        var params = vipDepositObj.getCondition();
        var ajaxObj = {url: '/resource/vipDeposit/getAllList', async:true, param:params, method: "GET"};
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
    },
    "retreatDeposit":function (id) {
        //询问框
        layer.confirm('确认退还押金？', {
            btn: ['确定','取消'] //按钮
        }, function(){
            var ajaxObj = {url: '/resource/zuorder/retreatDeposit?orderType=2&id='+id, async:true,method: "Get"};
            commonJS.sendAjaxRequest(ajaxObj, function (value) {
                vipDepositObj.getAllList();
            });
            layer.closeAll('dialog');
        }, function(){
            layer.closeAll('dialog');
        });
    }
};