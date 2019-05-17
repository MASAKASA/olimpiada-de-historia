package com.olimpiadasDeHistoria.modelo.participante;

public class NomeGrandeException extends Exception {

	private String nome;
	
	public NomeGrandeException(String nome) {
		super("Nome de participante muito grande!");
	}
}
