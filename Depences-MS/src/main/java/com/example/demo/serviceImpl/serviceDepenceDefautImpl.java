package com.example.demo.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.DepenceDefaultRepository;
import com.example.demo.Repository.DepenceMultipleDateRepository;
import com.example.demo.Repository.DepenceParDateRepository;
import com.example.demo.Repository.DepencePeriodeRepository;
import com.example.demo.Repository.DepencePersonnalisRepository;
import com.example.demo.Repository.DepenceRepository;
import com.example.demo.entity.DefaultDepence;
import com.example.demo.entity.Depence;
import com.example.demo.entity.DepenceDateMultiple;
import com.example.demo.entity.DepenceParDate;
import com.example.demo.entity.DepencePeriode;
import com.example.demo.entity.DepencePersonnalise;
import com.example.demo.service.serviceDepence;

@Service
public class serviceDepenceDefautImpl implements serviceDepence {

	@Autowired
	private DepenceRepository dr;
   
	@Autowired
	private DepenceDefaultRepository ddr;
	
	@Autowired
	private DepencePersonnalisRepository dpr;
	
	@Autowired
	private DepenceParDateRepository ddater;
	
	@Autowired
	private DepenceMultipleDateRepository dmr;
	
	@Autowired
	private DepencePeriodeRepository dperiodr;
	
	
	//****** Depence ****************
	@Override
	public Depence savedepence(Depence dep) {
		// TODO Auto-generated method stub
		return dr.save(dep);
	}

	@Override
	public List<Depence> getallDepences() {
		// TODO Auto-generated method stub
		return dr.findAll();
				
	}

	@Override
	public Depence updateDepence(Long id, Depence dep) {
	    Optional<Depence> findById = dr.findById(id);
	    if (findById.isPresent()) {
	        Depence depenceEntity = findById.get();
	        // Mettre à jour les propriétés de la dépense
	        depenceEntity.setNomDepense(dep.getNomDepense());
	        depenceEntity.setDescription(dep.getDescription());
	        depenceEntity.setMontant(dep.getMontant());
	    
	        depenceEntity.setTypePayement(dep.getTypePayement());
	        
	        // Enregistrer les modifications
	        return dr.save(depenceEntity);
	    }
	    return null;
	}

	@Override
	public void deleteDepence(Long id) {
		// TODO Auto-generated method stub
		dr.deleteById(id);
	}

	@Override
	public Depence findDepbyidentifiant(String idtfiant) {
		// TODO Auto-generated method stub
		return dr.findDepbyidentf(idtfiant);
	}

	//********Default Dep ************
	
	@Override
	public DefaultDepence saveDefdepence(DefaultDepence defdep) {
		// TODO Auto-generated method stub
		return ddr.save(defdep);
	}

	@Override
	public List<Depence> getallDefDepences() {
	    String type = "default";
	    return ddr.findByTypeDepence(type);
	}

	@Override
	public DefaultDepence updateDefDepence(Long id, DefaultDepence defdepence) {
	    Optional<DefaultDepence> findById = ddr.findById(id);
	    if (findById.isPresent()) {
	        DefaultDepence defDepenceEntity = (DefaultDepence) findById.get();
	        // Mettre à jour les propriétés de la dépense par défaut
	        defDepenceEntity.setNomDepense(defdepence.getNomDepense());
	        defDepenceEntity.setDescription(defdepence.getDescription());
	        defDepenceEntity.setMontant(defdepence.getMontant());

	        defDepenceEntity.setTypePayement(defdepence.getTypePayement());
	       

	        // Enregistrer les modifications
	        return ddr.save(defDepenceEntity);
	    }
	    return null;
	}


	@Override
	public void deleteDefDepence(Long id) {
		// TODO Auto-generated method stub
		ddr.deleteById(id);
	}

	@Override
	public DefaultDepence findDefDepbyidentifiant(String idtfiant) {
		// TODO Auto-generated method stub
		return (DefaultDepence) ddr.findDepbyidentf(idtfiant);
	}

