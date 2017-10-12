$(function () {
    /*初始化查询*/
    vipObj.getAllList();
});

var vipObj = {
    "getAllList": function () {
        var ajaxObj = {url: '/resource/viptype/getAllList', async:true, method: "GET"};
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
                var grade = $("#grade").val();
                var money = $("#money").val();

                if (!money){
                    layer.alert("会员押金必填");
                    return false;
                }

                if (!name){
                    layer.alert("名称必填");
                    return false;
                }

                if (!grade){
                    layer.alert("等级必填");
                    return false;
                }

                var ajaxObj;
                if (id) {
                    var updateParam = {"id":id,"name":name,"grade":grade,"money":money};
                    ajaxObj = {url: '/resource/viptype/update', async:true, param:updateParam, method: "POST"};
                } else {
                    var insertParam = {"name":name,"grade":grade,"money":money};
                    ajaxObj = {url: '/resource/viptype/insert', async:true, param:insertParam, method: "POST"};
                }
                commonJS.sendAjaxRequest(ajaxObj, function (value) {
                    layer.close(index);
                    vipObj.getAllList();
                });
            },
            cancel: function () {
            }
        });
    },
    "deleteById": function (id) {/*新增*/
        var ajaxObj = {url: '/resource/viptype/deleteById?id='+id, method: "GET"};
        commonJS.sendAjaxRequest(ajaxObj, function (value) {
            vipObj.getAllList();
        });
    }
};