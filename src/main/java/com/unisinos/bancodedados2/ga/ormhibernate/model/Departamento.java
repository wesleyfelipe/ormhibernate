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
public class Departamento implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_Departamento")
	@SequenceGenerator(name = "seq_Departamento", sequenceName = "s_Departamento", allocationSize = 1)
	private Long codigo;
	@Column(length = 50, nullable = false)
	private String nome;
	//TODO: Nome da restrição foreign key não esta sendo utilizada no banco
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="departamento", foreignKey = @ForeignKey(name = "fk_secao_departamento"), nullable=false)
	private List<Secao> secoes;
	
	public Departamento(){
		super();
	}
	public Departamento(String nome, List<Secao> secoes) {
		super();
		this.nome = nome;
		this.secoes = secoes;
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
	public List<Secao> getSecoes() {
		return secoes;
	}
	public void setSecoes(List<Secao> secoes) {
		this.secoes = secoes;
	}
	
	@Override
	public String toString() {
		return "Departamento [codigo=" + codigo + ", nome=" + nome + ", secoes=" + secoes + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((secoes == null) ? 0 : secoes.hashCode());
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
		Departamento other = (Departamento) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (secoes == null) {
			if (other.secoes != null)
				return false;
		} else if (!secoes.equals(other.secoes))
			return false;
		return true;
	}
}
