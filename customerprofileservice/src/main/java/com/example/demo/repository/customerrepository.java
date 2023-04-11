package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.customer.customer;

@Repository
public interface customerrepository extends MongoRepository<customer, String> {

	Optional<customer> findByName(String fileName);

}
