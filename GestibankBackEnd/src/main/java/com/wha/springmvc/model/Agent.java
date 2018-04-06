package com.wha.springmvc.model;

import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author TeamMyrtille
 * @version 1.0
 */

@Entity
@DiscriminatorValue("AG")
public class Agent extends User{

	private int matricule;
	private Date dateDeb;
	
	public Agent() {
		super();
	}
	
	public Agent(int id, String login, String mdp, String username,
			String prenom, String address, String email, String numTel) {
		super(id, login, mdp, username, prenom, address, email, numTel);
		this.matricule=matricule;
		this.dateDeb=dateDeb;
		// TODO Auto-generated constructor stub
	}


	//getter and setter
	public int getMatricule() {
		return matricule;
	}

	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}

	public Date getDateDeb() {
		return dateDeb;
	}

	public void setDateDeb(Date dateDeb) {
		this.dateDeb = dateDeb;
	}

	@Override
	public String toString() {
		return "Agent [getMatricule()=" + getMatricule() + ", getDateDeb()="
				+ getDateDeb() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dateDeb == null) ? 0 : dateDeb.hashCode());
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
		if (dateDeb == null) {
			if (other.dateDeb != null)
				return false;
		} else if (!dateDeb.equals(other.dateDeb))
			return false;
		if (matricule != other.matricule)
			return false;
		return true;
	}

}
