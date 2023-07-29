package com.example.demo.entity;

import java.util.Date;

public class DepencePeriodique extends Depence {
	
	private Date datedeb;
	private int nbreJours;
	public Date getDatedeb() {
		return datedeb;
	}
	public void setDatedeb(Date datedeb) {
		this.datedeb = datedeb;
	}
	public int getNbreJours() {
		return nbreJours;
	}
	public void setNbreJours(int nbreJours) {
		this.nbreJours = nbreJours;
	}
	public DepencePeriodique() {
		super();
		// TODO Auto-generated constructor stub
	} 

}
