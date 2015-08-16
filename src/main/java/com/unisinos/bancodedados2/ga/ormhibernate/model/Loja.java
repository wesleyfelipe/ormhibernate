package com.unisinos.bancodedados2.ga.ormhibernate.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Type;

@Entity
@Table(uniqueConstraints= @UniqueConstraint(name="uc_loja_codigo_empresa", columnNames = {"codigo", "empresa"}) )
public class Loja implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_Loja")
	@SequenceGenerator(name = "seq_Loja", sequenceName = "s_Loja", allocationSize = 1)
	private Long id;
	@Column(length = 20, nullable = false)
	private String codigo;
	@ManyToOne(optional = false)
	@JoinColumn(name = "empresa", foreignKey = @ForeignKey(name = "fk_loja_empresa"))
	private Empresa empresa;
	@Column(length = 255, nullable = false)
	private String nome;
	@Column
	@Type(type="date")
	private Date dataAbertura;
	@Column
	private int totalFuncionarios;
	
	public Loja() {
		super();
	}
	public Loja(String codigo, Empresa empresa, String nome, Date dataAbertura, int totalFuncionarios) {
		super();
		this.codigo = codigo;
		this.empresa = empresa;
		this.nome = nome;
		this.dataAbertura = dataAbertura;
		this.totalFuncionarios = totalFuncionarios;
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
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	public int getTotalFuncionarios() {
		return totalFuncionarios;
	}
	public void setTotalFuncionarios(int totalFuncionarios) {
		this.totalFuncionarios = totalFuncionarios;
	}
	
	@Override
	public String toString() {
		return "Loja [id=" + id + ", codigo=" + codigo + ", empresa=" + empresa + ", nome=" + nome + ", dataAbertura="
				+ dataAbertura + ", totalFuncionarios=" + totalFuncionarios + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((dataAbertura == null) ? 0 : dataAbertura.hashCode());
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + totalFuncionarios;
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
		Loja other = (Loja) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (dataAbertura == null) {
			if (other.dataAbertura != null)
				return false;
		} else if (!dataAbertura.equals(other.dataAbertura))
			return false;
		if (empresa == null) {
			if (other.empresa != null)
				return false;
		} else if (!empresa.equals(other.empresa))
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
		if (totalFuncionarios != other.totalFuncionarios)
			return false;
		return true;
	}
}
