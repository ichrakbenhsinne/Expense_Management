package com.example.demo.serviceImplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Departement;
import com.example.demo.entity.User;
import com.example.demo.repository.DepartementRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.vo.ResponseTemplateVO;
import com.google.gson.Gson;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService{
  
	@Autowired
	private UserRepository ur;
	
	@Autowired
	private DepartementRepository dr;
	
	@Autowired
	private RestTemplate rt;
	
	
	@Override
	public User saveuser(User user) {
		
		return ur.save(user);
	}

	@Override
	public List<User> getusers() {
			return ur.findAll();
	}

	@Override
	public User updateUser(Long id, User user) {
    Optional<User> findById = ur.findById(id);
		if(findById.isPresent())
		{
			User userEntity= findById.get();
			if(user.getName()!= null && !user.getName().isEmpty())
				userEntity.setName(user.getName());
		
			if(user.getAge() != null) 
				userEntity.setAge(user.getAge());
		  ur.save(userEntity);
		 
		} 
		return null;
	}

	@Override
	public void deleteUser(Long id) {
		ur.deleteById(id);
		
	}

	@Override
	public User finduserbyidentf(String idtfiant) {
		// TODO Auto-generated method stub
		return ur.finduserbyidentf(idtfiant);
	}

	@Override
	public ResponseTemplateVO getuserwithdepartement(String idtfiant) {
		// TODO Auto-generated method stub
		ResponseTemplateVO vo =new ResponseTemplateVO();
		User user=ur.finduserbyidentf(idtfiant);
		Departement departement= rt.getForObject("http://localhost:5008/departements/getbyname/"+user.getDepname(), Departement.class);
		vo.setUser(user);
		vo.setDepartement(departement);
		
		return vo;
	}

	@Override
	public List<Departement> getdeprtments(String idtfiant) {
	    List<Departement> res = new ArrayList<>();
	    User user = ur.finduserbyidentf(idtfiant);
	    
	    user.getDepatements().add(user.getDepname());
	    
	  
	    List<String> deprtsnames = user.getDepatements();
	  
	    if (deprtsnames != null) {
	        int nbdeprt = deprtsnames.size();

	        for (int i = 0; i < nbdeprt; i++) {
	            Departement departement = dr.finddepbyname(deprtsnames.get(i));
	            res.add(departement);
	        }
	    }

	    return res;
	}    
	/*
	@Override
	public void AddDeptToUser(String depname, User user) {
	    User existingUser = ur.finduserbyidentf(user.getIdentifiant());

	    if (existingUser == null) {
	        // L'utilisateur n'existe pas, donc nous créons un nouvel utilisateur avec le département
	        User newUser = new User();
	        newUser.setName(user.getName());
	        newUser.setAge(user.getAge());
	        newUser.setIdentifiant(user.getIdentifiant());
	        newUser.setDepatements(new ArrayList<>());
	        newUser.getDepatements().add(depname);

	        ur.save(newUser);
	        
	        //tjib l departement mil ms departement
	        // tajouti l user lil dep
	       //save lil user w depart
	        
	           
	    } else {
	        // L'utilisateur existe, nous ajoutons simplement le département à sa liste
	        if (existingUser.getDepatements() == null) {
	            existingUser.setDepatements(new ArrayList<>()); // Initialisation si la liste est null
	        }
	        existingUser.getDepatements().add(depname);

	        ur.save(existingUser);
	        
	         }
	}
*/
	
	@Override
	public void AddDeptToUser(String depname, User user) {
	    User existingUser = ur.finduserbyidentf(user.getIdentifiant());

	    if (existingUser == null) {
	        // L'utilisateur n'existe pas, donc nous créons un nouvel utilisateur avec le département
	        User newUser = new User();
	        newUser.setName(user.getName());
	        newUser.setAge(user.getAge());
	        newUser.setIdentifiant(user.getIdentifiant());
	        newUser.setDepatements(new ArrayList<>());
	        newUser.getDepatements().add(depname);
	        ur.save(newUser);
	        
	        // Ajouter l'utilisateur au département
	        Departement dep = dr.finddepbyname(depname);
	        if (dep != null) {
	            dep.getPersonnes().add(newUser.getIdentifiant());
	            dr.save(dep);
	        } else {
	            // Le département n'existe pas, vous pouvez gérer cette situation en lançant une exception ou en effectuant une autre action appropriée
	        }
	    } else {
	        // L'utilisateur existe, nous vérifions si le département existe déjà dans la liste
	        List<String> departements = existingUser.getDepatements();
	        if (departements == null) {
	            departements = new ArrayList<>();
	            existingUser.setDepatements(departements);
	        }
	        
	        if (!departements.contains(depname)) {
	            departements.add(depname);
	            
	            // Ajouter l'utilisateur au département
	            Departement dep = dr.finddepbyname(depname);
	            if (dep != null) {
	                dep.getPersonnes().add(existingUser.getIdentifiant());
	                dr.save(dep);
	            } else {
	                // Le département n'existe pas, vous pouvez gérer cette situation en lançant une exception ou en effectuant une autre action appropriée
	            }
	        }
	        
	        ur.save(existingUser);
	    }
	}

	/*private void sendAddUserToDepartementRequest(String depname, String useridtf) {
	    RestTemplate restTemplate = new RestTemplate();

	    // Créer les entêtes de la requête
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);

	    // Créer le corps de la requête
	    Departement departement = new Departement();
	    departement.setDepartementName(depname);
	    String requestBody = new Gson().toJson(departement);

	    // Créer l'entité de la requête
	    HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

	    // Créer l'URL de la requête POST
	    String url = "http://localhost:5008/departements/addUserToDepartement/" + useridtf;

	    // Envoyer la requête POST
	    ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
	}
	
	*/
	
}
