package com.aartek.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.model.User;
import com.aartek.repository.LoginRepository;

@Service
public class LoginService {
	@Autowired
	private LoginRepository loginrepository;

	/*
	 * public void checkLogin(User usr) { System.out.
	 * println("------------------------Inside Login  Service-----------------------"
	 * ); System.out.println(usr.getEmail()); System.out.println(usr.getPassword());
	 * loginrepository.checkLogin(usr); }
	 */
	public String checkEmailPassword(String email, String password) {

		System.out.println("Inside Service");
		String check = loginrepository.checkEmailPassword(email, password);
		System.out.println(check);
		if (check.equals("valid")) {
			System.out.println(check);
			return check;
		} else {
			System.out.println(check);
			return check;
		}
	}
}
