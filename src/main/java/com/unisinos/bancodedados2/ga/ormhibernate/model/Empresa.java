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
public class Empresa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_Empresa")
	@SequenceGenerator(name = "seq_Empresa", sequenceName = "s_Empresa", allocationSize = 1)
	private Long codigo;
	@Column(length = 255, nullable = false)
	private String razaoSocial;
	@Column(length = 255, nullable = false)
	private String fantasia;
	@Column(length = 150, nullable = false)
	private String logradouro;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="empresa", foreignKey = @ForeignKey(name = "fk_loja_empresa"), nullable=false)
	private List<Loja> lojas;
	
	public Empresa() {
		super();
	}
	public Empresa(String razaoSocial, String fantasia, String logradouro, List<Loja> lojas) {
		super();
		this.razaoSocial = razaoSocial;
		this.fantasia = fantasia;
		this.logradouro = logradouro;
		this.lojas = lojas;
	}
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
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
	public List<Loja> getLojas() {
		return lojas;
	}
	public void setLojas(List<Loja> lojas) {
		this.lojas = lojas;
	}
	
	@Override
	public String toString() {
		return "Empresa [codigo=" + codigo + ", razaoSocial=" + razaoSocial + ", fantasia=" + fantasia + ", logradouro="
				+ logradouro + ", lojas=" + lojas + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((fantasia == null) ? 0 : fantasia.hashCode());
		result = prime * result + ((logradouro == null) ? 0 : logradouro.hashCode());
		result = prime * result + ((lojas == null) ? 0 : lojas.hashCode());
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
		if (logradouro == null) {
			if (other.logradouro != null)
				return false;
		} else if (!logradouro.equals(other.logradouro))
			return false;
		if (lojas == null) {
			if (other.lojas != null)
				return false;
		} else if (!lojas.equals(other.lojas))
			return false;
		if (razaoSocial == null) {
			if (other.razaoSocial != null)
				return false;
		} else if (!razaoSocial.equals(other.razaoSocial))
			return false;
		return true;
	}	
}
