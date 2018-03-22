package com.wha.springmvc.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CL")
public class Client extends User{

	private String numeroTel;
	private int salaire;
	
	
	
	public Client(String numeroTel, int salaire) {
		super();
		this.numeroTel = numeroTel;
		this.salaire = salaire;
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
