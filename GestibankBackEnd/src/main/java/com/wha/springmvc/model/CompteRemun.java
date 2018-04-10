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
@DiscriminatorValue("CR")
public class CompteRemun extends Compte {
	
	private static double tauxInteret;
	private Date dateRemun;
	
	public CompteRemun() {
		super();
		CompteRemun.setTauxInteret(3);
		// TODO Auto-generated constructor stub
	}
	
	public CompteRemun(int id, double solde, Date dateDeb, Date dateRemun) {
		super(id, solde, dateDeb);
		CompteRemun.setTauxInteret(3);
		this.dateRemun=dateRemun;
	}

	public static double getTauxInteret() {
		return tauxInteret;
	}

	public static void setTauxInteret(double tauxInteret) {
		CompteRemun.tauxInteret = tauxInteret;
	}

	public Date getDateRemun() {
		return dateRemun;
	}

	public void setDateRemun(Date dateRemun) {
		this.dateRemun = dateRemun;
	}

	@Override
	public String toString() {
		return "CompteRemun [getDateRemun()=" + getDateRemun() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dateRemun == null) ? 0 : dateRemun.hashCode());
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
		CompteRemun other = (CompteRemun) obj;
		if (dateRemun == null) {
			if (other.dateRemun != null)
				return false;
		} else if (!dateRemun.equals(other.dateRemun))
			return false;
		return true;
	}
	
}
