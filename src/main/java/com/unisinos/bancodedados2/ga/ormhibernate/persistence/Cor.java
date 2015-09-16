package com.unisinos.bancodedados2.ga.ormhibernate.persistence;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Cor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;

	private String nome;

	@OneToMany(mappedBy="cor", cascade=CascadeType.PERSIST)
	private Set<GradeItem> gradeitems;

	public Cor() {
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

	public Set<GradeItem> getGradeitems() {
		return this.gradeitems;
	}

	public void setGradeitems(Set<GradeItem> gradeitems) {
		this.gradeitems = gradeitems;
	}

	public GradeItem addGradeitem(GradeItem gradeitem) {
		getGradeitems().add(gradeitem);
		gradeitem.setCor(this);

		return gradeitem;
	}

	public GradeItem removeGradeitem(GradeItem gradeitem) {
		getGradeitems().remove(gradeitem);
		gradeitem.setCor(null);

		return gradeitem;
	}

}