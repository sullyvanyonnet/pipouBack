package bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Client")
public class Client {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer idClient;
	
	public Integer getIdUtilisateur() {
		return idClient;
	}
	public void setIdUtilisateur(Integer idUtilisateur) {
		this.idClient = idUtilisateur;
	}
	@NotEmpty(message="Le nom ne peut pas être vide")
	String nom;
	
	@NotEmpty(message="Le prénom ne peut pas être vide")
	String prenom;
	
	@NotEmpty(message="Le nom ne peut pas être vide")
	String password;
	
	@NotEmpty(message="Le prénom ne peut pas être vide")
	String login;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
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
