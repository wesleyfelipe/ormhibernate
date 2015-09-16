package com.unisinos.bancodedados2.ga.ormhibernate.persistence;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;

	private String nome;

	@OneToMany(mappedBy="departamento", cascade=CascadeType.ALL)
	private Set<LojaDepartamento> lojaDepartamentos;

	@OneToMany(mappedBy="departamento", cascade=CascadeType.ALL)
	private Set<Secao> secoes;

	public Departamento() {
		this.secoes = new LinkedHashSet<Secao>();
		this.lojaDepartamentos = new LinkedHashSet<LojaDepartamento>();
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

	public Set<LojaDepartamento> getLojaDepartamentos() {
		return this.lojaDepartamentos;
	}

	public void setLojaDepartamentos(Set<LojaDepartamento> lojaDepartamentos) {
		this.lojaDepartamentos = lojaDepartamentos;
	}

	public LojaDepartamento addLojaDepartamento(LojaDepartamento lojaDepartamento) {
		getLojaDepartamentos().add(lojaDepartamento);
		lojaDepartamento.setDepartamento(this);

		return lojaDepartamento;
	}

	public LojaDepartamento removeLojaDepartamento(LojaDepartamento lojaDepartamento) {
		getLojaDepartamentos().remove(lojaDepartamento);
		lojaDepartamento.setDepartamento(null);

		return lojaDepartamento;
	}

	public Set<Secao> getSecoes() {
		return this.secoes;
	}

	public void setSecoes(Set<Secao> secoes) {
		this.secoes = secoes;
	}

	public Secao addSecao(Secao secao) {
		getSecoes().add(secao);
		secao.setDepartamento(this);

		return secao;
	}

	public Secao removeSecao(Secao secao) {
		getSecoes().remove(secao);
		secao.setDepartamento(null);

		return secao;
	}

}