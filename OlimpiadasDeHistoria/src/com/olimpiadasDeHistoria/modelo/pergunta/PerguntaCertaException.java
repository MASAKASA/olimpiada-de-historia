package com.olimpiadasDeHistoria.modelo.pergunta;

public class PerguntaCertaException extends Exception {

	private String respostaCerta;
	
	public PerguntaCertaException(String respostaCerta) {
		super("'" + respostaCerta + "'\nResposta certa n�o confere com nenhuma das alternativas!");
		this.respostaCerta = respostaCerta;
	}
}
