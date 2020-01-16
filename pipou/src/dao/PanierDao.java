package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Service;

import bean.Film;
import bean.Panier;
import data.Data;

@Service
public class PanierDao {
	
	EntityManagerFactory emf = null;
	EntityManager em = null;

	public PanierDao() {
		try {
			emf = Persistence.createEntityManagerFactory(Data.persistenceUnit);
			em = emf.createEntityManager();
			System.out.println("init Dao OK");
		} catch (Exception e) {
			System.out.println("Erreur init Dao " + e.getMessage());
		}
	}

	public void close() {
		em.clear();
		emf.close();
	}

	public void enregistrerPanier(Panier p) {
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();		
	}
}
