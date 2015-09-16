package com.unisinos.bancodedados2.ga.ormhibernate.persistence;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Tamanho implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;

	@Column(nullable=false)
	private String nome;

	@OneToMany(mappedBy="tamanho", cascade=CascadeType.PERSIST)
	private Set<GradeItem> gradeItems;

	public Tamanho() {
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

	public Set<GradeItem> getGradeItems() {
		return this.gradeItems;
	}

	public void setGradeItems(Set<GradeItem> gradeItems) {
		this.gradeItems = gradeItems;
	}

	public GradeItem addGradeItem(GradeItem gradeItem) {
		getGradeItems().add(gradeItem);
		gradeItem.setTamanho(this);

		return gradeItem;
	}

	public GradeItem removeGradeItem(GradeItem gradeItem) {
		getGradeItems().remove(gradeItem);
		gradeItem.setTamanho(null);

		return gradeItem;
	}

}