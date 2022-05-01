package com.example.projetg4.models;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Prefrence")
public class Prefrence {
	
	@Id 
	private String id ;
	private String name ; 
	private String image;
	
	
	
	public Prefrence() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Prefrence(String name, String image) {
		super();
		this.name = name;
		this.image = image;
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



	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}



	
	
	
	
	
	
	
	
} 
	