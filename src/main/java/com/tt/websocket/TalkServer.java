package com.tt.websocket;

import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;


/**
 * 
 * @author ciker
 * @desc  聊天功能服务
 *
 */
@ServerEndpoint(value = "/talkServer", configurator = HttpSessionConfigurator.class)
public class TalkServer {
	
	
	/**
	 *  服务开启
	 * @param session
	 * @param config
	 */
	@OnOpen
	public void onOpen(Session session, EndpointConfig config){
		System.out.println("开启连接");
	}
	
	/**
	 * 消息处理
	 * @param message
	 */
	@OnMessage
	public void onMessage(String message){
		
	}
	
	/**
	 * 连接关闭时
	 * 调用的方法
	 */
	@OnClose
	public void onClose(){
		
	}
	
	/**
     * 发生错误时调用
     * @param error
     */
    @OnError
    public void onError(Throwable error){
        error.printStackTrace();
    }
}
