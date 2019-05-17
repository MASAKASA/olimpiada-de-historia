package com.olimpiadasDeHistoria.modelo.participante;

public class Participante {

	public String nome;
	public int pontuacao;

	public Participante(String nome) {
		this.nome = nome;
	}
	
	public Participante(String nome, int pontuacao) {
		this.nome = nome;
		this.pontuacao = pontuacao;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getPontuacao() {
		return pontuacao;
	}
	
	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
}
