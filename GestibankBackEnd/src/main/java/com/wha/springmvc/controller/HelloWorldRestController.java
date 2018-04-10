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
import com.wha.springmvc.model.Agent;
import com.wha.springmvc.model.Admin;
import com.wha.springmvc.model.Client;
import com.wha.springmvc.model.User;
import com.wha.springmvc.service.CompteService;
import com.wha.springmvc.service.OperationService;
import com.wha.springmvc.service.UserService;
 
@RestController
public class HelloWorldRestController {
 
    @Autowired
    UserService userService;  //Service which will do all data retrieval/manipulation work
    
    @Autowired
    CompteService compteService; 
    
    @Autowired
    OperationService operationService; 
    
    //-------------------Retrieve All Users--------------------------------------------------------
     
    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<User>> listAllUsers() {
        List<User> users = userService.findAllUsers();
        if(users.isEmpty()){
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
 
 
    
    //-------------------Retrieve Single User--------------------------------------------------------
     
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable("id") long id) {
        System.out.println("Fetching User with id " + id);
        User user = userService.findById(id);
        if (user == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
 
     
     
    //-------------------Create a User--------------------------------------------------------
     
    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody User user,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + user.getUsername());
 
        if (userService.isUserExist(user)) {
            System.out.println("A User with name " + user.getUsername() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
        userService.saveUser(user);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
 
    
     
    //------------------- Update a User --------------------------------------------------------
     
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
        System.out.println("Updating User " + id);
         
        User currentUser = userService.findById(id);
         
        if (currentUser==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
 
        currentUser.setUsername(user.getUsername());
        currentUser.setAddress(user.getAddress());
        currentUser.setEmail(user.getEmail());
        currentUser.setLogin(user.getLogin());
        currentUser.setPrenom(user.getPrenom());		
        currentUser.setNumTel(user.getNumTel());
         
        userService.updateUser(currentUser);
        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
    }
 
    
    
    //------------------- Delete a User --------------------------------------------------------
     
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting User with id " + id);
 
        User user = userService.findById(id);
        if (user == null) {
            System.out.println("Unable to delete. User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
 
        userService.deleteUserById(id);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
 
     
    
    //------------------- Delete All Users --------------------------------------------------------
     
    @RequestMapping(value = "/user/", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteAllUsers() {
        System.out.println("Deleting All Users");
 
        userService.deleteAllUsers();
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
                       //PARTIE CLIENT
  //------------------- Recherche Client par id --------------------
    
    @RequestMapping(value = "/client/id/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> getClient(@PathVariable("id") int id) {
        System.out.println("Fetching Client with id " + id);
        Client client = userService.findClientById(id);
        if (client == null) {
            System.out.println("Client with id " + id + " not found");
            return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Client>(client, HttpStatus.OK);
    }
    
   //------------------- Recherche Client par nom --------------------
    @RequestMapping(value="/client/name/{nom}", method = RequestMethod.GET)
    public ResponseEntity<Client> rechercheClientParNom(@PathVariable("nom") String n){
    	Client cli = userService.findClientByName(n);
    	if(cli == null) {
    		return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
    	}else {
    		return new ResponseEntity<Client>(cli, HttpStatus.OK);
    	}
    }
      
    //------------------- Create Client --------------------
    
    @RequestMapping(value = "/client/id/", method = RequestMethod.POST)
    public ResponseEntity<Void> createClient(@RequestBody Client client,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Client "+client.getId()+" " + client.getUsername()+" " +client.getAddress()+" "+client.getEmail()+" "+
        		client.getLogin()+" "+client.getMdp()+" "+client.getNbEnfant()+" "+client.getNumTel()+" "+client.getPrenom()+" "+client.getSituationMaritale());
 
        if (userService.isUserExist(client)) {
            System.out.println("A Client with name " + client.getUsername() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
        userService.saveClient(client);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/client/id/{id}").buildAndExpand(client.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }




//-------------------Retrieve All Client--------------------------------------------------------

@RequestMapping(value = "/client/", method = RequestMethod.GET)
@CrossOrigin(origins = "http://localhost:4200")
public ResponseEntity<List<Client>> listAllClients() {
    List<Client> clients = userService.findAllClients();
    if(clients.isEmpty()){
        return new ResponseEntity<List<Client>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
    }
    return new ResponseEntity<List<Client>>(clients, HttpStatus.OK);
}

//------------------- Delete a Client --------------------------------------------------------

@RequestMapping(value = "/client/{id}", method = RequestMethod.DELETE)
public ResponseEntity<Client> deleteClient(@PathVariable("id") int id) {
    System.out.println("Fetching & Deleting Client with id " + id);

    Client client = userService.findClientById(id);
    if (client == null) {
        System.out.println("Unable to delete. Client with id " + id + " not found");
        return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
    }

    userService.deleteClientById(id);
    return new ResponseEntity<Client>(HttpStatus.NO_CONTENT);
}

 

//------------------- Delete All Users --------------------------------------------------------
 
@RequestMapping(value = "/client/", method = RequestMethod.DELETE)
public ResponseEntity<Client> deleteAllClients() {
    System.out.println("Deleting All clients");

    userService.deleteAllClients();
    return new ResponseEntity<Client>(HttpStatus.NO_CONTENT);
}


}

