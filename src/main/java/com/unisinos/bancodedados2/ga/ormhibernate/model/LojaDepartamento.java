package com.unisinos.bancodedados2.ga.ormhibernate.model;

import java.io.Serializable;

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

@Entity
@Table(uniqueConstraints= @UniqueConstraint(name="uc_lojadepartamento_loja_departamento", columnNames = {"loja", "departamento"}) )
public class LojaDepartamento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_LojaDepartamento")
	@SequenceGenerator(name = "seq_LojaDepartamento", sequenceName = "s_LojaDepartamento", allocationSize = 1)
	private Long id;
	@ManyToOne(optional = false)
	@JoinColumn(name = "loja", foreignKey = @ForeignKey(name = "fk_lojadepartamento_loja"))
	private Loja loja;
	@ManyToOne(optional = false)
	@JoinColumn(name = "departamento", foreignKey = @ForeignKey(name = "fk_lojadepartamento_departamento"))
	private Departamento departamento;
	
	public LojaDepartamento(){
		super();
	}
	public LojaDepartamento(Loja loja, Departamento departamento) {
		super();
		this.loja = loja;
		this.departamento = departamento;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Loja getLoja() {
		return loja;
	}
	public void setLoja(Loja loja) {
		this.loja = loja;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	@Override
	public String toString() {
		return "LojaDepartamento [id=" + id + ", loja=" + loja + ", departamento=" + departamento + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((departamento == null) ? 0 : departamento.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((loja == null) ? 0 : loja.hashCode());
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
		LojaDepartamento other = (LojaDepartamento) obj;
		if (departamento == null) {
			if (other.departamento != null)
				return false;
		} else if (!departamento.equals(other.departamento))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (loja == null) {
			if (other.loja != null)
				return false;
		} else if (!loja.equals(other.loja))
			return false;
		return true;
	}
}
