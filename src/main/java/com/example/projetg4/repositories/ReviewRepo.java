package com.example.projetg4.repositories;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.example.projetg4.models.Review;


public interface ReviewRepo  extends MongoRepository<Review,String> {
	
	@Query(value = "{figureid:?0}")
     List<Review> findByFigureId(String figureid);

}

	
	

