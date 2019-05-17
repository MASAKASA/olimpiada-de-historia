package com.olimpiadasDeHistoria.modelo.participante;

import java.util.List;

public interface IRepositorioParticipante <O, S> {//Objeto, String

	public void cadatrarParticipante(O participante);
	public void atualizarParticipante(O participante, String chave);
	public void excluirParticipante(S nome);
	public List<O> listaParticipantes();
	public boolean isParticipante(S nome);
	public void pontuar(O participante);
}
