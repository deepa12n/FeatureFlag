package com.websocket.chat.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.web.socket.messaging.WebSocketStompClient;

public class WebsocketClient {

	@Autowired 
	private WebSocketStompClient stompClient;

		StompSessionHandler sessionHandler = new CustomStompSessionHandler();
		

		

		
	
	
	}


