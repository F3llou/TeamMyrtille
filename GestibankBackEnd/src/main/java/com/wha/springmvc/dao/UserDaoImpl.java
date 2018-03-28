package com.wha.springmvc.dao;

//import java.util.Collection;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.wha.springmvc.model.User;

import com.wha.springmvc.dao.AbstractDao;

/**
 * 
 * @author TeamMyrtille
 * @version 1.0
 *
 */

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

	/**
	 * Recherche d'un utilisateur par identifiant
	 * 
	 * @param id identifiant utilisé pour la recherche
	 * @return user Retourne l'utilisateur trouvé
	 */
	public User findById(int id){
		User user = getByKey(id);
		return user;
	}
	
	/**
	 * Recherche de tous les utilisateurs
	 * 
	 * @return users Retourne une liste de tous les utilisateurs
	 */
	@SuppressWarnings("unchecked")
	public List<User> findAllUsers(){
	List<User> users = getEntityManager().createQuery("SELECT u FROM User u ORDER BY u.username ASC").getResultList();
	return users;
	}
	
	/**
	 * Sauvegarde du profil utilisateur
	 * 
	 * @param user Profil de l'utilisateur à sauvegarder
	 * @return user Profil de l'utilisateur passé en persistance
	 */
	public void save(User user){
		persist(user);
	}
	
	/**
	 * Efface un utilisateur par son ssoId
	 * 
	 * @param sso
	 */
	public void deleteBySSO(String sso){
		User user = (User) getEntityManager().createQuery("SELECT u FROM User u WHERE u.ssoId LIKE :ssoId").setParameter("ssoId", sso).getSingleResult();
		delete(user);
	}
	
	//An alternative to Hibernate.initialize()
	/*protected void initializeCollection(Collection<?> collection){
	*	if(collection == null){
	*		return;
	*	}
	*	collection.iterator().hasNext();
	}*/
	
	/**
	 * 
	 */
	@Override
	public User findByName(String name){
		System.out.println("name : "+name);
		try{
			User user = (User) getEntityManager().createQuery("SELECT u FROM User u WHERE u.username LIKE :name").setParameter("name",  name).getSingleResult();
			return user;
		}catch (NoResultException ex){
			return null;
		}
	}
	
	/**
	 * 
	 */
	@Override
	public void deleteUserById(int id){
		User user = getByKey(id);
		delete(user);
	}
	
	/**
	 * 
	 */
	@Override
	public void deleteAllUsers(){
		//
	}
}
