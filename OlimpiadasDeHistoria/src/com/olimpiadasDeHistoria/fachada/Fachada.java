package com.olimpiadasDeHistoria.fachada;

import java.util.Collections;
import java.util.List;

import com.olimpiadasDeHistoria.modelo.participante.ControladorParticipante;
import com.olimpiadasDeHistoria.modelo.participante.Participante;
import com.olimpiadasDeHistoria.modelo.participante.ParticipanteJaCadastradoException;
import com.olimpiadasDeHistoria.modelo.participante.IControladorParticipante;
import com.olimpiadasDeHistoria.modelo.participante.NomeGrandeException;
import com.olimpiadasDeHistoria.modelo.pergunta.AlternativaMuitoGrandeException;
import com.olimpiadasDeHistoria.modelo.pergunta.ControladorPergunta;
import com.olimpiadasDeHistoria.modelo.pergunta.EnunciadoGandeException;
import com.olimpiadasDeHistoria.modelo.pergunta.IControladorPergunta;
import com.olimpiadasDeHistoria.modelo.participante.NomeParticipanteInvalidoException;
import com.olimpiadasDeHistoria.modelo.pergunta.Pergunta;
import com.olimpiadasDeHistoria.modelo.pergunta.PerguntaCertaException;
import com.olimpiadasDeHistoria.modelo.pergunta.PerguntaJaCadastradaException;
import com.olimpiadasDeHistoria.modelo.pergunta.PerguntaNaoCadastradaException;

public class Fachada {
	
	private static Fachada fachada;
	private IControladorPergunta controladorPergunta;
	private IControladorParticipante controladorParticipante;
	
	//Construtor sem argumentos
	private Fachada() throws Exception{
		controladorPergunta = new ControladorPergunta();
		controladorParticipante = new ControladorParticipante();
	}
	
	//Construtor com argumentos int sistemaBancoDeDados
	private Fachada(int sistemaBancoDeDados) throws Exception{
		controladorPergunta = new ControladorPergunta(sistemaBancoDeDados);
		controladorParticipante = new ControladorParticipante(sistemaBancoDeDados);
	}
	
	//Esse metodo serve para capturar o indice da fachada
	public static Fachada getFachada() throws Exception{
		if(fachada == null){
			synchronized(Fachada.class) {
				if (fachada == null) {
					fachada = new Fachada();
				}
			}
		}
		return fachada;
	}
	
	public void cadastrarPergunta(Pergunta pergunta) throws PerguntaJaCadastradaException, PerguntaCertaException, EnunciadoGandeException, AlternativaMuitoGrandeException {
		
		controladorPergunta.cadastrarPergunta(pergunta);
	}

	public void atualizarPergunta(Pergunta pergunta, Boolean permissao) throws PerguntaJaCadastradaException, PerguntaCertaException {
		
		controladorPergunta.atualizarPergunta(pergunta, permissao);
	}

	public void excluirPergunta(Integer codigo) throws PerguntaNaoCadastradaException {
		controladorPergunta.excluirPergunta(codigo);
	}

	public List<Pergunta> perquisarPergunta(String enuciado) throws PerguntaNaoCadastradaException {
		
		return controladorPergunta.perquisarPergunta(enuciado);
	}

	public List<Pergunta> listaPerguntas() throws PerguntaNaoCadastradaException {
		
		return controladorPergunta.listaPerguntas();
	}

	public Pergunta proximaPergunta() {
		
		return (Pergunta) controladorPergunta.proximaPergunta();
	}
	
	public void setAcertos(Integer acerto) {
		
		controladorPergunta.setAcertos(acerto);
	}
	public Integer getAcertos() {

		return (Integer) controladorPergunta.getAcertos();
	}
	public Pergunta perguntaAnterior(Integer posicao){
		
		return (Pergunta) controladorPergunta.perguntaAnterior(posicao);
	}
	public Integer getListaPeguntasRespondidas(){
		
		return (Integer) controladorPergunta.getListaPeguntasRespondidas();
	}
	
	//Participante
	public void cadastrarParticipante(Participante participante) throws NomeParticipanteInvalidoException, ParticipanteJaCadastradoException, NomeGrandeException {

		controladorParticipante.cadatrarParticipante(participante);
	}
	
	public void atualizarParticipante(Participante participante, String chave) throws NomeParticipanteInvalidoException, ParticipanteJaCadastradoException {
		
	 controladorParticipante.atualizarParticipante(participante, chave);
	}

	public void excluirParticipante(String nome) {

		controladorParticipante.excluirParticipante(nome);
	}
	
	public void excluirTodosParticipante(List<Participante> listaParticipantes) {
		
		controladorParticipante.excluirTodosParticipante(listaParticipantes);
	}
	
	public List<Participante> listarParticipantes() {
		
		return controladorParticipante.listarParticipantes();
	}

	public List<Participante> hanking() {
		
		return controladorParticipante.hanking();
	}
	
	public void zerarPontos(List<Participante> listaParticipantes) {
		
		controladorParticipante.zerarPontos(listaParticipantes);
	}
	
	public void pontuar(Participante participante, int pontuacao) {
		
		controladorParticipante.pontuar(participante, pontuacao);
	}
	
	public void setParticipanteVez(Participante participante) {
		
		controladorParticipante.setParticipanteVez(participante);
	}

	public Participante getParticipanteVez() {
		
		return controladorParticipante.getParticipanteVez();
	}
}