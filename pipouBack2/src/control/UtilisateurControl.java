package control;

import java.util.List;

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

import bean.Client;
import bean.Film;
import dao.Dao;

@Controller
public class UtilisateurControl {

	@Autowired
	Dao dao;
	
	public UtilisateurControl() {
	}
	
	@RequestMapping(value="/lister",method=RequestMethod.GET)
	public @ResponseBody List<Client> lister() {
		System.out.println("lister");
		
		return dao.listerClients();
	}

	@RequestMapping(value="/enregistrer",method=RequestMethod.GET)
	public @ResponseBody Resultat enregistrer(
			@ModelAttribute @Valid Client u, BindingResult bres 
			// ?? @ModelAttribute(value="client" @Valid Utilisateur u, BindingResult bres 
			
		) {
		System.out.println("enregistrer");
		
		Resultat res = new Resultat();
		
		if (bres.hasErrors()) {
			res.setRes(false);
			for (FieldError fe : bres.getFieldErrors()) {
				System.out.println(fe.getField()+" "+fe.getDefaultMessage());
				res.getErr().put(fe.getField(), fe.getDefaultMessage());
			}

		}
		else {
			res.setRes(true);
			Client u2 = new Client();
			u2.setNom("zzzz");
			u2.setPrenom("ppp");
			u2.setLogin("login");
			u2.setPassword("123456");
			dao.enregistrerClient(u2);
			
			//dao.enregistrerUtilisateur(u);
		}
		
		
		
		return res;
	}

	@RequestMapping(value="/connection",method=RequestMethod.POST)
	public @ResponseBody int Connection(Client c) {
		System.out.println(c.getLogin());
		Client ClienTrouve = dao.RechercheUtilisateur(c.getLogin(), c.getPassword());
		System.out.println(ClienTrouve.toString());
		if( c != null) {
			
			return ClienTrouve.getIdClient();
		};
		bres.addError(new ObjectError("Login incorrect", "Login incorrect"));
		return 0;
	}
}
