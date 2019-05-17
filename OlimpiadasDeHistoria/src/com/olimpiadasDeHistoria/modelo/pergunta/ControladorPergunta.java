package com.olimpiadasDeHistoria.modelo.pergunta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ControladorPergunta implements IControladorPergunta<Pergunta, String, Integer, Boolean>{

	private static int acertos = 0;
	private IRepositorioPergunta repositorioPergunta;
	private List<Pergunta> listaPerguntas;
	private List<Pergunta> listaPeguntasRespondidas;
	private Pergunta pergunta;
	
	//Construtor sem argumentos
	public ControladorPergunta() throws Exception {
		repositorioPergunta = new PerguntaDAO();
		listaPerguntas = new ArrayList<>();
		listaPeguntasRespondidas = new ArrayList<>();
	}

	//Construor com argumentos
	public ControladorPergunta(int sistemaBancoDeDados) throws Exception {
		repositorioPergunta = new PerguntaDAO(sistemaBancoDeDados);
		listaPerguntas = new ArrayList<>();
		listaPeguntasRespondidas = new ArrayList<>();
	}

	@Override
	public void cadastrarPergunta(Pergunta pergunta) throws PerguntaJaCadastradaException, PerguntaCertaException, EnunciadoGandeException, AlternativaMuitoGrandeException {
		
		if(!pergunta.getReposta1().equals(pergunta.getRepostaCerta()) &&
				!pergunta.getReposta2().equals(pergunta.getRepostaCerta()) &&
				!pergunta.getReposta3().equals(pergunta.getRepostaCerta()) &&
				!pergunta.getReposta4().equals(pergunta.getRepostaCerta()) &&
				!pergunta.getReposta5().equals(pergunta.getRepostaCerta())) {
			throw new PerguntaCertaException(pergunta.getRepostaCerta());
		}
		if(pergunta.getEnuciado().length() > 102) {
			throw new EnunciadoGandeException(pergunta.getEnuciado());
		}
		if(pergunta.getReposta1().length()  > 102) {
			throw new AlternativaMuitoGrandeException(pergunta.getReposta1());
		}
		if(pergunta.getReposta2().length() > 102) {
			throw new AlternativaMuitoGrandeException(pergunta.getReposta2());
		}
		if(pergunta.getReposta3().length() > 102) {
			throw new AlternativaMuitoGrandeException(pergunta.getReposta3());
		}
		if(pergunta.getReposta4().length() > 102) {
			throw new AlternativaMuitoGrandeException(pergunta.getReposta4());
		}
		if(pergunta.getReposta5().length()> 102) {
			throw new AlternativaMuitoGrandeException(pergunta.getReposta5());
		}
		if(repositorioPergunta.isEnuciado(pergunta.getEnuciado())){
			throw new PerguntaJaCadastradaException(pergunta.getEnuciado());
		}
		repositorioPergunta.cadastrarPergunta(pergunta);
	}

	@Override
	public void atualizarPergunta(Pergunta pergunta, Boolean permissao) throws PerguntaJaCadastradaException, PerguntaCertaException {
		
		if(!pergunta.getReposta1().equals(pergunta.getRepostaCerta()) &&
				!pergunta.getReposta2().equals(pergunta.getRepostaCerta()) &&
				!pergunta.getReposta3().equals(pergunta.getRepostaCerta()) &&
				!pergunta.getReposta4().equals(pergunta.getRepostaCerta()) &&
				!pergunta.getReposta5().equals(pergunta.getRepostaCerta())) {
			throw new PerguntaCertaException(pergunta.getRepostaCerta());
		}
		/*
		 * Se true é porque o usuario quer modificar o enunciado;
		 * Se false é porque o usuario não quer modificar o enunciado.
		 */
		if(permissao) {
			/*
			 * Esse if confirma se já existe o enunciado com outro codigo no banco
			 */
			if(repositorioPergunta.isEnuciado(pergunta.getEnuciado()) && !repositorioPergunta.isCodigo(pergunta.getCodigo())){
				throw new PerguntaJaCadastradaException(pergunta.getEnuciado());
			}
		}
		repositorioPergunta.atualizarPergunta(pergunta);
	}

	@Override
	public void excluirPergunta(Integer codigo) throws PerguntaNaoCadastradaException {
		
		if(!repositorioPergunta.isCodigo(codigo)){
			throw new PerguntaNaoCadastradaException(codigo);
		}
		repositorioPergunta.excluirPergunta(codigo);
	}

	@Override
	public List<Pergunta> perquisarPergunta(String enuciado) throws PerguntaNaoCadastradaException {
		
		List<Pergunta> lista = repositorioPergunta.perquisarPergunta(enuciado);
		
		if(lista.isEmpty()) {
			throw new PerguntaNaoCadastradaException();
		}
		return lista;
	}

	@Override
	public List<Pergunta> listaPerguntas() throws PerguntaNaoCadastradaException {
		
		listaPerguntas = repositorioPergunta.listaPerguntas();
		
		if(listaPerguntas.isEmpty()) {
			throw new PerguntaNaoCadastradaException();
		}
		//Embaralha as perguntas
		Collections.shuffle(listaPerguntas); 
		
		return listaPerguntas;
	}

	@Override
	public Pergunta proximaPergunta() {
		
		/*
		 * Chamar o metodo listarPerguntas se a listaPergunta estiver vazia
		 */
		if(listaPerguntas.isEmpty()) {
			//listaPerguntas = repositorioPergunta.listaPerguntas();
			return null;
		}
		
		listaPeguntasRespondidas.add(listaPerguntas.get(0));
		
		pergunta = listaPerguntas.get(0);
		listaPerguntas.remove(0);
		return pergunta;
	}

	@Override
	public void setAcertos(Integer acerto) {
		
		this.acertos += acerto;
	}

	@Override
	public Integer getAcertos() {

		return this.acertos;
	}
	
	@Override
	public Integer getListaPeguntasRespondidas() {
		return listaPeguntasRespondidas.size();
	}
	
	@Override
	public Pergunta perguntaAnterior(Integer posicao) {
		
		return pergunta = listaPeguntasRespondidas.get(posicao);
	}
}