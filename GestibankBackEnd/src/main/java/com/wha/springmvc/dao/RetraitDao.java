package com.wha.springmvc.dao;

import java.util.List;

import com.wha.springmvc.model.Retrait;

public interface RetraitDao {

	
	Retrait findById(int id);	
	void save(Retrait retrait);	

	List<Retrait> findAllOperations();	

}
