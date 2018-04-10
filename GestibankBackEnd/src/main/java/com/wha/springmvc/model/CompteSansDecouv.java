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
@DiscriminatorValue("CSD")
public class CompteSansDecouv extends Compte {
	
	public CompteSansDecouv() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CompteSansDecouv(int id, double solde, Date dateDeb){
		super(id, solde, dateDeb);
	}

	@Override
	public String toString() {
		return "CompteSansDecouv [getSolde()=" + getSolde() + ", getId()=" + getId() + ", getListOperations()="
				+ getListOperations() + ", getDateDeb()=" + getDateDeb() + ", toString()=" + super.toString()
				+ ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + "]";
	}

}
