package com.wha.springmvc.model;

public class CompteRemun extends Compte {

	private double decouvert;
	
	public CompteRemun() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CompteRemun(double solde, String type) {
		super(solde, type);
		this.decouvert = decouvert;
	}

}
