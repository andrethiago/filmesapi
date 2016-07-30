package br.com.andrethiago.filmesapi.model;

public class Ator {

	private Long id;

	private String nome;

	public Ator(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

}
