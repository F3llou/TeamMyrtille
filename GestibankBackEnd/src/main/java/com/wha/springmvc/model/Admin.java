package com.wha.springmvc.model;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

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
			String prenom, String address, String email, String numTel, Date dateDeb) {
		super(id, login, mdp, username, prenom, address, email, numTel, dateDeb);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Admin [getId()=" + getId() + ", getLogin()=" + getLogin() + ", getMdp()=" + getMdp() + ", getPrenom()="
				+ getPrenom() + ", getUsername()=" + getNom() + ", getAddress()=" + getAddress() + ", getEmail()="
				+ getEmail() + ", getNumTel()=" + getNumTel() + ", getListUsers()=" + getListUsers()
				+ ", getListDemandes()=" + getListDemandes() + ", getDateDeb()=" + getDateDeb() + ", toString()="
				+ super.toString() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + "]";
	}

	// getter and setter

}
