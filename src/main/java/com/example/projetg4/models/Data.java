package com.example.projetg4.models;

import java.util.List;

public class Data {

	
	protected String category ;
	protected String name ; 
	protected String location ; 
	protected String latitude  ;
	protected String longitude ;
	protected String description ;
	protected List<String> gallery;
	
	
	
	
	
	
	
	
	public Data(String category , String name, String location, String latitude, String longitude, String description, 
			List<String> gallery) {
		super();
		this.category = category ;
		this.name = name;
		this.location = location;
		this.latitude = latitude;
		this.longitude = longitude;
		this.description = description;
		this.gallery = gallery;
	}
	
	
	public Data() {
		super();
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getLatitude() {
		return latitude;
	}


	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}


	public String getLongitude() {
		return longitude;
	}


	public void setLongitude(String longitude) {
		this.longitude = longitude;
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


	public String getCategory() {
		return category;
	}


	public void setCategory(String catergory) {
		this.category = catergory;
	}
	
	
	
	
	
	
}
