package com.tt.service;

import com.github.pagehelper.PageInfo;
import com.tt.common.ServerResponse;
import com.tt.pojo.Group;
import com.tt.pojo.GroupMembers;

public interface IGroupService {
	
	ServerResponse<String> createGroup(Group group);
	
	ServerResponse<String> addGroupMembers(String groupId,String members);
	
	ServerResponse<String> abortGroup(String groupId,String userId);
	
	ServerResponse<PageInfo<GroupMembers>> groupList(String userId,Integer pageNum,Integer paggSize);
}
