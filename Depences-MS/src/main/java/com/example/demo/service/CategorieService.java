package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Categorie;
import com.example.demo.entity.Depence;


public interface CategorieService {

	
	public Categorie saveCategorie(Categorie cat);
	public List<Categorie> getAllCategories();
	public Categorie  getCatbyidentifiant(String idtf);
	public void DeleteCategorie(Long id);
	public Categorie updateCategorie(Long id, Categorie cat);
	public  List<Depence> getdepencesByCategorie(String idtfiant);
	public void AddDepenceToCategorie(String nomdepence, Categorie categorie);
	
	
}

