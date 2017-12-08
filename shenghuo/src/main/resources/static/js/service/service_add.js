$(function () {
    $("#submit").on("click",function () {
        serviceObj.insert();
    });
});

var serviceObj = {
    "getParam":function () {
        var param = {};
        if ($("#serviceName").val()) param["serviceName"] = $("#serviceName").val();

        if ($("#servicePrice").val()) param["servicePrice"] = $("#servicePrice").val();

        if ($("#seeType").val()) param["seeType"] = $("#seeType").val();

        if ($("#isBanner").val()) param["isBanner"] = $("#isBanner").val();

        if ($("#isRec").val()) param["isRec"] = $("#isRec").val();

        if ($("#isDiscount").val()) param["isDiscount"] = $("#isDiscount").val();

        if ($("#discountPrice").val()) param["discountPrice"] = $("#discountPrice").val();

        var contextDetail = window.euditorFrame.getContent();
        param["serviceDetail"] = contextDetail;

        return param;
    },
    "insert": function () {/*添加服务*/
        var param = serviceObj.getParam();
        console.log(param.toString());
        var url = '/resource/service/addService';
        var ajaxObj = {url:url, async:true, param:param, method: "POST"};
        commonJS.sendAjaxRequest(ajaxObj, function (value) {
            window.location.href="/controller/service/serviceList";
        });
    }
};