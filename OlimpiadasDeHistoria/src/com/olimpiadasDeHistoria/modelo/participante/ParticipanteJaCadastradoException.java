package com.olimpiadasDeHistoria.modelo.participante;

public class ParticipanteJaCadastradoException extends Exception {

	public String nome;
	
	public ParticipanteJaCadastradoException(String nome) {
		super(nome + " já existe !!");
		this.nome = nome;
	}
}
