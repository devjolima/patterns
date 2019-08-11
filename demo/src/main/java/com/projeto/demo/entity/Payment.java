package com.projeto.demo.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Payment {

	@Id
	private String numOrdemPagamento;
	private List<Product> products;
	private LocalDateTime date;
	private Customer customer;

	public List<Product> getProducts() {
		return this.products;
	}

	public LocalDateTime getDate() {
		return this.date;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public String toString() {
		return "[Payment: " + date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " " + customer + " " + products
				+ "]";
	}

}
