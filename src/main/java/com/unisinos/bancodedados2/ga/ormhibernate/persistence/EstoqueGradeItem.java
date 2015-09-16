package com.unisinos.bancodedados2.ga.ormhibernate.persistence;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class EstoqueGradeItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;

	private Integer estoqueAtual;

	private Integer estoqueMinimo;

	@ManyToOne(cascade=CascadeType.PERSIST)
	private GradeItem gradeItem;

	@ManyToOne(cascade=CascadeType.PERSIST)
	private Loja loja;

	@ManyToOne(cascade=CascadeType.PERSIST)
	private Produto produto;

	public EstoqueGradeItem() {
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

	public GradeItem getGradeItem() {
		return this.gradeItem;
	}

	public void setGradeItem(GradeItem gradeItem) {
		this.gradeItem = gradeItem;
	}

	public Loja getLoja() {
		return this.loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}