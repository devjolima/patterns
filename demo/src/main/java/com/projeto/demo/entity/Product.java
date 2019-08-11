package com.projeto.demo.entity;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {

	private String name;
//	private Path file;
	private BigDecimal price;

	public String getName() {
		return this.name;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public String toString() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
