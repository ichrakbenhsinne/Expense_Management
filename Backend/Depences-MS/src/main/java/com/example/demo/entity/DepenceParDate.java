package com.example.demo.entity;

import java.util.Date;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "depences")
@TypeAlias("ParDate")
public class DepenceParDate extends Depence {

	private Date date;
	private String type="Date";

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

	public DepenceParDate() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
