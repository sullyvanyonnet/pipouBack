package bean;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Commande")
public class Commande {

	//TODO fk
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer idcommande;
	Integer statut_idstatut;	
	Date dateComande;
	Integer panier_idPanier;	
	
	public Commande() {}
	
	public Commande(Integer statut_idstatut, Date dateComande, Integer panier_idPanier) {
		super();
		this.statut_idstatut = statut_idstatut;
		this.dateComande = dateComande;
		this.panier_idPanier = panier_idPanier;
	}
	public Integer getIdcommande() {
		return idcommande;
	}
	public void setIdcommande(Integer idcommande) {
		this.idcommande = idcommande;
	}
	public Integer getStatut_idstatut() {
		return statut_idstatut;
	}
	public void setStatut_idstatut(Integer statut_idstatut) {
		this.statut_idstatut = statut_idstatut;
	}
	public Date getDateComande() {
		return dateComande;
	}
	public void setDateComande(Date dateComande) {
		this.dateComande = dateComande;
	}
	public Integer getPanier_idPanier() {
		return panier_idPanier;
	}
	public void setPanier_idPanier(Integer panier_idPanier) {
		this.panier_idPanier = panier_idPanier;
	}
	
}
