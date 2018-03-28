package com.wha.springmvc.dao;

import java.util.List;

import com.wha.springmvc.model.User;

/**
 * 
 * @author TeamMyrtille
 * @version 1.0
 */

public interface UserDao {

	/**
	 * 
	 * @param id
	 * @return
	 */
	User findById(int id);
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	User findByName(String name);
	
	/**
	 * 
	 * @param user
	 */
	void save(User user);
	
	/**
	 * 
	 * @param id
	 */
	void deleteUserById(int id);
	
	/**
	 * 
	 * @return
	 */
	List<User> findAllUsers();
	
	/**
	 * 
	 */
	void deleteAllUsers();
}
