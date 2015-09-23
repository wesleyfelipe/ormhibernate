package com.unisinos.bancodedados2.ga.ormhibernate.app;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.unisinos.bancodedados2.ga.ormhibernate.persistence.Categoria;
import com.unisinos.bancodedados2.ga.ormhibernate.persistence.Cor;
import com.unisinos.bancodedados2.ga.ormhibernate.persistence.Departamento;
import com.unisinos.bancodedados2.ga.ormhibernate.persistence.Empresa;
import com.unisinos.bancodedados2.ga.ormhibernate.persistence.EstoqueGradeItem;
import com.unisinos.bancodedados2.ga.ormhibernate.persistence.Grade;
import com.unisinos.bancodedados2.ga.ormhibernate.persistence.GradeItem;
import com.unisinos.bancodedados2.ga.ormhibernate.persistence.Holding;
import com.unisinos.bancodedados2.ga.ormhibernate.persistence.Loja;
import com.unisinos.bancodedados2.ga.ormhibernate.persistence.LojaDepartamento;
import com.unisinos.bancodedados2.ga.ormhibernate.persistence.Produto;
import com.unisinos.bancodedados2.ga.ormhibernate.persistence.Secao;
import com.unisinos.bancodedados2.ga.ormhibernate.persistence.Tamanho;

public class GerenciadorBDR {

