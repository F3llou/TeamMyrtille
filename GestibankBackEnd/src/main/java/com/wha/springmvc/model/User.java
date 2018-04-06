package com.wha.springmvc.model;

//import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

//import org.springframework.beans.factory.annotation.Autowired;

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
	//@GeneratedValue (strategy = GenerationType.IDENTITY)
	//@Column(name = "id")
	private int id;
	private String login;
	private String mdp;
	private String username;
	private String prenom;
	private String address;
	private String email;
	private String numTel;
	
	//@OneToMany
	//private List<Demande> listDemandes;
	
	public User(){
		id=0;
	}
	
	public User(int id, String login, String mdp, String username, String prenom, String address, String email, String numTel){
		this.id = id;
		this.login=login;
		this.mdp=mdp;
		this.username = username;
		this.prenom=prenom;
		this.address = address;
		this.email = email;
		this.numTel = numTel;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	@Override
	public String toString() {
		return "User [getId()=" + getId() + ", getLogin()=" + getLogin()
				+ ", getMdp()=" + getMdp() + ", getPrenom()=" + getPrenom()
				+ ", getUsername()=" + getUsername() + ", getAddress()="
				+ getAddress() + ", getEmail()=" + getEmail()
				+ ", getNumTel()=" + getNumTel() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((mdp == null) ? 0 : mdp.hashCode());
		result = prime * result + ((numTel == null) ? 0 : numTel.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
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
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
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
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	/*public List<Demande> getListDemandes() {
		return listDemandes;
	}

	public void setListDemandes(List<Demande> listDemandes) {
		this.listDemandes = listDemandes;
	}*/
	
}
