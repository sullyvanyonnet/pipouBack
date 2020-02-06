package bean;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Film")
public class Film {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer idFilm;
	String nom;
	String realisateur;
	Date dateSortie;	
	String synopsis;
	String lienImage;
	Double tarif;
	
	public Integer getIdFilm() {
		return idFilm;
	}
	public void setIdFilm(Integer idFilm) {
		this.idFilm = idFilm;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getRealisateur() {
		return realisateur;
	}
	public void setRealisateur(String realisateur) {
		this.realisateur = realisateur;
	}
	public Date getDateSortie() {
		return dateSortie;
	}
	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}
	public String getSynopsis() {
		return synopsis;
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	public String getLienImage() {
		return lienImage;
	}
	public void setLienImage(String lienImage) {
		this.lienImage = lienImage;
	}
	public Double getTarif() {
		return tarif;
	}
	public void setTarif(Double tarif) {
		this.tarif = tarif;
	}

}
