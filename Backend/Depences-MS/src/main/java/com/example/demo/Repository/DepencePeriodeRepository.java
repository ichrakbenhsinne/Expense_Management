package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.entity.Depence;
import com.example.demo.entity.DepencePeriode;

public interface DepencePeriodeRepository extends MongoRepository<DepencePeriode, Long> {


	@Query("{identifiant:'?0'}")
	DepencePeriode findDepbyidentf(String idtfiant);
	
	
	@Query("{Type:?0}")
	List<DepencePeriode> findByTypeDepence(String typeperiode);
}




