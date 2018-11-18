package com.jonathaslima.example.api;

import com.jonathaslima.example.model.Beer;
import com.jonathaslima.example.service.BeerService;
import com.jonathaslima.example.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/Beers")
public class BeerController {

    @Autowired
    private BeerService BeerService;

    @PostMapping
    public Mono<ResponseEntity<Beer>> save(@RequestBody Beer Beer) {
        return BeerService.save(Beer)
                .map(savedBeer -> new ResponseEntity<>(savedBeer, CREATED));
    }

    @GetMapping(path = "/{id}")
    public Mono<Beer> get(@PathVariable String id) {
        return BeerService.findONe(id);
    }

    @GetMapping(path = "/tittle/{tittle}")
    public  Mono<Beer> getTittle(@PathVariable String tittle) {
        return BeerService.findByTittle(tittle);
    }
}
