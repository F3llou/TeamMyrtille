package com.wha.springmvc.dao;

import java.util.List;

import com.wha.springmvc.model.Compte;
import com.wha.springmvc.model.CompteRemun;




public interface CompteRemunDao {

	CompteRemun findById(int id);
	void save(CompteRemun compteRemun);
	void deleteCompteById(int id);
	List<CompteRemun> findAllComptes();
	void deleteAllComptes();
}

