package com.moon.moonchat.controller;

import com.alibaba.fastjson.JSONObject;
import com.moon.moonchat.entity.Message;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import javax.websocket.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 接收websocket世界频道请求
 */
public class WorldWebSocketController extends TextWebSocketHandler {
    private WebSocketSession webSocketSession;
    private Set LinkedSessions = new HashSet<WebSocketSession>();     //存储所有建立的session

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        System.out.println(session.getId()+" 连接成功");
        LinkedSessions.add(session);
        String payload = message.getPayload();
        Map<String, String> msgMap = JSONObject.parseObject(payload, HashMap.class);    //收到的内容
        System.out.println(msgMap);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        if(!"lin".equals(msgMap.get("dest"))) {     //lin表示用于客户与服务端建立连接的第一次请求
            Message backMessage = new Message(msgMap.get("src"), msgMap.get("dest"), msgMap.get("srcname"), msgMap.get("msg"), sdf.format(new Date()));
            String backStr = JSONObject.toJSON(backMessage).toString();

            Iterator iterator = LinkedSessions.iterator();
            while (iterator.hasNext()) {
                webSocketSession = (WebSocketSession) iterator.next();
                webSocketSession.sendMessage(new TextMessage(backStr));
            }
        }
    }

    @OnMessage
    public void sendMes(String towho, String data) throws IOException {
        webSocketSession.sendMessage(new TextMessage("这是某某给你发的消息"+data));
    }
}
