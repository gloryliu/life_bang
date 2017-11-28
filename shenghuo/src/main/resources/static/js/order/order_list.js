$(function () {
    /*初始化查询*/
    buyObj.getOrderList();
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
        var orderid = $("#orderid").val();
        if(orderid)  param["orderid"] = orderid;

        // var orderphone = $("#orderphone").val();
        // if(orderphone)  param["orderphone"] = orderphone;
        //
        // var ordername = $("#ordername").val();
        // if(ordername)  param["ordername"] = ordername;
        //
        // var goodsid = $("#goodsid").val();
        // if(goodsid)  param["goodsid"] = goodsid;
        //
        // var userid = $("#userid").val();
        // if(userid)  param["userid"] = userid;
        //
        // var deliverytype = $("#deliverytype").val();
        // if(deliverytype)  param["deliverytype"] = deliverytype;

        param["pageSize"] = basePageObj.pageObj.pageSize;
        param["pageNum"] = basePageObj.pageObj.pageNo;
        return param;
    },
    "getOrderList": function () {/*获取组合列表信息*/
        var params = buyObj.getCondition();
        var ajaxObj = {url: '/resource/order/orderlist', async:true, param:params, method: "POST"};
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
    // ,
    // "confirmPayStatus":function (id) {
    //     //询问框
    //     layer.confirm('确认已经支付？', {
    //         btn: ['确定','取消'] //按钮
    //     }, function(){
    //         var ajaxObj = {url: '/resource/buyorder/confirmPay?id='+id, async:true,method: "GET"};
    //         commonJS.sendAjaxRequest(ajaxObj, function (value) {
    //             buyObj.getBuyList();
    //         });
    //         layer.closeAll('dialog');
    //     }, function(){
    //         layer.closeAll('dialog');
    //     });
    // },
    // "updatePayType":function (id) {
    //     //询问框
    //     layer.confirm('确定要却换支付方式？', {
    //         btn: ['确定','取消'] //按钮
    //     }, function(){
    //         var ajaxObj = {url: '/resource/buyorder/updatePayType?id='+id, async:true,method: "GET"};
    //         commonJS.sendAjaxRequest(ajaxObj, function (value) {
    //             buyObj.getBuyList();
    //         });
    //         layer.closeAll('dialog');
    //     }, function(){
    //         layer.closeAll('dialog');
    //     });
    // }
};