package com.wha.springmvc.dao;

import java.util.Date;
import java.util.List;

import com.wha.springmvc.model.Operation;

public interface OperationDao {

	Operation findById(int id);
	Operation findByDate(Date date);
	void save(Operation operation);
	
	List<Operation> findAllOperations();	

}
