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
@DiscriminatorValue("CAD")
public class CompteAvecDecouv extends Compte {

	private double decouvert;
	private Date dateDecouv;
	
	public CompteAvecDecouv() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CompteAvecDecouv(int id, double solde, Date dateDeb, double decouvert, Date dateDecouv) {
		super(id, solde, dateDeb);
		this.decouvert = decouvert;
		this.dateDecouv=dateDecouv;
	}

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

	public Date getDateDecouv() {
		return dateDecouv;
	}

	public void setDateDecouv(Date dateDecouv) {
		this.dateDecouv = dateDecouv;
	}

	@Override
	public String toString() {
		return "CompteAvecDecouv [getDecouvert()=" + getDecouvert() + ", getDateDecouv()=" + getDateDecouv() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dateDecouv == null) ? 0 : dateDecouv.hashCode());
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
		if (dateDecouv == null) {
			if (other.dateDecouv != null)
				return false;
		} else if (!dateDecouv.equals(other.dateDecouv))
			return false;
		if (Double.doubleToLongBits(decouvert) != Double.doubleToLongBits(other.decouvert))
			return false;
		return true;
	}
	
}
