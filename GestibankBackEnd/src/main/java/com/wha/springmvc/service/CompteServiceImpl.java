package com.wha.springmvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wha.springmvc.dao.CompteAvecDecouvertDao;
import com.wha.springmvc.dao.CompteDao;
import com.wha.springmvc.dao.CompteRemunDao;
import com.wha.springmvc.dao.CompteSansDecouvertDao;
import com.wha.springmvc.model.Compte;
import com.wha.springmvc.model.CompteAvecDecouv;
import com.wha.springmvc.model.CompteRemun;
import com.wha.springmvc.model.CompteSansDecouv;



@Service("compteService")
@Transactional
public class CompteServiceImpl implements CompteService{
	
	@Autowired
	private CompteDao comdao;

	@Autowired
	private CompteAvecDecouvertDao decdao;
	@Autowired
	private CompteSansDecouvertDao sdedao;
	@Autowired
	private CompteRemunDao remdao;
	
	//partie compte
	
	public Compte findCompteById(long id) {
	
		return comdao.findById((int)id);
	}
	
	
	public void updateCompte(Compte compte) {

		Compte entity = comdao.findById((int)compte.getId());
		if(entity!=null){
			entity.setSolde(compte.getSolde());
		}
		comdao.save(entity);
	}

	public void deleteCompteById(int id) {

		comdao.deleteCompteById(id);
	}

	
	
	public void deleteAllComptes(){
		
	}
	
	@Override
	public void saveCompte(Compte compte) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Compte> findAllComptes() {
		// TODO Auto-generated method stub
		return comdao.findAllComptes();
	}

	@Override
	public boolean isUserExist(Compte compte) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Compte findCompteById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
//partie compteAvecdecouv
	@Override
	public CompteAvecDecouv findCompteAvecDecouvById(int id) {
		
		return decdao.findById(id);
	}

	@Override
	public void saveCompteAvecDecouv(CompteAvecDecouv compteAvecDecouv) {
		
		decdao.save(compteAvecDecouv);
	}
	//partie compteSansdecouv
		@Override
		public CompteSansDecouv findCompteSansDecouvById(int id) {
			
			return sdedao.findById(id);
		}

		@Override
		public void saveCompteSansDecouv(CompteSansDecouv compteSansDecouv) {
			
			sdedao.save(compteSansDecouv);
		}

		//partie compteRemun
				@Override
				public CompteRemun findCompteRemunById(int id) {
					
					return remdao.findById(id);
				}

				@Override
				public void saveCompteRemun(CompteRemun compteRemun) {
					
					remdao.save(compteRemun);
				}

	

}
