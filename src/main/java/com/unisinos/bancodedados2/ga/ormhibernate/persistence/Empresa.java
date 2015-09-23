package com.unisinos.bancodedados2.ga.ormhibernate.persistence;

import java.io.Serializable;
import java.util.LinkedHashSet;
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
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;

	@Column(nullable=false)
	private String fantasia;

	@Column(nullable=false)
	private String logradouro;

	@Column(nullable=false)
	private String razaoSocial;

	@ManyToOne(cascade=CascadeType.PERSIST, optional=false)
	private Holding holding;

	@OneToMany(mappedBy="empresa", cascade=CascadeType.ALL)
	private Set<Loja> lojas;

	public Empresa() {
		this.lojas = new LinkedHashSet<Loja>();
	}

	public Long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getFantasia() {
		return this.fantasia;
	}

	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}

	public String getLogradouro() {
		return this.logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getRazaoSocial() {
		return this.razaoSocial;
	}

	public void setRazaoSocial(String razaosocial) {
		this.razaoSocial = razaosocial;
	}

	public Holding getHolding() {
		return this.holding;
	}

	public void setHolding(Holding holding) {
		this.holding = holding;
	}

	public Set<Loja> getLojas() {
		return this.lojas;
	}

	public void setLojas(Set<Loja> lojas) {
		this.lojas = lojas;
	}

	public Loja addLoja(Loja loja) {
		getLojas().add(loja);
		loja.setEmpresaBean(this);

		return loja;
	}

	public Loja removeLoja(Loja loja) {
		getLojas().remove(loja);
		loja.setEmpresaBean(null);

		return loja;
	}

}