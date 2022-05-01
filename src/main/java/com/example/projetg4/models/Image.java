package com.example.projetg4.models;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Image {

    @Id
    private String id;
    private String name; // file name
    private Binary content; // file content
    private String contenttype; // file type
    private long size; // file size
    
    
    
    
    
    
    
    
    // getter/setter
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
	public Binary getContent() {
		return content;
	}
	public void setContent(Binary content) {
		this.content = content;
	}
	public String getContenttype() {
		return contenttype;
	}
	public void setContenttype(String contenttype) {
		this.contenttype = contenttype;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
 
   
    
    
}