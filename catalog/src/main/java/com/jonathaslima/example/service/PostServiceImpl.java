package com.jonathaslima.example.service;

import com.jonathaslima.example.model.Post;
import com.jonathaslima.example.repository.PostRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Mono<Post> save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Mono<Post> update(Post post) {
        return postRepository.findById(post.getId()).flatMap(
                postDB -> postRepository.save(post)
        );
    }

    @Override
    public Mono<Post> findONe(String postId) {
        return postRepository.findById(postId);
    }


    @Override
    public Mono<Post> findByTittle(String tittle) {
        return postRepository.findByTittle(tittle);
    }

    @Override
    public Mono<Boolean> delete(String postId) {
        return postRepository.findById(postId)
                .flatMap(
                        post -> postRepository.delete(post).then(Mono.just(Boolean.TRUE))
                )
                .defaultIfEmpty(Boolean.FALSE);
    }

    @Override
    public Flux<Post> findAll() {
        return postRepository.findAll();
    }
}
