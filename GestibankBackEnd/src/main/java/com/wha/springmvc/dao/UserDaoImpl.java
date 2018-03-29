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
	 * @param sso ssoID de l'utilisateur à supprimer
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
	 * Retrouver un utilisateur par son nom (username)
	 * 
	 * @param name Nom de l'utilisateur à rechercher
	 * @return user Profil de l'utilisateur retrouvé
	 * @return null Rien n'est retourné s'il n'y a pas de résultat
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
	 * Efface un utilisateur retrouvé par son identifiant
	 * 
	 * @param id Identifiant de l'utilisateur à effacer
	 */
	@Override
	public void deleteUserById(int id){
		User user = getByKey(id);
		delete(user);
	}
	
	/**
	 * Efface tous les utilisateurs
	 * (pas de méthode pour le moment)
	 */
	@Override
	public void deleteAllUsers(){
		//
	}
}
