package com.example.projetg4.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.projetg4.models.User;

@Repository
public interface UserRepo extends MongoRepository<User,String>{

	  @Query(value = "{email:?0}")
	    User findByEmail(String email);
}
