package br.com.jl.entity;

import java.io.Serializable;

public class Owner implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String responsable;
	private String typePersona;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getResponsable() {
		return responsable;
	}
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	public String getTypePersona() {
		return typePersona;
	}
	public void setTypePersona(String typePersona) {
		this.typePersona = typePersona;
	}
	
	

}
