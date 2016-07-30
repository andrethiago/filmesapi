package br.com.andrethiago.filmesapi;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import br.com.andrethiago.filmesapi.exception.ObjetoNaoEncontradoExcepion;
import br.com.andrethiago.filmesapi.model.Ator;
import br.com.andrethiago.filmesapi.model.Filme;

@Service
class FilmesAPIService {
	
	private List<Filme> filmes = new ArrayList<>();
	
	private List<Ator> atores = new ArrayList<>();
	
	@PostConstruct
	public void inicializaFilmes() {
		Ator mattDamon = new Ator(1L, "Matt Damon");
		Ator willemDafoe = new Ator(2L, "Willem Dafoe");
		Ator christianBale = new Ator(3L, "Christian Bale");
		Ator steveCarell = new Ator(4L, "Steve Carell");
		
		atores.add(mattDamon);
		atores.add(willemDafoe);
		atores.add(christianBale);
		atores.add(steveCarell);
		
		Filme grandeMuralha = new Filme(1L, "A Grande Muralha", "O filme segue uma força de elite na estrutura mais emblemática do mundo.");
		grandeMuralha.addAtor(new Ator[] {mattDamon, willemDafoe});
		
		Filme perdidoEmMarte = new Filme(2L, "Perdido Em Marte", "Um astronauta fica perdido em Marte e sua equipe o declara como morto...");
		perdidoEmMarte.addAtor(mattDamon);
		
		Filme grandeAposta = new Filme(3L, "A Grande Aposta", "Quatro conhecedores do mundo financeiro preveem o colapso da bolha da habitação dos anos 2000...");
		grandeAposta.addAtor(new Ator[] {christianBale, steveCarell});
		
		Filme darkKnight = new Filme(4L, "Batman, O Cavaleiro das Trevas", "Batman enfrenta seu pior inimigo: o Coringa.");
		darkKnight.addAtor(christianBale);
		
		filmes.add(grandeMuralha);
		filmes.add(perdidoEmMarte);
		filmes.add(grandeAposta);
		filmes.add(darkKnight);
	}

	List<Filme> todosFilmes() {
		return filmes;
	}
	
	List<Ator> todosAtores() {
		return atores;
	}

	public Filme filme(Long id) {
		return filmes.stream().
				filter(filme -> id.equals(filme.getId())).
				findAny().
				orElse(null);
	}
	
	public Ator ator(Long id) {
		return atores.stream().
				filter(filme -> id.equals(filme.getId())).
				findAny().
				orElse(null);
	}

}
