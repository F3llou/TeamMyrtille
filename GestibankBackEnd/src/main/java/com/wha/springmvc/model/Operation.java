package com.wha.springmvc.model;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="operation")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_ENTITE")
@DiscriminatorValue("O")
public class Operation {
	
	@Id
	private int id;
	private Date dateOperation;
	private double montant;
	
	public Operation(){
		id=0;
	}
	
	public Operation(int id, Date dateOperation, double montant){
		this.id=id;
		this.dateOperation=dateOperation;
		this.montant=montant;
	}

	//getter and setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	@Override
	public String toString() {
		return "Operation [getId()=" + getId()
				+ ", getDateOperation()=" + getDateOperation()
				+ ", getMontant()=" + getMontant() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateOperation == null) ? 0 : dateOperation.hashCode());
		result = prime * result + id;
		long temp;
		temp = Double.doubleToLongBits(montant);
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
		Operation other = (Operation) obj;
		if (dateOperation == null) {
			if (other.dateOperation != null)
				return false;
		} else if (!dateOperation.equals(other.dateOperation))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(montant) != Double
				.doubleToLongBits(other.montant))
			return false;
		return true;
	}
	
}
