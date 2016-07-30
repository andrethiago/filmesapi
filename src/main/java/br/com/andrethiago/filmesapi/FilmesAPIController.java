package br.com.andrethiago.filmesapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Filme>> filmes() {
		return new ResponseEntity<>(service.todosFilmes(), HttpStatus.OK);
	}

	@RequestMapping(value = "/filmes/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Filme> filmePorId(@PathVariable Long id) {
		Filme filme = service.filme(id);
		HttpStatus status = HttpStatus.OK;
		if(filme == null) {
			status = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<Filme>(filme, status);
	}
	
	@RequestMapping(value = "/atores", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Ator>> atores() {
		return new ResponseEntity<>(service.todosAtores(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/atores/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Ator> atorPorId(@PathVariable Long id) {
		Ator ator = service.ator(id);
		HttpStatus status = HttpStatus.OK;
		if(ator == null) {
			status = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<Ator>(ator, status); 
	}

}