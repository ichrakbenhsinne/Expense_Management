package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


import com.example.demo.entity.Depence;



public interface DepenceRepository extends MongoRepository<Depence,Long> {
	@Query("{identifiant:'?0'}")
	Depence findDepbyidentf(String idtfiant);
	
	@Query("{nomDepense:'?0'}")
	Depence finddepbyname(String namedep);

}
