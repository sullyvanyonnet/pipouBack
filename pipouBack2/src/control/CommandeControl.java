package control;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.Commentaire;
import dao.Dao;

@Controller
public class CommandeControl {

	@Autowired
	Dao dao;
	
	public CommandeControl() {}
	
	//http://localhost:8080/pipouBack2/addCommande?id=16
	
	@RequestMapping(value="/addCommande{idPanier}",method=RequestMethod.GET)
	public @ResponseBody void addCommande(@RequestParam("idPanier") int id) {
		System.out.println("enregistrer");
		dao.enregistrerCommande(id);
	}
	
	//http://localhost:8080/pipouBack2/payerCommande?idPanier=16
									//	&Client_idClient=1
									//	&commande_idcommande=6
	
	@RequestMapping(value="/payerCommande{idPanier}",method=RequestMethod.GET)
	public @ResponseBody void payerCommande(
			@RequestParam("idPanier") int idPanier,
			@RequestParam("Client_idClient") int client_idClient,			
			@RequestParam("commande_idcommande") int commande_idcommande)  {
		System.out.println("payer");
		dao.payerCommande(idPanier, commande_idcommande, client_idClient);
	}
}
