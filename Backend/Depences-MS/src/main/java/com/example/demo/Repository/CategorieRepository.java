package com.example.demo.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.entity.Categorie;

public interface CategorieRepository extends MongoRepository<Categorie, Long> {
	@Query("{nomCategorie:'?0'}")
	Categorie findCatbyidentf(String nomCategorie);

	
}

