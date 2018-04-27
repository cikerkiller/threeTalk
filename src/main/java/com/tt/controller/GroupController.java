package com.tt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.tt.common.ServerResponse;
import com.tt.pojo.Group;
import com.tt.pojo.GroupMembers;
import com.tt.service.IGroupService;

@Controller("/group")
public class GroupController {
	
	@Autowired
	private IGroupService iGroupService;
	
	/**
	 * 建群
	 * @param group
	 * @return
	 */
	@RequestMapping("create_group")
	@ResponseBody
	public ServerResponse<String> createGroup(Group group){
		return iGroupService.createGroup(group);
	}
	
	/**
	 * 给群加人
	 * @param groupId
	 * @param members
	 * @return
	 */
	@RequestMapping("add_group_members")
	@ResponseBody
	public ServerResponse<String> addGroupMembers(String groupId,String members){
		return iGroupService.addGroupMembers(groupId,members);
	}
	
	/**
	 * 退群
	 * @param groupId
	 * @param members
	 * @return
	 */
	@RequestMapping("abort_group")
	@ResponseBody
	public ServerResponse<String> abortGroup(String groupId,String userId){
		return iGroupService.abortGroup(groupId,userId);
	}
	
	/**
	 * 群列表
	 * @param userId
	 * @return
	 */
	@RequestMapping("list_group")
	@ResponseBody
	public ServerResponse<PageInfo<GroupMembers>> groupList(String userId,
			@RequestParam(value="pageNum",defaultValue="1") Integer pageNum,
			@RequestParam(value="pageSize",defaultValue="10") Integer pageSize){
		return iGroupService.groupList(userId,pageNum,pageSize);
	}
	
	
	
}
