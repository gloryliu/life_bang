$(function () {
    /*初始化查询*/
    shopObj.getAllList();
});

var shopObj = {
    "getAllList": function () {
        var ajaxObj = {url: '/resource/shop/getAllList', async:true, method: "POST"};
        commonJS.loading("open");
        commonJS.sendAjaxRequest(ajaxObj, function (value) {
            $("#data").html($("#dataTemplate").render(value));
        });
        commonJS.loading("close");
    },
    "insertupdate": function (id) {/*新增*/
        $("#shopname").val("");
        layer.open({
            title: "填写店铺名称",
            type: 1,
            content: $('#shopDiv'),
            closeBtn: 1,
            area: ['400px', '250px'],
            btn: ['确定', '取消'],
            yes: function (index) {
                var shopname = $("#shopname").val();
                if (!shopname){
                    layer.alert("名称为必填项");
                    return false;
                }
                var ajaxObj;
                if (id) {
                    ajaxObj = {url: '/resource/shop/update', async:true, param:{"id":id,"shopname":shopname}, method: "POST"};
                } else {
                    ajaxObj = {url: '/resource/shop/insert', async:true, param:{"shopname":shopname}, method: "POST"};
                }
                commonJS.sendAjaxRequest(ajaxObj, function (value) {
                    layer.close(index);
                    shopObj.getAllList();
                });
            },
            cancel: function () {
            }
        });
    },
    "deleteById": function (id) {/*新增*/
        var ajaxObj = {url: '/resource/shop/deleteById?id='+id, method: "POST"};
        commonJS.sendAjaxRequest(ajaxObj, function (value) {
            shopObj.getAllList();
        });
    }
};