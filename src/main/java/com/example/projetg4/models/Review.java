package com.example.projetg4.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Review")
public class Review {
	@Id
    private String id ;
	
    private String figureid ;
    private String useremail ;
    private String username ;
    private String userimage ;
    private int rating;
    private String comment;
 


    public Review() {
        super();
    }


	public Review(String figureid, String useremail, int rating, String comment) {
		super();
		this.figureid = figureid;
		this.useremail = useremail;
		this.rating = rating;
		this.comment = comment;
	}



	public Review(String id, String figureid, String useremail, String username, String userimage, int rating,
			String comment) {
		super();
		this.id = id;
		this.figureid = figureid;
		this.useremail = useremail;
		this.username = username;
		this.userimage = userimage;
		this.rating = rating;
		this.comment = comment;
	}


	public String getFigureid() {
		return figureid;
	}



	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getUserimage() {
		return userimage;
	}


	public void setUserimage(String userimage) {
		this.userimage = userimage;
	}


	public void setFigureid(String figureid) {
		this.figureid = figureid;
	}





	public int getRating() {
		return rating;
	}



	public void setRating(int rating) {
		this.rating = rating;
	}





	public String getComment() {
		return comment;
	}



	public void setComment(String comment) {
		this.comment = comment;
	}




	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getuseremail() {
		// TODO Auto-generated method stub
		return this.useremail;
	}




}