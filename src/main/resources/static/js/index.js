function login(){//登录
    var username = $("#login-username").val(),
        password = $("#login-password").val(),
        validatecode = null,
        flag = false;
    //判断用户名密码是否为空
    if(username == ""){
        $.pt({
            target: $("#login-username"),
            position: 'r',
            align: 't',
            width: 'auto',
            height: 'auto',
            content:"用户名不能为空"
        });
        flag = true;
    }
    if(password == ""){
        $.pt({
            target: $("#login-password"),
            position: 'r',
            align: 't',
            width: 'auto',
            height: 'auto',
            content:"密码不能为空"
        });
        flag = true;
    }
    //用户名只能是4到15位的字母或数字
    var regExp = new RegExp("^[a-zA-Z0-9_]{4,15}$");
    if(!regExp.test(username)){
        $.pt({
            target: $("#login-username"),
            position: 'r',
            align: 't',
            width: 'auto',
            height: 'auto',
            content:"用户名必须为4到15位的字母或数字"
        });
        flag = true;
    }

    if(flag){
        return false;
    }else{//登录
        //调用后台登录验证的方法
        var postdata = {
            uid : username,
            password : password
        };
        var url = "http://127.0.0.1/moonchat/login/check";
        $.ajax({
            url : url,
            type : 'POST',
            dataType : "json",
            data : JSON.stringify(postdata),
            contentType : 'application/json; charset=utf-8',
            error : function() {
                alert("登录失败，请重试");
            },
            success : function(data) {
                console.log(data);
                userInfo = data.info;
                if(data.success=="1"){
                    var url = "http://127.0.0.1/moonchat/index/main";       //集成版
                    $("html").load(url);
                    // document.load(url);
                }else{
                    alert("登录失败，请检查账号密码是否正确");
                }
            }
        });
        return false;
    }
}