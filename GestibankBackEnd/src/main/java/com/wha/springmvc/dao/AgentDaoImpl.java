package com.wha.springmvc.dao;

//import java.util.Collection;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.wha.springmvc.dao.AbstractDao;
import com.wha.springmvc.model.Agent;


@Repository("agentDao")
public class AgentDaoImpl extends AbstractDao<Integer, Agent> implements AgentDao {

	public Agent findAgentById(int id){
		Agent agent = getByKey(id);
		return agent;
	}
	
	@SuppressWarnings("unchecked")
	public List<Agent> findAllAgents(){
	List<Agent> agents = getEntityManager().createQuery("SELECT u FROM Agent u ORDER BY u.username ASC").getResultList();
	return agents;
	}
	
	public void save(Agent agent){
		persist(agent);
	}
	
	public void deleteBySSO(String sso){
		Agent agent = (Agent) getEntityManager().createQuery("SELECT u FROM Agent u WHERE u.ssoId LIKE :ssoId").setParameter("ssoId", sso).getSingleResult();
		delete(agent);
	}
	
	
	public Agent findAgentByName(String name){
		System.out.println("name : "+name);
		try{
			Agent agent = (Agent) getEntityManager().createQuery("SELECT u FROM Agent u WHERE u.username LIKE :name").setParameter("name",  name).getSingleResult();
			return agent;
		}catch (NoResultException ex){
			return null;
		}
	}
	
	@Override
	public void deleteAgentById(int id){
		Agent agent = getByKey(id);
		delete(agent);
	}
	
	@Override
	public void deleteAllAgents(){
		//
	}

	
}
