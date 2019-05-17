package com.olimpiadasDeHistoria.modelo.participante;

public class NomeParticipanteInvalidoException extends Exception {

	public String nome;
	
	public NomeParticipanteInvalidoException(String nome) {
		super("Nome inv�lido!");
		this.nome = nome;
	}
}
