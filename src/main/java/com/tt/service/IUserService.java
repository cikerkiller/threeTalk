package com.tt.service;

import com.tt.common.ServerResponse;
import com.tt.pojo.User;


public interface IUserService {

    ServerResponse<User> login(String username,String password);

    ServerResponse<String> register(User user);

}