	//***********per dep***************
	@Override
	public DepencePersonnalise savePerdepence(DepencePersonnalise perdep) {
		
		return  dpr.save(perdep);
	}

	@Override
	public List<Depence> getallPerDepences() {
		// TODO Auto-generated method stub
		 String type = "Personnel";
		    return dpr.findByTypeDepence(type);
				
	}
	@Override
	public DepencePersonnalise updatePerDepence(Long id, Depence depence) {
	    Optional<DepencePersonnalise> findById = dpr.findById(id);
	    if (findById.isPresent() && findById.get() instanceof DepencePersonnalise) {
	        DepencePersonnalise perDepenceEntity = (DepencePersonnalise) findById.get();
	        // Mettre à jour les propriétés de la dépense personnalisée
	        perDepenceEntity.setNomDepense(depence.getNomDepense());
	        perDepenceEntity.setDescription(depence.getDescription());
	        perDepenceEntity.setMontant(depence.getMontant());

	        perDepenceEntity.setTypePayement(depence.getTypePayement());
	       
	        // Enregistrer les modifications
	        return dpr.save(perDepenceEntity);
	    }
	    return null;
	}


	@Override
	public void deletePerDepence(Long id) {
		// TODO Auto-generated method stub
		dpr.deleteById(id);
	}

	@Override
	public DepencePersonnalise findPerDepbyidentifiant(String idtfiant) {
		// TODO Auto-generated method stub
		return (DepencePersonnalise) dpr.findDepbyidentf(idtfiant);
	}

	@Override
	public Depence findDepbyname(String name) {
		// TODO Auto-generated method stub
		return dr.finddepbyname(name);
	}

	
	// ******* dep date************
	@Override
	public DepenceParDate saveDefdepenceDate(DepenceParDate depdate) {
		// TODO Auto-generated method stub
		return ddater.save(depdate);
	}

	@Override
	public List<DepenceParDate> getallDepancesDate() {
		// TODO Auto-generated method stub
		String type="Date";
		return ddater.findByTypeDepence(type);
	}

	@Override
	public List<DepenceParDate> getallDepancesDate(Date date) {
	    String type = "Date";
	    List<DepenceParDate> depences = ddater.findByTypeDepence(type);
	    List<DepenceParDate> res = new ArrayList<>();
        if(depences==null || depences.isEmpty())
        {
        	return null;
        }
        
	    for (DepenceParDate depence : depences) {
	        if (depence!= null && isSameDay(depence.getDate(), date)) {
	            res.add(depence);
	        }
	    }

	    return res;
	}

	private boolean isSameDay(Date date1, Date date2) {
	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    return format.format(date1).equals(format.format(date2));
	}


	@Override
	public DepenceParDate updateParDateDepence(Long id, DepenceParDate depdate) {
	    Optional<DepenceParDate> findbyid = ddater.findById(id);
	    if (findbyid.isPresent()) {
	        DepenceParDate depenceEntity = findbyid.get();
	        // mettre à jour l'entité, les propriétés de la depence par date
	        depenceEntity.setDepartementName(depdate.getDepartementName());
	        depenceEntity.setDescription(depdate.getDescription());
	        depenceEntity.setNomDepense(depdate.getNomDepense());
	        depenceEntity.setMontant(depdate.getMontant());
	        depenceEntity.setCategorie(depdate.getCategorie());
	        depenceEntity.setDate(depdate.getDate());
	        depenceEntity.setIdentifiant(depdate.getIdentifiant());

	        return ddater.save(depenceEntity);
	    }
	    
	    return null;
	}

	@Override
	public void deletepaeDateDepence(Long id) {
		// TODO Auto-generated method stub
		ddater.deleteById(id);
		
	}

	@Override
	public DepenceParDate findParDateDepbyidentifiant(String idtfiant) {
		// TODO Auto-generated method stub
		return ddater.findDepbyidentf(idtfiant);
				
	}

