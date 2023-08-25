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
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entity.Departement;
import com.example.demo.entity.User;
import com.example.demo.service.DepartementService;
import com.example.demo.service.UserService;
import com.example.demo.vo.Depence;
import com.example.demo.vo.ResponseTemplateVO;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService us;
	

@Autowired
private DepartementService ds;
	
	@PostMapping("/add")
	public User save(@RequestBody User user)
	{
		return us.saveuser(user);
		
	}
	
	
	@GetMapping("allusers")
	
	public List<User>allusers()
	{
		return us.getusers();
					
	}
	
	@PutMapping("/update/{id}")
	public User updateuser(@RequestBody User user, @PathVariable("id") Long id )
	{
		
		return us.updateUser(id, user);
	}
	
	
	@PutMapping("/delete/{id}")
	public String updateuser( @PathVariable("id") Long id )
	{
		
		 us.deleteUser(id);
		 return "deleted sucessefully";
	}
	
@GetMapping("userbyidtfiant/{idf}")
	
	public User userbycin(@PathVariable("idf") String idtf)
	{
		return us.finduserbyidentf(idtf);
					
	}

@GetMapping("/getuserwithdep/{idtf}")
public ResponseTemplateVO getuserwithdepartement(@PathVariable("idtf") String idtf) {
	
	return us.getuserwithdepartement(idtf);
	
}

@GetMapping("/getuserdepartements/{idtf}")
public List<Departement> getuserdepartements(@PathVariable("idtf") String idtf) {
	
	return us.getdeprtments(idtf);
	
}


@GetMapping("/addDepartement/{depname}")
public String AddDeptToUser(@PathVariable("depname") String depname, @RequestBody User user) {
	
	us.AddDeptToUser(depname,user);

	return "added successufully!" ;
}


@PostMapping("/adddep")
public Departement saveDepartement(@RequestBody Departement departement)
{

	return ds.savedep(departement);
}

/*
@GetMapping("/findbyid/{id}")
public Optional<Departement> findDepartementbyId(@PathVariable("id") Long depID) {
    return ds.finddepbyid(depID);
}
*/

@GetMapping("/all")
public List<Departement> alldepartement() {
    return ds.getalldep();
}

@PutMapping("/updatedep/{id}")
public Departement updatdepartement(@RequestBody Departement dep, @PathVariable("id") Long id )
{
	
	return ds.updateDepartement(id, dep);
}


@PutMapping("/deletedep/{id}")
public String  deletedepartement( @PathVariable("id") Long id )
{
	
	 ds.deletedepartement(id);
	 return "deleted sucessefully";
}

@GetMapping("/getbyname/{name}")
public Departement getdepartementbyname(@PathVariable("name") String name) {
    return ds.findbyname(name);
}

@GetMapping("/getdepences/{depname}")
public List<Depence> getalldepences(@PathVariable("depname") String name)
{
	
	
	return ds.getdepencesBydepartement(name);
}




@GetMapping("/addepencetodep/{depancename}")
public String AddDepencetoDepartement(@PathVariable("depancename") String depancename, @RequestBody Departement departement){

  ds.AddDepencetoDepartement(depancename,departement);

return "added successufully!" ;
}


@GetMapping("/getrecette/{name}")
public double getrecetteDepartement(@PathVariable("name") String name)
{
	
	
	return ds.getrecetteDepartement(name);
}

@PostMapping("/addUserToDepartement/{useridtf}")
public String addusertodepartement(@RequestBody Departement departement, @PathVariable("useridtf") String useridtf)
{
	
	ds.addusertodepartement(departement,useridtf);
	
	return "added succesfully!";
}

@GetMapping("/getdepensesDepartDate/{departName}/{date}")

public List<Depence> getdepensesDepartementDate(@PathVariable("departName") String departName, @PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date )
{
	return ds.getdepensesDepartementDate(departName,date);

}



@GetMapping("/getdepensesDepartCategorie/{departName}/{catname}")

public List<Depence> getdepensesDepartementcategorie(@PathVariable("departName") String departName,@PathVariable("catname") String catname)
{
	return ds.getdepensesDepartementCategorie(departName,catname);

}


}
 
