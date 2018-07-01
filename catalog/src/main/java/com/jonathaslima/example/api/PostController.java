package com.jonathaslima.example.api;

import com.jonathaslima.example.model.Post;
import com.jonathaslima.example.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public Mono<ResponseEntity<Post>> save(@RequestBody Post post) {
        return postService.save(post)
                .map(savedHotel -> new ResponseEntity<>(savedHotel, CREATED));
    }

    @GetMapping(path = "/{id}")
    public Mono<Post> get(@PathVariable String id) {
        return postService.findONe(id);
    }

    @GetMapping(path = "/tittle/{tittle}")
    public  Mono<Post> getTittle(@PathVariable String tittle) {
        return postService.findByTittle(tittle);
    }
}
