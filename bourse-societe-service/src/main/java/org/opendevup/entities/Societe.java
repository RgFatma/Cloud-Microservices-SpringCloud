package org.opendevup.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Societe implements Serializable {
	
	@Id @GeneratedValue
	private Long id;
	private String nomSociete;
	
	
	public Societe() {
		super();
	}


	public Societe(Long id, String nomSociete) {
		super();
		this.id = id;
		this.nomSociete = nomSociete;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNomSociete() {
		return nomSociete;
	}


	public void setNomSociete(String nomSociete) {
		this.nomSociete = nomSociete;
	}
	
	
	
	

}
