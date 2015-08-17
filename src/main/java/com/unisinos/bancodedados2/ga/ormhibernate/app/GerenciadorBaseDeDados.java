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
import com.unisinos.bancodedados2.ga.ormhibernate.model.Loja;
import com.unisinos.bancodedados2.ga.ormhibernate.model.Produto;
import com.unisinos.bancodedados2.ga.ormhibernate.model.Secao;
import com.unisinos.bancodedados2.ga.ormhibernate.model.Tamanho;

public class GerenciadorBaseDeDados {

	public static void main(String[] args) {
		
		System.out.println("Iniciando conexão com base de dados.");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BD2");
		EntityManager em = emf.createEntityManager();

		/*Holding holding = new Holding("hteste6","Holding Teste 6");
		Empresa empresa = new Empresa("emp5","Empresa teste 5","Empresa","Rua Teste", holding);
		Loja loja = new Loja("lojateste3",empresa,"Loja Teste 3",new Date(),12);
		Tamanho tamanho = new Tamanho("XGG","Extra grande x2");
		Cor cor = new Cor("AA2","Azul");
		Departamento departamento = new Departamento("DP4","Logistica");
		Secao secao = new Secao("SSA3","Secao 2", departamento);
		Grade grade = new Grade("GR2","Grade 2");
		Categoria categoria = new Categoria("CAT2","Categoria 2",secao);
		LojaDepartamento lojaDepartamento = new LojaDepartamento(loja,departamento);*/
		
		Tamanho tamanho = new Tamanho("33");
		Cor cor = new Cor("Azul");
		Categoria categoria = new Categoria("Categoria 1");
		Produto produto = new Produto("Produto 1", categoria);
		
		ArrayList<Categoria> categorias = new ArrayList<Categoria>();
		categorias.add(categoria);
		
		Secao secao = new Secao("Secao 1",categorias);
		Secao secao2 = new Secao("Secao 2",categorias);
		
		ArrayList<Secao> secoes = new ArrayList<Secao>();
		secoes.add(secao);
		secoes.add(secao2);
		Departamento departamento = new Departamento("Feminino",secoes);
		
		ArrayList<Departamento> departamentos = new ArrayList<Departamento>();
		departamentos.add(departamento);
		
		Loja loja = new Loja("Teste", new Date(), 10, departamentos);
		
		ArrayList<Loja> lojas = new ArrayList<Loja>();
		lojas.add(loja);
		
		Empresa empresa = new Empresa("Emp1","Empresa teste 1","Rua teste", lojas);
		
		
		System.out.println("Iniciando transação.");
		em.getTransaction().begin();
		
		System.out.println("Gravando um registro: empresa");
		em.persist(empresa);
		
		System.out.println("Comitando alterações.");
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
