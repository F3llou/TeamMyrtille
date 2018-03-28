package com.wha.springmvc.model;

public class Compte {

	private double solde;
	private String type;
	
	public Compte(){	
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
