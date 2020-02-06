package bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Statut")
public class Statut {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer idStatut;
	String nom;
	
	public Integer getIdStatut() {
		return idStatut;
	}
	public void setIdStatut(Integer idStatut) {
		this.idStatut = idStatut;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

}
