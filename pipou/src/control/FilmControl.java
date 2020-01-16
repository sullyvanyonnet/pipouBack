package control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.Film;
import dao.FilmDao;

@Controller
public class FilmControl {

	@Autowired
	FilmDao dao;
	
	public FilmControl() {
	}
	
	@RequestMapping(value="/film/getAll",method=RequestMethod.GET)
	public @ResponseBody List<Film> listerFilm() {
		System.out.println("listerFilms");
		return dao.listerFilms();
	}
	
	@RequestMapping(value="/film/get{id}",method=RequestMethod.GET)
	public @ResponseBody Film listerFilm(@RequestParam("id") int id) {
		return dao.getFilm(id);
	}

}
