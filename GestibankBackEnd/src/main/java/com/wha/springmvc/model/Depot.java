package com.wha.springmvc.model;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("D")
public class Depot extends Operation{
	
	public Depot(){
	}
	
	public Depot(int id, Date dateOperation, double montant){
		super(id, dateOperation, montant);
	}

	//getter and setter
	
}
