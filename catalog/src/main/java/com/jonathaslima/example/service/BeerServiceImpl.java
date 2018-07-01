package com.jonathaslima.example.service;

import com.jonathaslima.example.model.Beer;
import com.jonathaslima.example.repository.BeerRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BeerServiceImpl implements BeerService {

    private final BeerRepository BeerRepository;

    public BeerServiceImpl(BeerRepository BeerRepository) {
        this.BeerRepository = BeerRepository;
    }

    @Override
    public Mono<Beer> save(Beer Beer) {
        return BeerRepository.save(Beer);
    }

    @Override
    public Mono<Beer> update(Beer Beer) {
        return BeerRepository.findById(Beer.getId()).flatMap(
                BeerDB -> BeerRepository.save(Beer)
        );
    }

    @Override
    public Mono<Beer> findONe(String BeerId) {
        return BeerRepository.findById(BeerId);
    }


    @Override
    public Mono<Beer> findByTittle(String tittle) {
        return BeerRepository.findByTittle(tittle);
    }

    @Override
    public Mono<Boolean> delete(String BeerId) {
        return BeerRepository.findById(BeerId)
                .flatMap(
                        Beer -> BeerRepository.delete(Beer).then(Mono.just(Boolean.TRUE))
                )
                .defaultIfEmpty(Boolean.FALSE);
    }

    @Override
    public Flux<Beer> findAll() {
        return BeerRepository.findAll();
    }
}
