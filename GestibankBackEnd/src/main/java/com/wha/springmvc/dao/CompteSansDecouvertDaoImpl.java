package com.wha.springmvc.dao;

//import java.util.Collection;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.wha.springmvc.dao.AbstractDao;
import com.wha.springmvc.model.CompteSansDecouv;




@Repository("compteSansdecouvertDao")
public class CompteSansDecouvertDaoImpl extends AbstractDao<Integer, CompteSansDecouv> implements CompteSansDecouvertDao {

	public CompteSansDecouv findById(int id){
		CompteSansDecouv compteSansDecouv = getByKey(id);
		return compteSansDecouv;
	}
	
	@SuppressWarnings("unchecked")
	public List<CompteSansDecouv> findAllComptes(){
	List<CompteSansDecouv> CompteAvecDecouv = getEntityManager().createQuery("SELECT u FROM CompteAvecDecouv u ORDER BY u.id ASC").getResultList();
	return CompteAvecDecouv;
	}
	
	public void save(CompteSansDecouv compteSansDecouv){
		persist(compteSansDecouv);
	}
	
	public void deleteBySSO(String sso){
		CompteSansDecouv compteSansDecouv = (CompteSansDecouv) getEntityManager().createQuery("SELECT u FROM CompteAvecDecouv u WHERE u.ssoId LIKE :ssoId").setParameter("ssoId", sso).getSingleResult();
		delete(compteSansDecouv);
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
		CompteSansDecouv compteSansDecouv = getByKey(id);
		delete(compteSansDecouv);
	}
	
	@Override
	public void deleteAllComptes(){
		//
	}

	
}
