package com.unisinos.bancodedados2.ga.ormhibernate.persistence;

import java.io.Serializable;
import javax.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;


@Entity
public class Grade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;

	@Column(nullable=false)
	private String nome;

	@OneToMany(mappedBy="grade", cascade=CascadeType.ALL)
	private Set<GradeItem> gradeItens;

	@OneToMany(mappedBy="grade", cascade=CascadeType.PERSIST)
	private Set<Produto> produtos;

	public Grade() {
		this.produtos = new LinkedHashSet<Produto>();
		this.gradeItens = new LinkedHashSet<GradeItem>();
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

	public Set<GradeItem> getGradeItens() {
		return this.gradeItens;
	}

	public void setGradeItens(Set<GradeItem> gradeItems) {
		this.gradeItens = gradeItems;
	}

	public GradeItem addGradeItem(GradeItem gradeItem) {
		getGradeItens().add(gradeItem);
		gradeItem.setGrade(this);

		return gradeItem;
	}

	public GradeItem removeGradeItem(GradeItem gradeItem) {
		getGradeItens().remove(gradeItem);
		gradeItem.setGrade(null);

		return gradeItem;
	}

	public Set<Produto> getProdutos() {
		return this.produtos;
	}

	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
	}

	public Produto addProduto(Produto produto) {
		getProdutos().add(produto);
		produto.setGrade(this);

		return produto;
	}

	public Produto removeProduto(Produto produto) {
		getProdutos().remove(produto);
		produto.setGrade(null);

		return produto;
	}

}