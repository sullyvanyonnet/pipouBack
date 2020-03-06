package control;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
<<<<<<< HEAD
	 
	 //http://localhost:8080/pipouBack2/getPanier?id=16
		 
<<<<<<< HEAD

=======
>>>>>>> parent of 703ff36... requete commander ok
=======
>>>>>>> parent of ff2b2ff... test
	@RequestMapping(value = "/enregistrerPanier", method = RequestMethod.GET)
	public @ResponseBody Panier enregistrerPanier(
			@RequestParam("Client_idClient") Integer client_idClient,
			@RequestParam("adresseFacturation") String adresseFacturation) {
		return dao.enregistrerPanier(adresseFacturation, client_idClient);
	}
}
