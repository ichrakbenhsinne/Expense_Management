package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.entity.DefaultDepence;
import com.example.demo.entity.Depence;
import com.example.demo.entity.DepencePersonnalise;


public interface DepenceDefaultRepository extends  MongoRepository <DefaultDepence,Long>{

	@Query("{identifiant:'?0'}")
	Depence findDepbyidentf(String idtfiant);
	
	
	@Query("{Type:?0}")
	List<Depence> findByTypeDepence(String typeDefault);

}
