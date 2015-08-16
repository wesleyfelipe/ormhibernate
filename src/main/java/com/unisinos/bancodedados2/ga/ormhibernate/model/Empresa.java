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
public class Empresa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_Empresa")
	@SequenceGenerator(name = "seq_Empresa", sequenceName = "s_Empresa", allocationSize = 1)
	private Long id;
	@Column(length = 20, nullable = false, unique = true)
	private String codigo;
	@Column(length = 255, nullable = false)
	private String razaoSocial;
	@Column(length = 255, nullable = false)
	private String fantasia;
	@Column(length = 150, nullable = false)
	private String logradouro;
	@ManyToOne(optional = false)
	@JoinColumn(name = "holding", foreignKey = @ForeignKey(name = "fk_empresa_holding"))
	private Holding holding;
	
	public Empresa() {
		super();
	}
	public Empresa(String codigo, String razaoSocial, String fantasia, String logradouro, Holding holding) {
		super();
		this.codigo = codigo;
		this.razaoSocial = razaoSocial;
		this.fantasia = fantasia;
		this.logradouro = logradouro;
		this.holding = holding;
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
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getFantasia() {
		return fantasia;
	}
	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public Holding getHolding() {
		return holding;
	}
	public void setHolding(Holding holding) {
		this.holding = holding;
	}
	
	@Override
	public String toString() {
		return "Empresa [id=" + id + ", codigo=" + codigo + ", razaoSocial=" + razaoSocial + ", fantasia=" + fantasia
				+ ", logradouro=" + logradouro + ", holding=" + holding + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((fantasia == null) ? 0 : fantasia.hashCode());
		result = prime * result + ((holding == null) ? 0 : holding.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((logradouro == null) ? 0 : logradouro.hashCode());
		result = prime * result + ((razaoSocial == null) ? 0 : razaoSocial.hashCode());
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
		Empresa other = (Empresa) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (fantasia == null) {
			if (other.fantasia != null)
				return false;
		} else if (!fantasia.equals(other.fantasia))
			return false;
		if (holding == null) {
			if (other.holding != null)
				return false;
		} else if (!holding.equals(other.holding))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (logradouro == null) {
			if (other.logradouro != null)
				return false;
		} else if (!logradouro.equals(other.logradouro))
			return false;
		if (razaoSocial == null) {
			if (other.razaoSocial != null)
				return false;
		} else if (!razaoSocial.equals(other.razaoSocial))
			return false;
		return true;
	}
}
