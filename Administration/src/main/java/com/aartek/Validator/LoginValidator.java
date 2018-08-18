package com.aartek.Validator;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.aartek.model.User;
import com.aartek.repository.LoginRepository;
import com.aartek.repository.RegistrationRepository;

@Component
public class LoginValidator implements Validator {
	@Autowired
	private LoginRepository loginrepository;

	private static final String Email_reg = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	String pwd = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
	private static Pattern pattern;
	private Matcher matcher;

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return User.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		User usr = (User) target;
		ValidationUtils.rejectIfEmpty(errors, "email", " ", "Please enter email");
		ValidationUtils.rejectIfEmpty(errors, "password", " ", "Please Enter password");
	}
}

/*----------------- Validate Email and password----------------- */
/*
 * if (usr.getEmail() != null && usr.getEmail().trim().length() > 0) { if
 * (matcher.matches() != true) { errors.rejectValue("email", null,
 * "Please enter correct email"); } else {
 */
/*
 * List list = loginrepository.checkEmailPassword(usr.getEmail(),
 * usr.getPassword()); System.out.println(list); Iterator itr = list.iterator();
 * String email1 =null; String password1 = null; while(itr.hasNext()) { User
 * usr1 = (User)itr.next(); email1 = usr1.getEmail(); //
 * System.out.println(usr1.getEmail()); //System.out.println(email1); password1
 * = usr1.getPassword(); //System.out.println(usr1.getPassword());
 * //System.out.println(password1);
 * 
 * } if (email1.equals(usr.getEmail()) && password1.equals(usr.getPassword())) {
 * System.out.println("Welcome"); errors.rejectValue("email", "hello",
 * "Welcome"); } else { System.out.println(usr.getEmail() +
 * "Invalid email and password"); } }
 */