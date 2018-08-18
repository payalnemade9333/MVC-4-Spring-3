package com.aartek.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aartek.Validator.RegistrationValidator;
import com.aartek.model.User;
import com.aartek.service.LoginService;
import com.aartek.service.RegistartionService;

@Controller
public class RegistrationController {
	@Autowired
	private RegistrationValidator registrationvalidator;

	@Autowired
	private RegistartionService registrationservice;

	@RequestMapping("/registration")
	public String showRegistration(Map<String, Object> map) {
		System.out.println("-----------------Inside Controller-Registration--------------------");
		map.put("registrationMap", new User());
		return "registration";
	}

	@RequestMapping(value = "/userregistration", method = RequestMethod.POST)
	public String userSignInAction(@ModelAttribute("registrationMap") User usr, BindingResult result) {
		boolean status = false;
		if (result.hasErrors()) {
			return "registration";
		} else {

			System.out.println("-------------------Inside Controller-userreg----------------");
			System.out.println(usr.getEmail());
			System.out.println(usr.getPassword());
			System.out.println(usr.getFirstname());
			System.out.println(usr.getLastname());
			System.out.println(usr.getMobileno());
			registrationvalidator.validate(usr, result);
			registrationservice.checkLogin(usr);
			return "registration";
		}
	}

}