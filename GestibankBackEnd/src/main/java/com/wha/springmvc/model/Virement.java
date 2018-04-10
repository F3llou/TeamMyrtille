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
	
	private String ribDepart;
	private String ribArrivee;
	
	public Virement(){
	}
	
	public Virement(int id, Date dateOperation, double montant, String ribDepart, String ribArrivee){
		super(id, dateOperation, montant);
		this.ribDepart=ribDepart;
		this.ribArrivee=ribArrivee;
	}

	//getter and setter
	public String getRibDepart() {
		return ribDepart;
	}

	public void setRibDepart(String ribDepart) {
		this.ribDepart = ribDepart;
	}

	public String getRibArrivee() {
		return ribArrivee;
	}

	public void setRibArrivee(String ribArrivee) {
		this.ribArrivee = ribArrivee;
	}

	@Override
	public String toString() {
		return "Virement [getRibDepart()=" + getRibDepart() + ", getRibArrivee()=" + getRibArrivee() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((ribArrivee == null) ? 0 : ribArrivee.hashCode());
		result = prime * result + ((ribDepart == null) ? 0 : ribDepart.hashCode());
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
		if (ribArrivee == null) {
			if (other.ribArrivee != null)
				return false;
		} else if (!ribArrivee.equals(other.ribArrivee))
			return false;
		if (ribDepart == null) {
			if (other.ribDepart != null)
				return false;
		} else if (!ribDepart.equals(other.ribDepart))
			return false;
		return true;
	}
	
}
