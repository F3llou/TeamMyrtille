package com.wha.springmvc.dao;

import java.util.List;

import com.wha.springmvc.model.Admin;

public interface AdminDao {

	Admin findAdminById(int id);
	Admin findAdminByName(String name);
	void save(Admin admin);
	void deleteAdminById(int id);

}



