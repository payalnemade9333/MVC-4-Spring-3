package com.aartek.repository;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.model.User;

@Repository
public class LoginRepository {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	/*
	 * public void checkLogin(User usr) { System.out.
	 * println("-------------------Inside Login Repository----------------------");
	 * System.out.println(usr.getEmail()); System.out.println(usr.getPassword());
	 * 
	 * //hibernateTemplate.save(usr);
	 * //hibernateTemplate.find("from users u where u.email=? and u.password=?",
	 * usr.getEmail() , usr.getPassword()); }
	 */
	public String checkEmailPassword(String email, String password) {
		System.out.println("-----------------------Inside Login Repository----------------------");
		List list = hibernateTemplate.find("from User u where u.email=? and u.password=?", email, password);
		Iterator itr = list.iterator();
		String email1 = null;
		String password1 = null;
		String check = null;
		while (itr.hasNext()) {
			User usr = (User) itr.next();
			email1 = usr.getEmail();
			password1 = usr.getPassword();
		}
		System.out.println(email1);
		System.out.println(password1);
        System.out.println(email);
		if (email1.equals(email) && password1.equals(password)) {
			System.out.println(email + " Login successfully");
			check = "valid";
		} else {
			System.out.println(" Invalid email password");
			check = "not valid";
		}
		//System.out.println(check);
		return check;
	}

	public void checkLogin(User user) {
		System.out.println("Inside Service");
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
	}
}
