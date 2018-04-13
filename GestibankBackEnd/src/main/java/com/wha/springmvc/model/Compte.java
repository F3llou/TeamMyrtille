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
@Table(name="compte")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_ENTITE")
@DiscriminatorValue("CM")
public class Compte {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	//@Column(name = "id", updatable = false, nullable = false)
	private int id;
	private double solde;
	private Date dateDeb;
	
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Operation> listOperations;
	
	public Compte(){
		id=0;
	}
	
	public Compte(int id, double solde, Date dateDeb){
		this.id=id;
		this.solde = solde;
		this.dateDeb=dateDeb;
	}
	
	//getter and setters
	
	public double getSolde() {
		return solde;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public List<Operation> getListOperations() {
		return listOperations;
	}

	public void setListOperations(List<Operation> listOperations) {
		this.listOperations = listOperations;
	}

	public Date getDateDeb() {
		return dateDeb;
	}

	public void setDateDeb(Date dateDeb) {
		this.dateDeb = dateDeb;
	}

	@Override
	public String toString() {
		return "Compte [getSolde()=" + getSolde() + ", getId()=" + getId() + ", getListOperations()="
				+ getListOperations() + ", getDateDeb()=" + getDateDeb() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateDeb == null) ? 0 : dateDeb.hashCode());
		result = prime * result + id;
		result = prime * result + ((listOperations == null) ? 0 : listOperations.hashCode());
		long temp;
		temp = Double.doubleToLongBits(solde);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Compte other = (Compte) obj;
		if (dateDeb == null) {
			if (other.dateDeb != null)
				return false;
		} else if (!dateDeb.equals(other.dateDeb))
			return false;
		if (id != other.id)
			return false;
		if (listOperations == null) {
			if (other.listOperations != null)
				return false;
		} else if (!listOperations.equals(other.listOperations))
			return false;
		if (Double.doubleToLongBits(solde) != Double.doubleToLongBits(other.solde))
			return false;
		return true;
	}

}