	public static void main(String[] args) throws ParseException {

		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Criando objetos.");
		
		Holding holding = new Holding();
		holding.setNome("Grupo MasBahTche");

		Empresa empresa1 = new Empresa();
		empresa1.setLogradouro("Rua João Vedelino, 145");
		empresa1.setRazaoSocial("Tchê Sapatos Ltda");
		empresa1.setFantasia("Tchê");
		Empresa empresa2 = new Empresa();
		empresa2.setFantasia("Juca Sapato");
		empresa2.setRazaoSocial("Juca Sapato Feminino Ltda");
		empresa2.setLogradouro("Rua Zé Teodoro, 666");

		Departamento departamento1 = new Departamento();
		departamento1.setNome("Feminino");
		Departamento departamento2 = new Departamento();
		departamento2.setNome("Masculino");
		Departamento departamento3 = new Departamento();
		departamento3.setNome("Infantil");

		Secao secao1 = new Secao();
		secao1.setNome("Sapato");
		Secao secao2 = new Secao();
		secao2.setNome("Pasta");

		Cor cor1 = new Cor();
		cor1.setNome("Azul");
		Cor cor2 = new Cor();
		cor2.setNome("Preto");

		Tamanho tamanho1 = new Tamanho();
		tamanho1.setNome("33");
		Tamanho tamanho2 = new Tamanho();
		tamanho2.setNome("34");
		Tamanho tamanho3 = new Tamanho();
		tamanho3.setNome("35");
		Tamanho tamanho4 = new Tamanho();
		tamanho4.setNome("36");
		Tamanho tamanho5 = new Tamanho();
		tamanho5.setNome("37");

		Grade grade1 = new Grade();
		grade1.setNome("Grade Brasil Feminino");
		Grade grade2 = new Grade();
		grade2.setNome("Grade Brasil Masculino");
		Grade grade3 = new Grade();
		grade3.setNome("Grade Pasta");

		GradeItem gradeItem1 = new GradeItem();
		gradeItem1.setNome("Preto Universo tamanho 33");
		gradeItem1.setCor(cor2);
		gradeItem1.setTamanho(tamanho1);
		GradeItem gradeItem2 = new GradeItem();
		gradeItem2.setNome("Preto Universo tamanho 34");
		gradeItem2.setCor(cor2);
		gradeItem2.setTamanho(tamanho2);
		GradeItem gradeItem3 = new GradeItem();
		gradeItem3.setNome("Preto Universo tamanho 35");
		gradeItem3.setCor(cor2);
		gradeItem3.setTamanho(tamanho3);
		GradeItem gradeItem4 = new GradeItem();
		gradeItem4.setNome("Preto Universo tamanho 36");
		gradeItem4.setCor(cor2);
		gradeItem4.setTamanho(tamanho4);
		GradeItem gradeItem5 = new GradeItem();
		gradeItem5.setNome("Preto Universo tamanho 37");
		gradeItem5.setCor(cor2);
		gradeItem5.setTamanho(tamanho5);

		grade1.addGradeItem(gradeItem1);
		grade1.addGradeItem(gradeItem2);
		grade1.addGradeItem(gradeItem3);
		grade1.addGradeItem(gradeItem4);
		grade1.addGradeItem(gradeItem5);

		Categoria categoria1 = new Categoria();
		categoria1.setNome("Scarpin");
		Categoria categoria2 = new Categoria();
		categoria2.setNome("Rasteirinha");
		Categoria categoria3 = new Categoria();
		categoria3.setNome("Pasta de Mao");

		Produto produto1 = new Produto();
		produto1.setNome("Scarpin Velasquez");
		produto1.setCategoria(categoria1);
		produto1.setEstoqueAtual(10);
		produto1.setEstoqueMinimo(10);
		produto1.setGrade(grade1);

		secao1.addCategoria(categoria1);
		secao1.addCategoria(categoria2);
		secao2.addCategoria(categoria3);

		departamento1.addSecao(secao1);
		departamento2.addSecao(secao2);

		EstoqueGradeItem estoqueGradeItem1 = new EstoqueGradeItem();
		estoqueGradeItem1.setEstoqueAtual(5);
		estoqueGradeItem1.setEstoqueMinimo(2);
		estoqueGradeItem1.setProduto(produto1);
		estoqueGradeItem1.setGradeItem(gradeItem1);
		EstoqueGradeItem estoqueGradeItem2 = new EstoqueGradeItem();
		estoqueGradeItem2.setEstoqueAtual(2);
		estoqueGradeItem2.setEstoqueMinimo(5);
		estoqueGradeItem2.setProduto(produto1);
		estoqueGradeItem2.setGradeItem(gradeItem2);
		EstoqueGradeItem estoqueGradeItem3 = new EstoqueGradeItem();
		estoqueGradeItem3.setEstoqueAtual(3);
		estoqueGradeItem3.setEstoqueMinimo(3);
		estoqueGradeItem3.setProduto(produto1);
		estoqueGradeItem3.setGradeItem(gradeItem3);

		Loja loja1 = new Loja();
		loja1.setNome("Filial 01");
		loja1.setDataAbertura(formatter.parse("01/01/2014"));
		loja1.setTotalFuncionarios(16);
		Loja loja2 = new Loja();
		loja2.setNome("Filial 02");
		loja2.setDataAbertura(formatter.parse("15/02/2014"));
		loja2.setTotalFuncionarios(30);

		loja1.addEstoqueGradeItem(estoqueGradeItem1);
		loja1.addEstoqueGradeItem(estoqueGradeItem2);
		loja1.addEstoqueGradeItem(estoqueGradeItem3);

		loja1.addLojaDepartamento(new LojaDepartamento(departamento1));
		loja1.addLojaDepartamento(new LojaDepartamento(departamento2));
		loja1.addLojaDepartamento(new LojaDepartamento(departamento3));
		loja2.addLojaDepartamento(new LojaDepartamento(departamento1));

		empresa1.addLoja(loja1);
		empresa1.addLoja(loja2);

		holding.addEmpresa(empresa1);
		holding.addEmpresa(empresa2);
		

		System.out.println("Iniciando conexão com base de dados.");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BD2");
		try {
			System.out.println("Iniciando transação.");
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();

			em.persist(holding);
			em.persist(grade2);
			em.persist(grade3);
			em.persist(cor1);

			System.out.println("Comitando alterações.");
			em.getTransaction().commit();

		} catch (PersistenceException e) {
			System.out.println(e);
		} finally {
			emf.close();
		}
	}
}
