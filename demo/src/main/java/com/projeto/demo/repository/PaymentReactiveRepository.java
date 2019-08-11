package com.projeto.demo.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.projeto.demo.entity.Payment;

@Repository
public interface PaymentReactiveRepository extends ReactiveMongoRepository<Payment, String> {

}
