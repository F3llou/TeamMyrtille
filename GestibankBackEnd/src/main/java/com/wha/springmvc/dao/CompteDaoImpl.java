package com.wha.springmvc.dao;

//import java.util.Collection;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.wha.springmvc.dao.AbstractDao;
import com.wha.springmvc.model.Compte;


@Repository("compteDao")
public class CompteDaoImpl extends AbstractDao<Integer, Compte> implements CompteDao {

	public Compte findCompteById(int id){
		Compte compte = getByKey(id);
		return compte;
	}
	
	@SuppressWarnings("unchecked")
	public List<Compte> findAllUsers(){
	List<Compte> comptes = getEntityManager().createQuery("SELECT u FROM Compte u ORDER BY u.id ASC").getResultList();
	return comptes;
	}
	
	public void save(Compte compte){
		persist(compte);
	}
	
	public void deleteBySSO(String sso){
		Compte compte = (Compte) getEntityManager().createQuery("SELECT u FROM Compte u WHERE u.ssoId LIKE :ssoId").setParameter("ssoId", sso).getSingleResult();
		delete(compte);
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
		Compte compte = getByKey(id);
		delete(compte);
	}
	
	@Override
	public void deleteAllComptes(){
		//
	}

	@Override
	public List<Compte> findAllComptes() {
		// TODO Auto-generated method stub
		return null;
	}
}
