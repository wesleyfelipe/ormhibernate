package com.unisinos.bancodedados2.ga.ormhibernate.app;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.unisinos.bancodedados2.ga.ormhibernate.model.Categoria;
import com.unisinos.bancodedados2.ga.ormhibernate.model.Cor;
import com.unisinos.bancodedados2.ga.ormhibernate.model.Departamento;
import com.unisinos.bancodedados2.ga.ormhibernate.model.Empresa;
import com.unisinos.bancodedados2.ga.ormhibernate.model.Grade;
import com.unisinos.bancodedados2.ga.ormhibernate.model.Holding;
import com.unisinos.bancodedados2.ga.ormhibernate.model.Loja;
import com.unisinos.bancodedados2.ga.ormhibernate.model.LojaDepartamento;
import com.unisinos.bancodedados2.ga.ormhibernate.model.Secao;
import com.unisinos.bancodedados2.ga.ormhibernate.model.Tamanho;

public class GerenciadorBaseDeDados {

	public static void main(String[] args) {
		
		System.out.println("Iniciando conexão com base de dados.");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BD2");
		EntityManager em = emf.createEntityManager();

		Holding holding = new Holding("hteste6","Holding Teste 6");
		Empresa empresa = new Empresa("emp5","Empresa teste 5","Empresa","Rua Teste", holding);
		Loja loja = new Loja("lojateste3",empresa,"Loja Teste 3",new Date(),12);
		Tamanho tamanho = new Tamanho("XGG","Extra grande x2");
		Cor cor = new Cor("AA2","Azul");
		Departamento departamento = new Departamento("DP4","Logistica");
		Secao secao = new Secao("SSA3","Secao 2", departamento);
		Grade grade = new Grade("GR2","Grade 2");
		Categoria categoria = new Categoria("CAT2","Categoria 2",secao);
		LojaDepartamento lojaDepartamento = new LojaDepartamento(loja,departamento);
		
		System.out.println("Iniciando transação.");
		em.getTransaction().begin();
		
		System.out.println("Gravando um registro: holding");
		em.persist(holding);
		System.out.println("Gravando um registro: empresa");
		em.persist(empresa);
		System.out.println("Gravando um registro: loja");
		em.persist(loja);
		System.out.println("Gravando um registro: tamanho");
		em.persist(tamanho);
		System.out.println("Gravando um registro: cor");
		em.persist(cor);
		System.out.println("Gravando um registro: departamento");
		em.persist(departamento);
		System.out.println("Gravando um registro: secao");
		em.persist(secao);
		System.out.println("Gravando um registro: grade");
		em.persist(grade);
		System.out.println("Gravando um registro: categoria");
		em.persist(categoria);
		System.out.println("Gravando um registro: lojaDepartamento");
		em.persist(lojaDepartamento);
		
				
		System.out.println("Comitando alterações.");
		em.getTransaction().commit();
	}

}
