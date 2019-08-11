package com.projeto.pagamento.ui;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.demo.entity.Product;
import com.projeto.demo.repository.ProductReactiveRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProductRestController {
	
	@Autowired
	private ProductReactiveRepository repository;
	
	@PostMapping("/create")
	public Mono<ResponseEntity<Product>> create (@RequestBody Product product){
		return repository.save(product).map(ResponseEntity::ok);
	}
	
	@GetMapping("/all")
	public Flux<ResponseEntity<Product>> findAll (){
		
		List<Product> products = repository.findAll().toStream().collect(Collectors.toList());
		products.sort(Comparator.comparing(Product::getName));
		return Flux.fromIterable(products).map(ResponseEntity::ok);
	}

}
