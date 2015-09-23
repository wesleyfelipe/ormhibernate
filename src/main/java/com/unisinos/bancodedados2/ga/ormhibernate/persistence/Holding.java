package com.unisinos.bancodedados2.ga.ormhibernate.persistence;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Holding implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;

	@Column(nullable=false)
	private String nome;

	@OneToMany(mappedBy="holding", cascade=CascadeType.ALL)
	private Set<Empresa> empresas;

	public Holding() {
		this.empresas = new LinkedHashSet<Empresa>();
	}

	public Long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Empresa> getEmpresas() {
		return this.empresas;
	}

	public void setEmpresas(Set<Empresa> empresas) {
		this.empresas = empresas;
	}

	public Empresa addEmpresa(Empresa empresa) {
		getEmpresas().add(empresa);
		empresa.setHolding(this);

		return empresa;
	}

	public Empresa removeEmpresa(Empresa empresa) {
		getEmpresas().remove(empresa);
		empresa.setHolding(null);

		return empresa;
	}

}