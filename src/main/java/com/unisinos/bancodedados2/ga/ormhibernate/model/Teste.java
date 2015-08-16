package com.unisinos.bancodedados2.ga.ormhibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Teste implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_Teste")
	@SequenceGenerator(name = "seq_Teste", sequenceName = "s_Teste", allocationSize = 1)
	private Long id;
	@Column(length = 50, nullable = false)
	private String palavra;
	
	public Teste(String palavra) {
		super();
		this.palavra = palavra;
	}
	public Teste(){
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPalavra() {
		return palavra;
	}
	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}
	
}
