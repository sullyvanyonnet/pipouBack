package control;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.Client;
import bean.Commentaire;
import dao.Dao;

@Controller
public class CommentaireControl {

	@Autowired
	Dao dao;
	
	public CommentaireControl() {
	}
	
	@RequestMapping(value="/listerCommentaire{id}",method=RequestMethod.GET)
	public @ResponseBody List<Commentaire> lister(@RequestParam("id") int id) {
		System.out.println("lister");
		return dao.listerCommentaire(id);
	}
	
	//http://localhost:8080/pipouBack2/enregistrerCommentaire?Client_idClient=1
										//&Film_idFilm=1
										//&texte="Yeah !"

	@RequestMapping(value="/enregistrerCommentaire",method=RequestMethod.GET)
	public @ResponseBody  List<Commentaire> enregistrer(
			@RequestParam("Client_idClient") int client_idClient,
			@RequestParam("Film_idFilm") int film_idFilm,
			@RequestParam("texte") String texte) {
		
		System.out.println("enregistrer " + texte);
		
		
		return dao.enregistrerCommentaire(client_idClient, film_idFilm, texte);
	}
}
