package com.unisinos.bancodedados2.ga.ormhibernate.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Type;

@Entity
public class Loja implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_Loja")
	@SequenceGenerator(name = "seq_Loja", sequenceName = "s_Loja", allocationSize = 1)
	private Long codigo;
	@Column(length = 255, nullable = false)
	private String nome;
	@Column
	@Type(type="date")
	private Date dataAbertura;
	@Column
	private int totalFuncionarios;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "LojaDepartamento",
            joinColumns = @JoinColumn(name = "codigoloja", referencedColumnName="codigo"),
            inverseJoinColumns = @JoinColumn(name = "codigodepartamento",  referencedColumnName="codigo"))
	private List<Departamento> departamentos;
	
	public Loja() {
		super();
	}

	public Loja(String nome, Date dataAbertura, int totalFuncionarios, List<Departamento> departamentos) {
		super();
		this.nome = nome;
		this.dataAbertura = dataAbertura;
		this.totalFuncionarios = totalFuncionarios;
		this.departamentos = departamentos;
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

	public List<Departamento> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(List<Departamento> departamentos) {
		this.departamentos = departamentos;
	}
	

	@Override
	public String toString() {
		return "Loja [codigo=" + codigo + ", nome=" + nome + ", dataAbertura=" + dataAbertura + ", totalFuncionarios="
				+ totalFuncionarios + ", departamentos=" + departamentos + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((dataAbertura == null) ? 0 : dataAbertura.hashCode());
		result = prime * result + ((departamentos == null) ? 0 : departamentos.hashCode());
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
		if (departamentos == null) {
			if (other.departamentos != null)
				return false;
		} else if (!departamentos.equals(other.departamentos))
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
