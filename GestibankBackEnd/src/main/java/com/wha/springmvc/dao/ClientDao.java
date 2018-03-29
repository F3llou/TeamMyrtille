package com.wha.springmvc.dao;

import java.util.List;

import com.wha.springmvc.model.Client;

/**
 * 
 * @author TeamMyrtille
 * @version 1.0
 *
 */

public interface ClientDao {

	/**
	 * Recherche d'un client par identifiant
	 * 
	 * @param id Identifiant utilisé pour la recherche du client
	 * @return client Retourne l'utilisateur trouvé
	 */
	Client findById(int id);
	
	/**
	 * Retrouver un client par son nom (username)
	 * 
	 * @param name Nom du client à rechercher
	 * @return client Profil du client retrouvé
	 * @return null Rien n'est retourné s'il n'y a pas de résultat
	 */
	Client findByName(String name);
	
	/**
	 * Sauvegarde du profil client
	 * 
	 * @param client Profil du client à sauvegarder
	 * @return client Profil du client passé en persistance
	 */
	void save(Client client);
	
	/**
	 * Efface un client retrouvé par son identifiant
	 * 
	 * @param id Identifiant du client à effacer
	 */
	void deleteUserById(int id);
	
	/**
	 * Recherche de tous les clients
	 * 
	 * @return clients Retourne une liste de tous les clients
	 */
	List<Client> findAllUsers();
	
	/**
	 * Efface tous les clients
	 * (pas de méthode pour le moment)
	 */
	void deleteAllUsers();
	
	/**
	 * Efface un client par son ssoId
	 * 
	 * @param sso ssoID du client à supprimer
	 */
	void deleteBySSO(String sso);
}
