package com.wha.springmvc.dao;

//import java.util.Collection;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.wha.springmvc.model.Admin;
import com.wha.springmvc.dao.AbstractDao;


@Repository("adminDao")
public class AdminDaoImpl extends AbstractDao<Integer, Admin> implements AdminDao {

	public Admin findById(int id){
		Admin admin = getByKey(id);
		return admin;
	}
	
	@SuppressWarnings("unchecked")
	public List<Admin> findAllUsers(){
	List<Admin> admins = getEntityManager().createQuery("SELECT u FROM Admin u ORDER BY u.username ASC").getResultList();
	return admins;
	}
	
	public void save(Admin admin){
		persist(admin);
	}
	
	public void deleteBySSO(String sso){
		Admin admin = (Admin) getEntityManager().createQuery("SELECT u FROM Admin u WHERE u.ssoId LIKE :ssoId").setParameter("ssoId", sso).getSingleResult();
		delete(admin);
	}
	
	//An alternative to Hibernate.initialize()
	/*protected void initializeCollection(Collection<?> collection){
	*	if(collection == null){
	*		return;
	*	}
	*	collection.iterator().hasNext();
	}*/
	
	@Override
	public Admin findByName(String name){
		System.out.println("name : "+name);
		try{
			Admin admin = (Admin) getEntityManager().createQuery("SELECT u FROM Admin u WHERE u.username LIKE :name").setParameter("name",  name).getSingleResult();
			return admin;
		}catch (NoResultException ex){
			return null;
		}
	}
	
	@Override
	public void deleteUserById(int id){
		Admin admin = getByKey(id);
		delete(admin);
	}
	
	@Override
	public void deleteAllUsers(){
		//
	}
}
