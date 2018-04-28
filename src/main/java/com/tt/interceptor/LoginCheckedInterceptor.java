package com.tt.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.tt.common.TalkConstant;
import com.tt.pojo.User;

public class LoginCheckedInterceptor implements HandlerInterceptor{
	private List<String> sendRedirect;
	
	
	public List<String> getSendRedirect() {
		return sendRedirect;
	}

	public void setSendRedirect(List<String> sendRedirect) {
		this.sendRedirect = sendRedirect;
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res,
			Object obj) throws Exception {
		String requestUri = req.getRequestURI();
		if(!StringUtils.contains(requestUri, "/login")){
			User user=(User) req.getSession().getAttribute(TalkConstant.CURRENT_USER);
			if(user==null){
				req.getRequestDispatcher("/user/login").forward(req, res);
				return false;
			}
		}
		return true;
	}

}
