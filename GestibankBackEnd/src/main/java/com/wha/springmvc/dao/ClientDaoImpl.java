package com.wha.springmvc.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.wha.springmvc.model.Client;
import com.wha.springmvc.model.User;

/**
 * 
 * @author TeamMyrtille
 * @version 1.0
 *
 */

@Repository("clientDao")
public class ClientDaoImpl extends AbstractDao<Integer, Client> implements ClientDao {

	/**
	 * Recherche d'un client par identifiant
	 * 
	 * @param id Identifiant utilisé pour la recherche du client
	 * @return client Retourne l'utilisateur trouvé
	 */
	@Override
	public Client findClientById(int id) {
		Client client = getByKey(id);
		return client;
	}

	/**
	 * Retrouver un client par son nom (username)
	 * 
	 * @param name Nom du client à rechercher
	 * @return client Profil du client retrouvé
	 * @return null Rien n'est retourné s'il n'y a pas de résultat
	 */
	@Override
	public Client findClientByName(String name) {
		// TODO Auto-generated method stub
		System.out.println("name : "+name);
		try {
			Client client=(Client) getEntityManager().createQuery("SELECT c FROM Client c WHERE c.username LIKE :name").setParameter("name",  name).getSingleResult();
			return client;
		}catch (NoResultException ex) {
		return null;
		}
	}

	/**
	 * Sauvegarde du profil client
	 * 
	 * @param client Profil du client à sauvegarder
	 * @return client Profil du client passé en persistance
	 */
	@Override
	public void save(Client client) {
		// TODO Auto-generated method stub
		getEntityManager().persist(client);
	}

	/**
	 * Efface un client retrouvé par son identifiant
	 * 
	 * @param id Identifiant du client à effacer
	 */
	@Override
	public void deleteClientById(int id) {
		Client client = getByKey(id);
		delete(client);
	}

	/**
	 * Recherche de tous les clients
	 * 
	 * @return clients Retourne une liste de tous les clients
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Client> findAllClients() {
		List<Client> clients = getEntityManager().createQuery("SELECT u FROM User u WHERE u.TYPE_ENTITE = 'CL' ORDER BY u.username ASC").getResultList();
		return clients;
	}

	/**
	 * Efface tous les clients
	 * (pas de méthode pour le moment)
	 */
	@Override
	public void deleteAllClients() {
		// TODO Auto-generated method stub

	}

	/**
	 * Efface un client par son ssoId
	 * 
	 * @param sso ssoID du client à supprimer
	 */
	public void deleteBySSO(String sso){
		Client client = (Client) getEntityManager().createQuery("SELECT u FROM User u WHERE u.ssoId LIKE :ssoId").setParameter("ssoId", sso).getSingleResult();
		delete(client);
	}
}
