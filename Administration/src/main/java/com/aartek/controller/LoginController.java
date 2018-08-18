package com.aartek.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aartek.Validator.LoginValidator;
import com.aartek.model.User;
import com.aartek.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginservice;

	@Autowired
	private LoginValidator loginValidator;
	
	private static final Logger  log = Logger.getLogger(LoginController.class);

	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String userSignIn(@ModelAttribute("userMap") User user, BindingResult result, Map<String, Object> map,
			HttpServletRequest req, HttpServletResponse res) {
		System.out.println(System.currentTimeMillis());
	//	System.out.println("-----------------------inside Get controller--------------------------");
		log.info("-----------------------------------inside Get controller---------------------------------");
		System.out.println(req.getMethod());
		if ("GET".equals(req.getMethod())) {
			map.put("userMap", new User());
			return "login";
		} else {
			
			loginValidator.validate(user, result);
			if (result.hasErrors()) {
				return "login";
			} else {
				System.out.println("-------------------------Inside Post Controller--------------------------");
				String check = loginservice.checkEmailPassword(user.getEmail(), user.getPassword());
				System.out.println(check);
				if (check.equals("valid")) {
					System.out.println(check);
					try {
						HttpSession session = req.getSession();
						session.setAttribute("email",user);
						res.sendRedirect("product.do");
					} catch (Exception e) {
						e.printStackTrace();
					}
				} 
			}
		}
		System.out.println(System.currentTimeMillis());
		return "login";
		
	}
}