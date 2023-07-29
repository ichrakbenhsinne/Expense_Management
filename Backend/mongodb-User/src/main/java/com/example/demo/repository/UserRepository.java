package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


import com.example.demo.entity.User;

public interface UserRepository extends MongoRepository<User, Long> {
	@Query("{identifiant:'?0'}")
	User finduserbyidentf(String idtfiant);
}
