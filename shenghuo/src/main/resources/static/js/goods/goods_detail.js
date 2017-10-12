$(function () {
    /*编辑页面初始化查询*/
    goodsObj.goodsId=$("#goodsId").val();
    goodsObj.init();
});

var goodsObj = {
    "imgtype":"",
    "binners":[],
    "details":[],
    "goodsId":"",
    "init":function () {
        goodsObj.getGoodstypeList();
        goodsObj.getShopList();
        goodsObj.getDetail();
    },
    "getDetail": function () {
        var ajaxObj = {url: '/resource/goods/getDetail?id='+goodsObj.goodsId, async:true, method: "GET"};
        commonJS.sendAjaxRequest(ajaxObj, function (value) {
            $("#name").text(value.name);
            $("#deposit").text(value.deposit);
            $("#stock").text(value.stock);
            $("#price").text(value.price);
            $("#vipprice").text(value.vipprice);
            $("#purchase").text(value.purchase);
            $("#goodsdetail").text(value.goodsdetail);
            $("#stars1").text(value.stars1);
            $("#stars2").text(value.stars2);
            $("#stars3").text(value.stars3);
            $("#stars4").text(value.stars4);
            $("#stars5").text(value.stars5);

            $("#billingmode").val(value.billingmode);
            $("#goodstype").val(value.goodstype);
            $("#shop").val(value.shop);
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
    }
};