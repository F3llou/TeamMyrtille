package com.wha.springmvc.service;

import java.util.List;

import com.wha.springmvc.model.Admin;
import com.wha.springmvc.model.Agent;
import com.wha.springmvc.model.Auth;
import com.wha.springmvc.model.Client;
import com.wha.springmvc.model.Compte;
import com.wha.springmvc.model.User;

public interface UserService {
	
	User findById(long id);
	
	User findByName(String name);
	
	void saveUser(User user);
	
	void saveCompteClient(Client client, Compte compte);
	
	void updateUser(User user);
	
	/**
	 * Le service de vérification d'authentification
	 * @param auth : c'est le DTO qui sera envoyé par le Angular
	 * @return : le user connecté
	 */
	User verifLogin(Auth auth);
	
	void deleteUserById(long id);

	List<User> findAllUsers(); 
	
	void deleteAllUsers();
	
	public boolean isUserExist(User user);
	
	//Les methodes de traitement des clients
	Client findClientById(int id);
	Client findClientByName(String name);
	void saveClient(Client client);
	void updateClient(Client client);
	 List<Client> findAllClients();
	 void deleteClientById(int id);
	 void deleteAllClients();
	 
	//les methodes de traitement des agents
	Agent findAgentById(int id);
	Agent findAgentByName(String name);
	void saveAgent(Agent agent);
	List<Agent> findAllAgents();
	 void deleteAgentById(int id);
	 void deleteAllAgents();
	
	
	//les methodes de traitement des admin	
	    Admin findAdminById(int id);
		Admin findAdminByName(String name);
		void saveAdmin(Admin admin);
		void deleteAdminById(int id);
}
