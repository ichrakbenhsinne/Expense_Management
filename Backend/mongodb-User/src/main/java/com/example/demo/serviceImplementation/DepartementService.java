package com.example.demo.serviceImplementation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.vo.Depence;
import com.example.demo.entity.Departement;
import com.example.demo.repository.DepartementRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.entity.User;

@Service
public class DepartementService implements com.example.demo.service.DepartementService {
     
	
	@Autowired
	private DepartementRepository dr;
	
	@Autowired
	private UserRepository ur;
	
	@Autowired
	private RestTemplate rt;
	
	
	@Override
	public Departement savedep(Departement departement) {
		// TODO Auto-generated method stub
		return dr.save(departement);
	}

	@Override
	public List<Departement> getalldep() {
		// TODO Auto-generated method stub
		return dr.findAll();
				
	}

	@Override
	public Departement updateDepartement(Long id, Departement departement) {
	    Optional<Departement> depOptional = dr.findById(id);
	    if (depOptional.isPresent()) {
	        Departement depEntity = depOptional.get();
	        if (departement.getDepartementName() != null && !departement.getDepartementName().isEmpty()) {
	            depEntity.setDepartementName(departement.getDepartementName());
	        }
	        if (departement.getDepartementCode() != null) {
	            depEntity.setDepartementCode(departement.getDepartementCode());
	        }
	        return dr.save(depEntity);
	    }
	    return null;
	}





	@Override
	public void deletedepartement(Long id) {
		dr.deleteById(id);
		
	}

	@Override
	public Departement findbyname(String name) {
		
		return dr.finddepbyname(name);
	
	}

	public List<Depence> getdepencesBydepartement(String idtf) {
		 List<Depence> res = new ArrayList<>();
		    Departement departement = dr.finddepbyname(idtf);
		    
		   
		    
		  
		    List<String> depencesNames = departement.getDepences();
		    		
		  
		    if (depencesNames != null) {
		        int nbdeprt = depencesNames.size();

		        
		        for (int i = 0; i < nbdeprt; i++) {
		            Depence depence = rt.getForObject("http://localhost:8050/depences/getbyname/" + depencesNames.get(i), Depence.class);
		            res.add(depence);
		        }
		    }

		    return res;
	}

	@Override
	public double getrecetteDepartement(String name) {
		// TODO Auto-generated method stub
		Departement dprt=dr.finddepbyname(name);
		return dprt.getRecettes();
				
	}

	@Override
	public void AddDepencetoDepartement(String depancename, Departement departement) {
		// TODO Auto-generated method stub
		
		Departement existDepartement = dr.finddepbyname(departement.getDepartementName());
		
		if (existDepartement == null) {
			// le département n'existe pas , donc nous créons un nouvel departement avec la depence
			Departement newdepartement= new Departement();
			newdepartement.setDepartementName(departement.getDepartementName());
			newdepartement.setId(departement.getId());
			newdepartement.setDepartementCode(departement.getDepartementCode());
			newdepartement.setDepartmentAddress(departement.getDepartmentAddress());
			newdepartement.setRecettes(departement.getRecettes());
			
			newdepartement.setDepences(new ArrayList<>());
			newdepartement.getDepences().add(depancename);
			
			dr.save(newdepartement);
		} else 
		{
			// le département existe, nous ajoutons simplement la dépence à la liste
			if(existDepartement.getDepences() ==null)
			{
				existDepartement.setDepences(new ArrayList<>());
			}
			
			existDepartement.getDepences().add(depancename);	
		    dr.save(existDepartement);
		}
		
	}
	@Override
	public void addusertodepartement(Departement departement, String useridtf) {
	    Departement existDepartement = dr.finddepbyname(departement.getDepartementName());

	    if (existDepartement == null) {
	        // Le département n'existe pas, donc nous créons un nouveau département avec la liste des personnes
	        Departement newdepartement = new Departement();
	        newdepartement.setDepartementName(departement.getDepartementName());
	        newdepartement.setId(departement.getId());
	        newdepartement.setDepartementCode(departement.getDepartementCode());
	        newdepartement.setDepartmentAddress(departement.getDepartmentAddress());
	        newdepartement.setRecettes(departement.getRecettes());
            newdepartement.setPersonnes(new ArrayList<>());
            newdepartement.getPersonnes().add(useridtf);
	        
	      /*  List<String> personnes = new ArrayList<>();
	        personnes.add(useridtf);
	        newdepartement.setPersonnes(personnes);
	        
            */
	        dr.save(newdepartement);
	        //ajouter le departement to user
	        User user= ur.finduserbyidentf(useridtf);
	          if(user!=null) {
	        user.getDepatements().add(newdepartement.getDepartementName());
	         ur.save(user);}
	          
	         else {
	        	 // le user n'existe pas
	         }
	         
	          
	    } else {
	        // Le département existe, nous ajoutons simplement l'utilisateur à la liste des personnes
	        List<String> personnes = existDepartement.getPersonnes();
	        if (personnes == null) {
	            personnes = new ArrayList<>();
	            existDepartement.setPersonnes(personnes);
	        }

	        if (!personnes.contains(useridtf)) {
	            personnes.add(useridtf);
	           
	        // ajouter l'utilisateur au département
	            User user=ur.finduserbyidentf(useridtf);
	            if(user!=null) {
	            	 user.getDepatements().add(existDepartement.getDepartementName());
	      	       ur.save(user);
	            } else {
	            	// le département n'existe pas, 
	            }
	        }
            dr.save(existDepartement);
	        
	    }
	}

	@Override
	public List<Depence> getdepensesDepartementDate(String departName, Date date) {
		 List<Depence> res = new ArrayList<>();

		    if (date == null) {
		        return res;
		    }

		    List<Depence> depences = rt.exchange(
		        "http://localhost:8063/user/getdepences/" + departName,
		        HttpMethod.GET,
		        null,
		        new ParameterizedTypeReference<List<Depence>>() {}
		    ).getBody();

		    if (depences == null || depences.isEmpty()) {
		        return res;
		    }

		    for (Depence depence : depences) {
		        if (depence != null && isSameDay(depence.getDate(), date)) {
		            res.add(depence);
		        }
		    }

		    return res;
	  
	
	}
	
	// Méthode pour vérifier si deux dates sont le même jour
		private boolean isSameDay(Date date1, Date date2) {
			 if (date1 == null || date2 == null) {
			        return false;
			    }
			    
			    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			    return format.format(date1).equals(format.format(date2));}

		@Override
		public List<Depence> getdepensesDepartementCategorie(String departName, String catname) {
		    List<Depence> res = new ArrayList<>();

		    List<Depence> depences = rt.exchange(
		        "http://localhost:8063/user/getdepences/" + departName,
		        HttpMethod.GET,
		        null,
		        new ParameterizedTypeReference<List<Depence>>() {}
		    ).getBody();

		    if (depences != null && !depences.isEmpty()) {
		        for (Depence depence : depences) {
		            if (depence != null && depence.getCategorie().equals(catname)) {
		                res.add(depence);
		            }
		        }
		    }

		    return res;
		}


}
