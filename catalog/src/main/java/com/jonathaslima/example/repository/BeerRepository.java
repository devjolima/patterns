package com.jonathaslima.example.repository;

import com.jonathaslima.example.model.Beer;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Repository
public interface BeerRepository extends ReactiveCouchbaseRepository<Beer,String> {

    Mono<Beer> findByTittle(String tittle);
}
