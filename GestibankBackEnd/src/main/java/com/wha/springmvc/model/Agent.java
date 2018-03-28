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
	private String mdp;
	private Date dateDeb;
	
	public Agent() {
		super();
	}
	
	public Agent(int id, String username, String address, String email, String numTel) {
		super(id, username, address, email, numTel);
		this.matricule=matricule;
		this.mdp=mdp;
		this.dateDeb=dateDeb;
	}
	
	//getter and setter
	public int getMatricule() {
		return matricule;
	}

	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public Date getDateDeb() {
		return dateDeb;
	}

	public void setDateDeb(Date dateDeb) {
		this.dateDeb = dateDeb;
	}

	@Override
	public String toString() {
		return "Agent [getMatricule()=" + getMatricule() + ", getMdp()="
				+ getMdp() + ", getDateDeb()=" + getDateDeb() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dateDeb == null) ? 0 : dateDeb.hashCode());
		result = prime * result + matricule;
		result = prime * result + ((mdp == null) ? 0 : mdp.hashCode());
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
		if (dateDeb == null) {
			if (other.dateDeb != null)
				return false;
		} else if (!dateDeb.equals(other.dateDeb))
			return false;
		if (matricule != other.matricule)
			return false;
		if (mdp == null) {
			if (other.mdp != null)
				return false;
		} else if (!mdp.equals(other.mdp))
			return false;
		return true;
	}

}
