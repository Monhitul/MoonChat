package com.moon.moonchat.config;

import com.moon.moonchat.controller.WorldWebSocketController;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 *
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//        对应私聊、群聊、世界三个频道
        registry.addHandler(privateHandler(), "socket/private/{ID}").setAllowedOrigins("*");
        registry.addHandler(roomHandler(), "socket/room/{ID}").setAllowedOrigins("*");
        registry.addHandler(worldHandler(), "socket/world/{ID}").setAllowedOrigins("*");
    }
    public WebSocketHandler privateHandler() {
        return new WorldWebSocketController();
    }
    public WebSocketHandler roomHandler() {
        return new WorldWebSocketController();
    }
    public WebSocketHandler worldHandler() {
        return new WorldWebSocketController();
    }
}
