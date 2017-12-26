$(function () {
    /*初始化查询*/
    goodsListObj.getGoodsList();
    goodsListObj.getGoodstypeList();
    goodsListObj.getShopList();
    $("#insert").on("click",function () {
        window.location.href="/controller/goods/edit";
    });

    $("#searchButton").on("click",function () {
        goodsListObj.getGoodsList();
    });

    /**
     * 扩展jquery方法，调用公共分页
     */
    jQuery.extend({
        'pageList':function(){
            goodsListObj.getGoodsList();//调用分页查询接口
        }
    });
});

var goodsListObj = {
    "getCondition": function () {/*获取查询条件*/
        var param = {};
        
        var goodstype = $("#goodstype").val();
        if(goodstype)  param["goodstype"] = goodstype;

        var shop = $("#shop").val();
        if(shop)  param["shop"] = shop;

        var name = $("#name").val();
        if(name)  param["goodsName"] = name;

        param["pageSize"] = basePageObj.pageObj.pageSize;
        param["pageNum"] = basePageObj.pageObj.pageNo;
        return param;
    },
    "getGoodsList": function () {/*获取组合列表信息*/
        var params = goodsListObj.getCondition();
        var ajaxObj = {url: '/resource/goods/getAllList', async:true, param:params, method: "POST"};
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
    "changeRecState":function (obj,goodsId) {
        console.log(obj.checked);
        layer.confirm('确定要特卖？', {
            btn: ['确定','取消'] //按钮
        }, function(){
            var params = {};
            if(goodsId)  params["goodsId"] = goodsId;
            if(obj.checked){
                params["state"] = 1;
            }else {
                params["state"] = 0;
            }

            layer.closeAll('dialog');

            var ajaxObj = {url: '/resource/goods/changeRecGoodsState', async:true, param:params, method: "POST"};
            commonJS.sendAjaxRequest(ajaxObj, function (value) {
                goodsListObj.getGoodsList();
            });

        }, function(){
            layer.closeAll('dialog');
        });
    }
};
//根据id改变商品删除状态
function changeGoodsDeleteFlag(goodsid, deleteflag){
    var infostr = '是否删除该商品？';
    if(deleteflag == 1){
        infostr = '是否恢复该商品？'
    }
    layer.confirm(infostr, {
        btn: ['确定','取消'] //按钮
    }, function () {
        var ajaxObj = {url: '/resource/goods/changeGoodsDeleteFlag?goodsId=' + goodsid, async:true, method: "POST"};
        commonJS.sendAjaxRequest(ajaxObj, function (value) {
            goodsListObj.getGoodsList();
            layer.closeAll();
        });
    }, function () {

    });
}