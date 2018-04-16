package com.tt.service;

import com.tt.common.ServerResponse;
import com.tt.pojo.User;

public interface IUserService {

    ServerResponse<User> login(User user);

    ServerResponse<String> register(User user);

}
