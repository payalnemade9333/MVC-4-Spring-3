package com.aartek.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.aartek.controller.RegistrationController;
import com.aartek.model.User;
import com.aartek.repository.RegistrationRepository;

@Component
public class RegistrationValidator implements Validator {
	@Autowired
	private RegistrationRepository registrationrepository;

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
		ValidationUtils.rejectIfEmpty(errors, "firstname", " ", "Please enter first name");
		ValidationUtils.rejectIfEmpty(errors, "lastname", " ", "Please enter first name");
		ValidationUtils.rejectIfEmpty(errors, "email", " ", "Please enter email");
		ValidationUtils.rejectIfEmpty(errors, "password", " ", "Please Enter password");
		ValidationUtils.rejectIfEmpty(errors, "mobileno", " ", "Please enter mobile no");

		if (usr.getFirstname() != null && usr.getFirstname().trim().length() < 20) {
			errors.rejectValue("firstname", "firstname should be 50 character long");
		}
		if (usr.getLastname() != null && usr.getLastname().trim().length() < 20) {
			errors.rejectValue("lastname", "lastname should be 50 character long");
		}

		/*----------------- Validate Email----------------- */
		pattern = Pattern.compile(Email_reg, Pattern.CASE_INSENSITIVE);
		matcher = pattern.matcher(usr.getEmail());
		if (usr.getEmail() != null && usr.getEmail().trim().length() > 0) {
			if (matcher.matches() != true) {
				errors.rejectValue("email", null, "email formated is not matched");
			} else {
				String email = registrationrepository.checkEmail(usr.getEmail());
				if (email != null) {
					errors.rejectValue("email", "hello", "email already exist");
				}
			}
		}

		pattern = Pattern.compile(pwd);
		matcher = pattern.matcher(usr.getPassword());
		if (matcher.matches() != true) {
			errors.rejectValue("password", null,
					"Password should be at least 8 char and contain one special character");
		}

		if (usr.getMobileno() != null && usr.getMobileno().toString().length() != 10) {
			errors.rejectValue("mobileno", null, "please enter valid mobile number");
		}
	}
}