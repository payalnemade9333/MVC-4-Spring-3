package com.aartek.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private Integer id;
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name="EMAIL")
	private String email;
	
    public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="PASSWORD")
	private String password;
    
    @Column(name="FIRSTNAME")
    private String firstname;
    
    @Column(name="LASTNAME")
    private String lastname;
    
    @Column(name="MOBILENO")
    private Long mobileno;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Long getMobileno() {
		return mobileno;
	}
	public void setMobileno(Long mobileno) {
		this.mobileno = mobileno;
	}
}
