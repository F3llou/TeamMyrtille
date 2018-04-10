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
@DiscriminatorValue("AG")
public class Agent extends User{

	private int matricule;
	
	public Agent() {
		super();
	}
	
	public Agent(int id, String login, String mdp, String username,
			String prenom, String address, String email, String numTel, int matricule, Date dateDeb) {
		super(id, login, mdp, username, prenom, address, email, numTel, dateDeb);
		this.matricule=matricule;
		// TODO Auto-generated constructor stub
	}


	//getter and setter
	public int getMatricule() {
		return matricule;
	}

	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}

	@Override
	public String toString() {
		return "Agent [getMatricule()=" + getMatricule() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + matricule;
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
		Agent other = (Agent) obj;
		if (matricule != other.matricule)
			return false;
		return true;
	}

}
