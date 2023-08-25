package com.example.demo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "depences")
@TypeAlias("MutipleDate")
public class DepenceDateMultiple extends Depence {

	
	private List<Date> dates;
	private String type="multiple";

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Date> getDates() {
		return dates;
	}

	public void setDates(List<Date> dates) {
		this.dates = dates;
	}

	public DepenceDateMultiple() {
		 this.dates = new ArrayList<>();
		
		// TODO Auto-generated constructor stub
	}
	
	
}
