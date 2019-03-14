window.onload = worldConnectWebSocket();

function worldConnectWebSocket() {
    console.log("世界频道开始连接...");

    //建立webSocket连接
    websocket = new WebSocket("ws://127.0.0.1/moonchat/socket/world/ID="+userInfo.uid);

    //打开webSokcet连接时，回调该函数
    websocket.onopen = function () {
        console.log("onpen");
        var Message={};
        Message.src = userInfo.uid;
        Message.dest = "lin";       //用于建立连接
        Message.srcname = userInfo.nickname;
        // Message.srcname = "啦啦啦啊摘月亮";
        Message.msg = "";

        websocket.send(JSON.stringify(Message));
    };

    //关闭webSocket连接时，回调该函数
    websocket.onclose = function () {
        console.log("onclose");
        if(confirm("连接意外断开，请重新登录。")){
            location.reload();
        }
    };

    //接收信息
    websocket.onmessage = function (msg) {
        var msgJson = JSON.parse(msg.data);
        console.log(msgJson);

        var content = msgJson.srcName + "：(" + msgJson.time + ")" + "<br>" + msgJson.msg + "<br>";
        var showContent = document.getElementById("world-content");
        showContent.innerHTML += content;
        showContent.scrollTop = showContent.scrollHeight;

        // document.getElementById("world-content").innerHTML += "<br>";
    }

}

//发送消息
function worldSend() {
    // input输入框
    var content = document.getElementById("world-input");
    if(content.value == "")
        alert("发送内容不能为空");
    else{
        var Message={};
        Message.src = userInfo.uid;
        Message.dest = "all";
        Message.srcname = userInfo.nickname;
        // Message.srcname = "啦啦啦啊摘月亮";
        Message.msg = content.value;

        websocket.send(JSON.stringify(Message));
        content.value = "";
    }

    // UMeditor输入
    // if(umWolrd.hasContents()==true){
    //     var content = umWolrd.getContent();
    //     var Message={};
    //     Message.src = userInfo.uid;
    //     Message.dest = "all";
    //     Message.srcname = userInfo.uid;
    //     // Message.srcname = "啦啦啦啊摘月亮";
    //     Message.msg = content;
    //
    //     websocket.send(JSON.stringify(Message));
    //
    //     //发送成功清空
    //     umWolrd.execCommand('cleardoc');
    // }else{
    //     alert("输入不能为空");
    // }
}

//关闭连接
function closeWebSocket(){
    if(websocket != null) {
        websocket.close();
    }
}
