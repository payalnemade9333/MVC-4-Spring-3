package com.aartek.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aartek.model.User;
@Controller
public class LogoutController {
	@RequestMapping(value = "/logout", method = { RequestMethod.GET})
	public String logoutSession(User user, HttpServletRequest req, HttpServletResponse res) {
			req.getSession().invalidate();
			req.getSession().setAttribute("userMsg", "Session Invalid");
			return "redirect:/login.do";
	}
}
