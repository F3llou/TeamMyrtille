package com.wha.springmvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wha.springmvc.dao.CompteAvecDecouvertDao;
import com.wha.springmvc.dao.CompteDao;
import com.wha.springmvc.dao.CompteRemunDao;
import com.wha.springmvc.dao.CompteSansDecouvertDao;
import com.wha.springmvc.model.Client;
import com.wha.springmvc.model.Compte;
import com.wha.springmvc.model.CompteAvecDecouv;
import com.wha.springmvc.model.CompteRemun;
import com.wha.springmvc.model.CompteSansDecouv;
import com.wha.springmvc.model.Depot;
import com.wha.springmvc.model.Retrait;
import com.wha.springmvc.model.Virement;


@Service("compteService")
@Transactional
public class CompteServiceImpl implements CompteService{
	
    @Autowired
    private OperationService operationService;
	
    @Autowired
    private UserService userService;
    
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

	public void createCompteClient(int id, Compte compte){
        Client client = userService.findClientById(id);
        
        saveCompte(compte);
        userService.saveCompteClient(client, compte);
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
			//recup du compte 
			CompteSansDecouv compteSD = findCompteSansDecouvById(id);
			// recup Obj Retrait 
			Retrait retrait = operationService.retraitEffect(montant);
			
			//set objet retrait dans la liste des operation 
			compteSD.getListOperations().add(retrait);
			
			//set du compte
			double resultat = compteSD.getSolde()+retrait.getMontant();
			
			if(resultat >=0){
				compteSD.setSolde(resultat);
				//save compte 
				sdedao.save(compteSD);
			}
			return compteSD;
		}	
		
		//--------------------------------------depot Compte Sans Decouvert----------------------------------------	
		@Override
		public CompteSansDecouv depotCompteSansDecouv(double montant, int id) {
			CompteSansDecouv compteSD = findCompteSansDecouvById(id);
			System.out.println("Depot CompteSansDecouv " + compteSD.getId()+compteSD.getSolde()+compteSD.getDateDeb());
			Depot depot = operationService.depotEffect(montant);
			double resultat = compteSD.getSolde()+depot.getMontant();
			compteSD.getListOperations().add(depot);
		 
			compteSD.setSolde(resultat);
			saveCompteSansDecouv(compteSD);
			
			return compteSD;
		}	

		//--------------------------------------virement Compte Sans Decouvert----------------------------------------	
		@Override
		public CompteSansDecouv virementCompteSansDecouv(double montant, int id, int idrecev) {
			//recup du compte 
			CompteSansDecouv compteSDDepart = findCompteSansDecouvById(id);
			Compte compteArrive = findCompteSansDecouvById(idrecev);
			// recup Obj Retrait et Depot et deux types Virements
			Retrait retrait = operationService.retraitEffect(montant);
			Depot depot = operationService.depotEffect(montant);
			Virement virement1 = new Virement();
			virement1 = operationService.virementInit(virement1, retrait, compteArrive.getId());
			Virement virement2 = new Virement(); 
			virement2 = operationService.virementInit(virement2, depot, compteArrive.getId());
			
			//set objet retrait dans la liste des operation 
			compteSDDepart.getListOperations().add(virement1);
			compteArrive.getListOperations().add(virement2);
			
			//set du compte
			double resultat1 = compteSDDepart.getSolde()+virement1.getMontant();
			double resultat2 = compteArrive.getSolde()+virement2.getMontant();
			
			if(resultat1 >=0){
				compteSDDepart.setSolde(resultat1);
				compteArrive.setSolde(resultat2);
				//save compte 
				sdedao.save(compteSDDepart);
				compteDao.save(compteArrive);
			}

			return compteSDDepart;
			
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
