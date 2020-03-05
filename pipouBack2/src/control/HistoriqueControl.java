package control;

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
public class HistoriqueControl {

	@Autowired
	Dao dao;
	
	public HistoriqueControl() {}
	
	//http://localhost:8080/pipouBack2/addCommande?id=16
	
	@RequestMapping(value="/historiserPanier{idPanier}",method=RequestMethod.GET)
	public @ResponseBody void historiserPanier(@RequestParam("idPanier") int id) {
		System.out.println("historiserPanier");
	//	dao.historiserPanier(id);
	}
}
