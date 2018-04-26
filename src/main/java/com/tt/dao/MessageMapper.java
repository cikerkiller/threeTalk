package com.tt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tt.pojo.Message;

public interface MessageMapper {
    int deleteByPrimaryKey(String id);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
    
    List<Message> listMessage(@Param("senderId") String senderId,@Param("receiverId") String receiverId);
    
    int updateMessageStatus(Integer status,String id);
}