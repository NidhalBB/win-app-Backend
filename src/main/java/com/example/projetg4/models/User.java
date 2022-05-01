package com.example.projetg4.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "User")
public class User {
	@Id 
	private String id ;
	private String email ; 
	private String password ; 
	private String fullname ;
	private String gender ;
	private String adress;
	private String profileimage ;
	private List<String> favoris ;
	private List<String> prefrences;
	
	


	
	

	public User( String email, String password, String fullname, String gender , String Adress /*, String profileimage */) {
		super();
		this.email = email;
		this.password = password;
		this.fullname = fullname;
		this.gender = gender;
		this.adress = Adress ;
	   this.favoris = new ArrayList<String>() ;
	}
	public User() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getProfileimage() {
		return profileimage;
	}
	public void setProfileimage(String profileimage) {
		this.profileimage = profileimage;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	public List<String> getPrefrences() {
		return prefrences;
	}
	public void setPrefrences(List<String> prefrences) {
	
		this.prefrences =prefrences   ; 
	}
	public List<String> getFavoris() {
		return favoris;
	}
	public void setFavoris(List<String> favoris) {
		this.favoris = favoris;
	}


	
	
	
	
	
	
	
	
	
	
	
	

}
