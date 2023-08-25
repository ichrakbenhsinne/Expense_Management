package com.example.demo.entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;



@Document(collection = "depences")

public  class Depence {

   
    public enum TypePayement {
        chec,
        carte,
        cash
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String identifiant;
    private String nomDepense;
    private String description;
    private Double montant;
    private TypePayement typePayement;
    private String categorie;
    private String departementName;
    
    
    
    
    public String getCategorie() {
		return categorie;
	}



	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}



	public String getDepartementName() {
		return departementName;
	}



	public void setDepartementName(String departementName) {
		this.departementName = departementName;
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

    public String getNomDepense() {
        return nomDepense;
    }

    public void setNomDepense(String nomDepense) {
        this.nomDepense = nomDepense;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

   
    public TypePayement getTypePayement() {
        return typePayement;
    }

    public void setTypePayement(TypePayement typePayement) {
        this.typePayement = typePayement;
    }

   

    public Depence() {
        super();
    }
}
