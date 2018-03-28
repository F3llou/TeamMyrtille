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
@DiscriminatorValue("R")
public class Retrait extends Operation{
	
	public Retrait(){
	}
	
	public Retrait(int id, Date dateOperation, double montant){
		super(id, dateOperation, montant);
	}

	//getter and setter
	
}
