package com.unisinos.bancodedados2.ga.ormhibernate.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.unisinos.bancodedados2.ga.ormhibernate.model.Empresa;
import com.unisinos.bancodedados2.ga.ormhibernate.model.Holding;

public class GerenciadorBaseDeDados {

	public static void main(String[] args) {
		
		System.out.println("Iniciando conexão com base de dados.");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BD2");
		EntityManager em = emf.createEntityManager();

		Holding holding = new Holding("hteste2","Holding Teste 2");
		Empresa empresa = new Empresa("emp1","Empresa teste1","Empresa","Rua Teste", holding);
		
		System.out.println("Iniciando transação.");
		em.getTransaction().begin();
		
		System.out.println("Gravando um registro: holding");
		em.persist(holding);
		System.out.println("Gravando um registro: empresa");
		em.persist(empresa);
		
				
		System.out.println("Comitando alterações.");
		em.getTransaction().commit();
	}

}
