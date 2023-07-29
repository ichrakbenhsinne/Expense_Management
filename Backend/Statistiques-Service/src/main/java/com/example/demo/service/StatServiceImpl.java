package com.example.demo.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.VO.Depence;
import com.fasterxml.jackson.databind.JsonNode;

@Service
public class StatServiceImpl implements StatService {
	
	@Autowired
	private RestTemplate rt;
      
	
	
	@Override
	public Float CalculerStatDepansesDepartjour(String depName, Date date) {
	    List<Depence> depences = rt.exchange(
	        "http://localhost:8063/user/getdepences/" + depName,
	        HttpMethod.GET,
	        null,
	        new ParameterizedTypeReference<List<Depence>>() {}
	    ).getBody();

	    if (depences == null || depences.isEmpty()) {
	        return 0f;
	    }

	    Float res = 0f;
        
	    
	    
	    for (Depence depence : depences) {
	        if (depence != null && isSameDay(depence.getDateDepense(), date)) {
	            res = (float) (res + depence.getMontant());
	        }
	    }

	    return res;
	}

	// Méthode pour vérifier si deux dates sont le même jour
	private boolean isSameDay(Date date1, Date date2) {
	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    return format.format(date1).equals(format.format(date2));
	}

	
	@Override
	public Float CalculerStatDepansesDepartAns( Date date,String depName) {
		// TODO Auto-generated method stub
		List<Depence> depences = rt.exchange(
		        "http://localhost:8063/user/getdepences/" + depName,
		        HttpMethod.GET,
		        null,
		        new ParameterizedTypeReference<List<Depence>>() {}
		    ).getBody();

		    if (depences == null || depences.isEmpty()) {
		        return 0f;
		    }

		    Float res = 0f;

		    for (Depence depence : depences) {
		        if (depence != null && isSameYear(depence.getDateDepense(), date)) {
		            res = (float) (res + depence.getMontant());
		        }
		    }

		    return res;
	}
	private boolean isSameYear(Date date1, Date date2) {
	    Calendar cal1 = Calendar.getInstance();
	    cal1.setTime(date1);
	    int year1 = cal1.get(Calendar.YEAR);

	    Calendar cal2 = Calendar.getInstance();
	    cal2.setTime(date2);
	    int year2 = cal2.get(Calendar.YEAR);

	    return year1 == year2;
	}

	@Override
	public Float CalculerStatDepansesDepartMois(Date date, String depName) {
		// TODO Auto-generated method stub
		 List<Depence> depences = rt.exchange(
			        "http://localhost:8063/user/getdepences/" + depName,
			        HttpMethod.GET,
			        null,
			        new ParameterizedTypeReference<List<Depence>>() {}
			    ).getBody();

			    if (depences == null || depences.isEmpty()) {
			        return 0f;
			    }

			    Float res = 0f;

			    for (Depence depence : depences) {
			        if (depence != null && isSameMonthAndYear(depence.getDateDepense(), date)) {
			            res = (float) (res + depence.getMontant());
			        }
			    }

			    return res;


	      
	}
	private boolean isSameMonthAndYear(Date date1, Date date2) {
	    Calendar cal1 = Calendar.getInstance();
	    cal1.setTime(date1);
	    int month1 = cal1.get(Calendar.MONTH);
	    int year1 = cal1.get(Calendar.YEAR);

	    Calendar cal2 = Calendar.getInstance();
	    cal2.setTime(date2);
	    int month2 = cal2.get(Calendar.MONTH);
	    int year2 = cal2.get(Calendar.YEAR);

	    return month1 == month2 && year1 == year2;
	}

	
	
	
	@Override
	public Float CalculerStatDepansesDepartTotal(String depName) {
	    List<Depence> depences = rt.exchange(
	        "http://localhost:8063/user/getdepences/" + depName,
	        HttpMethod.GET,
	        null,
	        new ParameterizedTypeReference<List<Depence>>() {}
	    ).getBody();

	    if (depences == null || depences.isEmpty()) {
	        return 0f;
	    }

	    Float res = 0f;

	    for (Depence depence : depences) {
	        if (depence != null) {
	            res = (float) (res+depence.getMontant());
	        }
	    }

	    return res;
	}

		
	
     
	
	@Override
	public Float CalculerStatDepansesDepPeriode(Date datedep, Date datefin, String depName) {
	    List<Depence> depences = rt.exchange(
	        "http://localhost:8063/user/getdepences/" + depName,
	        HttpMethod.GET,
	        null,
	        new ParameterizedTypeReference<List<Depence>>() {}
	    ).getBody();

	    if (depences == null || depences.isEmpty()) {
	        return 0f;
	    }

	    Float res = 0f;

	    for (Depence depence : depences) {
	        Date dateDepence = depence.getDateDepense();
	        if (dateDepence != null && isWithinPeriod(dateDepence, datedep, datefin)) {
	            res = (float) (res + depence.getMontant());
	        }
	    }

	    return res;
	}

	// Méthode pour vérifier si une date est dans la période donnée
	private boolean isWithinPeriod(Date date, Date startDate, Date endDate) {
	    return date.compareTo(startDate) >= 0 && date.compareTo(endDate) <= 0;
	}

	
	
