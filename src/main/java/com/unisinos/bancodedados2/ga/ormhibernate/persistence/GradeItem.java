package com.unisinos.bancodedados2.ga.ormhibernate.persistence;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class GradeItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;

	@Column(nullable=false)
	private String nome;

	@OneToMany(mappedBy="gradeItem", cascade=CascadeType.ALL)
	private Set<EstoqueGradeItem> estoqueGradeItens;

	@ManyToOne(cascade=CascadeType.PERSIST, optional=false)
	private Cor cor;

	@ManyToOne(cascade=CascadeType.PERSIST, optional=false)
	private Grade grade;

	@ManyToOne(cascade=CascadeType.PERSIST, optional=false)
	private Tamanho tamanho;

	public GradeItem() {
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

	public Set<EstoqueGradeItem> getEstoqueGradeItens() {
		return this.estoqueGradeItens;
	}

	public void setEstoqueGradeItems(Set<EstoqueGradeItem> estoqueGradeItems) {
		this.estoqueGradeItens = estoqueGradeItems;
	}

	public EstoqueGradeItem addEstoqueGradeItem(EstoqueGradeItem estoqueGradeItem) {
		getEstoqueGradeItens().add(estoqueGradeItem);
		estoqueGradeItem.setGradeItem(this);

		return estoqueGradeItem;
	}

	public EstoqueGradeItem removeEstoqueGradeItem(EstoqueGradeItem estoqueGradeItem) {
		getEstoqueGradeItens().remove(estoqueGradeItem);
		estoqueGradeItem.setGradeItem(null);

		return estoqueGradeItem;
	}

	public Cor getCor() {
		return this.cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

	public Grade getGrade() {
		return this.grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public Tamanho getTamanhoBean() {
		return this.tamanho;
	}

	public void setTamanho(Tamanho tamanho) {
		this.tamanho = tamanho;
	}

}