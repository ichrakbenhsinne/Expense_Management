package com.example.demo.service;

import java.util.Date;
import java.util.List;


import com.example.demo.entity.Departement;
import com.example.demo.vo.Depence;

public interface DepartementService {

    public Departement savedep(Departement departement);
	
	public List<Departement> getalldep();
	
	public Departement updateDepartement(Long id, Departement departement);
	
	public void deletedepartement(Long id);
	 public Departement findbyname(String name);
	public List<Depence> getdepencesBydepartement(String idtf);
	public void AddDepencetoDepartement(String depancename,Departement departement);
	public void  addusertodepartement(Departement departement, String useridtf) ;
	public double getrecetteDepartement(String name);

	public List<Depence> getdepensesDepartementDate(String departName, Date date);

	public List<Depence> getdepensesDepartementCategorie(String departName, String catname);
	
}
