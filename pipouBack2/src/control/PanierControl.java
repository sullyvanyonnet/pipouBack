package control;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.Client;
import bean.Film;
import bean.Panier;
import dao.Dao;

@Controller
public class PanierControl {

	@Autowired
	Dao dao;

	public PanierControl() {
	}


	 @RequestMapping(value="/getPanier{id}",method=RequestMethod.POST)
	 public @ResponseBody Panier getPanier(@RequestParam("id") int id) { 
		 System.out.println(id);
		 return dao.getPanier(id); 
	 }

	@RequestMapping(value = "/enregistrerPanier", method = RequestMethod.GET)
	public @ResponseBody Panier enregistrerPanier(
			@RequestParam("Client_idClient") Integer client_idClient,
			@RequestParam("adresseFacturation") String adresseFacturation) {
		return dao.enregistrerPanier(adresseFacturation, client_idClient);
	}
	
	@RequestMapping(value="/panier/EnregisterElement",method=RequestMethod.GET)
	public @ResponseBody List<Film> EnregisterElement(@RequestParam("idClient") int id, @RequestParam("idFilm") int id2) { 
		 
	//http://localhost:8080/pipouBack2/panier/EnregisterElement?idClient=1&idFilm=2	
		
		if(dao.GetIdPanier(id) == null ) {
			dao.enregistrerPanier(null, id);
		}
		if(dao.estDejaDansPanier(id, id2) != null){
			return null;
		}
		
		
		
		return null;//dao.getElementPanier(id); 
	} 
	
	 @RequestMapping(value="/panier/getContenuePanier{id}",method=RequestMethod.GET)
	 public @ResponseBody List<Film> getElementPanier(@RequestParam("id") int id) { 
		//http://localhost:8080/pipouBack2/panier/getContenuePanier?id=1 
		return dao.getElementPanier(id); 
	 }


}
