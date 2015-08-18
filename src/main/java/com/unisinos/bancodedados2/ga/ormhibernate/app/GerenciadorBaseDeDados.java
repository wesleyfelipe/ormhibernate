package com.unisinos.bancodedados2.ga.ormhibernate.app;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.unisinos.bancodedados2.ga.ormhibernate.model.Categoria;
import com.unisinos.bancodedados2.ga.ormhibernate.model.Cor;
import com.unisinos.bancodedados2.ga.ormhibernate.model.Departamento;
import com.unisinos.bancodedados2.ga.ormhibernate.model.Empresa;
import com.unisinos.bancodedados2.ga.ormhibernate.model.EstoqueGradeItem;
import com.unisinos.bancodedados2.ga.ormhibernate.model.GradeItem;
import com.unisinos.bancodedados2.ga.ormhibernate.model.Loja;
import com.unisinos.bancodedados2.ga.ormhibernate.model.Produto;
import com.unisinos.bancodedados2.ga.ormhibernate.model.Secao;
import com.unisinos.bancodedados2.ga.ormhibernate.model.Tamanho;

public class GerenciadorBaseDeDados {

	public static void main(String[] args) {
		
		System.out.println("Iniciando conexão com base de dados.");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BD2");
		EntityManager em = emf.createEntityManager();
		
		Categoria categoria = new Categoria("Categoria Teste");
		
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
		
		EstoqueGradeItem egitem1 = new EstoqueGradeItem(10,10,produto1,gradeItem1);
		EstoqueGradeItem egitem2 = new EstoqueGradeItem(10,10,produto2,gradeItem2);
		
		ArrayList<EstoqueGradeItem> estoque = new ArrayList<EstoqueGradeItem>();
		estoque.add(egitem1);
		estoque.add(egitem2);
		
		Loja loja1 = new Loja("Loja teste 1", new Date(), 10, new ArrayList<Departamento>(), estoque);
		
		ArrayList<Loja> lojas = new ArrayList<Loja>();
		lojas.add(loja1);
		Empresa empresa = new Empresa("Teste Razão","Teste Fantasia","Rua teste", lojas);
		
		
		System.out.println("Iniciando transação.");
		em.getTransaction().begin();
		
		System.out.println("Gravando um registro: empresa");
		em.persist(departamento);
		em.persist(empresa);
		
		System.out.println("Comitando alterações.");
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

}
