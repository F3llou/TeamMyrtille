package com.wha.springmvc.dao;

import java.util.List;

import com.wha.springmvc.model.User;

/**
 * 
 * @author TeamMyrtille
 * @version 1.0
 */

public interface UserDao {

	/**
	 * Recherche d'un utilisateur par identifiant
	 * 
	 * @param id identifiant utilisé pour la recherche
	 * @return user Retourne l'utilisateur trouvé
	 */
	User findById(int id);
	
	/**
	 * Retrouver un utilisateur par son nom (username)
	 * 
	 * @param name Nom de l'utilisateur à rechercher
	 * @return user Profil de l'utilisateur retrouvé
	 * @return null Rien n'est retourné s'il n'y a pas de résultat
	 */
	User findByName(String name);
	
	/**
	 * Sauvegarde du profil utilisateur
	 * 
	 * @param user Profil de l'utilisateur à sauvegarder
	 * @return user Profil de l'utilisateur passé en persistance
	 */
	void save(User user);
	
	/**
	 * Efface un utilisateur retrouvé par son identifiant
	 * 
	 * @param id Identifiant de l'utilisateur à effacer
	 */
	void deleteUserById(int id);
	
	/**
	 * Recherche de tous les utilisateurs
	 * 
	 * @return users Retourne une liste de tous les utilisateurs
	 */
	List<User> findAllUsers();
	
	/**
	 * Efface tous les utilisateurs
	 * (pas de méthode pour le moment)
	 */
	void deleteAllUsers();
}
