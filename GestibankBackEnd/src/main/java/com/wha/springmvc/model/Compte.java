package com.wha.springmvc.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CM")
public class Compte {

	private double solde;
	private String type;
	
	public Compte(){	
	}
	
	public Compte(double solde, String type){
		this.solde = solde;
		this.type = type;
	}
	
	//getter and setter
	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
