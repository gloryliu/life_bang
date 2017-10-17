
var goodstypeObj = {
    "insertupdate": function (id,parent,text,action) {/*新增*/
        $("#typename").val("");
        layer.open({
            title: "填写名称",
            type: 1,
            content: $('#typenameDiv'),
            closeBtn: 1,
            area: ['400px', '250px'],
            btn: ['确定', '取消'],
            yes: function (index) {
                var typename = $("#typename").val();
                if (!typename){
                    layer.alert("名称为必填项");
                    return false;
                }
                var ajaxObj;
                if (id) {
                    ajaxObj = {url: '/resource/goodstype/update', async:true, param:{"id":id,"typename":typename}, method: "POST"};
                } else {
                    ajaxObj = {url: '/resource/goodstype/insert', async:true, param:{"typename":typename}, method: "POST"};
                }
                commonJS.sendAjaxRequest(ajaxObj, function (value) {
                    layer.close(index);
                    goodstypeObj.getAllList();
                });
            },
            cancel: function () {
            }
        });
    },
    "deleteById": function (id) {/*新增*/
        var ajaxObj = {url: '/resource/goodstype/deleteById?id='+id, method: "POST"};
        commonJS.sendAjaxRequest(ajaxObj, function (value) {
            goodstypeObj.getAllList();
        });
    }
};