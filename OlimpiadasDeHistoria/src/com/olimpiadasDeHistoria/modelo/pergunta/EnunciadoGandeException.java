package com.olimpiadasDeHistoria.modelo.pergunta;

public class EnunciadoGandeException extends Exception {

	private String enunciado;
	public EnunciadoGandeException(String enunciado) {
		super("Enunciado muito grande!");
	}
}
