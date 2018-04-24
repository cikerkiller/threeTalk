package com.tt.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketStompConfig implements WebSocketMessageBrokerConfigurer {

	@Override
	public void registerStompEndpoints(StompEndpointRegistry stompendpointregistry) {
		stompendpointregistry.addEndpoint("/marcopilo").withSockJS();
		
	}

	@Override
	public void configureClientInboundChannel(ChannelRegistration channelregistration) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configureClientOutboundChannel(ChannelRegistration channelregistration) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry messagebrokerregistry) {
		/*messagebrokerregistry.enableSimpleBroker("/queue","/topic");
		*/
		messagebrokerregistry.setApplicationDestinationPrefixes("/app");
	}

}
