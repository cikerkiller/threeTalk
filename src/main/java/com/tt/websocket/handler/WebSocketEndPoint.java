package com.tt.websocket.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class WebSocketEndPoint extends TextWebSocketHandler{
	private static Logger log=LoggerFactory.getLogger(WebSocketEndPoint.class);
	@Override
	protected void handleTextMessage(WebSocketSession session,
			TextMessage message) throws Exception {
		super.handleTextMessage(session, message);
		TextMessage returnMessage = new TextMessage(message.getPayload()+" received at server");  
		log.info("handleTextMessage....");
		session.sendMessage(returnMessage);  
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		log.info("afterConnectionClosed....");
		super.afterConnectionClosed(session, status);
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		log.info("afterConnectionEstablished....");
		super.afterConnectionEstablished(session);
	}

	
	
	
}
