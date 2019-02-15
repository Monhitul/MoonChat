// 显示注册页面
function gotoRegister() {
    document.getElementById("containerT").style.display="none";
    document.getElementById("containerR").style.display="block";
}
// 开始注册操作
function toRegister() {
    // document.getElementById("containerT").style.display="block";
    // document.getElementById("containerR").style.display="none";

    var uid = document.getElementById("register_name");
    var pass = document.getElementById("register_password");
    var again_pass = document.getElementById("check_password");
    if(pass.value!=again_pass.value){
        alert("不相等");
        document.getElementById("register_tip").innerHTML="密码不一致";
    }
    else{
        var postdata = {
            uid : uid.value,
            password : pass.value
        };
        var url = "http://127.0.0.1/moonchat/login/register";
        $.ajax({
            url : url,
            type : "POST",
            dataType : "json",
            data : JSON.stringify(postdata),
            contentType: "application/json;charset=UTF-8",
            error : function() {
                document.getElementById("entry_tip").innerHTML="注册失败，请重试";
            },
            success : function(data) {
                console.log(data);
            }
        });
    }
}
// 登录操作
function toEntry() {
    var uid = document.getElementById("entry_name");
    var pass = document.getElementById("entry_password");
    if(uid.value==""||pass.value=="")
        document.getElementById("entry_tip").innerHTML="输入不能为空";
    else{
        var postdata = {
            uid : uid.value,
            password : pass.value
        };
        var url = "http://127.0.0.1/moonchat/login/check";
        $.ajax({
            url : url,
            type : 'POST',
            dataType : "json",
            data : JSON.stringify(postdata),
            contentType : 'application/json; charset=utf-8',
            error : function() {
                document.getElementById("entry_tip").innerHTML="登录失败，请重试";
            },
            success : function(data) {
                console.log(data);
            }
        });
    }
}