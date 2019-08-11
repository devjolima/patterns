package com.projeto.demo.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.projeto.demo.entity.Product;

public interface ProductReactiveRepository extends ReactiveMongoRepository<Product, String> {

}
