package com.tt.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.tt.common.MessageStatusEnum;
import com.tt.common.ResponseCode;
import com.tt.common.ServerResponse;
import com.tt.common.TalkConstant;
import com.tt.pojo.Message;
import com.tt.pojo.SpecialResult;
import com.tt.pojo.User;
import com.tt.service.IMessageService;
import com.tt.service.IUserService;
import com.tt.vo.MessageVo;
  
/**
 * 
 * @author ciker
 * @desc  消息控制器 
 *
 */
@Controller
@RequestMapping("/message/")
public class MessageController {  
	
	@Autowired
	private IUserService iUserService;
	
	@Autowired
	private IMessageService iMessageService;
	
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
    
	/**
	 * 单对单发送消息
	 * @param message
	 * @throws Exception
	 */
	@MessageMapping("/simple_send")  
    public void sendSimpleMessage(MessageVo message) throws Exception { 
		String receiverId=message.getReceiverId();
		String senderId=message.getSenderId();
		ServerResponse<String> response= iMessageService.insertMessage(message);
		if(response.isSuccess()){
			message.setMessageId(response.getData());
			simpMessagingTemplate.convertAndSendToUser(receiverId,"/simple_send", message);
			simpMessagingTemplate.convertAndSendToUser(senderId,"/simple_send", MessageStatusEnum.success.getCode());
		}else{
			simpMessagingTemplate.convertAndSendToUser(senderId,"/message/simple_send", MessageStatusEnum.error.getCode());
		}
    }
	
	/**
	 * 撤回消息
	 * @param messageId
	 * @return
	 */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public ServerResponse<String> deleteMessage(MessageVo message){
		return iMessageService.deleteMessage(message.getMessageId(),message.getSenderId());
	}
	
	@RequestMapping("/read_message")
	@ResponseBody
	public ServerResponse<String> readMessage(MessageVo message){
		//接收者是自己，即当自己去点击有未读消息用户图标时，会调用这个接口
		return iMessageService.readMessage(message.getReceiverId(),message.getSenderId());
	}
	
	/**
	 * 消息列表
	 * @param message
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public ServerResponse<PageInfo<Message>> listMessage(MessageVo message,
			@RequestParam(value="pageNum",defaultValue="1") Integer pageNum,
			@RequestParam(value="pageSize",defaultValue="10") Integer pageSize){
		return iMessageService.listMessage(message.getSenderId(),message.getReceiverId(),pageNum,pageSize);
	}
	
	
	@RequestMapping("/unread_list")
	@ResponseBody
	public ServerResponse<List<SpecialResult>> unreadListMessage(HttpSession session){
		User user=(User)session.getAttribute(TalkConstant.CURRENT_USER);
		if(user==null){
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
		}
		return iMessageService.unreadListMessage(user.getId());
	}
	
	
	
}  