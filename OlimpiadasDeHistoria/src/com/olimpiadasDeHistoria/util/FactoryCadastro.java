package com.olimpiadasDeHistoria.util;

import com.olimpiadasDeHistoria.modelo.participante.Participante;
import com.olimpiadasDeHistoria.modelo.pergunta.Pergunta;

public class FactoryCadastro implements IFactoryCadastro {

	@Override
	public Pergunta criarPergunta(String enuciado, String reposta1, String reposta2, String reposta3, String reposta4,
			String reposta5, String repostaCerta) {
		
		return new Pergunta(enuciado, reposta1, reposta2, reposta3, reposta4, reposta5, repostaCerta);
	}

	@Override
	public Participante criarParticipante(String nome) {
		
		return new Participante(nome);
	}
}
