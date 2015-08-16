package com.unisinos.bancodedados2.ga.ormhibernate.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.unisinos.bancodedados2.ga.ormhibernate.model.Holding;

public class GerenciadorBaseDeDados {

	public static void main(String[] args) {
		
		System.out.println("Iniciando conex�o com base de dados.");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BD2");
		EntityManager em = emf.createEntityManager();

		System.out.println("Iniciando transa��o.");
		em.getTransaction().begin();
		System.out.println("Gravando um registro.");
		em.persist(new Holding("hteste","Holding Teste"));
		System.out.println("Comitando altera��es.");
		em.getTransaction().commit();
	}

}
