package com.wha.springmvc.dao;

import java.util.List;

import com.wha.springmvc.model.Compte;


public interface CompteDao {

	Compte findById(int id);
	void save(Compte compte);
	void deleteCompteById(int id);
	List<Compte> findAllComptes();
	void deleteAllComptes();
}
