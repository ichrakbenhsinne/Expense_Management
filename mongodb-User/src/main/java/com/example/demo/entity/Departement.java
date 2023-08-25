package com.example.demo.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Departements")
public class Departement {

    @Id
    private Long id;

    private String identifiant;
    private String departementName;
    private String departmentAddress;
    private String departementCode;
    private double recettes;
    private List<String> personnes;
    private List<String> depences;

    // Getters and setters

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartementName() {
        return departementName;
    }

    public void setDepartementName(String departementName) {
        this.departementName = departementName;
    }

    public String getDepartmentAddress() {
        return departmentAddress;
    }

    public void setDepartmentAddress(String departmentAddress) {
        this.departmentAddress = departmentAddress;
    }

    public String getDepartementCode() {
        return departementCode;
    }

    public void setDepartementCode(String departementCode) {
        this.departementCode = departementCode;
    }

    public double getRecettes() {
        return recettes;
    }

    public void setRecettes(double recettes) {
        this.recettes = recettes;
    }

    public List<String> getPersonnes() {
        return personnes;
    }

    public void setPersonnes(List<String> personnes) {
        this.personnes = personnes;
    }

    public List<String> getDepences() {
        return depences;
    }

    public void setDepences(List<String> depences) {
        this.depences = depences;
    }

    // Constructors

    public Departement(Long id, String departementName, String departmentAddress, String departementCode) {
        this.id = id;
        this.departementName = departementName;
        this.departmentAddress = departmentAddress;
        this.departementCode = departementCode;
    }

    public Departement() {
    }
}
