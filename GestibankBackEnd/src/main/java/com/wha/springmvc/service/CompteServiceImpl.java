package com.wha.springmvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wha.springmvc.dao.CompteAvecDecouvertDao;
import com.wha.springmvc.dao.CompteDao;
import com.wha.springmvc.dao.UserDao;
import com.wha.springmvc.model.Compte;
import com.wha.springmvc.model.CompteAvecDecouv;



@Service("compteService")
@Transactional
public class CompteServiceImpl implements CompteService{
	
	@Autowired
	private CompteDao comdao;

	@Autowired
	private CompteAvecDecouvertDao decdao;
	
	
	//partie compte
	
	public Compte findCompteById(long id) {
	
		return comdao.findById((int)id);
	}
	
	
	public void updateCompte(Compte compte) {

		Compte entity = comdao.findById((int)compte.getId());
		if(entity!=null){
			entity.setSolde(compte.getSolde());
			entity.setType(compte.getType());
			
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


	

	

}
