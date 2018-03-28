package com.wha.springmvc.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="compte")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_ENTITE")
@DiscriminatorValue("CM")
public class Compte {

	@Id
	private int id;
	private double solde;
	private String type;
	
	public Compte(){
		id=0;
	}
	
	public Compte(int id, double solde, String type){
		this.id=id;
		this.solde = solde;
		this.type = type;
	}
	
	//getter and setters
	
	public double getSolde() {
		return solde;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
