package com.aartek.serviceTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.aartek.model.User;
import com.aartek.repository.RegistrationRepository;
import com.aartek.service.RegistartionService;

import mockit.Mock;
import mockit.MockUp;

public class TestRegistrationService {
	@Before
	public void setUp() {
		new MockUp<User>() {
			
			@Mock
			String getEmail() {
				return "mail@example.com";	
			}
			
			@Mock
			String getPassword() {
				return "Po123456";	
			}
			
			@Mock
			String getFirstname() {
				return "payal";
			}
			
			@Mock
			String getLastname() {
				return "nemade";	
			}
			
			/*@Mock
			Long getMobileno() {
				return 1258963;
				
			}*/
		};
		
		new MockUp<RegistrationRepository>() {
			new MockUp<RegistrationRepository>() {
				@Mock
				String checkLogin(String email) {
					return "valid";
				}
			};
		}
		
		new MockUp<RegistartionService>() {
			@Mock
			void registrationRepository(User user) {
				System.out.println("success");
			}
		};	
	}
	
	@Test
	public void testServiceRegistration() {
		User usr = new User();
		RegistartionService rs = new RegistartionService();
			String email = usr.getEmail();
			String fn = usr.getFirstname();
			String ln = usr.getLastname();
			String pwd = usr.getPassword();
			
			assertEquals("first name return", "payal",fn);
			assertEquals("last name return","nemade",ln);
			assertEquals("email return", "mail@example.com",email);
			assertEquals("password return", "Po123456",pwd);
	}
}
