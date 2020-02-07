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

	/*
	 * @RequestMapping(value="/getpanier{id}",method=RequestMethod.POST)
	 * public @ResponseBody Panier getPanier(@RequestParam("id") int id) { return
	 * dao.getPanier(id); }
	 */

	@RequestMapping(value = "/enregistrerPanier", method = RequestMethod.GET)
	public @ResponseBody Resultat enregistrerPanier(@ModelAttribute @Valid Panier p, BindingResult bres
	// ?? @ModelAttribute(value="client" @Valid Utilisateur u, BindingResult bres

	) {
		System.out.println("enregistrer");

		Resultat res = new Resultat();

		if (bres.hasErrors()) {
			res.setRes(false);
			for (FieldError fe : bres.getFieldErrors()) {
				System.out.println(fe.getField() + " " + fe.getDefaultMessage());
				res.getErr().put(fe.getField(), fe.getDefaultMessage());
			}

		} else {
			res.setRes(true);
			Panier pan = new Panier();
			pan.setAdresseFacturation("testBackEnd");
			pan.setClient_idClient(1);
			dao.enregistrerPanier(p);
		}
		return res;
	}
}
