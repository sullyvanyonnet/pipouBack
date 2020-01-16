package control;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.Client;
import bean.Utilisateur;
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
		
		return dao.listerUtilisateurs();
	}

	@RequestMapping(value="/enregistrer",method=RequestMethod.POST)
	public @ResponseBody Resultat enregistrer(
			@RequestBody @Valid Client c, BindingResult bres			
		) {
		dao.enregistrerClient(c);
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
		}
		
		return res;
	}

}
