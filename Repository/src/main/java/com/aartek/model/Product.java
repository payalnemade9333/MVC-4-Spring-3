package com.aartek.model;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="product_id")
	private Integer pid;
	
	@Column(name="product_name")
	private String productname;
	
	@Column(name="price")
	private String price;
	
	@Column(name="quantity")
	private Integer quantity;
	
	@Column(name="Product_desc")
	private String productdesc;

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getProductdesc() {
		return productdesc;
	}

	public void setProductdesc(String productdesc) {
		this.productdesc = productdesc;
	}
}
