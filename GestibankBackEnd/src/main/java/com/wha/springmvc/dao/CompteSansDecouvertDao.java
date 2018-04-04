package com.wha.springmvc.dao;

import java.util.List;

import com.wha.springmvc.model.Compte;
import com.wha.springmvc.model.CompteSansDecouv;



public interface CompteSansDecouvertDao {

	CompteSansDecouv findById(int id);
	void save(CompteSansDecouv compteSansDecouv);
	void deleteCompteById(int id);
	List<CompteSansDecouv> findAllComptes();
	void deleteAllComptes();
}

