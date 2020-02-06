package bean;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Historique")
public class Historique {

	Integer Client_idClient;				/*fk/pk ?*/
	Integer Film_idFilm;					/*fk/pk ?*/
	Integer commande_idcommande;			/*fk*/
	
	public Integer getClient_idClient() {
		return Client_idClient;
	}
	public void setClient_idClient(Integer client_idClient) {
		Client_idClient = client_idClient;
	}
	public Integer getFilm_idFilm() {
		return Film_idFilm;
	}
	public void setFilm_idFilm(Integer film_idFilm) {
		Film_idFilm = film_idFilm;
	}
	public Integer getCommande_idcommande() {
		return commande_idcommande;
	}
	public void setCommande_idcommande(Integer commande_idcommande) {
		this.commande_idcommande = commande_idcommande;
	}
	
}
