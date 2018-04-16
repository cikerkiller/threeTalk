package com.tt.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tt.common.ServerResponse;
import com.tt.common.TalkConstant;
import com.tt.pojo.User;
import com.tt.service.IUserService;

@Controller
@RequestMapping("/user/")
public class UserController {
	
	@Autowired
	private IUserService iUserService;
	
	@RequestMapping(value = "register.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> register(User user){
        return iUserService.register(user);
    }
	
	
	@RequestMapping(value = "login.do",method = RequestMethod.POST)
	@ResponseBody
	public ServerResponse<User> login(HttpSession session,User user){
		ServerResponse<User> response=iUserService.login(user);
		if(response.isSuccess()){
			session.setAttribute(TalkConstant.CURRENT_USER, user);
		}
		return response;
	}
	
}
