package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entity.Categorie;
import com.example.demo.entity.DefaultDepence;
import com.example.demo.entity.Depence;
import com.example.demo.entity.DepenceDateMultiple;
import com.example.demo.entity.DepenceParDate;
import com.example.demo.entity.DepencePeriode;
import com.example.demo.entity.DepencePersonnalise;
import com.example.demo.service.CategorieService;
import com.example.demo.service.serviceDepence;





@RestController
@RequestMapping("/depences")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")

public class Controller {
	@Autowired      
	private serviceDepence sdd;
	
	@Autowired
	private serviceDepence sd;
	@Autowired
	private CategorieService cs;
	
	@PostMapping("/addDef")
	public Depence saved(@RequestBody DefaultDepence defdep)
	{
		return sd.savedepence(defdep);
		
	}
	
	@PostMapping("/addpersDep")
	public DepencePersonnalise savep(@RequestBody DepencePersonnalise defp)
	{
		return sd.savePerdepence(defp);
		
	}
	
	
	@GetMapping("alldef")
	
	public List<Depence> alldefdep()
	{
		return sd.getallDefDepences();
				
	}
	
@GetMapping("allper")
	
	public List<Depence> allpersdep()
	{
		return sd.getallPerDepences();
				
					
	}
	
	
	@PutMapping("/updated/{id}")
	public DefaultDepence updatedefdep(@RequestBody DefaultDepence defdep, @PathVariable("id") Long id )
	{
		
		return sd.updateDefDepence(id, defdep);
	}
	
	@PutMapping("/updatep/{id}")
	public DepencePersonnalise updateperdep(@RequestBody DepencePersonnalise perdep, @PathVariable("id") Long id )
	{
		
		return sd.updatePerDepence(id, perdep);
	}
	
	
	
	
	@PutMapping("/deletedef/{id}")
	public String deleteDefDep( @PathVariable("id") Long id )
	{
		
		sd.deleteDefDepence(id);
		return "deleted succesfully";
	}
	

	@PutMapping("/deletePer/{id}")
	public String deleteDefPer( @PathVariable("id") Long id )
	{
		
		sd.deletePerDepence(id);
		return "deleted succesfully";
	}
	
	
	
@GetMapping("depdefbyidtfiant/{idf}")
	
