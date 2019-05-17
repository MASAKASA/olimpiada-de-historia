package com.olimpiadasDeHistoria.testes;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.olimpiadasDeHistoria.fachada.Fachada;
import com.olimpiadasDeHistoria.modelo.participante.Participante;
import com.olimpiadasDeHistoria.modelo.participante.ParticipanteJaCadastradoException;
import com.olimpiadasDeHistoria.modelo.pergunta.NomeParticipanteInvalidoException;
import com.olimpiadasDeHistoria.util.FactoryCadastro;
import com.olimpiadasDeHistoria.util.FactoryObjetoCompleto;
import com.olimpiadasDeHistoria.util.IFactoryCadastro;
import com.olimpiadasDeHistoria.util.IFactoryObjetoCompleto;

public class TesteParticipante {
	
	private static Participante participante;
	private static List<Participante> hanking;
	private static List<Participante> listaParticipantes;
	private static Fachada fachada;
	private static IFactoryCadastro factoryCadastro;
	private static IFactoryObjetoCompleto factoryObjetoCompleto;

	public static void main(String[] args) {
		
		factoryCadastro = new FactoryCadastro();
		factoryObjetoCompleto = new FactoryObjetoCompleto();
		hanking = new ArrayList<>();
		listaParticipantes = new ArrayList<>();

		//Cadastrar
		
//		try {
//			fachada = Fachada.getFachada();
//			
//			String[] escolas = {"escola Mario Sette", "escola Felisberto","colegio Dom Miguel"};
//			
//			for (int i = 0; i < escolas.length; i++) {
//				participante = factoryCadastro.criarParticipante(escolas[i]);
//				
//				fachada.cadastrarParticipante(participante);
//			}
//			System.out.println("Participantes cadastrados com sucesso!");
//		}catch (NomeParticipanteInvalidoException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		

		//Atualizar
		
//		try {
//			fachada = Fachada.getFachada();
//			
//			String nomeAtualizado = "escola Mario Sette";
//			String chave = "Mario Sette";
//			
//			participante = factoryObjetoCompleto.criarParticipante(nomeAtualizado, 0);
//			
//			fachada.atualizarParticipante(participante, chave);
//			
//			System.out.println("Participante atualizado com sucesso!");
//		} catch (NomeParticipanteInvalidoException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ParticipanteJaCadastradoException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		//Excluir
		
//		try {
//			fachada = Fachada.getFachada();
//			
//			String nome = "escola Mario Sette";
//			
//			fachada.excluirParticipante(nome);
//			
//			System.out.println("Participante excluido com sucesso!");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		
		//Excluir todos
		
//		try {
//			fachada = Fachada.getFachada();
//			
//			listaParticipantes = fachada.listaParticipantes();
//			
//			fachada.excluirTodosParticipante(listaParticipantes);
//			
//			System.out.println("Participantes excluidos com sucesso!");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		//Listar hanking
		
//		try {
//			fachada = Fachada.getFachada();
//			
//			hanking = fachada.hanking();
//			
//			for (Participante p : hanking) {
//				System.out.println("Nome: " + p.getNome() + " - Pontuação: " + p.getPontuacao());
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		
		//Zerar pontos
		
//		try {
//		fachada = Fachada.getFachada();
//		
//		listaParticipantes = fachada.listaParticipantes();
//		
//		fachada.zerarPontos(listaParticipantes);
//		
//		System.out.println("Participantes com pontos zerados!");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		//Pontuar	
		
//		try {
//			fachada = Fachada.getFachada();
//			
//			//Pesquisa de participante no banco 
//			listaParticipantes = fachada.listarParticipantes();
//			Participante p = listaParticipantes.get(0);
//			System.out.println("Nome: " + p.getNome() + "\nPontuação: " + p.getPontuacao());
//			
//			fachada.pontuar(p, 1);
//			
//			//Repesquisa de participante no banco para comprovação de atualização 
//			listaParticipantes = fachada.listarParticipantes();
//			p = listaParticipantes.get(0);
//			System.out.println("Nome: " + p.getNome() + "\nPontuação: " + p.getPontuacao());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		

		//Logica para hanking
		
//		int vet[] = new int[3];
//	    int aux = 0;
//
//	    //Lendo os valores do vetor
//	    for (int i = 0; i < vet.length; i++) {
//	        vet[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o elemento " + (i+1)));
//	    }
//
//	    //Ordenação
//	    for (int i = 0; i < vet.length; i++) {
//	        for (int j = 0; j < vet.length - 1; j++) {
//	            if (vet[j] < vet[j + 1]) {
//	                aux = vet[j];
//	                vet[j] = vet[j + 1];
//	                vet[j + 1] = aux;
//	            }
//	        }
//	    }
//
//	    //Imprimindo valores do vetor ordenado
//	    for (int i = 0; i < vet.length; i++) {
//	        JOptionPane.showMessageDialog(null, "Valor da posição " + (i+1) + " --> " + vet[i]);
//
//	    }
	}
}
