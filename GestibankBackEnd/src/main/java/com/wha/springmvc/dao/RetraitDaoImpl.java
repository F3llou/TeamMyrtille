package com.wha.springmvc.dao;

//import java.util.Collection;
import java.util.List;
import javax.persistence.NoResultException;
import org.springframework.stereotype.Repository;
import com.wha.springmvc.dao.AbstractDao;
import com.wha.springmvc.model.Retrait;




@Repository("retraitDao")
public class RetraitDaoImpl extends AbstractDao<Integer, Retrait> implements RetraitDao {

	public Retrait findById(int id){
		Retrait retrait = getByKey(id);
		return retrait;
	}
	
	@SuppressWarnings("unchecked")
	public List<Retrait> findAllOperations(){
	List<Retrait> retraits = getEntityManager().createQuery("SELECT u FROM Retrait u ORDER BY u.id ASC").getResultList();
	return retraits;
	}
	
	public void save(Retrait retrait){
		persist(retrait);
	}
	
	

	
}
