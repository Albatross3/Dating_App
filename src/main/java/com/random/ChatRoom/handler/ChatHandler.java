package com.random.ChatRoom.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.HashSet;
import java.util.Set;


public class ChatHandler extends TextWebSocketHandler {

    private static final Logger logger = LoggerFactory.getLogger(ChatHandler.class);
    private static long number = 0L;
    private Set<WebSocketSession> sessionSet = new HashSet<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessionSet.add(session);
        session.sendMessage(new TextMessage(Long.toString(++number)));

        logger.info(session + " 클라이언트 접속");
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // message 받기
        String payload = message.getPayload();
        System.out.println(payload);

        // 받은 message session 마다 전송
        for (WebSocketSession sess : sessionSet) {
            sess.sendMessage(new TextMessage(payload));
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessionSet.remove(session);
        logger.info(session + " 클라이언트 접속 해제");
    }


}
