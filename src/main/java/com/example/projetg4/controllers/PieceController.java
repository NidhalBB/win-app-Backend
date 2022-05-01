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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.projetg4.models.Image;
import com.example.projetg4.models.Piece;

import com.example.projetg4.repositories.PieceRepo;




@CrossOrigin("*")
@RestController
public class PieceController {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private PieceRepo rep;
	
	//to be removed (just for testing)
	@GetMapping("/getpieces")
    public List<Piece> getAll(){
        List<Piece> pieces = this.rep.findAll();
        return pieces;
    }
	
	
	@GetMapping("/getpiece/{id}")
    public Optional<Piece> getOne(@PathVariable String id){
		
        Optional<Piece> piece = this.rep.findById(id);
        return piece;
    }


	
	@PostMapping("/upPiece")
	@ResponseBody
	public String uploadMonument(
			@RequestParam(value = "image") MultipartFile file,
			@RequestParam String name,
			@RequestParam String description
			) throws IOException{
	   

	    
	    	String fileName = file.getOriginalFilename();

	        Image uploadFile = new Image();
	        uploadFile.setName(fileName);
	        uploadFile.setContent(new Binary(file.getBytes()));
	        uploadFile.setContenttype(file.getContentType());
	        uploadFile.setSize(file.getSize());

	        Image savedFile = mongoTemplate.save(uploadFile);
  
	        List<String> gallery = new ArrayList<String>();
	        gallery.add(savedFile.getId()) ;
	        Piece m = new Piece(name,description,gallery);
	        rep.save(m) ;
	    return savedFile.getId();

} 
	
	
	
	
	
}
