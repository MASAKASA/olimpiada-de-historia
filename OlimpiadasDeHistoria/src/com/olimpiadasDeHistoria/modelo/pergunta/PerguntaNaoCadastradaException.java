package com.olimpiadasDeHistoria.modelo.pergunta;

public class PerguntaNaoCadastradaException extends Exception {

	private int codigo;
	
	public PerguntaNaoCadastradaException() {
		super("Sem pergunta");
	}
	
	public PerguntaNaoCadastradaException(int codigo) {
		super("Pergunta não cadastrada no sistema!");
		this.codigo = codigo;
	}
}
