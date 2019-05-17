package com.olimpiadasDeHistoria.modelo.pergunta;

public class PerguntaJaCadastradaException extends Exception {

	private String enunciado;

	public PerguntaJaCadastradaException(String enunciado) {
		super("'" + enunciado + "'\nEnunciado j� cadastrado no sistema!");
		this.enunciado = enunciado;
	}
}
