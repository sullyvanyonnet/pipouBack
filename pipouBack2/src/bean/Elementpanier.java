package bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Elementpanier")
public class Elementpanier {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer idElementPanier;
	Integer Film_idFilm;		/*fk ?*/
	Integer panier_idPanier;	/*fk ?*/
	
	public Integer getIdElementPanier() {
		return idElementPanier;
	}
	public void setIdElementPanier(Integer idElementPanier) {
		this.idElementPanier = idElementPanier;
	}
	public Integer getFilm_idFilm() {
		return Film_idFilm;
	}
	public void setFilm_idFilm(Integer film_idFilm) {
		Film_idFilm = film_idFilm;
	}
	public Integer getPanier_idPanier() {
		return panier_idPanier;
	}
	public void setPanier_idPanier(Integer panier_idPanier) {
		this.panier_idPanier = panier_idPanier;
	}
	
}
