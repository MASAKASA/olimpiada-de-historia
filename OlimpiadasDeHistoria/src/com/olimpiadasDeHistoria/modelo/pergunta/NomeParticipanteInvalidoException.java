package com.olimpiadasDeHistoria.modelo.pergunta;

public class NomeParticipanteInvalidoException extends Exception {

	public String nome;

	public NomeParticipanteInvalidoException(String nome) {
		super("Nome inválido!");
		this.nome = nome;
	}
}
