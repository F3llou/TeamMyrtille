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
@DiscriminatorValue("D")
public class Depot extends Operation{
	
	public Depot(){
	}
	
	public Depot(int id, Date dateOperation, double montant){
		super(id, dateOperation, montant);
	}

	//getter and setter
	
	@Override
	public String toString() {
		return "Depot [getId()=" + getId() + ", getDateOperation()=" + getDateOperation() + ", getMontant()="
				+ getMontant() + ", toString()=" + super.toString() + ", hashCode()=" + hashCode() + ", getClass()="
				+ getClass() + "]";
	}
	
}
