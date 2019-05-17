package com.olimpiadasDeHistoria.testes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.olimpiadasDeHistoria.fachada.Fachada;
import com.olimpiadasDeHistoria.modelo.pergunta.Pergunta;
import com.olimpiadasDeHistoria.modelo.pergunta.PerguntaCertaException;
import com.olimpiadasDeHistoria.modelo.pergunta.PerguntaJaCadastradaException;
import com.olimpiadasDeHistoria.modelo.pergunta.PerguntaNaoCadastradaException;
import com.olimpiadasDeHistoria.util.FactoryCadastro;
import com.olimpiadasDeHistoria.util.FactoryObjetoCompleto;
import com.olimpiadasDeHistoria.util.IFactoryCadastro;
import com.olimpiadasDeHistoria.util.IFactoryObjetoCompleto;

public class testePerguntas {
	
	private static Pergunta pergunta;
	private static List<Pergunta> listaPerguntas;
	private static Fachada fachada;
	private static IFactoryCadastro factoryCadastro;
	private static IFactoryObjetoCompleto factoryObjetoCompleto;

	public static void main(String[] args) {
		
		factoryCadastro = new FactoryCadastro();
		factoryObjetoCompleto = new FactoryObjetoCompleto();
		listaPerguntas = new ArrayList<>();
		
		//Cadastrar pergunta
		
//		try {
//			fachada = Fachada.getFachada();
//			
//			String enuciado = "No Estado Moderno o Rei tinha uma imagem de grandeza, seus súditos o veneravam, isso acontecia devido a:";
//			String reposta1 = "Acreditava-se que o rei era iluminado, que era o enviado de Deus na terra.";
//			String reposta2 = "Os impostos foram reduzidos, permitindo aos mais pobres ascenderem socialmente";
//			String reposta3 = "O povo não pagava mais dízimos a igreja";
//			String reposta4 = "O povo tinha total proteção do rei";
//			String reposta5 = "Todos eram tratados de forma justa e igualitária";
//			String repostaCerta = "Acreditava-se que o rei era iluminado, que era o enviado de Deus na terra.";
//		
//			pergunta = factoryCadastro.criarPergunta(enuciado, reposta1, reposta2, reposta3, reposta4, reposta5, repostaCerta);
//			
//			fachada.cadastrarPergunta(pergunta);
//			
//			System.out.println("Pergunta cadastrada com sucesso!");
//		} catch (PerguntaJaCadastradaException e) {
//			System.out.println(e.getMessage());
//		}catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//Atualizar pergunta
		
		//Modificar enunciado
//		try {
//			fachada = Fachada.getFachada();
//			
//			String enuciado = "No Estado Moderno o Rei tinha uma imagem de grandeza, seus súditos o veneravam, isso acontecia devido a:";
//			String reposta1 = "Acreditava-se que o rei era iluminado, que era o enviado de Deus na terra.";
//			String reposta2 = "Os impostos foram reduzidos, permitindo aos mais pobres ascenderem socialmente";
//			String reposta3 = "O povo não pagava mais dízimos a igreja";
//			String reposta4 = "O povo tinha total proteção do rei";
//			String reposta5 = "Todos eram tratados de forma justa e igualitária";
//			String repostaCerta = "Acreditava-se que o rei era iluminado, que era o enviado de Deus na terra.";
//			
//			pergunta = factoryObjetoCompleto.criarPergunta(10, enuciado, reposta1, reposta2, reposta3, reposta4, reposta5, repostaCerta);
//			
//			fachada.atualizarPergunta(pergunta, true);//True porque não desejo modificar enunciado
//			
//			System.out.println("Pergunta atualizada com sucesso!");
//		} catch (PerguntaJaCadastradaException e) {
//			System.out.println(e.getMessage());
//		} catch (PerguntaCertaException e) {
//			System.out.println(e.getMessage());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//Não modificar enunciado
//		try {
//			fachada = Fachada.getFachada();
//			
//			String enuciado = "No Estado Moderno o Rei tinha uma imagem de grandeza, seus súditos o veneravam, isso acontecia devido a:";
//			String reposta1 = "Acreditava-se que o rei era iluminado, que era o enviado de Deus na terra.";
//			String reposta2 = "Os impostos foram reduzidos, permitindo aos mais pobres ascenderem socialmente";
//			String reposta3 = "O povo não pagava mais dízimos a igreja";
//			String reposta4 = "O povo tinha total proteção do rei";
//			String reposta5 = "Todos eram tratados de forma justa e igualitária";
//			String repostaCerta = "Acreditava-se que o rei era iluminado, que era o enviado de Deus na terra.";
//			
//			pergunta = factoryObjetoCompleto.criarPergunta(10, enuciado, reposta1, reposta2, reposta3, reposta4, reposta5, repostaCerta);
//			
//			fachada.atualizarPergunta(pergunta, false);//False porque não desejo modificar enunciado
//			
//			System.out.println("Pergunta atualizada com sucesso!");
//		} catch (PerguntaJaCadastradaException e) {
//			System.out.println(e.getMessage());
//		} catch (PerguntaCertaException e) {
//			System.out.println(e.getMessage());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//Excluir pergunta
		
//		try {
//			fachada = Fachada.getFachada();
//			
//			fachada.excluirPergunta(10);
//			
//			System.out.println("Pergunta excluida com sucesso!");
//		} catch (PerguntaNaoCadastradaException e) {
//			System.out.println(e.getMessage());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//Pesquisa pegunta
		
//		try {
//			fachada = Fachada.getFachada();
//			
//			String enuciado = "No";
//			
//			listaPerguntas = fachada.perquisarPergunta(enuciado);
//			
//			for (Pergunta p : listaPerguntas) {
//				System.out.println("Codigo: " + p.getCodigo() +
//						"\nEnunciado: " + p.getEnuciado() +
//						"\nResposta1: " + p.getReposta1() +
//						"\nResposta2: " + p.getReposta2() +
//						"\nResposta3: " + p.getReposta3() +
//						"\nResposta4: " + p.getReposta4() +
//						"\nResposta5: " + p.getReposta5() +
//						"\nRespostaCerta: " + p.getRepostaCerta() + "\n\n");
//			}
//		} catch (PerguntaNaoCadastradaException e) {
//			System.out.println(e.getMessage());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		//Listar todas as perguntas
		
//		try {
//			fachada = Fachada.getFachada();
//			
//			listaPerguntas = fachada.listaPerguntas();
//			
//			for (Pergunta p : listaPerguntas) {
//				
//				/*
//				 * Embalharar as alternativas
//				 */
//				List<String> alternativas = new ArrayList<>();
//				
//				alternativas.add(p.getReposta1());
//				alternativas.add(p.getReposta2());
//				alternativas.add(p.getReposta3());
//				alternativas.add(p.getReposta4());
//				alternativas.add(p.getReposta5());
//				
//				//Embaralha as alternativas
//				Collections.shuffle(alternativas);
//				
//				//Mostrando codigo e enunciado
//				System.out.println("Codigo: " + p.getCodigo() +
//						" - Enunciado: " + p.getEnuciado());
//				
//				//Mostrando alternativas e depois a resposta certa
//				for (int i = 0; i < alternativas.size(); i++) {
//					System.out.println("Resposta" + (i+1) + ": " + alternativas.get(i));
//				}
//				System.out.println("RespostaCerta: " + p.getRepostaCerta() + "\n\n");
//				
//			}
//		} catch (PerguntaNaoCadastradaException e) {
//			System.out.println(e.getMessage());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//Proxima pergunta
		
//		try {
//			fachada = Fachada.getFachada();
//			
//			fachada.listaPerguntas();
//			
//			for(int i = 0; i < 11; i++) {
//				
//				Pergunta pergunta = fachada.proximaPergunta();
//				
//				if(pergunta != null) {
//					/*
//					 * Embalharar as alternativas
//					 */
//					List<String> alternativas = new ArrayList<>();
//					alternativas.add(pergunta.getReposta1());
//					alternativas.add(pergunta.getReposta2());
//					alternativas.add(pergunta.getReposta3());
//					alternativas.add(pergunta.getReposta4());
//					alternativas.add(pergunta.getReposta5());
//					
//					//Embaralha as alternativas
//					Collections.shuffle(alternativas);
//					
//					//Mostrando codigo e enunciado
//					System.out.println("Enunciado: " + pergunta.getEnuciado());
//					
//					//Mostrando alternativas e depois a resposta certa
//					for (int j = 0; j < alternativas.size(); j++) {
//						System.out.println("Resposta" + (j+1) + ": " + alternativas.get(j));
//					}
//					System.out.println("\n");
//
//				} else {
//					System.out.println("Acabou as perguntas!");
//				}
//			}
//		} catch (PerguntaNaoCadastradaException e) {
//			System.out.println(e.getMessage());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
