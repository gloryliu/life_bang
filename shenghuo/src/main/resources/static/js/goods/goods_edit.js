$(function () {
    /*编辑页面初始化查询*/
    goodsObj.goodsId=$("#goodsId").val();
    goodsObj.type=$("#type").val();
    goodsObj.init();
    $("#submit").on("click",function () {
        goodsObj.insertupdate();
    });
});

var goodsObj = {
    "imgtype":"",
    "binners":[],
    "details":[],
    "goodsId":"",
    "type":"",
    "init":function () {
        goodsObj.getGoodstypeList();
        goodsObj.getShopList();
        if(goodsObj.type == 1){
            goodsObj.getDetail();
        }
    },
    "getParam":function () {
        var param = {};
        if(goodsObj.binners.length>0){
            var strimage1 = goodsObj.binners.join("|");
            param["image1"] = strimage1;
        }

        if(goodsObj.details.length>0){
            var strimage2 = goodsObj.details.join("|");
            param["image2"] = strimage2;
        }

        if ($("#stars1").val()) param["stars1"] = $("#stars1").val();
        if ($("#stars2").val()) param["stars2"] = $("#stars2").val();
        if ($("#stars3").val()) param["stars3"] = $("#stars3").val();
        if ($("#stars4").val()) param["stars4"] = $("#stars4").val();
        if ($("#stars5").val()) param["stars5"] = $("#stars5").val();
        if ($("#billingmode").val()) param["billingmode"] = $("#billingmode").val();

        if ($("#name").val()) param["name"] = $("#name").val();
        if ($("#stock").val()) param["stock"] = $("#stock").val();
        if ($("#deposit").val()) param["deposit"] = $("#deposit").val();
        if ($("#price").val()) param["price"] = $("#price").val();
        if ($("#vipprice").val()) param["vipprice"] = $("#vipprice").val();
        if ($("#purchase").val()) param["purchase"] = $("#purchase").val();
        if ($("#goodstype").val()) param["goodstype"] = $("#goodstype").val();
        if ($("#shop").val()) param["shop"] = $("#shop").val();
        if ($("#goodsdetail").val()) param["goodsdetail"] = $("#goodsdetail").val();
        if (goodsObj.type == 1){
            param["id"] = goodsObj.goodsId;
        }
        return param;
    },
    "getDetail": function () {
        var ajaxObj = {url: '/resource/goods/getDetail?id='+goodsObj.goodsId, async:true, method: "GET"};
        commonJS.sendAjaxRequest(ajaxObj, function (value) {
            $("#name").val(value.name);
            $("#deposit").val(value.deposit);
            $("#stock").val(value.stock);
            $("#price").val(value.price);
            $("#vipprice").val(value.vipprice);
            $("#purchase").val(value.purchase);
            $("#goodsdetail").text(value.goodsdetail);
            $("#stars1").val(value.stars1);
            $("#stars2").val(value.stars2);
            $("#stars3").val(value.stars3);
            $("#stars4").val(value.stars4);
            $("#stars5").val(value.stars5);

            $("#goodstype").val(value.goodstype);
            $("#shop").val(value.shop);
        });
    },
    "insertupdate": function () {/*新增编辑*/
        var param = goodsObj.getParam();
        console.log(param.toString());
        var url = '/resource/goods/insert';
        if (goodsObj.type == 1) {
            url = '/resource/goods/update';
        }
        var ajaxObj = {url:url, async:true, param:param, method: "POST"};
        commonJS.sendAjaxRequest(ajaxObj, function (value) {
            window.location.href="/controller/goods/list";
        });
    },
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
        if("1"==goodsObj.imgtype){
            goodsObj.addBinner(response._raw);
        }else if("2"==goodsObj.imgtype){
            goodsObj.addDetail(response._raw);
        }
    },
    "addBinner":function (obj) {

        goodsObj.binners.push(obj);

        $("#banner").empty();
        $(goodsObj.binners).each(function (i,item) {
            $("#banner").append("<img src='"+item+"' class='smallImage'/>");
        });
    },
    "addDetail":function (obj) {

        goodsObj.details.push(obj);

        $("#detail").empty();
        $(goodsObj.details).each(function (i,item) {
            $("#detail").append("<img src='"+item+"' class='smallImage'/>");
        });
    },
    "selectImg":function (imgtype) {
        goodsObj.imgtype = imgtype;
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