	@Override
	public List<DepenceParDate> getallDepancesDates(Date datedeb, Date datefin) {
		 String type = "Date";
		    List<DepenceParDate> depences = ddater.findByTypeDepence(type);
		    List<DepenceParDate> res = new ArrayList<>();
	        if(depences==null || depences.isEmpty())
	        {
	        	return null;
	        }
	        
		    for (DepenceParDate depence : depences) {
		        if (depence!= null && isWithinPeriod(depence.getDate(),datedeb, datefin)) {
		            res.add(depence);
		        }
		    }

		    return res;
	}

	// Méthode pour vérifier si une date est dans la période donnée
		private boolean isWithinPeriod(Date date, Date startDate, Date endDate) {
		    return date.compareTo(startDate) >= 0 && date.compareTo(endDate) <= 0;
		}
		
		
	@Override
	public DepenceDateMultiple saveDefdepenceMultDate(DepenceDateMultiple depdatemult) {
		// TODO Auto-generated method stub
		return dmr.save(depdatemult);
	}

	@Override
	public List<DepenceDateMultiple> getallDepancesmultDate() {
		// TODO Auto-generated method stub
		String type="multiple";
		return dmr.findByTypeDepence(type);
	}
	@Override
	public List<DepenceDateMultiple> getallDepancesDateMultiple(Date date) {
	    String type = "multiple";
	    List<DepenceDateMultiple> depences = dmr.findByTypeDepence(type);
	    List<DepenceDateMultiple> res = new ArrayList<>();

	    if (depences == null || depences.isEmpty()) {
	        return res;
	    }

	    for (DepenceDateMultiple depence : depences) {
	        List<Date> dates = depence.getDates();
	        if (dates != null) {
	            for (Date d : dates) {
	                if (isSameDay(d, date)) {
	                    res.add(depence);
	                    break; // Exit the inner loop once a match is found
	                }
	            }
	        }
	    }

	    return res;
	}


	@Override
	public DepenceDateMultiple updateMultipDateDepence(Long id, DepenceDateMultiple depmultpdate) {
	    Optional<DepenceDateMultiple> findbyid = dmr.findById(id);
	    if (findbyid.isPresent()) {
	        DepenceDateMultiple depenceEntity = findbyid.get();
	        // mettre à jour l'entité, les propriétés de la depence par date
	        depenceEntity.setDepartementName(depmultpdate.getDepartementName());
	        depenceEntity.setDescription(depmultpdate.getDescription());
	        depenceEntity.setNomDepense(depmultpdate.getNomDepense());
	        depenceEntity.setMontant(depmultpdate.getMontant());
	        depenceEntity.setCategorie(depmultpdate.getCategorie());
	        depenceEntity.setDates(depmultpdate.getDates());
	        depenceEntity.setIdentifiant(depmultpdate.getIdentifiant());

	        return dmr.save(depenceEntity);
	    }
	    return null;
	}

	@Override
	public void deleteDateMultipDateDepence(Long id) {
		// TODO Auto-generated method stub
		dmr.deleteById(id);
	}

	@Override
	public DepenceDateMultiple findDepDateMultiplebyidentifiant(String idtfiant) {
		// TODO Auto-generated method stub
		return dmr.findDepbyidentf(idtfiant);
	}

	@Override
	public List<DepenceDateMultiple> getallDepancesDateMultiples(Date datedeb, Date datefin) {
	    String type = "multiple";
	    List<DepenceDateMultiple> depences = dmr.findByTypeDepence(type);
	    List<DepenceDateMultiple> res = new ArrayList<>();

	    if (depences == null || depences.isEmpty()) {
	        return res;
	    }

	    for (DepenceDateMultiple depence : depences) {
	        List<Date> dates = depence.getDates();
	        if (dates != null) {
	            for (Date date : dates) {
	                if (isWithinPeriod(date, datedeb, datefin)) {
	                    res.add(depence);
	                    break; // Exit the inner loop once a match is found
	                }
	            }
	        }
	    }

	    return res;
	}

	
	
