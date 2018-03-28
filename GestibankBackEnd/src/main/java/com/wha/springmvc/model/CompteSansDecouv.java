package com.wha.springmvc.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CSD")
public class CompteSansDecouv extends Compte {

	
	
	public CompteSansDecouv() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
