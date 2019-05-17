package com.olimpiadasDeHistoria.modelo.pergunta;

import java.util.List;

public interface IControladorPergunta <O, S, I, B> {//Objeto, String, Integer, Booloan
	
	public void cadastrarPergunta(O pergunta) throws PerguntaJaCadastradaException, PerguntaCertaException, EnunciadoGandeException, AlternativaMuitoGrandeException;
	public void atualizarPergunta(O pergunta, B permissao) throws PerguntaJaCadastradaException, PerguntaCertaException;
	public void excluirPergunta(I codigo) throws PerguntaNaoCadastradaException;
	public List<O> perquisarPergunta(S enuciado) throws PerguntaNaoCadastradaException;
	public List<O> listaPerguntas() throws PerguntaNaoCadastradaException;
    public O proximaPergunta();
    public void setAcertos(I acerto);
    public I getAcertos();
    public I getListaPeguntasRespondidas();
    public O perguntaAnterior(I posicao); 
}
