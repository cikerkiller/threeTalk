package com.tt.service.impl;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tt.common.ServerResponse;
import com.tt.dao.UserMapper;
import com.tt.pojo.User;
import com.tt.service.IUserService;
import com.tt.util.MD5Util;

@Service("iUserService")
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public ServerResponse<User> login(String username,String password) {
		int resultCount=userMapper.checkUsername(username);
		if(resultCount==0){
			return ServerResponse.createByErrorMessage("用户名不存在");
		}
		//密码加密
		password=MD5Util.MD5EncodeUtf8(password);
		User user=userMapper.selectByUsernameAndPassword(username, password);
		if(user==null){
			return ServerResponse.createByErrorMessage("密码错误");
		}
		//密码置空
		user.setPassword(StringUtils.EMPTY);
		return ServerResponse.createBySuccess(user);
	}

	@Override
	public ServerResponse<String> register(User user) {
		int resultCount=userMapper.checkUsername(user.getUsername());
		if(resultCount > 0){
			return ServerResponse.createByErrorMessage("用户名已存在");
		}
		user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));
		user.setId(UUID.randomUUID().toString());
		int resultCode=userMapper.insert(user);
		if(resultCode==0){
			 return ServerResponse.createByErrorMessage("注册失败");
        }
        return ServerResponse.createBySuccessMessage("注册成功");
	}

	@Override
	public ServerResponse<PageInfo<User>> search(String username, Integer age, Integer gender,
			String address,Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<User> list=userMapper.selectByAnyCondition(username, age, gender, address);
		PageInfo<User> pageInfo=new PageInfo<>(list);
		return ServerResponse.createBySuccess(pageInfo);
	}
	
}
