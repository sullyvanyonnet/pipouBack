package bean;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Commentaire")
public class Commentaire {

	
	Client Client_idCLient;
	
	Film Film_idFilm;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer idCommentaire;
	
	@NotEmpty(message="Le commentaire ne peut pas être vide")
	String texte;
	
	public Integer getIdCommentaire() {
		return idCommentaire;
	}
	public void setIdCommentaire(Integer idCommentaire) {
		this.idCommentaire = idCommentaire;
	}
	@NotEmpty(message="La date ne peut pas être vide")
	Date date;
	
	
	public Date getDateComande() {
		return date;
	}
	
	public void setDateComande(Date date) {
		this.date = date;
	}
	
	public Film getFilm_idFilm() {
		return Film_idFilm;
	}
	
	public void setDateComande(Film Film_idFilm) {
		this.Film_idFilm = Film_idFilm;
	}

	public Client getClient_idCLientm() {
		return Client_idCLient;
	}
	
	public void setClient_idCLient(Client Client) {
		this.Client_idCLient = Client;
	}
	
	public String gettexte() {
		return texte;
	}
	
	public void settexte(String texte) {
		this.texte = texte;
	}
	
}
