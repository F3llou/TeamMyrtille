package com.wha.springmvc.service;

import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Iterator;
import java.util.List;
//import java.util.concurrent.atomic.AtomicLong;





import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wha.springmvc.dao.AdminDao;
import com.wha.springmvc.dao.AgentDao;
import com.wha.springmvc.dao.ClientDao;
import com.wha.springmvc.dao.UserDao;
import com.wha.springmvc.model.Admin;
import com.wha.springmvc.model.Agent;
import com.wha.springmvc.model.Client;
import com.wha.springmvc.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	
//	private static final AtomicLong counter = new AtomicLong();
//	
//	private static List<User> users;
//	
//	static{
//		users= populateDummyUsers();
//	}

	@Autowired
	private UserDao dao;
	
	@Autowired
	private ClientDao cdao;
	
	@Autowired
	private AgentDao agdao;
	
	@Autowired
	private AdminDao addao;
	
	//partie user
	public List<User> findAllUsers() {
		//return users;
		return dao.findAllUsers();
	}
	
	public User findById(long id) {
		return dao.findById((int)id);
	}
	
	public User findByName(String name) {
//		for(User user : users){
//			if(user.getUsername().equalsIgnoreCase(name)){
//				return user;
//			}
//		}
//		return null;
		return dao.findByName(name);
	}
	
	public void saveUser(User user) {
//		user.setId(counter.incrementAndGet());
//		users.add(user);
		dao.save(user);
	}

	public void updateUser(User user) {
		User entity = dao.findById((int)user.getId());
		if(entity!=null){
			entity.setLogin(user.getLogin());
			entity.setMdp(user.getMdp());
			entity.setPrenom(user.getPrenom());
			entity.setUsername(user.getUsername());
			entity.setAddress(user.getAddress());
			entity.setEmail(user.getEmail());
			entity.setNumTel(user.getNumTel());
		}
		dao.save(entity);
	}

	public void deleteUserById(long id) {
		dao.deleteUserById((int)id);
	}

	public boolean isUserExist(User user) {
		return findByName(user.getUsername())!=null;
	}
	
	public void deleteAllUsers(){
		//users.clear();
	}
	 
//partie client
	public Client findClientById(int id) {
		return cdao.findClientById((int)id);
	}
	public Client findClientByName(String name) {
		// TODO Auto-generated method stub
		return cdao.findClientByName(name);
	}

	public void saveClient(Client client) {
		// TODO Auto-generated method stub
		cdao.save(client);
	}
	public List<Client> findAllClients() {
		//return users;
		return cdao.findAllClients();
	}
	
	public void deleteClientById(int id) {
		cdao.deleteClientById((int)id);
	}

	
	public void deleteAllClients(){
		
	}
	
//partie agent
	public Agent findAgentById(int id) {
		return agdao.findAgentById((int)id);
	}

	public Agent findAgentByName(String name) {
		// TODO Auto-generated method stub
		return agdao.findAgentByName(name);
	}

	
	public void saveAgent(Agent agent) {
		// TODO Auto-generated method stub
		agdao.save(agent);
	}
	public List<Agent> findAllAgents() {
		//return users;
		return agdao.findAllAgents();
	}
	
	public void deleteAgentById(int id) {
		agdao.deleteAgentById((int)id);
	}

	
	public void deleteAllAgents(){
		
	}
//partie admin
	public Admin findAdminById(int id) {
		return addao.findAdminById((int)id);
	}

	public Admin findAdminByName(String name) {
		// TODO Auto-generated method stub
		return addao.findAdminByName(name);
	}


	public void saveAdmin(Admin admin) {
		// TODO Auto-generated method stub
		addao.save(admin);
	}
	
	
	public void deleteAdminById(int id) {
		addao.deleteAdminById((int)id);
	}

	
	

}
