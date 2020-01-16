package control;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.Commentaire;
import dao.CommentaireDao;

@Controller
public class CommentaireControl {

	@Autowired
	CommentaireDao dao;
	
	public CommentaireControl() {
	}
	
	@RequestMapping(value="/Comentaire/getAll{id}",method=RequestMethod.GET)
	public @ResponseBody List<Commentaire> listerCommentaire(@RequestParam("id") int id) {
		System.out.println("listerCommentaire");
		return dao.listerCommentaire(id);
	}
	
	@RequestMapping(value="/commentaire/enregistrer",method=RequestMethod.POST)
	public @ResponseBody Resultat enregistrer(
			@RequestBody @Valid Commentaire c, BindingResult bres			
		) {
		dao.enregistrerCommentaire(c);
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
