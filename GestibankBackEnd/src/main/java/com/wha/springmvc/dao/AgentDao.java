package com.wha.springmvc.dao;

import java.util.List;

import com.wha.springmvc.model.Agent;

public interface AgentDao {

	Agent findById(int id);
	Agent findByName(String name);
	void save(Agent agent);
	void deleteUserById(int id);
	List<Agent> findAllUsers();
	void deleteAllUsers();
}
