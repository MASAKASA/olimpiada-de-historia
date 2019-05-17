package com.olimpiadasDeHistoria.util;

import com.olimpiadasDeHistoria.modelo.participante.Participante;
import com.olimpiadasDeHistoria.modelo.pergunta.Pergunta;

public interface IFactoryCadastro {

	public Pergunta criarPergunta(String enuciado, String reposta1, String reposta2, String reposta3, String reposta4,
			String reposta5, String repostaCerta);
	public Participante  criarParticipante(String nome);
}
