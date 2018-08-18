package com.aartek.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.model.Product;
import com.aartek.repository.ProductRepository;
@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	public void checkProduct(Product product) {
		System.out.println("------------------------Inside Product Service-----------------------------");
		System.out.println(product.getPid());
		System.out.println(product.getProductname());
		System.out.println(product.getQuantity());
		System.out.println(product.getPrice());
		System.out.println(product.getProductdesc());
		productRepository.checkProduct(product);
	}
	public List getProductDetails(Product prodlist) {
		List list =productRepository.getProductDetails(prodlist);
		Iterator itr = list.iterator();
		while(itr.hasNext()) {
			Product product = (Product)itr.next();
			System.out.println(product.getProductname()+" "+product.getPid()+" "+product.getPrice()+" "+product.getQuantity()+" "+product.getProductdesc());
		}
		return list;
	}
}
