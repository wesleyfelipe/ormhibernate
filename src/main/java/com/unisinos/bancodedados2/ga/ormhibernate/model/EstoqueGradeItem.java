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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table( name = "estoquegradeitem", uniqueConstraints = @UniqueConstraint(columnNames={"produto","gradeItem","loja"}, name="uc_estoquegradeitem_loja_produto_gradeitem"))
public class EstoqueGradeItem implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_EstoqueGradeItem")
	@SequenceGenerator(name = "seq_EstoqueGradeItem", sequenceName = "s_EstoqueGradeItem", allocationSize = 1)
	private Long codigo;
	
	@Column
	private Integer estoqueAtual;
	
	@Column
	private Integer estoqueMinimo;
	
	@ManyToOne(cascade={CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
	@JoinColumn(name = "produto", foreignKey = @ForeignKey(name = "fk_estoqueGradeItem_produto"), nullable = false)
	private Produto produto;
	
	@ManyToOne(cascade={CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
	@JoinColumn(name = "gradeItem", foreignKey = @ForeignKey(name = "fk_estoqueGradeItem_gradeitem"), nullable = false)
	private GradeItem gradeItem;
	
	public EstoqueGradeItem(){
		super();
	}
	public EstoqueGradeItem(int estoqueAtual, int estoqueMinimo, Produto produto, GradeItem gradeItem) {
		super();
		this.estoqueAtual = estoqueAtual;
		this.estoqueMinimo = estoqueMinimo;
		this.produto = produto;
		this.gradeItem = gradeItem;
	}
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public GradeItem getGradeItem() {
		return gradeItem;
	}
	public void setGradeItem(GradeItem gradeItem) {
		this.gradeItem = gradeItem;
	}
	
	@Override
	public String toString() {
		return "EstoqueGradeItem [codigo=" + codigo + ", estoqueAtual=" + estoqueAtual + ", estoqueMinimo="
				+ estoqueMinimo + ", produto=" + produto + ", gradeItem=" + gradeItem + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + estoqueAtual;
		result = prime * result + estoqueMinimo;
		result = prime * result + ((gradeItem == null) ? 0 : gradeItem.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
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
		EstoqueGradeItem other = (EstoqueGradeItem) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (estoqueAtual != other.estoqueAtual)
			return false;
		if (estoqueMinimo != other.estoqueMinimo)
			return false;
		if (gradeItem == null) {
			if (other.gradeItem != null)
				return false;
		} else if (!gradeItem.equals(other.gradeItem))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		return true;
	}	
}
