package com.tt.service;

import com.github.pagehelper.PageInfo;
import com.tt.common.ServerResponse;
import com.tt.pojo.User;


public interface IUserService {

    ServerResponse<User> login(String username,String password);

    ServerResponse<String> register(User user);
    
    ServerResponse<PageInfo<User>> search(String username,Integer age,Integer gender,String address,Integer pageNum, Integer pageSize);
}
