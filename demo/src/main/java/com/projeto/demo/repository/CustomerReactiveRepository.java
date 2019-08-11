package com.projeto.demo.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.projeto.demo.entity.Customer;

@Repository
public interface CustomerReactiveRepository extends ReactiveMongoRepository<Customer, String>{

}
