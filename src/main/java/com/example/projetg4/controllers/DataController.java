package com.example.projetg4.controllers;




import java.io.IOException;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.bson.types.Binary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.projetg4.models.Image;
import com.example.projetg4.models.Figure;
import com.example.projetg4.repositories.FigureRepo;


@CrossOrigin("*")
@RestController
public class DataController {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private FigureRepo rep;
	
	
	@GetMapping("/getfigures")
    public List<Figure> getAll(){
        List<Figure> monuments = this.rep.findAll();
        return monuments;
    }
	
	@GetMapping("/getfigures/{id}")
    public Optional<Figure> getAMonument(@PathVariable String id){
		
        Optional<Figure> monument = this.rep.findById(id);
        return monument;
    }


	
	
	@PostMapping("/upFigure")
	@ResponseBody
	public String uploadMonument(
			@RequestParam(value = "image") MultipartFile file,
			@RequestParam String category ,
			@RequestParam String name,
			@RequestParam String location ,
			@RequestParam String latitude ,
			@RequestParam String longitude ,
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
	     Figure m = new Figure(category , name,location ,latitude ,longitude ,description,gallery);
	     rep.save(m) ;
	    return savedFile.getId();

} 
	
	
	@GetMapping(value = "/getimage/{id}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
	@ResponseBody
	public byte[] image(@PathVariable String id ,Model model){
	    byte[] data = null;
	    Image file = mongoTemplate.findById(id, Image.class);
	    if(file != null){
	        data = file.getContent().getData();
	    }
	    model.addAttribute("image", 
	      Base64.getEncoder().encodeToString(file.getContent().getData()));
	    return data;
	}
	
	
	
}
