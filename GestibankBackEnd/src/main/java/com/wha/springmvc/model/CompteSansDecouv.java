package com.wha.springmvc.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * 
 * @author TeamMyrtille
 * @version 1.0
 */

@Entity
@DiscriminatorValue("CSD")
public class CompteSansDecouv extends Compte {
	
	public CompteSansDecouv() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CompteSansDecouv(int id, double solde, String type){
		super(id, solde, type);
	}


}
