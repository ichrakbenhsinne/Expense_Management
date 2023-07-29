package com.example.demo.entity;

import java.util.Date;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "depences")
@TypeAlias("Periodique")
public class DepencePeriode extends Depence {

	private Date detedeb;
	private Date detefin;
	private String type="periode";
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getDetedeb() {
		return detedeb;
	}
	public void setDetedeb(Date detedeb) {
		this.detedeb = detedeb;
	}
	public Date getDetefin() {
		return detefin;
	}
	public void setDetefin(Date detefin) {
		this.detefin = detefin;
	}
	public DepencePeriode() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
