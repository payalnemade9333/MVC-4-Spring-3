package com.aartek.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.model.User;
import com.aartek.repository.LoginRepository;
import com.aartek.repository.RegistrationRepository;
@Service
public class RegistartionService {
	@Autowired
	private RegistrationRepository registrationrepository;
	
	public void checkLogin(User usr) {
		System.out.println("----------------------Inside Registration service-------------------");
		System.out.println(usr.getEmail());
		System.out.println(usr.getPassword());
		System.out.println(usr.getFirstname());
		System.out.println(usr.getLastname());
		System.out.println(usr.getMobileno());
		registrationrepository.checkLogin(usr);
	}
}