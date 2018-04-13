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
@DiscriminatorValue("V")
public class Virement extends Operation{
	
	private int ribArrivee;
	
	public Virement(){
	}
	
	public Virement(int id, Date dateOperation, double montant, int ribArrivee){
		super(id, dateOperation, montant);
		this.ribArrivee=ribArrivee;
	}

	public int getRibArrivee() {
		return ribArrivee;
	}

	public void setRibArrivee(int ribArrivee) {
		this.ribArrivee = ribArrivee;
	}

	@Override
	public String toString() {
		return "Virement [getRibArrivee()=" + getRibArrivee() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ribArrivee;
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
		Virement other = (Virement) obj;
		if (ribArrivee != other.ribArrivee)
			return false;
		return true;
	}
	
}
