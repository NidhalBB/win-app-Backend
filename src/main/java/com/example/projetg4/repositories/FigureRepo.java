package com.example.projetg4.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.projetg4.models.Figure;
import com.example.projetg4.models.User;


@Repository
public interface FigureRepo extends MongoRepository<Figure,String> {
	
	@Query(value = "{id:?0}")
    Figure findByMyId(String id);
	
	
	@Query(value = "{category:?0}")
    List<Figure> findByCategory(String category);

}
