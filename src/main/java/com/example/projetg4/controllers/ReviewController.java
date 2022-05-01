package com.example.projetg4.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetg4.models.Review;
import com.example.projetg4.models.User;
import com.example.projetg4.repositories.ReviewRepo;
import com.example.projetg4.repositories.UserRepo;

@CrossOrigin("*")
@RestController
public class ReviewController {

    @Autowired
    ReviewRepo rep ;

    @Autowired
	UserRepo userep ;

    @GetMapping("/showreview/{id}")
    @ResponseBody
       public List<Review> getreview(@PathVariable String id ) {
    	   List<Review> reviews = rep.findByFigureId(id) ;
    	   reviews.forEach((r)->{
    		   System.out.println(r.getuseremail()) ;
    		   User u = userep.findByEmail(r.getuseremail()) ;
    		   r.setUsername(u.getFullname()) ;
    		   r.setUserimage(u.getProfileimage()) ;
    		   
    	   }) ;
           return reviews;
       }
    
   
    
    
    
    @PostMapping("/addreview")
    @ResponseBody
       public Review addreview(@RequestBody Review review  ) {
    		rep.save(review) ;
            return review ;
    	} 
    
    
    
    
}