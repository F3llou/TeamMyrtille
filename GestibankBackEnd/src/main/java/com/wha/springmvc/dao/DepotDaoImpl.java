package com.wha.springmvc.dao;

//import java.util.Collection;
import java.util.List;
import javax.persistence.NoResultException;
import org.springframework.stereotype.Repository;
import com.wha.springmvc.dao.AbstractDao;
import com.wha.springmvc.model.Depot;





@Repository("depotDao")
public class DepotDaoImpl extends AbstractDao<Integer, Depot> implements DepotDao {

	public Depot findById(int id){
		Depot depot = getByKey(id);
		return depot;
	}
	
	@SuppressWarnings("unchecked")
	public List<Depot> findAllOperations(){
	List<Depot> depots = getEntityManager().createQuery("SELECT u FROM Depot u ORDER BY u.id ASC").getResultList();
	return depots;
	}
	
	public void save(Depot depot){
		persist(depot);
	}
	
	

	
}
