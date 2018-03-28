package com.wha.springmvc.service;

import java.util.List;

import com.wha.springmvc.model.Admin;
import com.wha.springmvc.model.Agent;
import com.wha.springmvc.model.Client;
import com.wha.springmvc.model.User;



public interface UserService {
	
	User findById(long id);
	
	User findByName(String name);
	
	void saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUserById(long id);

	List<User> findAllUsers(); 
	
	void deleteAllUsers();
	
	public boolean isUserExist(User user);
	
	//Les methodes de traitement des clients
	Client findClientByName(String name);
	void saveClient(Client client);
	
	//les methodes de traitement des agents
	Agent findAgentByName(String name);
	void saveAgent(Agent agent);
	
	//les methodes de traitement des admin
		Admin findAdminByName(String name);
		void saveAdmin(Admin admin);
}
