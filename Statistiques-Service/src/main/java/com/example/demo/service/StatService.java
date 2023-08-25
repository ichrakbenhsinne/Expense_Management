package com.example.demo.service;

import java.util.Date;

import com.fasterxml.jackson.databind.JsonNode;

public interface StatService {
	
	Float  CalculerStatDepansesDepartjour(String depName,Date date);
	Float CalculerStatDepansesDepartAns(Date Date,String depName) ;
	Float  CalculerStatDepansesDepartMois(Date date, String depName);

	Float  CalculerStatDepansesDepartTotal(String depName);
	Float  CalculerStatDepansesDepPeriode(Date datedep,Date datefin,String depName);

 
	Float  CalculerStatDepansesCategorieDate(String catName, Date date);
	Float  CalculerStatDepansesCategoriejour(String catName, Date date);
	Float  CalculerStatDepansesCategorieAns(String catName, Date date);
	Float  CalculerStatDepansesCategorieMois(String catName, Date date);
	Float  CalculerStatDepansesCategoriePeriode(String catName, Date datedep, Date datefin);
	
	
	
    Float  CalculerRevenuDeprt(String depName, Date datedep, Date datefin);
	
	Float  CalculerRevenueDepartementDate(String depName, Date date);
	



	
	
	
}
