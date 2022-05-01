package com.example.projetg4.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Figure")
public class Figure extends Data {
	
	@Id 
	private String id ;
	
	
	public Figure(String category ,String name, String location, String latitude, String longitude, String description,
			 List<String> gallery) {
		super(category ,name, location, latitude, longitude, description, gallery);
		
	}
	public Figure() {
		super();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	
	

}
