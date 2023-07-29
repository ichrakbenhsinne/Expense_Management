package com.example.demo.entity;

import java.util.Date;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.DiscriminatorValue;

@Document(collection = "depences")
@TypeAlias("Personnel")
public class DepencePersonnalise extends Depence {
          
	private String type="Personnel";
	private Date date;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public DepencePersonnalise() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
