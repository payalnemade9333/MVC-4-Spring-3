package com.aartek.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aartek.Validator.ProductValidation;
import com.aartek.model.Product;
import com.aartek.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductValidation productValidation;

	@RequestMapping(value = "/product", method = { RequestMethod.GET, RequestMethod.POST })
	public String saveProductDetail(@ModelAttribute("productMap") Product product, BindingResult result,
			Map<String, Object> map, HttpServletRequest request) {
		System.out.println("------------------------Inside Product Controller---------------------");

		map.put("prod", productService.getProductDetails(product));
		
		if ("get".equals(request.getMethod().toLowerCase())) {
			map.put("productMap", product);
			return "product";
		}else {
			productValidation.validate(product, result);
			if (result.hasErrors()) {
				return "product";
			} else {
				productService.checkProduct(product);
				return "product";
			}
		}
	}
}