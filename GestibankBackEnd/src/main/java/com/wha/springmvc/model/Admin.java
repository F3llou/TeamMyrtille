package com.wha.springmvc.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("AD")
public class Admin extends User{


	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Admin(int id, String username, String address, String email) {
		super(id, username, address, email);

		// TODO Auto-generated constructor stub
	}
	
	//getter and setter

	

}
