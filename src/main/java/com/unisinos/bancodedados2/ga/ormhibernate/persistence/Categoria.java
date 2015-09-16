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
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;

	private String nome;

	@ManyToOne(cascade=CascadeType.PERSIST)
	private Secao secao;

	@OneToMany(mappedBy="categoria", cascade=CascadeType.ALL)
	private Set<Produto> produtos;

	public Categoria() {
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

	public Secao getSecao() {
		return this.secao;
	}

	public void setSecao(Secao secao) {
		this.secao = secao;
	}

	public Set<Produto> getProdutos() {
		return this.produtos;
	}

	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
	}

	public Produto addProduto(Produto produto) {
		getProdutos().add(produto);
		produto.setCategoria(this);

		return produto;
	}

	public Produto removeProduto(Produto produto) {
		getProdutos().remove(produto);
		produto.setCategoria(null);

		return produto;
	}

}