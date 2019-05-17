package com.olimpiadasDeHistoria.modelo.pergunta;

public class AlternativaMuitoGrandeException extends Exception {

	private String alternativa;
	
	public AlternativaMuitoGrandeException(String alternativa) {
		super("Alternativa muito grande!");
	}
}
