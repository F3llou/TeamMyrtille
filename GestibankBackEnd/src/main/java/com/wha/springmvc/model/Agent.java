package com.wha.springmvc.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("AG")
public class Agent extends User{


	
	public Agent() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Agent(int id, String username, String address, String email) {
		super(id, username, address, email);

		// TODO Auto-generated constructor stub
	}
	
	//getter and setter

	

}
