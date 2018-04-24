package com.tt.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import com.tt.pojo.Shout;  
  
/**
 * 
 * @author ciker
 * @desc  消息控制器 
 *
 */
@Controller  
public class MessageController {  
	
	@MessageMapping("/marco")
    public void handleShout(Shout shout) {
	   System.out.println("this is a shout");
    }
      
}  