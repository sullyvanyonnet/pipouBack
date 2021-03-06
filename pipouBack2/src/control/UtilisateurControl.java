package control;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.Client;
import dao.Dao;

@Controller
public class UtilisateurControl {

	@Autowired
	Dao dao;
	
	public UtilisateurControl() {
	}
	
	@RequestMapping(value="/lister",method=RequestMethod.GET)
	public @ResponseBody int lister() {
		System.out.println("lister");
		
		return 1; //dao.listerClients();
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
	public @ResponseBody Integer connection(
			@RequestBody Client c , BindingResult bres 			
		) {	
		
		if(c.getLogin() != null && c.getPassword() != null ) {
			Client ClienTrouve = dao.RechercheUtilisateur(c.getLogin(), c.getPassword());
			if(ClienTrouve != null) {
				return ClienTrouve.getIdUtilisateur();
			};
		}
		bres.addError(new ObjectError("Login incorrect", "Login incorrect"));
		return null;
	}
	
	public static String getBody(HttpServletRequest request) throws IOException {

		// Read from request
	    StringBuilder buffer = new StringBuilder();
	    BufferedReader reader = request.getReader();
	    String line;
	    while ((line = reader.readLine()) != null) {
	        buffer.append(line);
	    }
	    String data = buffer.toString();
	    return data;
	}
	
	//http://localhost:8080/pipouBack2/rechercheNomUtilisateur?idUtilisateur=1
	
	@RequestMapping(value="/rechercheNomUtilisateur{idUtilisateur}",method=RequestMethod.GET)
	public @ResponseBody String rechercheNomUtilisateur(@RequestParam("idUtilisateur") int id) {
		return dao.rechercheUtilisateurNom(id).getLogin();
	}
}
