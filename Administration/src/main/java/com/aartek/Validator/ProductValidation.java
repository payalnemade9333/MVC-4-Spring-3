package com.aartek.Validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.aartek.model.Product;

@Component
public class ProductValidation implements Validator {

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Product.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Product product = (Product) target;
		ValidationUtils.rejectIfEmpty(errors, "productname"," ", "Product Name is mandatory");
		ValidationUtils.rejectIfEmpty(errors, "price"," ", "Product price is mandatory");
		ValidationUtils.rejectIfEmpty(errors, "quantity"," ", "Product quantity is mandatory ");
		ValidationUtils.rejectIfEmpty(errors, "productdesc"," ", "Product description is mandatory");
	}

}
