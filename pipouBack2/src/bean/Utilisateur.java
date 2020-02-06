package bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="t_utilisateur")
public class Utilisateur {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer idUtilisateur;
	
	@NotEmpty(message="Le nom ne peut pas être vide")
	@Size(min=3 , message="Le nom doit avoir au moins 3 caractères")
	String nom;
	
	@NotEmpty(message="Le prénom ne peut pas être vide")
	@Size(min=3 , message="Le prénom doit avoir au moins 3 caractères")
	String prenom;
	
	public Integer getIdUtilisateur() {
		return idUtilisateur;
	}
	public void setIdUtilisateur(Integer idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
}
