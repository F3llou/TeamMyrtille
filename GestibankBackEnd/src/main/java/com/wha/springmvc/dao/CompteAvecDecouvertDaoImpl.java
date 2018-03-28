package com.wha.springmvc.dao;

//import java.util.Collection;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.wha.springmvc.dao.AbstractDao;
import com.wha.springmvc.model.CompteAvecDecouv;



@Repository("compteAvecdecouvertDao")
public class CompteAvecDecouvertDaoImpl extends AbstractDao<Integer, CompteAvecDecouv> implements CompteAvecDecouvertDao {

	public CompteAvecDecouv findById(int id){
		CompteAvecDecouv compteAvecDecouv = getByKey(id);
		return compteAvecDecouv;
	}
	
	@SuppressWarnings("unchecked")
	public List<CompteAvecDecouv> findAllComptes(){
	List<CompteAvecDecouv> CompteAvecDecouv = getEntityManager().createQuery("SELECT u FROM CompteAvecDecouv u ORDER BY u.id ASC").getResultList();
	return CompteAvecDecouv;
	}
	
	public void save(CompteAvecDecouv compteAvecDecouv){
		persist(compteAvecDecouv);
	}
	
	public void deleteBySSO(String sso){
		CompteAvecDecouv compteAvecDecouv = (CompteAvecDecouv) getEntityManager().createQuery("SELECT u FROM CompteAvecDecouv u WHERE u.ssoId LIKE :ssoId").setParameter("ssoId", sso).getSingleResult();
		delete(compteAvecDecouv);
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
		CompteAvecDecouv compteAvecDecouv = getByKey(id);
		delete(compteAvecDecouv);
	}
	
	@Override
	public void deleteAllComptes(){
		//
	}

	
}
