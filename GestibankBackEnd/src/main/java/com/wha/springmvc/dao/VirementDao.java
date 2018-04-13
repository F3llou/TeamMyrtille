package com.wha.springmvc.dao;

import java.util.List;

import com.wha.springmvc.model.Virement;


public interface VirementDao {

	
	Virement findById(int id);
	Virement findByRib(int rib);
	void save(Virement virement);	
		
	List<Virement> findAllOperations();	

}
