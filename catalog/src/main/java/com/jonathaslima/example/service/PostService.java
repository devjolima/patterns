package com.jonathaslima.example.service;

import com.jonathaslima.example.model.Post;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PostService {

    Mono<Post> save(Post post);

    Mono<Post> update(Post post);

    Mono<Post> findONe(String postId);

    Mono<Post> findByTittle(String tittle);

    public Mono<Boolean> delete(String postId);

    Flux<Post> findAll();
}
