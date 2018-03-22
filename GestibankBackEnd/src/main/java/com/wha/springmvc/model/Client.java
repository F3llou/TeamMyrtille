package com.wha.springmvc.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CL")
public class Client extends User{

	private String numeroTel;
	private int salaire;
	
	
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Client(int id, String username, String address, String email) {
		super(id, username, address, email);
		this.numeroTel = numeroTel;
		this.salaire = salaire;
		// TODO Auto-generated constructor stub
	}
	
	//getter and setter
	public String getNumeroTel() {
		return numeroTel;
	}
	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}
	public int getSalaire() {
		return salaire;
	}
	public void setSalaire(int salaire) {
		this.salaire = salaire;
	}
	

	
}
