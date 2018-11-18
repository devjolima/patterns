package com.jonathaslima.example.service;

import com.jonathaslima.example.model.Beer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BeerService {

    Mono<Beer> save(Beer Beer);

    Mono<Beer> update(Beer Beer);

    Mono<Beer> findONe(String BeerId);

    Mono<Beer> findByTittle(String tittle);

    public Mono<Boolean> delete(String BeerId);

    Flux<Beer> findAll();
}
