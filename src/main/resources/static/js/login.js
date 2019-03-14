// 显示注册页面
function gotoRegister() {
    document.getElementById("containerT").style.display="none";
    document.getElementById("containerR").style.display="block";
}
//判断注册时账号输入长度是否符合要求
function checkUid() {
    var uid = document.getElementById("register_name");
    var content = document.getElementById("register_tip").innerHTML;
    if(uid.value.length<4||uid.value.length>16)
        document.getElementById("register_tip").innerHTML="账号长度应为4～16";
    else
        document.getElementById("register_tip").innerHTML=content;
}
function checkPass() {
    var pass = document.getElementById("register_password");
    var content = document.getElementById("register_tip").innerHTML;
    if(pass.value.length<6||pass.value.length>16)
        document.getElementById("register_tip").innerHTML="密码长度应为6～16";
    else
        document.getElementById("register_tip").innerHTML=content;
}
function checkAgainPass() {
    var pass = document.getElementById("register_password");
    var content = document.getElementById("register_tip").innerHTML;
    var again_pass = document.getElementById("check_password");
    if(pass.value!=again_pass.value)
        document.getElementById("register_tip").innerHTML="密码不一致";
    else
        document.getElementById("register_tip").innerHTML=content;
}
//返回登录
function goBackEntry() {
    document.getElementById("containerT").style.display="block";
    document.getElementById("containerR").style.display="none";
}
// 开始注册操作
function toRegister() {
    var uid = document.getElementById("register_name");
    var pass = document.getElementById("register_password");
    var again_pass = document.getElementById("check_password");
    if(uid.value==""||pass.value==""||again_pass.value=="")
        document.getElementById("register_tip").innerHTML="输入不能为空";
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
                if(data.success=="1"){
                    if(confirm("注册成功，是否登录"))
                        goBackEntry();
                }else{
                    alert("服务器繁忙，请稍后重试")
                }
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
                userInfo = data.info;
                if(data.success=="1"){
                    // var url = "http://127.0.0.1/moonchat/index/goto";
                    // var url = "http://127.0.0.1/moonchat/index/temp";   //简陋版
                    var url = "http://127.0.0.1/moonchat/index/main";       //集成版
                    // document.load(url);
                    $("body").load(url);
                }else{
                    document.getElementById("entry_tip").innerHTML="登录失败，请检查账号密码是否正确";
                }
            }
        });
    }
}