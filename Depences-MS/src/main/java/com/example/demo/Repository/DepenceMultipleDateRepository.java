package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.entity.Depence;
import com.example.demo.entity.DepenceDateMultiple;

public interface DepenceMultipleDateRepository extends MongoRepository<DepenceDateMultiple, Long> {


	@Query("{identifiant:'?0'}")
	DepenceDateMultiple findDepbyidentf(String idtfiant);
	
	
	@Query("{Type:?0}")
	List<DepenceDateMultiple> findByTypeDepence(String typemultiple);

}
