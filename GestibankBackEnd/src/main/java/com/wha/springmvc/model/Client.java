package com.wha.springmvc.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * 
 * @author TeamMyrtille
 * @version 1.0
 */

@Entity
@DiscriminatorValue("CL")
public class Client extends User{

	private String prenom;
	private String mdp;
	private int nbEnfant;
	private String situationMaritale;
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Client(int id, String username, String address, String email, String numTel) {
		super(id, username, address, email, numTel);
		this.prenom=prenom;
		this.mdp=mdp;
		this.nbEnfant = nbEnfant;
		this.situationMaritale = situationMaritale;
		// TODO Auto-generated constructor stub
	}
	
	//getter and setter
	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getNbEnfant() {
		return nbEnfant;
	}

	public void setNbEnfant(int nbEnfant) {
		this.nbEnfant = nbEnfant;
	}

	public String getSituationMaritale() {
		return situationMaritale;
	}

	public void setSituationMaritale(String situationMaritale) {
		this.situationMaritale = situationMaritale;
	}

	@Override
	public String toString() {
		return "Client [getMdp()=" + getMdp() + ", getPrenom()=" + getPrenom()
				+ ", getNbEnfant()=" + getNbEnfant()
				+ ", getSituationMaritale()=" + getSituationMaritale() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((mdp == null) ? 0 : mdp.hashCode());
		result = prime * result + nbEnfant;
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime
				* result
				+ ((situationMaritale == null) ? 0 : situationMaritale
						.hashCode());
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
		Client other = (Client) obj;
		if (mdp == null) {
			if (other.mdp != null)
				return false;
		} else if (!mdp.equals(other.mdp))
			return false;
		if (nbEnfant != other.nbEnfant)
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		if (situationMaritale == null) {
			if (other.situationMaritale != null)
				return false;
		} else if (!situationMaritale.equals(other.situationMaritale))
			return false;
		return true;
	}
	
}