	@Override
	public void AdddateToDepence(DepenceDateMultiple dep, Date date) {
		 DepenceDateMultiple existingDepence = dmr.findDepbyidentf(dep.getIdentifiant());
		    if (existingDepence != null) {
		        existingDepence.getDates().add(date);
		        dmr.save(existingDepence);
		    }
	}
	
	@Override
	public void DeletedateDepencemult(DepenceDateMultiple dep, Date date) {
	    DepenceDateMultiple depence = dmr.findDepbyidentf(dep.getIdentifiant());
	    if (depence != null && depence.getDates().contains(date)) {
	        depence.getDates().remove(date);
	        dmr.save(depence);
	    }
	}


	
	
	//******** dep periodique ************
	
	
	
	

	
	
	
	@Override
	public DepencePeriode saveDefdepenceperiodique(DepencePeriode periodicDepence) {
		// TODO Auto-generated method stub
		return dperiodr.save(periodicDepence);
	}

	@Override
	public List<DepencePeriode> getallDepancesPeriodiques() {
		// TODO Auto-generated method stub
		String type="periode";
		return dperiodr.findByTypeDepence(type);
	}

	@Override
	public List<DepencePeriode> getallDepancesperiodiques(Date datedeb, Date datefin) {
	    String type = "periode";
	    List<DepencePeriode> depences = dperiodr.findByTypeDepence(type);
	    List<DepencePeriode> res = new ArrayList<>();

	    if (depences == null || depences.isEmpty()) {
	        return res;
	    }
	    
	    for (DepencePeriode depen : depences) {
	        if (depen != null && isWithinPeriod(depen.getDetedeb(), datedeb, datefin) && isWithinPeriod(depen.getDetefin(), datedeb, datefin)) {
	            res.add(depen);
	        }
	    }

	    return res;
	}

	
	
	@Override
	public List<DepencePeriode> getallDepancesperiodique(Date datedeb) {
		  String type = "periode";
		    List<DepencePeriode> depPeriode = dperiodr.findByTypeDepence(type);
		    List<DepencePeriode> res = new ArrayList<>();

		    for (DepencePeriode depen : depPeriode) {
		        if (depen != null) {
		            if (depen.getDetedeb().compareTo(datedeb) >= 0) {
		                res.add(depen);
		            }
		        }
		    }

		    return res;

	}

	@Override
	public DepencePeriode updateMultipDateDepence(Long id, DepencePeriode depencePeriodique) {
		// TODO Auto-generated method stub
		Optional<DepencePeriode> perdep =dperiodr.findById(id);
		if(perdep.isPresent()) {
			DepencePeriode perioddep= perdep.get();
			// mettre à jour les propriétes de l'objet depence
			perioddep.setNomDepense(depencePeriodique.getNomDepense());
			perioddep.setDescription(depencePeriodique.getDescription());
			perioddep.setCategorie(depencePeriodique.getCategorie());
			perioddep.setDepartementName(depencePeriodique.getDepartementName());
			perioddep.setDetedeb(depencePeriodique.getDetedeb());
			perioddep.setDetefin(perioddep.getDetefin());
			perioddep.setIdentifiant(depencePeriodique.getIdentifiant());
			perioddep.setMontant(depencePeriodique.getMontant());
			
			return dperiodr.save(perioddep);
			
			
		}
		return null;
	}

	@Override
	public void deleteperiodDepence(Long id) {
		// TODO Auto-generated method stub
		dperiodr.deleteById(id);
	}

	@Override
	public DepencePeriode findperiodDepenceByIdtf(String idtfiant) {
		// TODO Auto-generated method stub
		return dperiodr.findDepbyidentf(idtfiant);
	}
	
	
}
