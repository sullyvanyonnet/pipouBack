package bean;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Commentaire")
public class Commentaire {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer idCommentaire;
	Integer Client_idClient;
	Integer Film_idFilm;
	String texte;
	Date date;
	
	public Commentaire() {}
	
	public Commentaire(Integer client_idClient, Integer film_idFilm, String texte, Date date) {
		super();
		Client_idClient = client_idClient;
		Film_idFilm = film_idFilm;
		this.texte = texte;
		this.date = date;
	}
	
	public Integer getIdCommentaire() {
		return idCommentaire;
	}
	public void setIdCommentaire(Integer idCommentaire) {
		this.idCommentaire = idCommentaire;
	}
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
	public String getTexte() {
		return texte;
	}
	public void setTexte(String texte) {
		this.texte = texte;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
