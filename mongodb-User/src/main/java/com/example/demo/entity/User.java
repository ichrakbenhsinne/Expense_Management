package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

@Document(collection = "Users")
public class User {

	@Id
	private Long id;
	private String name;
	private Integer age;
	private String identifiant;
	private String depname;
	private List<String> depatements;
	
	
	public List<String> getDepatements() {
		return depatements;
	}
	public void setDepatements(List<String> depatements) {
		this.depatements = depatements;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
	public String getDepname() {
		return depname;
	}
	public void setDepname(String depname) {
		this.depname = depname;
	}
	public User() {
		super();
		  this.depatements = new ArrayList<>();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
