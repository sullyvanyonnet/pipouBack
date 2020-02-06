package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Service;

import bean.Client;
import bean.Film;
import bean.Panier;
import data.Data;

@Service
public class Dao {

	static EntityManagerFactory emf = null;
	static EntityManager em = null;

	public Dao() {
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

	public List<Client> listerClients() {
		List<Client> lst = em.createQuery("select u from Client u").getResultList();
		return lst;

	}

	public boolean enregistrerClient(Client u) {

		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();

		return true;
	}

	//FILM
	public List<Film> listerFilms() {
		List<Film> lst = Dao.em.createQuery("select u from Film u").getResultList();
		return lst;
	}
	
	//FILM
	public Film getFilm(int id) {
		Film film = (Film) Dao.em.createQuery("select u from Film u where u.idFilm LIKE :id").setParameter("id", id).getSingleResult();
		return film;
	}
	
	
	public void enregistrerPanier(Panier p) {
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();		
	}

	public Panier getPanier(int id) {
		Panier panier = (Panier) em.createQuery("select u from Panier u where u.idPanier LIKE :id").setParameter("id", id).getSingleResult();
		return panier;
	}
	
	
	
}
