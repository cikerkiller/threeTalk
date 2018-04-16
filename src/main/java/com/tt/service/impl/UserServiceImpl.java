package com.tt.service.impl;

import org.springframework.stereotype.Service;

import com.tt.common.ServerResponse;
import com.tt.pojo.User;
import com.tt.service.IUserService;

@Service("iUserService")
public class UserServiceImpl implements IUserService{

	@Override
	public ServerResponse<User> login(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServerResponse<String> register(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
