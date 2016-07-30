package br.com.andrethiago.filmesapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.andrethiago.filmesapi.model.Ator;
import br.com.andrethiago.filmesapi.model.Filme;

@RestController
public class FilmesAPIController {
	
	@Autowired
	private FilmesAPIService service;
	
	
	@RequestMapping(value = "/filmes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Filme> filmes() {
		return service.todosFilmes();
	}

	@RequestMapping(value = "/filmes/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Filme filmePorId(@PathVariable Long id) {
		return service.filme(id);
	}
	
	@RequestMapping(value = "/atores", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Ator> atores() {
		return service.todosAtores();
	}

}
