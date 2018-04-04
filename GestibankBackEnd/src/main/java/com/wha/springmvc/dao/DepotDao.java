package com.wha.springmvc.dao;

import java.util.List;

import com.wha.springmvc.model.Depot;



public interface DepotDao {

	
	Depot findById(int id);	
	void save(Depot depot);	
		
	List<Depot> findAllOperations();	

}
