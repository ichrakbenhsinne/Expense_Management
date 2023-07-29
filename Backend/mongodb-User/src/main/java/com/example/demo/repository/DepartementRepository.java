package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.entity.Departement;

public interface DepartementRepository extends MongoRepository<Departement, Long> {

	@Query("{departementName:'?0'}")
	Departement finddepbyname(String departementName);
	
	@Query("{id:'?0'}")
	Departement findepbyidentf(Long id);

	
}
