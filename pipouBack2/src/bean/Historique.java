package bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Historique")
public class Historique {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer idHistorique;
	Integer commande_idcommande;
	Integer Film_idFilm;
	Integer Client_idClient;
	
	public Historique() {}
	
	public Historique(Integer commande_idcommande, Integer film_idFilm, Integer client_idClient) {
		super();
		this.commande_idcommande = commande_idcommande;
		Film_idFilm = film_idFilm;
		Client_idClient = client_idClient;
	}
	public Integer getCommande_idcommande() {
		return commande_idcommande;
	}
	public void setCommande_idcommande(Integer commande_idcommande) {
		this.commande_idcommande = commande_idcommande;
	}
	public Integer getFilm_idFilm() {
		return Film_idFilm;
	}
	public void setFilm_idFilm(Integer film_idFilm) {
		Film_idFilm = film_idFilm;
	}
	public Integer getClient_idClient() {
		return Client_idClient;
	}
	public void setClient_idClient(Integer client_idClient) {
		Client_idClient = client_idClient;
	}
	
	
}
