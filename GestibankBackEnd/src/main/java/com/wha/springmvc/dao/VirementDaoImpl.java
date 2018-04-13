package com.wha.springmvc.dao;

//import java.util.Collection;
import java.util.List;

//import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.wha.springmvc.dao.AbstractDao;
import com.wha.springmvc.model.Virement;


@Repository("VirementDao")
public class VirementDaoImpl extends AbstractDao<Integer, Virement> implements VirementDao {

	public Virement findById(int id){
		Virement virement = getByKey(id);
		return virement;
	}
	
	@SuppressWarnings("unchecked")
	public List<Virement> findAllOperations(){
	List<Virement> virement = getEntityManager().createQuery("SELECT u FROM Virement u ORDER BY u.id ASC").getResultList();
	return virement;
	}
	
	public void save(Virement virement){
		persist(virement);
	}

	@Override
	public Virement findByRib(int rib) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
