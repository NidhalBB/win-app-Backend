package com.example.projetg4.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.projetg4.models.Piece;

@Repository
public interface PieceRepo extends MongoRepository<Piece,String> {

}
