package com.olimpiadasDeHistoria.modelo.pergunta;

public class PerguntaNaoCadastradaException extends Exception {

	private int codigo;
	
	public PerguntaNaoCadastradaException() {
		super("Sem pergunta");
	}
	
	public PerguntaNaoCadastradaException(int codigo) {
		super("Pergunta n�o cadastrada no sistema!");
		this.codigo = codigo;
	}
}
