package com.aartek.repository;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.model.User;

@Repository
public class RegistrationRepository {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public void checkLogin(User usr) {
		System.out.println("---------------Inside  Registration Repository-------------------");
		System.out.println(usr.getEmail());
		System.out.println(usr.getPassword());
		System.out.println(usr.getFirstname());
		System.out.println(usr.getLastname());
		System.out.println(usr.getMobileno());
		hibernateTemplate.save(usr);
	}

	public String checkEmail(String email) {
		List<User> list = hibernateTemplate.find("from User u where u.email=?", email);
		Iterator itr = list.iterator();
		while (itr.hasNext()) {
			User u = (User) itr.next();
			email = u.getEmail();
		}
		return "email";
	}
}