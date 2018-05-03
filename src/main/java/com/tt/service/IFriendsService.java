package com.tt.service;

import java.util.List;

import com.tt.common.ServerResponse;
import com.tt.pojo.Friends;
import com.tt.pojo.User;

public interface IFriendsService {
	
	ServerResponse<String> addFriends(String userId,String friendId);
	ServerResponse<String> updateNote(String userId,String friendId,String note);
	ServerResponse<String> addBlacklist(String userId,String friendId);
	ServerResponse<String> delete(String userId,String friendId);
	ServerResponse<User> queryFriendDetail(String friendId);
	ServerResponse<List<Friends>> list(String userId);
	

}
