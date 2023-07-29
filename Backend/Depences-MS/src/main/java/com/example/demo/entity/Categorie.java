package com.example.demo.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

@Document(collection = "Categorie")
public class Categorie {
	
	@Id
	private Long id;
	private String identifiant;
	private String nomCategorie;
	private String Description;
	private List<String> depences;
	
	
	public List<String> getDepences() {
		return depences;
	}
	public void setDepences(List<String> depences) {
		this.depences = depences;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
	public String getNomCategorie() {
		return nomCategorie;
	}
	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
