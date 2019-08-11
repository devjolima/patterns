package com.projeto.pagamento.ui;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.demo.entity.Customer;
import com.projeto.demo.repository.CustomerReactiveRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customer")
public class CustomerRestController {

	@Autowired
	private CustomerReactiveRepository repository;
	
	@GetMapping("/all")
	public Flux<ResponseEntity<Customer> > getAll(){
		List<Customer> customers = repository.findAll().toStream().collect(Collectors.toList()); // exemplo para transformar em lista o retorno
		return repository.findAll().map(ResponseEntity::ok);
	}
	
	@GetMapping("/get/{id}")
	public Mono<ResponseEntity<Customer> > getCustomer(@PathVariable("id") String id){
		return repository.findById(id).map(ResponseEntity::ok);
	}
	
	@PostMapping("/post")
	public Mono<ResponseEntity<Customer> > create(@RequestBody Customer customer){
		return repository.save(customer).map(ResponseEntity::ok);
	}
	
}
