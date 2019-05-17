package com.olimpiadasDeHistoria.modelo.pergunta;

import java.util.List;

public interface IRepositorioPergunta <O, S, I> {//Objeto, String, Integer
	
	public void cadastrarPergunta(O pergunta);
	public void atualizarPergunta(O pergunta);
	public void excluirPergunta(I codigo);
	public List<O> perquisarPergunta(S enuciado);
	public List<O> listaPerguntas();
    public boolean isEnuciado(S enuciado);
    public boolean isCodigo(I codigo);
}
