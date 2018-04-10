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
@DiscriminatorValue("CL")
public class Client extends User{

	private int nbEnfant;
	private String situationMaritale;
	
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY)
	private List<Compte> listComptes;
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Client(int id, String login, String mdp, String username,
			String prenom, String address, String email, String numTel, int nbEnfant, String situationMaritale, Date dateDeb) {
		super(id, login, mdp, username, prenom, address, email, numTel, dateDeb);
		this.nbEnfant = nbEnfant;
		this.situationMaritale = situationMaritale;
		// TODO Auto-generated constructor stub
	}
	
	//getter and setter
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

	public List<Compte> getListComptes() {
		return listComptes;
	}

	public void setListComptes(List<Compte> listComptes) {
		this.listComptes = listComptes;
	}

	@Override
	public String toString() {
		return "Client [getNbEnfant()=" + getNbEnfant() + ", getSituationMaritale()=" + getSituationMaritale()
				+ ", getListComptes()=" + getListComptes() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((listComptes == null) ? 0 : listComptes.hashCode());
		result = prime * result + nbEnfant;
		result = prime * result + ((situationMaritale == null) ? 0 : situationMaritale.hashCode());
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
		if (listComptes == null) {
			if (other.listComptes != null)
				return false;
		} else if (!listComptes.equals(other.listComptes))
			return false;
		if (nbEnfant != other.nbEnfant)
			return false;
		if (situationMaritale == null) {
			if (other.situationMaritale != null)
				return false;
		} else if (!situationMaritale.equals(other.situationMaritale))
			return false;
		return true;
	}

}
