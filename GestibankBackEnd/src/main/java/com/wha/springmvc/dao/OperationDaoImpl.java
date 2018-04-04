package com.wha.springmvc.dao;

//import java.util.Collection;
import java.util.Date;
import java.util.List;

//import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.wha.springmvc.dao.AbstractDao;
import com.wha.springmvc.model.Operation;



@Repository("operationDao")
public class OperationDaoImpl extends AbstractDao<Integer, Operation> implements OperationDao {

	public Operation findById(int id){
		Operation operation = getByKey(id);
		return operation;
	}
	
	@SuppressWarnings("unchecked")
	public List<Operation> findAllOperations(){
	List<Operation> operations = getEntityManager().createQuery("SELECT u FROM Operation u ORDER BY u.id ASC").getResultList();
	return operations;
	}
	
	public void save(Operation operation){
		persist(operation);
	}

	@Override
	public Operation findByDate(Date date) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
