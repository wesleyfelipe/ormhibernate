package com.unisinos.bancodedados2.ga.ormhibernate.persistence;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;

	private Integer estoqueAtual;

	private Integer estoqueMinimo;

	private String nome;

	@OneToMany(mappedBy="produto", cascade=CascadeType.ALL)
	private Set<EstoqueGradeItem> estoqueGradeItems;

	@ManyToOne(cascade=CascadeType.PERSIST)
	private Categoria categoria;

	@ManyToOne(cascade=CascadeType.PERSIST)
	private Grade grade;

	public Produto() {
	}

	public Long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Integer getEstoqueAtual() {
		return this.estoqueAtual;
	}

	public void setEstoqueAtual(Integer estoqueAtual) {
		this.estoqueAtual = estoqueAtual;
	}

	public Integer getEstoqueMinimo() {
		return this.estoqueMinimo;
	}

	public void setEstoqueMinimo(Integer estoqueMinimo) {
		this.estoqueMinimo = estoqueMinimo;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<EstoqueGradeItem> getEstoqueGradeItems() {
		return this.estoqueGradeItems;
	}

	public void setEstoqueGradeItems(Set<EstoqueGradeItem> estoqueGradeItems) {
		this.estoqueGradeItems = estoqueGradeItems;
	}

	public EstoqueGradeItem addEstoqueGradeItem(EstoqueGradeItem estoqueGradeItem) {
		getEstoqueGradeItems().add(estoqueGradeItem);
		estoqueGradeItem.setProduto(this);

		return estoqueGradeItem;
	}

	public EstoqueGradeItem removeEstoqueGradeItem(EstoqueGradeItem estoqueGradeItem) {
		getEstoqueGradeItems().remove(estoqueGradeItem);
		estoqueGradeItem.setProduto(null);

		return estoqueGradeItem;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Grade getGrade() {
		return this.grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

}