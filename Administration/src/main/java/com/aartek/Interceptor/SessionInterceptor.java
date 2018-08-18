package com.aartek.Interceptor;

import java.util.logging.Handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.aartek.model.User;

@Component
public class SessionInterceptor extends HandlerInterceptorAdapter {

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Session Interceptor=========inside After Completion");
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Session Interceptor=========inside post handle");
	}

	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Session Interceptor=========inside preHandle");
		User usr = (User) req.getSession().getAttribute("email");
		//System.out.println(usr.getEmail());


		if (usr == null || usr.equals("")) {
			res.sendRedirect("login.do");
			return false;
		}

		System.out.println("This is preHandle !");
		return true;
	}
}
