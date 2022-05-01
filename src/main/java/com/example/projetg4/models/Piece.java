package com.example.projetg4.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Piece")
public class Piece {
	
	@Id 
	private String id ;
	private String name ; 
	private String description ;
	private List<String> gallery;
	
	
	
	public Piece() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Piece(String name, String description, List<String> gallery) {
		super();
		this.name = name;
		this.description = description;
		this.gallery = gallery;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public List<String> getGallery() {
		return gallery;
	}



	public void setGallery(List<String> gallery) {
		this.gallery = gallery;
	}
	
	
	
	
	
	
	
	
} 
	