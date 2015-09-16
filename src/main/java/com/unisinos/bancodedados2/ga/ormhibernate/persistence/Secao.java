package com.unisinos.bancodedados2.ga.ormhibernate.persistence;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Secao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;

	private String nome;

	@OneToMany(mappedBy="secao", cascade=CascadeType.ALL)
	private Set<Categoria> categorias;

	@ManyToOne(cascade=CascadeType.PERSIST)
	private Departamento departamento;

	public Secao() {
		this.categorias = new LinkedHashSet<Categoria>();
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

	public Set<Categoria> getCategorias() {
		return this.categorias;
	}

	public void setCategorias(Set<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Categoria addCategoria(Categoria categoria) {
		getCategorias().add(categoria);
		categoria.setSecao(this);

		return categoria;
	}

	public Categoria removeCategoria(Categoria categoria) {
		getCategorias().remove(categoria);
		categoria.setSecao(null);

		return categoria;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

}