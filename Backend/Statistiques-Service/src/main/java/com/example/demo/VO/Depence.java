package com.example.demo.VO;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;



import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public  class Depence {

    public enum TypeDepense {
        MENSUELLE,
        ANNUELLE,
        HEBDOMADAIRE
    }

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
    private Date dateDepense;
    private TypePayement typePayement;
    private TypeDepense typeDepense;
    private String categorie;
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

	private String departementName;

   



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

    public Date getDateDepense() {
        return dateDepense;
    }

    public void setDateDepense(Date dateDepense) {
        this.dateDepense = dateDepense;
    }

    public TypePayement getTypePayement() {
        return typePayement;
    }

    public void setTypePayement(TypePayement typePayement) {
        this.typePayement = typePayement;
    }

    public TypeDepense getTypeDepense() {
        return typeDepense;
    }

    public void setTypeDepense(TypeDepense typeDepense) {
        this.typeDepense = typeDepense;
    }

    public Depence() {
        super();
    }
}
