package com.wha.springmvc.dao;

import java.util.List;

import javax.persistence.NoResultException;

import com.wha.springmvc.model.Client;

public class ClientDaoImpl extends AbstractDao<Integer, Client> implements ClientDao {

	@Override
	public Client findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client findByName(String name) {
		// TODO Auto-generated method stub
		System.out.println("name : "+name);
		try {
			Client client=(Client) getEntityManager().createQuery("SELECT c FROM Client c WHERE c.username LIKE :name").setParameter("name",  name).getSingleResult();
			return client;
		}catch (NoResultException ex) {
		return null;
		}
	}

	@Override
	public void save(Client client) {
		// TODO Auto-generated method stub
		getEntityManager().persist(client);

	}

	@Override
	public void deleteUserById(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Client> findAllClients() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllClients() {
		// TODO Auto-generated method stub

	}

}
