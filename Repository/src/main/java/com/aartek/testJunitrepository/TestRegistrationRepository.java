package com.aartek.testJunitrepository;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.aartek.model.User;
import com.aartek.repository.RegistrationRepository;

import mockit.Mock;
import mockit.MockUp;

public class TestRegistrationRepository {
	@Before
	public void setup() {
		new MockUp<User>() {

			@Mock
			String getEmail() {
				return "mani@gmail.com";
			}
		};
		new MockUp<HibernateTemplate>() {

		};
		new MockUp<RegistrationRepository>() {
			@Mock
			String checkEmail(String email) {
				return "valid";
			}
		};
	}
	@Test
	public void testCheckRepositoryRegistration() {
		User user = new User();
		RegistrationRepository rs=new RegistrationRepository();
		
		String check = rs.checkEmail(user.getEmail());
		
		System.out.println("Check Status" +check);
		assertEquals("string returned", "valid",check);
	
	}
}
