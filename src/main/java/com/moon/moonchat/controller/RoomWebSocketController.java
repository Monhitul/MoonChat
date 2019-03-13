package com.moon.moonchat.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.PingMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import javax.websocket.*;
import java.io.IOException;
import java.util.*;

/**
 * 接收websocket群聊频道请求
 */
public class RoomWebSocketController extends TextWebSocketHandler {
    private WebSocketSession webSocketSession;
    private Set sessions = new HashSet<WebSocketSession>();     //存储所有建立的session
    private String senderSessionId;   //发送者的sessionId
    private String receiverSessionId;       //接收者的sessionId
    private Map<String, String> uidSessionidMap = new HashMap<String, String>();     //用户Uid和sessionId的对应关系

    private Map<String, WebSocketSession> uidSessionMap = new HashMap<String, WebSocketSession>();
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        System.out.println("连接成功");
        sessions.add(session);
        String payload = message.getPayload();
        Map<String, String> msgMap = JSONObject.parseObject(payload, HashMap.class);    //收到的内容
        String sendUid = msgMap.get("id");
        String receiveUid = msgMap.get("towho");
        uidSessionMap.put(sendUid, session);
        if("all".equals(receiveUid)){       //群发
            Iterator iterator = sessions.iterator();
            while(iterator.hasNext()){
                WebSocketSession s = (WebSocketSession)iterator.next();
                s.sendMessage(new TextMessage(sendUid + "：" + msgMap.get("message")));
            }
        }else {

            Map<String, String> backMap = JSONObject.parseObject(payload, HashMap.class);   //返回给发送者的内容
            session.sendMessage(new TextMessage(payload));
            session.sendMessage(new TextMessage("我：" + msgMap.get("message")));

            webSocketSession = uidSessionMap.get(receiveUid);
            webSocketSession.sendMessage(new TextMessage(sendUid + "：" + msgMap.get("message")));
        }
    }

    @OnMessage
    public void sendMes(String towho, String data) throws IOException {
        webSocketSession.sendMessage(new TextMessage("这是某某给你发的消息"+data));
    }
}
