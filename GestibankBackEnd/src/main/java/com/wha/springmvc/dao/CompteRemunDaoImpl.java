package com.wha.springmvc.dao;

//import java.util.Collection;
import java.util.List;

import javax.persistence.NoResultException;
import org.springframework.stereotype.Repository;
import com.wha.springmvc.dao.AbstractDao;
import com.wha.springmvc.model.CompteRemun;





@Repository("compteRemunDao")
public class CompteRemunDaoImpl extends AbstractDao<Integer, CompteRemun> implements CompteRemunDao {

	public CompteRemun findById(int id){
		CompteRemun compteRemun = getByKey(id);
		return compteRemun;
	}
	
	@SuppressWarnings("unchecked")
	public List<CompteRemun> findAllComptes(){
	List<CompteRemun> CompteRemun = getEntityManager().createQuery("SELECT u FROM CompteRemun u ORDER BY u.id ASC").getResultList();
	return CompteRemun;
	}
	
	public void save(CompteRemun compteRemun){
		persist(compteRemun);
	}
	
	public void deleteBySSO(String sso){
		CompteRemun compteRemun = (CompteRemun) getEntityManager().createQuery("SELECT u FROM CompteRemun u WHERE u.ssoId LIKE :ssoId").setParameter("ssoId", sso).getSingleResult();
		delete(compteRemun);
	}
	
	//An alternative to Hibernate.initialize()
	/*protected void initializeCollection(Collection<?> collection){
	*	if(collection == null){
	*		return;
	*	}
	*	collection.iterator().hasNext();
	}*/
		
	
	@Override
	public void deleteCompteById(int id){
		CompteRemun compteRemun = getByKey(id);
		delete(compteRemun);
	}
	
	@Override
	public void deleteAllComptes(){
		//
	}

	
}