	@Override
	public Float CalculerRevenuDeprt(String depName, Date datedep, Date datefin) {
		// TODO Auto-generated method stub
		 List<Depence> depences = rt.exchange(
			        "http://localhost:8063/user/getdepences/" + depName,
			        HttpMethod.GET,
			        null,
			        new ParameterizedTypeReference<List<Depence>>() {}
			    ).getBody();
		 
		 
		    // Step 2: Récupérer la recette du département
		    Float recette = rt.getForObject("http://localhost:8063/user/getdepences/" + depName , Float.class);
		    
		    // Step 3: Faire la soustraction entre la recette et le total des dépenses dans la période spécifiée
		    Float totalDepenses = CalculerStatDepansesDepPeriode(datedep, datefin, depName);
		    Float revenu = recette - totalDepenses;
		    
		    return revenu;
	}

	                    

	@Override
	public Float CalculerRevenueDepartementDate(String depName, Date date) {
		// TODO Auto-generated method stub
		  List<Depence> depences = rt.exchange(
				  "http://localhost:8063/user/getdepences/" + depName,
			        HttpMethod.GET,
			        null,
			        new ParameterizedTypeReference<List<Depence>>() {}
			    ).getBody();
		  
		    // Step 2: Récupérer la recette du département
		    Float recette = rt.getForObject("http://localhost:8063/user/getrecette/" + depName , Float.class);
		    
		    // Step 3: Faire la soustraction entre la recette et le total des dépenses dans la période spécifiée
		    Float totalDepenses = CalculerStatDepansesDepartjour( depName, date);
		    Float revenu = recette - totalDepenses;
		     return revenu;
	}
	
	

	
	
	

	@Override
	public Float CalculerStatDepansesCategorieDate(String catName, Date date) {
	    List<Depence> depences = rt.exchange(
	    		"http://localhost:8063/user/getdepences/" + catName,
	        HttpMethod.GET,
	        null,
	        new ParameterizedTypeReference<List<Depence>>() {}
	    ).getBody();

	    if (depences == null || depences.isEmpty()) {
	        return 0f;
	    }

	    Float res = 0f;

	    for (Depence depence : depences) {
	        if (depence != null && isSameDay(depence.getDateDepense(), date)) {
	            res = (float) (res + depence.getMontant());
	        }
	    }

	    return res;
	}

	// Méthode pour vérifier si deux dates sont le même jour
	


	@Override
	public Float CalculerStatDepansesCategoriejour(String catName, Date date) {
		// TODO Auto-generated method stub
		 List<Depence> depences = rt.exchange("\"http://localhost:8063/user/getdepences/\"" + catName, HttpMethod.GET, null, new ParameterizedTypeReference<List<Depence>>() {}).getBody();
		  Float res= (float) 0; 
		  
		  for(int i=0; i<depences.size();i++)
		  {
			  if(depences.get(i).getDateDepense().equals(date))
			  {
			  res=(float) (res+depences.get(i).getMontant());  
			  }
		  }
		    return res;
	}

       
	@Override
	public Float CalculerStatDepansesCategorieAns(String catName, Date date) {
		  // TODO Auto-generated method stub
		
		
				List<Depence> depences = rt.exchange(
						"http://localhost:8063/user/getdepences/" + catName,
				        HttpMethod.GET,
				        null,
				        new ParameterizedTypeReference<List<Depence>>() {}
				    ).getBody();

				    if (depences == null || depences.isEmpty()) {
				        return 0f;
				    }

				    Float res = 0f;

				    for (Depence depence : depences) {
				        if (depence != null && isSameYear(depence.getDateDepense(), date)) {
				            res = (float) (res + depence.getMontant());
				        }
				    }

				    return res;

	}


	@Override
	public Float CalculerStatDepansesCategorieMois(String catName, Date date) {
		 List<Depence> depences = rt.exchange(
				 "http://localhost:8063/user/getdepences/" + catName,
			        HttpMethod.GET,
			        null,
			        new ParameterizedTypeReference<List<Depence>>() {}
			    ).getBody();

			    if (depences == null || depences.isEmpty()) {
			        return 0f;
			    }

			    Float res = 0f;

			    for (Depence depence : depences) {
			        if (depence != null && isSameMonthAndYear(depence.getDateDepense(), date)) {
			            res = (float) (res + depence.getMontant());
			        }
			    }

			    return res;
	}

	@Override
	public Float CalculerStatDepansesCategoriePeriode(String catName, Date datedep, Date datefin) {
	    List<Depence> depences = rt.exchange(
	    		"http://localhost:8063/user/getdepences/"+ catName,
	        HttpMethod.GET,
	        null,
	        new ParameterizedTypeReference<List<Depence>>() {}
	    ).getBody();

	    if (depences == null || depences.isEmpty()) {
	        return 0f;
	    }

	    Float res = 0f;

	    for (Depence depence : depences) {
	        if (depence != null) {
	            Date dateDepence = depence.getDateDepense();
	            if (dateDepence != null && isWithinPeriod(dateDepence, datedep, datefin)) {
	                res =(float) (res+ depence.getMontant());
	            }
	        }
	    }

	    return res;
	}



	

}
