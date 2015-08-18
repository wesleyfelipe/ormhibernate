package com.unisinos.bancodedados2.ga.ormhibernate.app;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.unisinos.bancodedados2.ga.ormhibernate.model.Categoria;
import com.unisinos.bancodedados2.ga.ormhibernate.model.Cor;
import com.unisinos.bancodedados2.ga.ormhibernate.model.Departamento;
import com.unisinos.bancodedados2.ga.ormhibernate.model.Empresa;
import com.unisinos.bancodedados2.ga.ormhibernate.model.EstoqueGradeItem;
import com.unisinos.bancodedados2.ga.ormhibernate.model.Grade;
import com.unisinos.bancodedados2.ga.ormhibernate.model.GradeItem;
import com.unisinos.bancodedados2.ga.ormhibernate.model.Holding;
import com.unisinos.bancodedados2.ga.ormhibernate.model.Loja;
import com.unisinos.bancodedados2.ga.ormhibernate.model.Produto;
import com.unisinos.bancodedados2.ga.ormhibernate.model.Secao;
import com.unisinos.bancodedados2.ga.ormhibernate.model.Tamanho;

public class GerenciadorBaseDeDados {

	public static void main(String[] args) throws Exception{
		
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		/*Categoria categoria = new Categoria("Categoria Teste");
		
		ArrayList<Categoria> categorias = new ArrayList<Categoria>();
		categorias.add(categoria);
		
		Secao secao = new Secao("Seção 1", categorias);
		
		ArrayList<Secao> secoes = new ArrayList<Secao>();
		secoes.add(secao);
		
		Departamento departamento = new Departamento("Departamento Teste 1", secoes);
		
		Produto produto1 = new Produto("Produto Teste 1",categoria,12,2);
		Produto produto2 = new Produto("Produto Teste 2",categoria,12,2);
		
		GradeItem gradeItem1 = new GradeItem("Teste Grade Item",new Cor("Azul"), new Tamanho("34"));
		GradeItem gradeItem2 = new GradeItem("Teste Grade Item 2",new Cor("Verde"), new Tamanho("35"));
		
		ArrayList<GradeItem> itens = new ArrayList<GradeItem>();
		itens.add(gradeItem1);
		itens.add(gradeItem2);
		
		Grade grade = new Grade("Grade teste", itens);
		
		EstoqueGradeItem egitem1 = new EstoqueGradeItem(10,10,produto1,gradeItem1);
		EstoqueGradeItem egitem2 = new EstoqueGradeItem(10,10,produto2,gradeItem2);
		
		ArrayList<EstoqueGradeItem> estoque = new ArrayList<EstoqueGradeItem>();
		estoque.add(egitem1);
		estoque.add(egitem2);
		
		Loja loja1 = new Loja("Loja teste 1", new Date(), 10, new ArrayList<Departamento>(), estoque);
		
		ArrayList<Loja> lojas = new ArrayList<Loja>();
		lojas.add(loja1);
		Empresa empresa = new Empresa("Teste Razão","Teste Fantasia","Rua teste", lojas);*/
		
		System.out.println("Iniciando conexão com base de dados.");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BD2");
		EntityManager em = emf.createEntityManager();
		
		
		System.out.println("Criando objetos.");
		Holding holding = new Holding("Grupo MasBahTche");
		
		Empresa empresa1 = new Empresa("Tchê Sapatos Ltda", "Tchê", "Rua João Vedelino, 145");
		Empresa empresa2 = new Empresa("Juca Sapato Feminino Ltda", "Juca Sapato", "Rua Zé Teodoro, 666");
		
		Departamento departamento1 = new Departamento("Feminino");
		Departamento departamento2 = new Departamento("Masculino");
		Departamento departamento3 = new Departamento("Infantil");
		
		Secao secao1 = new Secao("Sapato");
		Secao secao2 = new Secao("Pasta");
		
		Cor cor1 = new Cor("Azul");
		Cor cor2 = new Cor("Preto");
		
		Tamanho tamanho1 = new Tamanho("33");
		Tamanho tamanho2 = new Tamanho("34");
		Tamanho tamanho3 = new Tamanho("35");
		Tamanho tamanho4 = new Tamanho("36");
		Tamanho tamanho5 = new Tamanho("37");
		
		Grade grade1 = new Grade("Grade Brasil Feminino");
		Grade grade2 = new Grade("Grade Brasil Masculino");
		Grade grade3 = new Grade("Grade Pasta");
		
		GradeItem gradeItem1 = new GradeItem("Preto Universo tamanho 33", cor2, tamanho1);
		GradeItem gradeItem2 = new GradeItem("Preto Universo tamanho 34", cor2, tamanho2);
		GradeItem gradeItem3 = new GradeItem("Preto Universo tamanho 35", cor2, tamanho3);
		GradeItem gradeItem4 = new GradeItem("Preto Universo tamanho 36", cor2, tamanho4);
		GradeItem gradeItem5 = new GradeItem("Preto Universo tamanho 37", cor2, tamanho5);
		
		Categoria categoria1 = new Categoria("Scarpin");
		Categoria categoria2 = new Categoria("Rasteirinha");
		Categoria categoria3 = new Categoria("Pasta de Mao");
		
		Produto produto1 = new Produto("Scarpin Velasquez", categoria1, 10, 10);
		
		secao1.addCategoria(categoria1);
		secao1.addCategoria(categoria2);
		secao2.addCategoria(categoria3);
		
		departamento1.addSecao(secao1);
		departamento2.addSecao(secao2);
		
		EstoqueGradeItem estoqueGradeItem1 = new EstoqueGradeItem( 5, 2, produto1, gradeItem1);
		EstoqueGradeItem estoqueGradeItem2 = new EstoqueGradeItem( 2, 5, produto1, gradeItem2);
		EstoqueGradeItem estoqueGradeItem3 = new EstoqueGradeItem( 3, 3, produto1, gradeItem3);
		
		Loja loja1 = new Loja("Filial 01", formatter.parse("01/01/2014"), 16);
		Loja loja2 = new Loja("Filial 02", formatter.parse("15/02/2014"), 30);
		
		loja1.addEstoqueGradeItem(estoqueGradeItem1);
		loja1.addEstoqueGradeItem(estoqueGradeItem2);
		loja1.addEstoqueGradeItem(estoqueGradeItem3);
		
		loja1.addDepartamento(departamento1);
		loja1.addDepartamento(departamento2);
		loja1.addDepartamento(departamento3);
		loja2.addDepartamento(departamento1);
		
		empresa1.addLoja(loja1);
		empresa1.addLoja(loja2);
		
		holding.addEmpresa(empresa1);
		holding.addEmpresa(empresa2);
		
		
		System.out.println("Iniciando transação.");
		em.getTransaction().begin();
		
		em.persist(holding);
		
		/*em.persist(grade);
		em.persist(departamento);
		em.persist(empresa);*/
		
		System.out.println("Comitando alterações.");
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

}
