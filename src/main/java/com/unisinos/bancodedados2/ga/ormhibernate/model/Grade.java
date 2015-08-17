package com.unisinos.bancodedados2.ga.ormhibernate.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Grade implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_Grade")
	@SequenceGenerator(name = "seq_Grade", sequenceName = "s_Grade", allocationSize = 1)
	private Long codigo;
	@Column(length = 100, nullable = false)
	private String nome;
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="grade", foreignKey = @ForeignKey(name = "fk_gradeitem_grade"))
	private List<GradeItem> itens;
	
	public Grade(){
		super();
	}
	public Grade(String nome, List<GradeItem> itens) {
		super();
		this.nome = nome;
		this.itens = itens;
	}
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<GradeItem> getItens() {
		return itens;
	}
	public void setItens(List<GradeItem> itens) {
		this.itens = itens;
	}
	
	@Override
	public String toString() {
		return "Grade [codigo=" + codigo + ", nome=" + nome + ", itens=" + itens + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((itens == null) ? 0 : itens.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grade other = (Grade) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (itens == null) {
			if (other.itens != null)
				return false;
		} else if (!itens.equals(other.itens))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}	
}
