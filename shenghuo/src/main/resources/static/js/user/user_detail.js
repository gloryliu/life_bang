$(function () {
    /*编辑页面初始化查询*/
    userDetailObj.userId=$("#userIdhidden").val();
    userDetailObj.init();
});

var userDetailObj = {
    "userId":"",
    "init":function () {
        userDetailObj.getDetail();
    },
    "getDetail": function () {
        var ajaxObj = {url: '/resource/user/getDetail?id='+userDetailObj.userId, async:true, method: "GET"};
        commonJS.sendAjaxRequest(ajaxObj, function (value) {
            $("#userId").text(value.userId);
            $("#nickname").text(value.nickname);
            $("#name").text(value.name);
            $("#phone").text(value.phone);
            $("#birthday").text(value.birthday);
            $("#vipgrade").text(value.vipgrade);
            $("#paytime").text(new Date(value.paytime).format("yyyy-MM-dd hh:mm:ss"));
            $("#endtime").text(new Date(value.endtime).format("yyyy-MM-dd hh:mm:ss"));

            $("#sex").val(value.sex);
        });
    }
};