
$(function () {
    //粒子背景特效
    $('body').particleground({
        dotColor: '#5cbdaa',
        lineColor: '#5cbdaa'
    });
    $(".submit_btn").click(function(){
        //location.href="index.html";
        loginObj.login();
    });

   /* var msg = $("#msg").val();
    if(!msg){
        alert(msg);
    }
    console.log($("#msg").val());*/

});

var loginObj = {
    "login": function () {

        var adminname = $("#adminname").val();
        var adminpwd = $("#adminpwd").val();

        var ajaxObj = {url: '/resource/admin/loginCheck?adminname='+adminname+'&adminpwd='+adminpwd, async:true, method: "GET"};
        commonJS.sendAjaxRequest(ajaxObj, function (value) {

            if(value == 1){
                layer.alert("用户名或密码错误");
                //window.location.href="/controller/admin/loginCheck?value="+value;
            } else{
                window.location.href="/controller/admin/index";
            }
        });
    }
};