package com.unisinos.bancodedados2.ga.ormhibernate.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_Produto")
	@SequenceGenerator(name = "seq_Produto", sequenceName = "s_Produto", allocationSize = 1)
	private Long codigo;
	
	@Column(length = 255, nullable = false)
	private String nome;
	
	@ManyToOne(optional = false, cascade={CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
	@JoinColumn(name = "categoria", foreignKey = @ForeignKey(name = "fk_produto_categoria"))
	private Categoria categoria;
	
	@Column
	private int estoqueAtual;
	
	@Column
	private int estoqueMinimo;
	
	public Produto(){
		super();
	}
	public Produto(String nome, Categoria categoria, int estoqueAtual, int estoqueMinimo) {
		super();
		this.nome = nome;
		this.categoria = categoria;
		this.estoqueAtual = estoqueAtual;
		this.estoqueMinimo = estoqueMinimo;
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
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public int getEstoqueAtual() {
		return estoqueAtual;
	}
	public void setEstoqueAtual(int estoqueAtual) {
		this.estoqueAtual = estoqueAtual;
	}
	public int getEstoqueMinimo() {
		return estoqueMinimo;
	}
	public void setEstoqueMinimo(int estoqueMinimo) {
		this.estoqueMinimo = estoqueMinimo;
	}
	
	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", nome=" + nome + ", categoria=" + categoria + ", estoqueAtual="
				+ estoqueAtual + ", estoqueMinimo=" + estoqueMinimo + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + estoqueAtual;
		result = prime * result + estoqueMinimo;
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
		Produto other = (Produto) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (estoqueAtual != other.estoqueAtual)
			return false;
		if (estoqueMinimo != other.estoqueMinimo)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}	
}
