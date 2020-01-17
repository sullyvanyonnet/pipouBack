package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Service;

import bean.Client;
import bean.Utilisateur;
import data.Data;

@Service
public class Dao {

	EntityManagerFactory emf = null;
	EntityManager em = null;

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

	public List<Client> listerUtilisateurs() {
		List<Client> lst = em.createQuery("select u from Client u").getResultList();
		return lst;

	}

	public Client RechercheUtilisateur(String login,String pwd) {
		Client lst = (Client) em.createQuery("select u from Client u.password LIKE :pwd && u.login LIKE :login").setParameter("login", login).setParameter("pwd",pwd).getSingleResult();;
		return lst;
	}
	
	public boolean enregistrerUtilisateur(Utilisateur u) {

		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();

		return true;
	}
	
	public boolean enregistrerClient(Client u) {

		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();

		return true;
	}

	public static void main(String[] args) {

		/*Dao dao = new Dao();
		Client u = new Client();
		System.out.println("test qsd ");

		u.setNom("zzzz");
		u.setPrenom("ppp");
		u.setLogin("login");
		u.setPassword("123456");
		dao.enregistrerClient(u);

		List<Client> lst = dao.listerUtilisateurs();
		for (Client ut : lst) {
			System.out.println("nom = " + ut.getNom());
		}

		dao.close();*/
	}

}