	public Depence depbyidetf(@PathVariable("idf") String idtf)
	{
		return sd.findDefDepbyidentifiant(idtf);
					
	}


@GetMapping("getbyname/{name}")

public Depence depdepbyname(@PathVariable("name") String name)
{
	return sd.findDepbyname(name);
				
}

//*************** Categorie ************

@PostMapping("/addCategorie")
public Categorie add(@RequestBody Categorie cat)
{
	
	return cs.saveCategorie(cat);
}


@GetMapping("/allcategories")
public List<Categorie> getall()
{
	return cs.getAllCategories();
			
}

@GetMapping("/getcatbyname/{name}")
public Categorie getCatByidtf(@PathVariable("name") String idtf)
{
	
	return cs.getCatbyidentifiant(idtf);
}

@PutMapping("/delete/{id}")
public String deletecat(@PathVariable("id") Long id)
{
	cs.DeleteCategorie(id);
	return "deleted sucessefully";
	
}

@PutMapping("/update/{id}")
public Categorie update(@RequestBody Categorie cat, @PathVariable("id") Long id)
{
	
return	cs.updateCategorie(id, cat);
}

@GetMapping("adddepToCategorie/{nomdepence}")

public String AddDepenceToCategorie(@PathVariable String nomdepence ,@RequestBody Categorie categorie )

{
	cs.AddDepenceToCategorie(nomdepence, categorie);
	return "added sucessufly";
	
	
}


@GetMapping("/getdepences/{nom}")
public List<Depence> getalldepences(@PathVariable("nom") String nom)
{
	
	
	
	return cs.getdepencesByCategorie(nom);
}


//*********depence date ************
@PostMapping("/adddatedepence")
public DepenceParDate AdddepDate(@RequestBody DepenceParDate depdate)
{
	
return sdd.saveDefdepenceDate(depdate);		

}

@GetMapping("/getAlldepDate")
public List<DepenceParDate> getalldepencesdate()
{
	
 return sdd.getallDepancesDate();	
 
}

@GetMapping("/getalldepdate/{date}")
public List<DepenceParDate> getalldepencesdates(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
    return sdd.getallDepancesDate(date);
}


@PutMapping("/updateDepenceDate/{id}")
public DepenceParDate  updateDepenceDate (@PathVariable("id") Long id,@RequestBody DepenceParDate depdate )
{
	return sdd.updateParDateDepence(id, depdate);

}

@PutMapping("/deletedepenceDate/{id}")
public String deletepaeDateDepence(@PathVariable("id") Long id)
{
  sdd.deletepaeDateDepence(id);	
  return "deleted sucessefully";
}

@GetMapping("/getDepDateByidtf/{idtf}")
public DepenceParDate findParDateDepbyidentifiant(@PathVariable("idtf") String idtf)
{
	return sdd.findParDateDepbyidentifiant(idtf);

}

@GetMapping("/getAllDepDate/{datedeb}/{datefin}")
public List<DepenceParDate> getallDepancesDates(@PathVariable("datedeb")@DateTimeFormat(pattern = "yyyy-MM-dd") Date datedeb,@PathVariable("datefin")@DateTimeFormat(pattern = "yyyy-MM-dd") Date datefin)
{
	return sdd.getallDepancesDates(datedeb, datefin);

}

//***********dep par date multiple **************

@PostMapping("/AddDepMultDate")
public DepenceDateMultiple AddnewdepmultipleDate(@RequestBody DepenceDateMultiple dep)
{
  return sdd.saveDefdepenceMultDate(dep);	
}

@GetMapping("/getAlldepMultiple")
public List<DepenceDateMultiple> getallDepancesmultDate()
{
return sdd.getallDepancesmultDate();
}


@GetMapping("/getAlldepMultip/{date}")
public List<DepenceDateMultiple> getallDepancesDateMultiple(@PathVariable("date")@DateTimeFormat(pattern = "yyyy-MM-dd") Date date)

{
  return sdd.getallDepancesDateMultiple(date);	
}


@PutMapping("updateMultDateDep/{id}")
public DepenceDateMultiple updateMultipDateDepence(@PathVariable("id") Long id,@RequestBody DepenceDateMultiple depmultpdate)
{
	return sdd.updateMultipDateDepence( id, depmultpdate);
}

@PutMapping("deleteMultDep/{id}")
public String deleteDateMultipDateDepence(@PathVariable("id") Long id)
{
	sdd.deleteDateMultipDateDepence(id);
	return "deleted sucessefully";
}

@GetMapping("findDepByMultDate/{idtf}")
public DepenceDateMultiple findDepDateMultiplebyidentifiant(@PathVariable("idtf") String idtf)
{
	return sdd.findDepDateMultiplebyidentifiant(idtf);
			

}

@GetMapping("getAlldepmulti/{datedeb}/{datefin}")
public List<DepenceDateMultiple> getallDepancesDateMultiples(@PathVariable("datedeb")@DateTimeFormat(pattern = "yyyy-MM-dd") Date datedeb,@PathVariable("datefin")@DateTimeFormat(pattern = "yyyy-MM-dd") Date datefin)
{
	return sdd.getallDepancesDateMultiples(datedeb, datefin);
			
}

@GetMapping("/AddDateToMultDep/{date}")
public String AdddateToDepence(@RequestBody DepenceDateMultiple dep,@PathVariable("date")@DateTimeFormat(pattern = "yyyy-MM-dd") Date date)
{
  sdd.AdddateToDepence(dep, date);
  return "Added date to depence sucessefully !";
}

@PutMapping("/deleteDateMultDep/{date}")
public String DeleteDateFromDep(@RequestBody DepenceDateMultiple dep,@PathVariable("date")@DateTimeFormat(pattern = "yyyy-MM-dd") Date date)
{
  sdd.DeletedateDepencemult(dep, date);
  return " date deleted from depence sucessefully !";
}

//***************** period depence *******************

@PostMapping("/AddPeriodDepence")
public DepencePeriode  AddPeriodDepence(@RequestBody DepencePeriode periodicDepence)
{
	return sdd.saveDefdepenceperiodique(periodicDepence); 
}

@GetMapping("/getAllDepPeriod")
public List<DepencePeriode> getallDepancesPeriodiques()
{
 return sdd.getallDepancesPeriodiques();	
}

@GetMapping("/getAlldepperiodDate/{datedeb}/{datefin}")
public List<DepencePeriode> getallDepancesperiodiques(@PathVariable("datedeb")@DateTimeFormat(pattern = "yyyy-MM-dd") Date datedeb,@PathVariable("datefin")@DateTimeFormat(pattern = "yyyy-MM-dd") Date datefin)
{
return sdd.getallDepancesperiodiques(datedeb,datefin);	

}


@GetMapping("/getAllDepPeriod/{date}")
public List<DepencePeriode> getallDepancesperiodique(@PathVariable("datedeb") Date datedeb)
{
  return sdd.getallDepancesperiodique(datedeb);	
}

@PutMapping("/updateDepPeriod/{id}")
public DepencePeriode updateMultipDateDepence(@PathVariable("id") Long id,@RequestBody DepencePeriode depencePeriodique)
{
	
	return sdd.updateMultipDateDepence(id, depencePeriodique);
}

@PutMapping("/deleteDepPeriod/{id}")
public String deleteperiodDepence(@PathVariable("id") Long id)
{
	sdd.deleteperiodDepence(id);
	return "deleted sucessefully";
}


@GetMapping("/getPeriodDepByidtf/{idtf}")
public DepencePeriode findperiodDepenceByIdtf(@PathVariable("idtf") String idtf)
{  return sdd.findperiodDepenceByIdtf(idtf);
	}




}






