package br.com.andrethiago.filmesapi.exception;

public class ObjetoNaoEncontradoExcepion extends RuntimeException {

	private static final long serialVersionUID = -6888000378980720246L;

	public ObjetoNaoEncontradoExcepion(String mensagem) {
		super(mensagem);
	}


}
