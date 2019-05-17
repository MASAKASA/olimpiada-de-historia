package com.olimpiadasDeHistoria.modelo.participante;

import java.util.List;

import com.olimpiadasDeHistoria.modelo.participante.NomeParticipanteInvalidoException;

public interface IControladorParticipante {

	public void cadatrarParticipante(Participante hanking) throws NomeParticipanteInvalidoException, ParticipanteJaCadastradoException, NomeGrandeException; 
	public void atualizarParticipante(Participante participante, String chave) throws NomeParticipanteInvalidoException, ParticipanteJaCadastradoException;
	public void excluirParticipante(String nome);
	public void excluirTodosParticipante(List<Participante> listaParticipantes);
	public List<Participante> listarParticipantes();
	public List<Participante> hanking();
	public void zerarPontos(List<Participante> listaParticipantes);
	public void pontuar(Participante participante, int pontuacao);
	public void setParticipanteVez(Participante participante);
	public Participante getParticipanteVez();
}
