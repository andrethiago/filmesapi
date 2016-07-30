package br.com.andrethiago.filmesapi.exception;

import java.util.function.Supplier;

public class ObjetoNaoEncontradoExcepion extends RuntimeException implements Supplier {

	public ObjetoNaoEncontradoExcepion(String mensagem) {
		super(mensagem);
	}

	@Override
	public Object get() {
		// TODO Auto-generated method stub
		return null;
	}

}
