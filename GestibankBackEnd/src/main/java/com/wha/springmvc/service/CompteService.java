package com.wha.springmvc.service;

import java.util.List;

import com.wha.springmvc.model.Compte;
import com.wha.springmvc.model.CompteAvecDecouv;
import com.wha.springmvc.model.CompteRemun;
import com.wha.springmvc.model.CompteSansDecouv;

public interface CompteService {
	
	Compte findCompteById(int id);	
	void saveCompte(Compte compte);
	
	void updateCompte(Compte compte);
	
	void deleteCompteById(int id);

	List<Compte> findAllComptes(); 
	
	void deleteAllComptes();
	
	public boolean isUserExist(Compte compte);
	
	//Les methodes de traitement des compteAvecdecouv
	CompteAvecDecouv  findCompteAvecDecouvById(int id);
	void saveCompteAvecDecouv(CompteAvecDecouv compteAvecDecouv);
	
	/*//les methodes de traitement des compteSansDecouv
	CompteSansDecouv findCompteSansDecouvById(int id);
	void saveCompteSansDecouv(CompteSansDecouv compteSansDecouv);
	
	//les methodes de traitement des CompteRemun
	CompteRemun findCompteRemunById(int id);
		void saveCompteRemun(CompteRemun compteRemun);*/
}
