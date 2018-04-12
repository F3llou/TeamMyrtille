package com.wha.springmvc.service;

import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wha.springmvc.dao.DepotDao;
import com.wha.springmvc.dao.OperationDao;
import com.wha.springmvc.dao.RetraitDao;
import com.wha.springmvc.model.Compte;
import com.wha.springmvc.model.Depot;
import com.wha.springmvc.model.Operation;
import com.wha.springmvc.model.Retrait;
import com.wha.springmvc.model.Virement;




@Service("operationService")
@Transactional
public class OperationServiceImpl implements OperationService{
	
	@Autowired
	private OperationDao operdao;

	@Autowired
	private RetraitDao retdao;
	@Autowired
	private DepotDao depdao;
	/*@Autowired
	private VirementDao virdao;*/
	
	//partie operationService
	
	public Operation findOperationById(long id) {
	
		return operdao.findById((int)id);
	}
	
	
	
	
	@Override
	public void saveOperation(Operation operation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Operation> findAllOperations() {
		// TODO Auto-generated method stub
		return operdao.findAllOperations();
	}
	
//------------------------------------------------------------------------	
	//retrait effectué 
	
	@Override
	public double retraitEffect (double montant, Compte compte) {
		Retrait retrait = new Retrait();
		retrait.setMontant(montant);
		Calendar c = Calendar.getInstance ();
		retrait.setDateOperation(c.getTime());
		return (double) (compte.getSolde() - retrait.getMontant());
	}
	
//------------------------------------------------------------------------	
	//------------------------------------------------------------------------	
		//depot effectué 
		
		@Override
		public double depotEffect (double montant, Compte compte) {
			Depot depot = new Depot();
			depot.setMontant(montant);
			Calendar c = Calendar.getInstance ();
			depot.setDateOperation(c.getTime());
			return (double) (compte.getSolde() + depot.getMontant());
		}
		
	//------------------------------------------------------------------------	
	
	
	
	
	@Override
	public boolean isUserExist(Operation operation) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Operation findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
//partie retrait
	@Override
	public Retrait findRetraitById(int id) {
		
		return retdao.findById(id);
	}

	@Override
	public void saveOperation(Retrait retrait) {
		
		retdao.save(retrait);
	}
	//partie depot
		@Override
		public Depot findDepotById(int id) {
			
			return depdao.findById(id);
		}

		@Override
		public void saveOperation(Depot depot) {
			
			depdao.save(depot);
		}




		@Override
		public Virement findVirementById(int id) {
			// TODO Auto-generated method stub
			return null;
		}




		@Override
		public void saveVirement(Virement virement) {
			// TODO Auto-generated method stub
			
		}

		/*//partie virement
				@Override
				public Virement findVirementById(int id) {
					
					return virdao.findById(id);
				}

				@Override
				public void saveVirement(Virement virement) {
					
					virdao.save(virement);
				}*/

	

}
