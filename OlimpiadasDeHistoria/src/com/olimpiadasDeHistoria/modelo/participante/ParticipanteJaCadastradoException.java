package com.olimpiadasDeHistoria.modelo.participante;

public class ParticipanteJaCadastradoException extends Exception {

	public String nome;
	
	public ParticipanteJaCadastradoException(String nome) {
		super(nome + " j� existe !!");
		this.nome = nome;
	}
}
