package com.aartek.repository;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.model.Product;

@Repository
public class ProductRepository {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public void checkProduct(Product product) {
		System.out.println("-----------------------Inside Product Repository----------------------");
		System.out.println(product.getPid());
		System.out.println(product.getProductname());
		System.out.println(product.getQuantity());
		System.out.println(product.getPrice());
		System.out.println(product.getProductdesc());
		hibernateTemplate.save(product);
	}
	public List getProductDetails(Product prod) {
		List list = hibernateTemplate.find("from Product");
		Iterator itr = list.iterator();
		while(itr.hasNext()) {
			Product product = (Product)itr.next();
			System.out.println(product.getProductname()+" "+product.getPid()+" "+product.getPrice()+" "+product.getQuantity()+" "+product.getProductdesc());
		}
		return list;
	}
}
