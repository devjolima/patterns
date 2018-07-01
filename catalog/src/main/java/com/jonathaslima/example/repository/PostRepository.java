package com.jonathaslima.example.repository;

import com.jonathaslima.example.model.Post;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Repository
public interface PostRepository extends ReactiveCouchbaseRepository<Post,String> {

    Mono<Post> findByTittle(String tittle);
}
