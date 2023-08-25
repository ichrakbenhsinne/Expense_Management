package com.example.demo.vo;

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
    private Date date;
    private TypePayement typePayement;
   
    private String categorie;
    private String type;
    private Date detedeb;
	private Date detefin;
    private List<Date> dates;
    
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

    

    public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



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



	public Depence() {
        super();
    }
}
