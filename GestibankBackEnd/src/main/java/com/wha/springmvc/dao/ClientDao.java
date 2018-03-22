package com.wha.springmvc.dao;

import java.util.List;

import com.wha.springmvc.model.Client;
import com.wha.springmvc.model.User;

public interface ClientDao {

	Client findById(int id);
	Client findByName(String name);
	void save(Client client);
	void deleteUserById(int id);
	List<Client> findAllClients();
	void deleteAllClients();
}
