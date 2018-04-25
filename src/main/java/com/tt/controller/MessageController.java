package com.tt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import com.tt.pojo.Message;
import com.tt.service.IUserService;
  
/**
 * 
 * @author ciker
 * @desc  消息控制器 
 *
 */
@Controller  
public class MessageController {  
	
	@Autowired
	private IUserService iUserService;
	
	@MessageMapping("/marco")
    public void handleShout(Message message) {
	   System.out.println("this is a message"+message);
	  System.out.println(iUserService.search("hf", 1, 10).getData().getList().get(0).toString());
    }
    
	
}  