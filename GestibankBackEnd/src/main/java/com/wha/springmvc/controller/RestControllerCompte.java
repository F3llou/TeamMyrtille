package com.wha.springmvc.controller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;





import com.wha.springmvc.model.Compte;
import com.wha.springmvc.model.CompteAvecDecouv;
import com.wha.springmvc.model.CompteRemun;
import com.wha.springmvc.model.CompteSansDecouv;
import com.wha.springmvc.service.CompteService;
import com.wha.springmvc.service.OperationService;

 
@RestController
public class RestControllerCompte {
 
    @Autowired
    CompteService compteService; 
    
    @Autowired
    OperationService operationService; 
    
    //-------------------Retrieve All Comptes--------------------------------------------------------
     
    @RequestMapping(value = "/compte/", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Compte>> listAllComptes() {
        List<Compte> comptes = compteService.findAllComptes();
        if(comptes.isEmpty()){
            return new ResponseEntity<List<Compte>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Compte>>(comptes, HttpStatus.OK);
    }
 
 
    
    //-------------------Retrieve Single Compte--------------------------------------------------------
     
    @RequestMapping(value = "/compte/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Compte> getCompte(@PathVariable("id") int id) {
        System.out.println("Fetching User with id " + id);
        Compte compte = compteService.findCompteById(id);
        if (compte == null) {
            System.out.println("Compte with id " + id + " not found");
            return new ResponseEntity<Compte>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Compte>(compte, HttpStatus.OK);
    }
 
     
     
    //-------------------Create a Compte--------------------------------------------------------
     
    @RequestMapping(value = "/compte/", method = RequestMethod.POST)
    public ResponseEntity<Void> createCompte(@RequestBody Compte compte,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Compte " + compte.getId()+compte.getSolde()+compte.getDateDeb());
 
        if (compteService.isUserExist(compte)) {
            System.out.println("A Compte with name " +compte.getId()+compte.getSolde()+compte.getDateDeb()+  " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
        compteService.saveCompte(compte);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/compte/{id}").buildAndExpand(compte.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
 
    
     
    //------------------- Update a Compte --------------------------------------------------------
     
    @RequestMapping(value = "/compte/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Compte> updateCompte(@PathVariable("id") int id, @RequestBody Compte compte) {
        System.out.println("Updating Compte " + id);
         
        Compte currentCompte = compteService.findCompteById(id);
         
        if (currentCompte==null) {
            System.out.println("Compte with id " + id + " not found");
            return new ResponseEntity<Compte>(HttpStatus.NOT_FOUND);
        }
 
        currentCompte.setId(compte.getId());
        currentCompte.setSolde(compte.getSolde());
        currentCompte.setDateDeb(compte.getDateDeb());
        
         
        compteService.updateCompte(currentCompte);
        return new ResponseEntity<Compte>(currentCompte, HttpStatus.OK);
    }
 
    
    
    //------------------- Delete a Compte --------------------------------------------------------
     
    @RequestMapping(value = "/compte/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Compte> deleteCompte(@PathVariable("id") int id) {
        System.out.println("Fetching & Deleting Compte with id " + id);
 
        Compte compte = compteService.findCompteById(id);
        if (compte == null) {
            System.out.println("Unable to delete. Compte with id " + id + " not found");
            return new ResponseEntity<Compte>(HttpStatus.NOT_FOUND);
        }
 
        compteService.deleteCompteById(id);
        return new ResponseEntity<Compte>(HttpStatus.NO_CONTENT);
    }
 
     
    
    //------------------- Delete All Comptes --------------------------------------------------------
     
    @RequestMapping(value = "/compte/", method = RequestMethod.DELETE)
    public ResponseEntity<Compte> deleteAllComptes() {
        System.out.println("Deleting All Comptes");
 
        compteService.deleteAllComptes();
        return new ResponseEntity<Compte>(HttpStatus.NO_CONTENT);
    }
     //------------PARTIE COMPTE AVEC DECOUVERT----------- 
  //-------------------Retrieve Single CompteAvecDecouv--------------------------------------------------------
    
    @RequestMapping(value = "/compteAvecDecouv/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CompteAvecDecouv> getCompteAvecDecouv(@PathVariable("id") int id) {
        System.out.println("Fetching CompteAvecDecouv with id " + id);
        CompteAvecDecouv compteAvecDecouv = compteService.findCompteAvecDecouvById(id);
        if (compteAvecDecouv == null) {
            System.out.println("CompteAvecDecouv with id " + id + " not found");
            return new ResponseEntity<CompteAvecDecouv>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CompteAvecDecouv>(compteAvecDecouv, HttpStatus.OK);
    }
 
     
     
    //-------------------Create a CompteAvecDecouv--------------------------------------------------------
     
    @RequestMapping(value = "/compteAvecDecouv/", method = RequestMethod.POST)
    public ResponseEntity<Void> createCompteAvecDecouv(@RequestBody CompteAvecDecouv compteAvecDecouv,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating CompteAvecDecouv " + compteAvecDecouv.getId()+compteAvecDecouv.getSolde()+compteAvecDecouv.getDateDeb());
 
        if (compteService.isUserExist(compteAvecDecouv)) {
            System.out.println("A CompteAvecDecouv with name " +compteAvecDecouv.getId()+compteAvecDecouv.getSolde()+compteAvecDecouv.getDateDeb()+  " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
        compteService.saveCompteAvecDecouv(compteAvecDecouv);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/compteAvecDecouv/{id}").buildAndExpand(compteAvecDecouv.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    //------------PARTIE COMPTE SANS DECOUVERT-----------  
  //-------------------Retrieve Single CompteSansDecouv--------------------------------------------------------
    
    @RequestMapping(value = "/compteSansDecouv/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CompteSansDecouv> getCompteSansDecouv(@PathVariable("id") int id) {
        System.out.println("Fetching CompteSansDecouv with id " + id);
        CompteSansDecouv compteSansDecouv = compteService.findCompteSansDecouvById(id);
        if (compteSansDecouv == null) {
            System.out.println("CompteSansDecouv with id " + id + " not found");
            return new ResponseEntity<CompteSansDecouv>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CompteSansDecouv>(compteSansDecouv, HttpStatus.OK);
    }
 
     
     
    //-------------------Create a CompteSansDecouv--------------------------------------------------------
    @RequestMapping(value = "/compteSansDecouv/", method = RequestMethod.POST)
    public ResponseEntity<Void> createCompteSansDecouv(@RequestBody CompteSansDecouv compteSansDecouv,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating CompteSansDecouv " + compteSansDecouv.getId()+compteSansDecouv.getSolde()+compteSansDecouv.getDateDeb());
 
        if (compteService.isUserExist(compteSansDecouv)) {
            System.out.println("A CompteSansDecouv with name " +compteSansDecouv.getId()+compteSansDecouv.getSolde()+compteSansDecouv.getDateDeb()+  " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
        compteService.saveCompteSansDecouv(compteSansDecouv);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/compteSansDecouv/{id}").buildAndExpand(compteSansDecouv.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    //------------PARTIE COMPTE REMUN-----------   
  //-------------------Retrieve Single CompteRemun--------------------------------------------------------
    @RequestMapping(value = "/compteRemun/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CompteRemun> getCompteRemun(@PathVariable("id") int id) {
        System.out.println("Fetching CompteRemun with id " + id);
        CompteRemun compteRemun = compteService.findCompteRemunById(id);
        if (compteRemun == null) {
            System.out.println("CompteRemun with id " + id + " not found");
            return new ResponseEntity<CompteRemun>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CompteRemun>(compteRemun, HttpStatus.OK);
    }
    
     
     
    //-------------------Create a CompteRemun--------------------------------------------------------
     
    @RequestMapping(value = "/compteRemun/", method = RequestMethod.POST)
    public ResponseEntity<Void> createCompteRemun(@RequestBody CompteRemun compteRemun,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating CompteRemun " + compteRemun.getId()+compteRemun.getSolde()+compteRemun.getDateDeb());
 
        if (compteService.isUserExist(compteRemun)) {
            System.out.println("A CompteRemun with name " +compteRemun.getId()+compteRemun.getSolde()+compteRemun.getDateDeb()+  " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
        compteService.saveCompteRemun(compteRemun);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/compteRemun/{id}").buildAndExpand(compteRemun.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    
    
}