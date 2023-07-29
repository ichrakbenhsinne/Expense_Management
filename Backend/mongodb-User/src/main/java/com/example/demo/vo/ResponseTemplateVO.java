package com.example.demo.vo;

import com.example.demo.entity.Departement;
import com.example.demo.entity.User;


public class ResponseTemplateVO {

	private User user;
	private Departement departement;
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Departement getDepartement() {
		return departement;
	}
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	public ResponseTemplateVO(User user, Departement departement) {
		super();
		this.user = user;
		this.departement = departement;
	}
	public ResponseTemplateVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
