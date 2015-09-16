package com.unisinos.bancodedados2.ga.ormhibernate.persistence;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class LojaDepartamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;

	@ManyToOne(cascade=CascadeType.PERSIST)
	private Departamento departamento;

	@ManyToOne(cascade=CascadeType.PERSIST)
	private Loja loja;

	public LojaDepartamento() {
	}
	
	public LojaDepartamento(Departamento departamento){
		this.departamento = departamento;
	}

	public Long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Loja getLoja() {
		return this.loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

}