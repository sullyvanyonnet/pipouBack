package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Service;

import bean.Client;
import bean.Commentaire;
import bean.Film;
import data.Data;

@Service
public class CommentaireDao {
	
	EntityManagerFactory emf = null;
	EntityManager em = null;

	public CommentaireDao() {
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
	public List<Commentaire> listerCommentaire(int id) {
		List<Commentaire> lst = em.createQuery("select u from Commentaire u where u.Film_idFilm LIKE :id").setParameter("id", id).getResultList();
		return lst;
	}
	
	//FILM
	public Commentaire getCommentaire(int id) {
		Commentaire commentaire = (Commentaire) em.createQuery("select u from Commentaire u where u.idCommentaire LIKE :id").setParameter("id", id).getSingleResult();
		return commentaire;
	}
	
	public boolean enregistrerCommentaire(Commentaire com) {

		em.getTransaction().begin();
		em.persist(com);
		em.getTransaction().commit();

		return true;
	}
}
