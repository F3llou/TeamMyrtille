package com.wha.springmvc.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author TeamMyrtille
 * @version 1.0
 */

@Entity
@Table(name="user")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_ENTITE")
@DiscriminatorValue("U")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String login;
	private String mdp;
	private String nom;
	private String prenom;
	private String address;
	private String email;
	private String numTel;
	private Date dateDeb;
	
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<User> listUsers;
	
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY)
	private List<Demande> listDemandes;
	
	public User(){
		id=0;
	}
	
	public User(int id, String login, String mdp, String username, String prenom, String address, String email, String numTel, Date dateDeb){
		this.id = id;
		this.login=login;
		this.mdp=mdp;
		this.nom = username;
		this.prenom=prenom;
		this.address = address;
		this.email = email;
		this.numTel = numTel;
		this.dateDeb=dateDeb;
	}

	// getter and setter
	public int getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

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

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String username) {
		this.nom = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	public List<User> getListUsers() {
		return listUsers;
	}

	public void setListUsers(List<User> listUsers) {
		this.listUsers = listUsers;
	}

	public List<Demande> getListDemandes() {
		return listDemandes;
	}

	public void setListDemandes(List<Demande> listDemandes) {
		this.listDemandes = listDemandes;
	}

	public Date getDateDeb() {
		return dateDeb;
	}

	public void setDateDeb(Date dateDeb) {
		this.dateDeb = dateDeb;
	}

	@Override
	public String toString() {
		return "User [getId()=" + getId() + ", getLogin()=" + getLogin()
				+ ", getMdp()=" + getMdp() + ", getPrenom()=" + getPrenom()
				+ ", getNom()=" + getNom() + ", getAddress()=" + getAddress()
				+ ", getEmail()=" + getEmail() + ", getNumTel()=" + getNumTel()
				+ ", getListUsers()=" + getListUsers() + ", getListDemandes()="
				+ getListDemandes() + ", getDateDeb()=" + getDateDeb() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((dateDeb == null) ? 0 : dateDeb.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((listDemandes == null) ? 0 : listDemandes.hashCode());
		result = prime * result
				+ ((listUsers == null) ? 0 : listUsers.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((mdp == null) ? 0 : mdp.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((numTel == null) ? 0 : numTel.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (dateDeb == null) {
			if (other.dateDeb != null)
				return false;
		} else if (!dateDeb.equals(other.dateDeb))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (listDemandes == null) {
			if (other.listDemandes != null)
				return false;
		} else if (!listDemandes.equals(other.listDemandes))
			return false;
		if (listUsers == null) {
			if (other.listUsers != null)
				return false;
		} else if (!listUsers.equals(other.listUsers))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (mdp == null) {
			if (other.mdp != null)
				return false;
		} else if (!mdp.equals(other.mdp))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (numTel == null) {
			if (other.numTel != null)
				return false;
		} else if (!numTel.equals(other.numTel))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		return true;
	}

}
