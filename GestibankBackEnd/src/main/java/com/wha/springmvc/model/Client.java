package com.wha.springmvc.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CL")
public class Client extends User{

	private String prenom;
	private String mdp;
	private String numeroTel;
	private int salaire;
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Client(int id, String username, String address, String email) {
		super(id, username, address, email);
		this.prenom=prenom;
		this.mdp=mdp;
		this.numeroTel = numeroTel;
		this.salaire = salaire;
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
	
	public String getNumeroTel() {
		return numeroTel;
	}


	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}
	public int getSalaire() {
		return salaire;
	}
	public void setSalaire(int salaire) {
		this.salaire = salaire;
	}

	@Override
	public String toString() {
		return "Client [getMdp()=" + getMdp() + ", getPrenom()=" + getPrenom()
				+ ", getNumeroTel()=" + getNumeroTel() + ", getSalaire()="
				+ getSalaire() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((mdp == null) ? 0 : mdp.hashCode());
		result = prime * result
				+ ((numeroTel == null) ? 0 : numeroTel.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result + salaire;
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
		if (numeroTel == null) {
			if (other.numeroTel != null)
				return false;
		} else if (!numeroTel.equals(other.numeroTel))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		if (salaire != other.salaire)
			return false;
		return true;
	}
	
}
