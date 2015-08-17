package com.unisinos.bancodedados2.ga.ormhibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_Categoria")
	@SequenceGenerator(name = "seq_Categoria", sequenceName = "s_Categoria", allocationSize = 1)
	private Long id;
	@Column(length = 20, nullable = false, unique = true)
	private String codigo;
	@Column(length = 50, nullable = false)
	private String nome;
	@ManyToOne(optional = false)
	@JoinColumn(name = "secao", foreignKey = @ForeignKey(name = "fk_categoria_secao"))
	private Secao secao;
	
	public Categoria(){
		super();
	}
	public Categoria(String codigo, String nome, Secao secao) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.secao = secao;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Secao getSecao() {
		return secao;
	}
	public void setSecao(Secao secao) {
		this.secao = secao;
	}
	
	@Override
	public String toString() {
		return "Categoria [id=" + id + ", codigo=" + codigo + ", nome=" + nome + ", secao=" + secao + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((secao == null) ? 0 : secao.hashCode());
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
		Categoria other = (Categoria) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (secao == null) {
			if (other.secao != null)
				return false;
		} else if (!secao.equals(other.secao))
			return false;
		return true;
	}
}
