package com.example.demo.service;

import java.util.Date;
import java.util.List;

import com.example.demo.entity.DefaultDepence;
import com.example.demo.entity.Depence;
import com.example.demo.entity.DepenceDateMultiple;
import com.example.demo.entity.DepenceParDate;
import com.example.demo.entity.DepencePeriode;
import com.example.demo.entity.DepencePersonnalise;



public interface serviceDepence{
	
    public Depence savedepence(Depence defdep);
	public List<Depence> getallDepences();
	public Depence updateDepence(Long id,Depence defdepence);
	public void deleteDepence(Long id);
	public Depence findDepbyidentifiant(String idtfiant);
	public Depence findDepbyname(String name);
	

    public DefaultDepence saveDefdepence(DefaultDepence defdep);
	public List<Depence> getallDefDepences();
	public DefaultDepence updateDefDepence(Long id,DefaultDepence defdepence);
	public void deleteDefDepence(Long id);
	public DefaultDepence findDefDepbyidentifiant(String idtfiant);
	


    public DepencePersonnalise savePerdepence(DepencePersonnalise defdep);
	public List<Depence> getallPerDepences();
	public DepencePersonnalise updatePerDepence(Long id,Depence defdepence);
	public void deletePerDepence(Long id);
	public DepencePersonnalise findPerDepbyidentifiant(String idtfiant);
	
// depenses par date 
    public DepenceParDate saveDefdepenceDate(DepenceParDate depdate);
    List<DepenceParDate> getallDepancesDate();
	public List<DepenceParDate> getallDepancesDate(Date date);
	public DepenceParDate updateParDateDepence(Long id,DepenceParDate depdate);
	public void deletepaeDateDepence(Long id);
	public DepenceParDate findParDateDepbyidentifiant(String idtfiant);
	public List<DepenceParDate> getallDepancesDates(Date datedeb, Date datefin);
	
	
	// depenses par date multiple 
	    public DepenceDateMultiple saveDefdepenceMultDate(DepenceDateMultiple depdatemult);
		public List<DepenceDateMultiple> getallDepancesmultDate();
		public List<DepenceDateMultiple> getallDepancesDateMultiple(Date date);
		public DepenceDateMultiple updateMultipDateDepence(Long id,DepenceDateMultiple depmultpdate);
		public void deleteDateMultipDateDepence(Long id);
		public DepenceDateMultiple findDepDateMultiplebyidentifiant(String idtfiant);
		public List<DepenceDateMultiple> getallDepancesDateMultiples(Date datedeb, Date datefin);
		public void AdddateToDepence(DepenceDateMultiple dep, Date date);
		public void DeletedateDepencemult(DepenceDateMultiple dep, Date date) ;
		
		// depenses periodique 
	    public DepencePeriode saveDefdepenceperiodique(DepencePeriode periodicDepence);
		public List<DepencePeriode> getallDepancesPeriodiques();
		public List<DepencePeriode> getallDepancesperiodiques(Date datedeb, Date datefin);
		public List<DepencePeriode> getallDepancesperiodique(Date datedeb);
		
		
		public DepencePeriode updateMultipDateDepence(Long id,DepencePeriode depencePeriodique);
		public void deleteperiodDepence(Long id);
		public DepencePeriode findperiodDepenceByIdtf(String idtfiant);
		
	

}
