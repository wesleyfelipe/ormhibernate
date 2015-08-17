package com.unisinos.bancodedados2.ga.ormhibernate.app;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.unisinos.bancodedados2.ga.ormhibernate.model.Cor;
import com.unisinos.bancodedados2.ga.ormhibernate.model.Departamento;
import com.unisinos.bancodedados2.ga.ormhibernate.model.Empresa;
import com.unisinos.bancodedados2.ga.ormhibernate.model.Holding;
import com.unisinos.bancodedados2.ga.ormhibernate.model.Loja;
import com.unisinos.bancodedados2.ga.ormhibernate.model.Tamanho;

public class GerenciadorBaseDeDados {

	public static void main(String[] args) {
		
		System.out.println("Iniciando conexão com base de dados.");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BD2");
		EntityManager em = emf.createEntityManager();

		Holding holding = new Holding("hteste5","Holding Teste 5");
		Empresa empresa = new Empresa("emp4","Empresa teste 4","Empresa","Rua Teste", holding);
		Loja loja = new Loja("lojateste",empresa,"Loja Teste",new Date(),12);
		Tamanho tamanho = new Tamanho("XG","Extra grande");
		Cor cor = new Cor("AA1","Azul celeste");
		Departamento departamento = new Departamento("DP1","Vendas");
		
		System.out.println("Iniciando transação.");
		em.getTransaction().begin();
		
		/*System.out.println("Gravando um registro: holding");
		em.persist(holding);
		System.out.println("Gravando um registro: empresa");
		em.persist(empresa);
		System.out.println("Gravando um registro: loja");
		em.persist(loja);
		System.out.println("Gravando um registro: tamanho");
		em.persist(tamanho);
		System.out.println("Gravando um registro: cor");
		em.persist(cor);*/
		System.out.println("Gravando um registro: departamento");
		em.persist(departamento);
		
				
		System.out.println("Comitando alterações.");
		em.getTransaction().commit();
	}

}
