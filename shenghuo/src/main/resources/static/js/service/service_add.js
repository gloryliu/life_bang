$(function () {
    $("#submit").on("click",function () {
        serviceObj.insert();
    });
});

var serviceObj = {
    "binners":[],
    "getParam":function () {
        var param = {};

        if(serviceObj.binners.length>0){
            var strimage1 = serviceObj.binners.join("|");
            param["banners"] = strimage1;
        }

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
    },
    "uploadImagCallBack":function (response) {
        console.log(response._raw);
        serviceObj.addBinner(response._raw);
    },
    "addBinner":function (obj) {

        serviceObj.binners.push(obj);

        $("#banner").empty();
        $(serviceObj.binners).each(function (i,item) {
            $("#banner").append("<img src='"+item+"' class='smallImage'/>");
        });
    },
    "selectImg":function () {
        var index = layer.open({
            type: 2,
            content: '/upload',
            area: ['320px', '195px'],
            maxmin: true,
            end:function () {
                //alert(window.test);
            }
        });
        layer.full(index);
    }
};