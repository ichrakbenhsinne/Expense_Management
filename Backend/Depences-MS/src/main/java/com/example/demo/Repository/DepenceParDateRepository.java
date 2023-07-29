package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.entity.Depence;
import com.example.demo.entity.DepenceParDate;

public interface DepenceParDateRepository extends MongoRepository<DepenceParDate, Long>{


	@Query("{identifiant:'?0'}")
	DepenceParDate findDepbyidentf(String idtfiant);
	
	
	@Query("{Type:?0}")
	List<DepenceParDate> findByTypeDepence(String typedate);

}
