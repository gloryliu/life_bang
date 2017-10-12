$(function () {
    /*初始化查询*/
    adminObj.getAllList();
    adminObj.getShopList();
});

var adminObj = {
    "getAllList": function () {
        var ajaxObj = {url: '/resource/admin/getAllList', async:true, method: "GET"};
        commonJS.loading("open");
        commonJS.sendAjaxRequest(ajaxObj, function (value) {
            $("#data").html($("#dataTemplate").render(value));
        });
        commonJS.loading("close");
    },
    "insertupdate": function (id) {/*新增*/
        layer.open({
            title: "填写店铺名称",
            type: 1,
            content: $('#shopDiv'),
            closeBtn: 1,
            area: ['400px', '250px'],
            btn: ['确定', '取消'],
            yes: function (index) {
                var name = $("#name").val();
                var phone = $("#phone").val();
                var adminname = $("#adminname").val();
                var adminpwd = $("#adminpwd").val();
                var shopname=$("#shop").find("option:selected").text();
                var shopId = $("#shop").val();

                if (!phone){
                    layer.alert("电话必填");
                    return false;
                }

                if (!name){
                    layer.alert("姓名必填");
                    return false;
                }

                if (!adminname){
                    layer.alert("登录账号必填");
                    return false;
                }

                if (!adminpwd){
                    layer.alert("登录密码必填");
                    return false;
                }

                if (!shopId){
                    layer.alert("门店必填");
                    return false;
                }

                var ajaxObj;
                if (id) {
                    var updateParam = {"id":id,"name":name,"phone":phone,"adminname":adminname,"adminpwd":adminpwd,"shopname":shopname,"shopId":shopId};
                    ajaxObj = {url: '/resource/admin/update', async:true, param:updateParam, method: "POST"};
                } else {
                    var insertParam = {"name":name,"phone":phone,"adminname":adminname,"adminpwd":adminpwd,"shopname":shopname,"shopId":shopId};
                    ajaxObj = {url: '/resource/admin/insert', async:true, param:insertParam, method: "POST"};
                }
                commonJS.sendAjaxRequest(ajaxObj, function (value) {
                    layer.close(index);
                    adminObj.getAllList();
                });
            },
            cancel: function () {
            }
        });
    },
    "deleteById": function (id) {/*新增*/
        var ajaxObj = {url: '/resource/admin/deleteById?id='+id, method: "GET"};
        commonJS.sendAjaxRequest(ajaxObj, function (value) {
            vipObj.getAllList();
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
};