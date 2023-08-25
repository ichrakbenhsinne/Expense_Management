package com.example.demo.controller;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.StatService;

@RestController
@RequestMapping("/statistiques")
public class controller {
	
	@Autowired
	private StatService ss;
	
	@GetMapping("/getstatdepartement/{depname}")
	public Float getstatDepensesDepartement(@PathVariable("depname") String depname)
	{
		return ss.CalculerStatDepansesDepartTotal(depname);
	}
	@GetMapping("/getstatdepartementjours/{depname}/{date}")
	public Float getstatDepensesDepartement(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
	                                        @PathVariable("depname") String depname) {
	    return ss.CalculerStatDepansesDepartjour(depname, date);
	}
	
	@GetMapping("/getstatdepartementAns/{depname}/{date}")
	public Float getstatDepensesDepartementans(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
	                                        @PathVariable("depname") String depname) {
	    return ss.CalculerStatDepansesDepartAns(date, depname);
	}

	@GetMapping("/getstatdepartementmois/{depname}/{date}")
	public Float getstatDepensesDepartementmois(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
	                                        @PathVariable("depname") String depname) {
	    return ss.CalculerStatDepansesDepartMois(date, depname);
	}
	
	
	@GetMapping("/getstatdepartementperiode/{depname}/{datedeb}/{datefin}")
	public Float getstatDepensesDepartementperiode(@PathVariable("datedeb") @DateTimeFormat(pattern = "yyyy-MM-dd") Date datedeb,@PathVariable("datefin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date datefin,
	                                        @PathVariable("depname") String depname) {
	    return ss.CalculerStatDepansesDepPeriode(datedeb, datefin, depname);
	}

	

	@GetMapping("/getRevdepartementperiode/{depname}/{datedeb}/{datefin}")
	public Float getstatRevenueDepartementperiode(@PathVariable("datedeb") @DateTimeFormat(pattern = "yyyy-MM-dd") Date datedeb,@PathVariable("datefin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date datefin,
	                                        @PathVariable("depname") String depname) {
	    return ss.CalculerRevenuDeprt(depname, datedeb, datefin);
	}

	
	@GetMapping("/getRevdepartementdate/{depname}/{date}")
	public Float getstatRevenueDepartementjour(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
	                                        @PathVariable("depname") String depname) {
	    return ss.CalculerRevenueDepartementDate(depname, date);
	}

	
	@GetMapping("/getstetCategoriedate/{catname}/{date}")
	public Float getstatcategoriejour(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
	                                        @PathVariable("catname") String depname) {
	    return ss.CalculerStatDepansesCategorieDate(depname, date);
	}
	
	@GetMapping("/getstetCategorieAns/{catname}/{date}")
	public Float getstatcategorieans(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
	                                        @PathVariable("catname") String catname) {
	    return ss.CalculerStatDepansesCategorieAns(catname, date);
	}


	@GetMapping("/getstetCategoriemois/{catname}/{date}")
	public Float getstatcategoriemois(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
	                                        @PathVariable("catname") String catname) {
	    return ss.CalculerStatDepansesCategorieMois(catname, date);
	}

	@GetMapping("/getstetCategorieperiode/{catname}/{datedeb}/{datefin}")
	public Float getstatcategorieperiode(@PathVariable("datedeb") @DateTimeFormat(pattern = "yyyy-MM-dd") Date datedeb,
			@PathVariable("datefin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date datefin,
	                                        @PathVariable("catname") String catname) {
	    return ss.CalculerStatDepansesCategoriePeriode(catname, datedeb, datefin);
	}
	
}
