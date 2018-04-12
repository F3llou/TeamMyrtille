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
    private OperationService operationService;
	
	@Autowired
	private CompteDao compteDao;

	@Autowired
	private CompteAvecDecouvertDao decdao;
	@Autowired
	private CompteSansDecouvertDao sdedao;
	@Autowired
	private CompteRemunDao remdao;
	
	//partie compte
	
	public Compte findCompteById(long id) {
	
		return compteDao.findCompteById((int)id);
	}
	
	
	public void updateCompte(Compte compte) {

		Compte entity = compteDao.findCompteById((int)compte.getId());
		if(entity!=null){
			entity.setSolde(compte.getSolde());
		}
		compteDao.save(entity);
	}

	public void deleteCompteById(int id) {

		compteDao.deleteCompteById(id);
	}

	
	
	public void deleteAllComptes(){
		
	}
	
	@Override
	public void saveCompte(Compte compte) {
		// TODO Auto-generated method stub
		compteDao.save(compte);
		
	}

	@Override
	public List<Compte> findAllComptes() {
		// TODO Auto-generated method stub
		return compteDao.findAllComptes();
	}

	@Override
	public boolean isUserExist(Compte compte) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Compte findCompteById(int id) {

		return compteDao.findCompteById((int)id);
		
	}
	
//partie compteAvecdecouv
	@Override
	public CompteAvecDecouv findCompteAvecDecouvById(int id) {
		
		return decdao.findCompteAvecDecouvById((int) id);
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

		//--------------------------------------retrait Compte Sans Decouvert----------------------------------------	
		@Override
		public CompteSansDecouv retraitCompteSansDecouv(double montant, int id) {
			CompteSansDecouv compteSD = findCompteSansDecouvById(id);
			System.out.println("Retrait CompteSansDecouv " + compteSD.getId()+compteSD.getSolde()+compteSD.getDateDeb());
			double resultat = operationService.retraitEffect(montant, compteSD);
		 
			if (resultat >=0) {
				compteSD.setSolde(resultat);
				saveCompteSansDecouv(compteSD);
			}
			return compteSD;
		}	
		
		//--------------------------------------depot Compte Sans Decouvert----------------------------------------	
		@Override
		public CompteSansDecouv depotCompteSansDecouv(double montant, int id) {
			CompteSansDecouv compteSD = findCompteSansDecouvById(id);
			System.out.println("Depot CompteSansDecouv " + compteSD.getId()+compteSD.getSolde()+compteSD.getDateDeb());
			double resultat = operationService.depotEffect(montant, compteSD);
		 
			compteSD.setSolde(resultat);
			saveCompteSansDecouv(compteSD);
			return compteSD;
		}	
		
		
		
		
		//------------------------------------------------------------------------------	
		
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
