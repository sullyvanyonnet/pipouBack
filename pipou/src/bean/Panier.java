package bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Panier")
public class Panier {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer idPanier;
	
	String adresseFacturation;

	Integer Client_idClient;
	
	public Integer getId() {
		return idPanier;
	}
	public void setId(Integer id) {
		this.idPanier = id;
	}	
	public String getAdresseFacturation() {
		return adresseFacturation;
	}
	public void setAdresseFacturation(String adresseFacturation) {
		this.adresseFacturation = adresseFacturation;
	}
	public Integer getIdClient() {
		return Client_idClient;
	}
	public void setIdClient(Integer idClient) {
		this.Client_idClient = idClient;
	}
	
}
