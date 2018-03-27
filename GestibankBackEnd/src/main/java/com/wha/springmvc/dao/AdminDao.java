package com.wha.springmvc.dao;

import java.util.List;

import com.wha.springmvc.model.Admin;

public interface AdminDao {

	Admin findById(int id);
	Admin findByName(String name);
	void save(Admin admin);
	void deleteUserById(int id);
	List<Admin> findAllUsers();
	void deleteAllUsers();
}
