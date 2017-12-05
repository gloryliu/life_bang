window.onload = function() {
    /*编辑页面初始化查询*/
    serviceObj.serviceId=$("#serviceid").val();
    serviceObj.type=$("#type").val();

    serviceObj.init();
    $("#submit").on("click",function () {
        serviceObj.update();
    });
};

var serviceObj = {

    "binners":[],
    "serviceId":"",
    "type":"",
    "init":function () {
        if(serviceObj.type == 1){
            serviceObj.getDetail();
        }
    },
    "getParam":function () {
        var param = {};
        // if(serviceObj.binners.length>0){
        //     var strimage1 = serviceObj.binners.join("|");
        //     param["banners"] = strimage1;
        // }

        if ($("#serviceName").val()) param["serviceName"] = $("#serviceName").val();

        if ($("#servicePrice").val()) param["servicePrice"] = $("#servicePrice").val();

        if ($("#seeType").val()) param["seeType"] = $("#seeType").val();

        if ($("#isBanner").val()) param["isBanner"] = $("#isBanner").val();

        if ($("#isRec").val()) param["isRec"] = $("#isRec").val();

        if ($("#isDiscount").val()) param["isDiscount"] = $("#isDiscount").val();

        if ($("#discountPrice").val()) param["discountPrice"] = $("#discountPrice").val();

        var contextDetail = window.euditorFrame.getContent();
        param["serviceDetail"] = contextDetail;

        if (serviceObj.type == 1){
            param["id"] = serviceObj.serviceId;
        }
        return param;
    },
    "getDetail": function () {
        var ajaxObj = {url: '/resource/service/detailService?serviceId='+serviceObj.serviceId, async:true, method: "POST"};
        commonJS.sendAjaxRequest(ajaxObj, function (value) {
            $("#serviceName").val(value.id);
            $("#servicePrice").val(value.servicePrice);
             $("#seeType").val(value.seeType);
            $("#isBanner").val(value.isBanner);
            $("#isRec").val(value.isRec);
            // $("#serviceName").val(value.);
            // $("#serviceName").val();
            // $("#serviceName").val();
            $("#discountPrice").val(value.discountPrice);
            $("#euditorFrame").setContent(value.serviceDetail);
        });
    },
    "update": function () {/*编辑服务*/
        var param = serviceObj.getParam();
        console.log(param.toString());
        var url = '/resource/service/updateService';
        // if (serviceObj.type == 1) {
        //     url = '/resource/service/update';
        // }
        var ajaxObj = {url:url, async:true, param:param, method: "POST"};
        commonJS.sendAjaxRequest(ajaxObj, function (value) {
            window.location.href="/controller/service/serviceList";
        });
    }
    /*,
    "getGoodstypeList": function () {
        var ajaxObj = {url: '/resource/goodstype/getAllList', async:true, method: "GET"};
        commonJS.sendAjaxRequest(ajaxObj, function (value) {
            $("#goodstype").html("<option value='' >请选择</option>");
            if (value != null) {
                $($("#goodstype_template").render(value)).appendTo("#goodstype");
            }
        });
    },
    "getShopList": function () {
        var ajaxObj = {url: '/resource/shop/getAllList', async:true, method: "POST"};
        commonJS.sendAjaxRequest(ajaxObj, function (value) {
            $("#shop").html("<option value='' >请选择</option>");
            if (value != null) {
                $($("#shop_template").render(value)).appendTo("#shop");
            }
        });
    },
    "uploadImagCallBack":function (response) {
        goodsObj.addBinner(response._raw);
    },
    "addBinner":function (obj) {

        goodsObj.binners.push(obj);

        $("#banner").empty();
        $(goodsObj.binners).each(function (i,item) {
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
    */
};