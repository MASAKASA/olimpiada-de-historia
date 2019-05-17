package com.olimpiadasDeHistoria.util;

import com.olimpiadasDeHistoria.modelo.participante.Participante;
import com.olimpiadasDeHistoria.modelo.pergunta.Pergunta;

public class FactoryObjetoCompleto implements IFactoryObjetoCompleto {

	@Override
	public Pergunta criarPergunta(int codigo, String enuciado, String reposta1, String reposta2, String reposta3, String reposta4,
			String reposta5, String repostaCerta) {
		return new Pergunta(codigo, enuciado, reposta1, reposta2, reposta3, reposta4, reposta5, repostaCerta);
	}

	@Override
	public Participante criarParticipante(String nome, int pontuacao) {
		
		return new Participante(nome,pontuacao);
	}
}
