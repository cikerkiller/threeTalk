package com.tt.service;

import com.github.pagehelper.PageInfo;
import com.tt.common.ServerResponse;
import com.tt.pojo.Message;
import com.tt.vo.MessageVo;

public interface IMessageService {
	ServerResponse<String> insertMessage(MessageVo message);
	ServerResponse<String> deleteMessage(String messageId,String senderId);
	ServerResponse<String> readMessage(String receiverId,String senderId);
	ServerResponse<PageInfo<Message>> listMessage(String senderId,String receiverId,Integer pageNum,Integer pageSize);
}
