package com.jonathaslima.example.catalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.couchbase.repository.config.EnableReactiveCouchbaseRepositories;


@SpringBootApplication
@ComponentScan("com.jonathaslima.example")
@EnableReactiveCouchbaseRepositories(basePackages = { "com.jonathaslima.example.repository" })
public class CatalogApplication {

	public static void main(String[] args) {

		SpringApplication.run(CatalogApplication.class, args);
	}

}
