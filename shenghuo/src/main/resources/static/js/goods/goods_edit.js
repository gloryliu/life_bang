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

    "binners":[],
    "goodsId":"",
    "type":"",
    "checkIsOK":true,
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
            param["banners"] = strimage1;
        }

        if($("#type1").val()==0){
            commonJS.alert("请选择类型");
            serviceObj.checkIsOK = false;
            return;
        }
        if ($("#goodsName").val()) param["goodsName"] = $("#goodsName").val();

        if ($("#type2").val()) param["goodsType"] = $("#type2").val();

        var contextDetail = window.euditorFrame.getContent();
        param["goodsDetail"] = contextDetail;

        if ($("#stock").val()) param["stock"] = $("#stock").val();

        if ($("#isBanner").val()) param["isBanner"] = $("#isBanner").val();

        if ($("#originalPrice").val()) param["originalPrice"] = $("#originalPrice").val();

        if ($("#profit").val()) param["profit"] = $("#profit").val();

        if ($("#goodsImg").val()) param["goodsImg"] = $("#goodsImg").val();
        // if ($("#goodstype").val()) param["goodsType"] = $("#goodstype").val();

        if ($("#serviceProvider").val()) param["serviceProvider"] = $("#serviceProvider").val();

        if ($("#freight").val()) param["freight"] = $("#freight").val();

        if ($("#isCarry").val()) param["isCarry"] = $("#isCarry").val();

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
        if(!goodsObj.checkIsOK){
            return;
        }
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
};