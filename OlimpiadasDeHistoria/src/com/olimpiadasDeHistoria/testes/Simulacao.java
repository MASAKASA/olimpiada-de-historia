package com.olimpiadasDeHistoria.testes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.olimpiadasDeHistoria.fachada.Fachada;
import com.olimpiadasDeHistoria.modelo.pergunta.Pergunta;
import com.olimpiadasDeHistoria.modelo.pergunta.PerguntaNaoCadastradaException;

public class Simulacao {
	
	//Variaveis para auxilio
	private static List<String> alternativas;
	private static Pergunta pergunta;
	private static Fachada fachada;
	private static Scanner entrada;
	private static String resposta;

	public static void main(String[] args) {
		
		try {
			//Capturar a entrada de dados
			entrada = new Scanner (System.in);
			//Instancia fachada se for null
			fachada = Fachada.getFachada();
			//Coloca as perguntas na memoria
			fachada.listaPerguntas();
			//For para auxilio do teste
			for(int i = 0; i < 11; i++) {
				//Pega uma pergunta na memoria
				pergunta = fachada.proximaPergunta();
				//if e else para auxilio do teste
				if(pergunta != null) {
					
					//Seta as alternativas en um array 
					alternativas = new ArrayList<>();
					alternativas.add(pergunta.getReposta1());
					alternativas.add(pergunta.getReposta2());
					alternativas.add(pergunta.getReposta3());
					alternativas.add(pergunta.getReposta4());
					alternativas.add(pergunta.getReposta5());
					
					//Embaralha as alternativas
					Collections.shuffle(alternativas);
					
					//Mostrando enunciado
					System.out.println((i+1)+"º) "+ pergunta.getEnuciado()+"\n");

					//Mostrando alternativas
					System.out.println("a) " + alternativas.get(0));
					System.out.println("b) " + alternativas.get(1));
					System.out.println("c) " + alternativas.get(2));
					System.out.println("d) " + alternativas.get(3));
					System.out.println("e) " + alternativas.get(4));
					
					//Capitura resposta
					System.out.println("\nResposta: ");
					resposta = entrada.next();
					
					//ifs e elses para auxilio do teste
					if(resposta.equalsIgnoreCase("a")) {
						//Comparando a resposta
						if (pergunta.getRepostaCerta().equals(alternativas.get(0))) {
							System.out.println("Alternativa certa!\n");
							System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
							//Somando a resposta certa
							fachada.setAcertos(1);
						} else {
							System.out.println("Alternativa errada!\n");
							System.out.println("Alternativa certa era: " + pergunta.getRepostaCerta()+"\n");
							System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
						}
					} else if(resposta.equalsIgnoreCase("b")) {
						//Comparando a resposta
						if (pergunta.getRepostaCerta().equals(alternativas.get(1))) {
							System.out.println("Alternativa certa!\n");
							System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
							//Somando a resposta certa
							fachada.setAcertos(1);
						} else {
							System.out.println("Alternativa errada!\n");
							System.out.println("Alternativa certa era: " + pergunta.getRepostaCerta()+"\n");
							System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
						}
					} else if(resposta.equalsIgnoreCase("c")) {
						//Comparando a resposta
						if (pergunta.getRepostaCerta().equals(alternativas.get(2))) {
							System.out.println("Alternativa certa!\n");
							System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
							//Somando a resposta certa
							fachada.setAcertos(1);
						} else {
							System.out.println("Alternativa errada!\n");
							System.out.println("Alternativa certa era: " + pergunta.getRepostaCerta()+"\n");
							System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
						}
					} else if(resposta.equalsIgnoreCase("d")) {
						//Comparando a resposta
						if (pergunta.getRepostaCerta().equals(alternativas.get(3))) {
							System.out.println("Alternativa certa!\n");
							System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
							//Somando a resposta certa
							fachada.setAcertos(1);
						} else {
							System.out.println("Alternativa errada!\n");
							System.out.println("Alternativa certa era: " + pergunta.getRepostaCerta()+"\n");
							System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
						}
					} else if(resposta.equalsIgnoreCase("e")) {
						//Comparando a resposta
						if (pergunta.getRepostaCerta().equals(alternativas.get(4))) {
							System.out.println("Alternativa certa!\n");
							System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
							//Somando a resposta certa
							fachada.setAcertos(1);
						} else {
							System.out.println("Alternativa errada!\n");
							System.out.println("Alternativa certa era: " + pergunta.getRepostaCerta()+"\n");
							System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
						}
					}
				} else {
					//Mensagem ao final do jogo com o numero perguntas certas
					System.out.println("Acabou as perguntas!");
					System.out.println("Você acertou " + fachada.getAcertos() + " perguntas!");
				}
			}
		} catch (PerguntaNaoCadastradaException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
