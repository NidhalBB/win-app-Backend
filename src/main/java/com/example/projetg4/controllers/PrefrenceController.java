package com.example.projetg4.controllers;



import java.io.IOException;
import java.util.List;

import org.bson.types.Binary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.projetg4.models.Image;
import com.example.projetg4.models.Prefrence;
import com.example.projetg4.models.User;
import com.example.projetg4.repositories.PrefrenceRepo;
import com.example.projetg4.repositories.UserRepo;


@CrossOrigin("*")
@RestController
public class PrefrenceController {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private PrefrenceRepo rep;
	
	@Autowired
	private UserRepo repU;
	
	@GetMapping("/getprefrences")
    public List<Prefrence> getAll(){
        List<Prefrence> pieces = this.rep.findAll();
        return pieces;
    }
	
	
	
	
	 @PostMapping("/setprefrences/")
	    public User setPrefrences(@RequestParam("email") String email ,@RequestParam("prefrences") List<String> prefrences ){
		  try { 
	          User u = repU.findByEmail(email) ;
	          u.setPrefrences(prefrences) ;
			  this.repU.save(u);
	          u.setId(null);
	          return u ; }
		  catch(Exception E){
			  return null ;
		  }
	    }
	
	
	
	
	@PostMapping("/upPrefrence")
	@ResponseBody
	public String uploadPrefrence(
			@RequestParam(value = "image") MultipartFile file,
			@RequestParam String name
			) throws IOException{
	   

	    
	        String fileName = file.getOriginalFilename();
	        Image uploadFile = new Image();
	        uploadFile.setName(fileName);
	        uploadFile.setContent(new Binary(file.getBytes()));
	        uploadFile.setContenttype(file.getContentType());
	        uploadFile.setSize(file.getSize());

	        Image savedFile = mongoTemplate.save(uploadFile);
  
	      Prefrence m = new Prefrence(name,savedFile.getId());
	      rep.save(m) ;
	    return savedFile.getId();

}  
	
	
	
	
	
	
	
	
	
	
	
	
	
}
