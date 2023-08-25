package com.example.demo.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Repository.CategorieRepository;
import com.example.demo.Repository.DepenceRepository;
import com.example.demo.entity.Categorie;
import com.example.demo.entity.Depence;
import com.example.demo.service.CategorieService;


@Service
public class CategorieServiceImpl implements CategorieService {
    
	@Autowired
	private CategorieRepository cr;
	
	@Autowired
	private DepenceRepository dr;
	
	@Autowired
	private RestTemplate rt;
	
	@Override
	public Categorie saveCategorie(Categorie cat) {
		// TODO Auto-generated method stub
		return cr.save(cat);
	}

	@Override
	public List<Categorie> getAllCategories() {
		// TODO Auto-generated method stub
		return cr.findAll();
				
	}

	@Override
	public Categorie getCatbyidentifiant(String idtf) {
		// TODO Auto-generated method stub
		return cr.findCatbyidentf(idtf);
	}

	@Override
	public void DeleteCategorie(Long id) {
		// TODO Auto-generated method stub
		cr.deleteById(id);
	}

	@Override
	public Categorie updateCategorie(Long id, Categorie cat) {
	    Optional<Categorie> optionalCategorie = cr.findById(id);
	    if (optionalCategorie.isPresent()) {
	        Categorie existingCategorie = optionalCategorie.get();
	        
	        // Update the identifiant if it is not null or empty
	        if (cat.getIdentifiant() != null && !cat.getIdentifiant().isEmpty()) {
	            existingCategorie.setIdentifiant(cat.getIdentifiant());
	        }

	        // Update the nomCategorie if it is not null or empty
	        if (cat.getNomCategorie() != null && !cat.getNomCategorie().isEmpty()) {
	            existingCategorie.setNomCategorie(cat.getNomCategorie());
	        }

	        // Update the description if it is not null or empty
	        if (cat.getDescription() != null && !cat.getDescription().isEmpty()) {
	            existingCategorie.setDescription(cat.getDescription());
	        }

	        // Save the updated category entity
	        Categorie updatedCategorie = cr.save(existingCategorie);
	        updatedCategorie.setDescription(existingCategorie.getDescription());
	        return updatedCategorie;
	    } else {
	      System.out.println("objet dosent exist!!");
	        return null;
	    }
	}
	
	@Override
	public List<Depence> getdepencesByCategorie(String idtfiant) {
	    List<Depence> res = new ArrayList<>();
	    Categorie categorie = cr.findCatbyidentf(idtfiant);
	    
	   
	    
	  
	    List<String> depencesNames = categorie.getDepences();
	    		
	  
	    if (depencesNames != null) {
	        int nbdeprt = depencesNames.size();

	        for (int i = 0; i < nbdeprt; i++) {
	            Depence depence = dr.finddepbyname(depencesNames.get(i));
	            res.add(depence);
	        }
	    }

	    return res;
	}

	@Override
	public void AddDepenceToCategorie(String nomdepence, Categorie categorie) {
	    Categorie existingCategorie = cr.findCatbyidentf(categorie.getNomCategorie());

	    if (existingCategorie == null) {
	        // La catégorie n'existe pas, donc nous créons une nouvelle catégorie avec la dépendance
	        Categorie newCateg = new Categorie();
	        newCateg.setNomCategorie(categorie.getNomCategorie());
	        newCateg.setDescription(categorie.getDescription());
	        newCateg.setIdentifiant(categorie.getIdentifiant());
	        newCateg.setId(categorie.getId());
	        newCateg.setDepences(new ArrayList<>());
	        newCateg.getDepences().add(nomdepence);

	        cr.save(newCateg);

	    } else {
	        // La catégorie existe, nous ajoutons simplement la dépendance à sa liste des dépendances dans la catégorie
	      if(existingCategorie.getDepences()==null)
	      {
	    	  existingCategorie.setDepences(new ArrayList<>());
	    	  
	      }
	      existingCategorie.getDepences().add(nomdepence);
	     cr.save(existingCategorie);
	    }
	}

		
	}



