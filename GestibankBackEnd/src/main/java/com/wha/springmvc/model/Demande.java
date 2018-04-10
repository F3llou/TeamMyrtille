package com.wha.springmvc.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * 
 * @author TeamMyrtille
 * @version 1.0
 */

@Entity
@Table(name="demande")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_ENTITE")
@DiscriminatorValue("DM")
public class Demande {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int userDemandeur;
	private int userReceveur;
	private String type;
	
	public Demande(){
		id=0;
	}
	
	public Demande(int id, int userDemandeur, int userReceveur, String type) {
		super();
		this.id = id;
		this.userDemandeur = userDemandeur;
		this.userReceveur = userReceveur;
		this.type=type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserDemandeur() {
		return userDemandeur;
	}

	public void setUserDemandeur(int userDemandeur) {
		this.userDemandeur = userDemandeur;
	}

	public int getUserReceveur() {
		return userReceveur;
	}

	public void setUserReceveur(int userReceveur) {
		this.userReceveur = userReceveur;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Demande [getId()=" + getId() + ", getUserDemandeur()=" + getUserDemandeur() + ", getUserReceveur()="
				+ getUserReceveur() + ", getType()=" + getType() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + userDemandeur;
		result = prime * result + userReceveur;
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
		Demande other = (Demande) obj;
		if (id != other.id)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (userDemandeur != other.userDemandeur)
			return false;
		if (userReceveur != other.userReceveur)
			return false;
		return true;
	}
	
	
}
