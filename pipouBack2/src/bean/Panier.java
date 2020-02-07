package bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Panier")
public class Panier {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer idPanier;
	String adresseFacturation;
	Integer Client_idClient;		/*fk ?*/
	
	public Panier() {}
	
	public Panier(String adresseFacturation, Integer client_idClient) {
		super();
		this.adresseFacturation = adresseFacturation;
		Client_idClient = client_idClient;
	}
	
	public Integer getIdPanier() {
		return idPanier;
	}
	public void setIdPanier(Integer idPanier) {
		this.idPanier = idPanier;
	}
	public String getAdresseFacturation() {
		return adresseFacturation;
	}
	public void setAdresseFacturation(String adresseFacturation) {
		this.adresseFacturation = adresseFacturation;
	}
	public Integer getClient_idClient() {
		return Client_idClient;
	}
	public void setClient_idClient(Integer client_idClient) {
		Client_idClient = client_idClient;
	}	
}
