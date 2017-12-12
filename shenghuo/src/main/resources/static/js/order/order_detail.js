window.onload = function(){
    var orderid = $("#orderId").val();
    orderDetailObj.getProductByOrderId(orderid);
};
var orderDetailObj = {
    "getProductByOrderId": function (orderid) {/*获取组合列表信息*/
        var ajaxObj = {url: '/resource/order/getProductByOrderId?orderId='+orderid, async:true,method:"POST"};
        commonJS.loading("open");
        commonJS.sendAjaxRequest(ajaxObj, function (value) {
            console.log(value);
            $("#data").html($("#dataTemplate").render(value));
        });
        commonJS.loading("close");
    }
};