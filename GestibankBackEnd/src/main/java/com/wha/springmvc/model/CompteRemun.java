package com.wha.springmvc.model;

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
	/*private float tauxInterets;*/
	
	public CompteRemun() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CompteRemun(int id, double solde, String type) {
		super(id, solde, type);

	}
	/*public float getTauxInterets() {
        return tauxInterets;
    }
    
    public double calculInterets() {
        solde=solde+solde*tauxInterets;
        return solde;}
    
}*/
}
