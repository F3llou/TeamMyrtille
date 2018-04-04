package com.wha.springmvc.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * 
 * @author TeamMyrtille
 * @version 1.0
 */

@Entity
@DiscriminatorValue("CAD")
public class CompteAvecDecouv extends Compte {

	private double decouvert;
	
	public CompteAvecDecouv() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CompteAvecDecouv(int id, double solde, String type) {
		super(id, solde, type);
		this.decouvert = decouvert;
	}



	@Override
	public String toString() {
		return "CompteAvecDecouv [hashCode()=" + hashCode() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(decouvert);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompteAvecDecouv other = (CompteAvecDecouv) obj;
		if (Double.doubleToLongBits(decouvert) != Double.doubleToLongBits(other.decouvert))
			return false;
		return true;
	}
	

}
