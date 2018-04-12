package com.wha.springmvc.dao;

import java.util.List;

import com.wha.springmvc.model.CompteAvecDecouv;


public interface CompteAvecDecouvertDao {

	CompteAvecDecouv findCompteAvecDecouvById(int id);
	void save(CompteAvecDecouv compteAvecDecouvert);
	void deleteCompteById(int id);
	List<CompteAvecDecouv> findAllComptes();
	void deleteAllComptes();
}

