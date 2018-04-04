package com.wha.springmvc.dao;

import java.util.List;

import com.wha.springmvc.model.Agent;

public interface AgentDao {

	Agent findAgentById(int id);
	Agent findAgentByName(String name);
	void save(Agent agent);
	void deleteAgentById(int id);
	List<Agent> findAllAgents();
	void deleteAllAgents();
}
