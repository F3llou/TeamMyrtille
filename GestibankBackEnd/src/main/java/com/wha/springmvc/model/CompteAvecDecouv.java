package com.wha.springmvc.model;

public class CompteAvecDecouv extends Compte {

	private double decouvert;
	
	public CompteAvecDecouv() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CompteAvecDecouv(double solde, String type) {
		super(solde, type);
		this.decouvert = decouvert;
	}

}
