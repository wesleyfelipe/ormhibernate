package com.unisinos.bancodedados2.ga.ormhibernate.persistence;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Loja implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;

	@Temporal(TemporalType.DATE)
	private Date dataAbertura;

	@Column(nullable=false)
	private String nome;

	@Column(nullable=false)
	private Integer totalFuncionarios;

	@OneToMany(mappedBy="loja", cascade=CascadeType.ALL)
	private Set<EstoqueGradeItem> estoqueGradeItems;

	@ManyToOne(cascade=CascadeType.PERSIST, optional=false)
	private Empresa empresa;

	@OneToMany(mappedBy="loja", cascade=CascadeType.ALL)
	private Set<LojaDepartamento> lojaDepartamentos;

	public Loja() {
		this.estoqueGradeItems = new LinkedHashSet<EstoqueGradeItem>();
		this.lojaDepartamentos = new LinkedHashSet<LojaDepartamento>();
	}

	public Long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Date getDataAbertura() {
		return this.dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getTotalFuncionarios() {
		return this.totalFuncionarios;
	}

	public void setTotalFuncionarios(Integer totalFuncionarios) {
		this.totalFuncionarios = totalFuncionarios;
	}

	public Set<EstoqueGradeItem> getEstoqueGradeItems() {
		return this.estoqueGradeItems;
	}

	public void setEstoqueGradeItems(Set<EstoqueGradeItem> estoqueGradeItems) {
		this.estoqueGradeItems = estoqueGradeItems;
	}

	public EstoqueGradeItem addEstoqueGradeItem(EstoqueGradeItem estoqueGradeItem) {
		getEstoqueGradeItems().add(estoqueGradeItem);
		estoqueGradeItem.setLoja(this);

		return estoqueGradeItem;
	}

	public EstoqueGradeItem removeEstoqueGradeItem(EstoqueGradeItem estoqueGradeItem) {
		getEstoqueGradeItems().remove(estoqueGradeItem);
		estoqueGradeItem.setLoja(null);

		return estoqueGradeItem;
	}

	public Empresa getEmpresaBean() {
		return this.empresa;
	}

	public void setEmpresaBean(Empresa empresaBean) {
		this.empresa = empresaBean;
	}

	public Set<LojaDepartamento> getLojaDepartamentos() {
		return this.lojaDepartamentos;
	}

	public void setLojaDepartamentos(Set<LojaDepartamento> lojaDepartamentos) {
		this.lojaDepartamentos = lojaDepartamentos;
	}

	public LojaDepartamento addLojaDepartamento(LojaDepartamento lojaDepartamento) {
		getLojaDepartamentos().add(lojaDepartamento);
		lojaDepartamento.setLoja(this);

		return lojaDepartamento;
	}

	public LojaDepartamento removeLojaDepartamento(LojaDepartamento lojaDepartamento) {
		getLojaDepartamentos().remove(lojaDepartamento);
		lojaDepartamento.setLoja(null);

		return lojaDepartamento;
	}

}