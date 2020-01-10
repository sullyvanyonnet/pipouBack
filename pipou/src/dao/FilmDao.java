package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Service;

import bean.Film;
import data.Data;

@Service
public class FilmDao {
	
	EntityManagerFactory emf = null;
	EntityManager em = null;

	public FilmDao() {
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

	//FILM
	public List<Film> listerFilms() {
		List<Film> lst = em.createQuery("select u from Film u").getResultList();
		return lst;
	}
	
	//FILM
	public Film getFilm(int id) {
		Film film = (Film) em.createQuery("select u from Film u where u.idFilm LIKE :id").setParameter("id", id).getSingleResult();
		return film;
	}
}
