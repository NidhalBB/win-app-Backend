package com.example.projetg4.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.projetg4.models.Figure;
import com.example.projetg4.models.Image;
import com.example.projetg4.models.User;
import com.example.projetg4.repositories.FigureRepo;
import com.example.projetg4.repositories.UserRepo;


@CrossOrigin("*")
@RestController
public class UserController {
	@Autowired
	UserRepo rep ;
	
	@Autowired
	private FigureRepo rep1;
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@GetMapping("/")
	public String home() {
		return "hello" ;
	}
	

	  @GetMapping("/show")
	    public List<User> getAll(){
	        List<User> users = this.rep.findAll();
	        return users;
	    }
	
	
	  @PostMapping("/register")
	    public User register(@RequestBody User user){
		  try {
		    User u = new User(user.getEmail() , user.getPassword() , user.getFullname() , user.getGender() , user.getAdress() ) ; 
	        this.rep.save(u);
	        u.setId(null);
	        return u ; }
		  catch(Exception E){
			  return null ;
		  }
	    }
	  
		
	  

	  @PostMapping("/login")
	    public User login(@RequestBody User user){
	        User users = this.rep.findByEmail(user.getEmail());
	        if (users != null && (users.getPassword().equals(user.getPassword()) )) {
	        	users.setId(null) ;
	        	 return users  ;
	        }
	        else return null ; 
	    }
	  
	  @GetMapping("/getuser/{email}")
	    public User getUser(@PathVariable String email){
	        User user = this.rep.findByEmail(email);
	        if (user != null) {
	        	user.setId(null) ;
	        	return user  ;
	        }
	        else return null ; 
	    }
	  
	  
	  @PostMapping("/update")
	   @ResponseBody
       public User updateUser (
	              @RequestBody User user 
	             ) throws IOException {
	              User u = this.rep.findByEmail(user.getEmail());


	           	            if (u != null) {

	                  
	                        u.setEmail(user.getEmail()!= null ? user.getEmail():u.getEmail() );
	                        u.setAdress(user.getAdress()!= null ? user.getAdress():u.getAdress() );
	                        u.setFullname(user.getFullname()!= null ? user.getFullname():u.getFullname());
	                        u.setPassword(user.getPassword()!= null ? user.getPassword():u.getPassword() );
	                        u.setProfileimage(user.getProfileimage()!= null ? user.getProfileimage():u.getProfileimage());
	                        
	                        this.rep.save(u);

	                        return u;
	                      }

	        else {
	             return null;
	        }

	            }
	  
	  
	  @PostMapping("/updatefavoris")
	   @ResponseBody
	   public User Favoris(@RequestParam(value="figure") String figureId ,@RequestParam(value="email") String email ) {

	       User user = this.rep.findByEmail(email);
	       if(user.getFavoris() == null) {
	    	   user.setFavoris(new ArrayList<String>()) ;
	       }
	    	   
	    	     if (user.getFavoris().indexOf(figureId) > -1 ) { 
               	  user.getFavoris().remove(user.getFavoris().indexOf(figureId)) ; 
	    	     }else {
	    	    	 user.getFavoris().add(figureId) ;  
	                  }
	       user.setFavoris(user.getFavoris());
	       rep.save(user);
	       return user;
	   }

	   @GetMapping("/getfavoris/{email}")
	   @ResponseBody
	   public List<Figure> Favoris(@PathVariable String email ) {

	       User user = this.rep.findByEmail(email);
	       List <String>  fav = new ArrayList<String>();
	       List <Figure>  figures = new ArrayList<Figure>();
	       if( user.getFavoris() != null) {
	                  fav = user.getFavoris();
	                  fav.forEach((id)->{
	                	 figures.add(rep1.findByMyId(id));
	                  });
	       }
	      
	       return figures;
	   }


	} 

	  
	
	  
	

