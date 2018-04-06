package com.wha.springmvc.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 * 
 * @author TeamMyrtille
 * @version 1.0
 */

@Entity
@DiscriminatorValue("AD")
public class Admin extends User {

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(int id, String login, String mdp, String username,
			String prenom, String address, String email, String numTel) {
		super(id, login, mdp, username, prenom, address, email, numTel);
		// TODO Auto-generated constructor stub
	}

	// getter and setter

}
