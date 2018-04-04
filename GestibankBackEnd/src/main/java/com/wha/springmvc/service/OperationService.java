package com.wha.springmvc.service;

import java.util.List;

import com.wha.springmvc.model.Compte;
import com.wha.springmvc.model.Depot;
import com.wha.springmvc.model.Operation;
import com.wha.springmvc.model.Retrait;
import com.wha.springmvc.model.Virement;


public interface OperationService {
	
	Operation findById(int id);	
	
	void saveOperation(Operation operation);	
	
	List<Operation> findAllOperations(); 
	
	public boolean isUserExist(Operation operation);
	
	//Les methodes de traitement des retrait
	Retrait  findRetraitById(int id);	
	void saveOperation(Retrait retrait);
	
	//les methodes de traitement des depot
	Depot findDepotById(int id);	
	void saveOperation(Depot depot);
	
	//les methodes de traitement virement
	Virement findVirementById(int id);	
		void saveVirement(Virement virement);
}
