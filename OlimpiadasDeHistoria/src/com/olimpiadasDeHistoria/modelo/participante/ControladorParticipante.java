package com.olimpiadasDeHistoria.modelo.participante;

import java.util.ArrayList;
import java.util.List;

import com.olimpiadasDeHistoria.modelo.participante.NomeParticipanteInvalidoException;

public class ControladorParticipante implements IControladorParticipante {
	
	private IRepositorioParticipante repositorioParticipante;
	private List<Participante> listaParticipantes;
	private Participante participante;

	//Construtor sem argumentos
	public ControladorParticipante() throws Exception {
		repositorioParticipante = new ParticipanteDAO();
		listaParticipantes = new ArrayList<>();
	}

	//Construor com argumentos
	public ControladorParticipante(int sistemaBancoDeDados) throws Exception {
		repositorioParticipante = new ParticipanteDAO(sistemaBancoDeDados);
		listaParticipantes = new ArrayList<>();
	}
	
	@Override
	public void cadatrarParticipante(Participante participante) throws NomeParticipanteInvalidoException, ParticipanteJaCadastradoException, NomeGrandeException {
		
		if(participante.getNome().equals("") || participante.getNome().equals(" ") || participante.getNome().equals(null)) {
			throw new NomeParticipanteInvalidoException(participante.getNome());
		}
		if(participante.getNome().length() > 20) {
			throw new NomeGrandeException(participante.getNome());
		}
		if(repositorioParticipante.isParticipante(participante.getNome())) {
			throw new ParticipanteJaCadastradoException(participante.getNome()); 
		}
		repositorioParticipante.cadatrarParticipante(participante);
	}
	
	@Override
	public void atualizarParticipante(Participante participante, String chave) throws NomeParticipanteInvalidoException, ParticipanteJaCadastradoException {
		
		if(participante.getNome().equals("") || participante.getNome().equals(" ") || participante.getNome().equals(null)) {
			throw new NomeParticipanteInvalidoException(participante.getNome());
		}
		if(repositorioParticipante.isParticipante(participante.getNome())) {
			throw new ParticipanteJaCadastradoException(participante.getNome()); 
		}
		repositorioParticipante.atualizarParticipante(participante, chave);
	}

	@Override
	public void excluirParticipante(String nome) {

		repositorioParticipante.excluirParticipante(nome);
	}
	
	@Override
	public void excluirTodosParticipante(List<Participante> listaParticipantes) {
		
		for (Participante participante : listaParticipantes) {
			repositorioParticipante.excluirParticipante(participante.getNome());
		}
	}
	
	@Override
	public List<Participante> listarParticipantes(){
		
		return listaParticipantes = repositorioParticipante.listaParticipantes();
	}

	@Override
	public List<Participante> hanking() {
		
		List<Participante> hanking = repositorioParticipante.listaParticipantes();
		
		for (int i = 0; i < hanking.size(); i++) {
			for (int j = 0; j < hanking.size() - 1; j++) {
				Participante p1 = hanking.get(j);
				Participante p2 = hanking.get(j + 1);
				if(p1.getPontuacao() < p2.getPontuacao()) {
					Participante aux = p1;
					hanking.set(j, p2);
					hanking.set((j + 1), aux);
				}
			}
		}
		return hanking;
	}
	
	@Override
	public void zerarPontos(List<Participante> listaParticipantes) {
		
		for (Participante participante : listaParticipantes) {
			participante.setPontuacao(0);
			repositorioParticipante.pontuar(participante);
		}
	}

	@Override
	public void pontuar(Participante participante, int pontuacao) {

		participante.setPontuacao(participante.getPontuacao() + pontuacao);
		
		repositorioParticipante.pontuar(participante);
	}

	@Override
	public void setParticipanteVez(Participante participante) {
		
		this.participante = participante;
	}

	@Override
	public Participante getParticipanteVez() {
		
		return this.participante;
	}
}
