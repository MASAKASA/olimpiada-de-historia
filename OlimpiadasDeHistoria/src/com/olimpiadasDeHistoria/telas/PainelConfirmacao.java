package com.olimpiadasDeHistoria.telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.olimpiadasDeHistoria.fachada.Fachada;
import com.olimpiadasDeHistoria.modelo.participante.Participante;
import com.olimpiadasDeHistoria.modelo.pergunta.Pergunta;
import com.olimpiadasDeHistoria.util.ShadowText;

public class PainelConfirmacao extends JPanel {

	//Criando icone dos botões
    ImageIcon icone = new ImageIcon(TelaPrincipal.class.getResource("/com/olimpiadasDeHistoria/imagens/botao_official.png"));
		
    //Criando icone dos botões
    ImageIcon icone2 = new ImageIcon(TelaPrincipal.class.getResource("/com/olimpiadasDeHistoria/imagens/btn_1.png"));
    
	private static JLayeredPane painelCamada = new JLayeredPane();
	private PainelOlimpiada painelOlimpiada;
	private JButton btnSim = new JButton("Sim", icone);
	private JButton btnNao = new JButton("Não", icone);
	private String alternativa;
	private Pergunta pergunta;
	private Participante participante;
	private int pontosPorQuestao;
	private static Fachada fachada;
    
	public PainelConfirmacao(PainelOlimpiada painelOlimpiada,TelaPrincipal tp, int largura, int altura, String alternativa, Pergunta pergunta, Participante participante, int pontosPorQuestao) {
		
		//Recebendo fachada
		//Instanciando fachada
		try {
			fachada = Fachada.getFachada();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		//Recebendo painel olimpiada
		this.painelOlimpiada = painelOlimpiada;
		
		//Recebendo a alternativa
		this.alternativa = alternativa;
		
		//Recebendo pergunta
		this.pergunta = pergunta;
		
		//Recebendo participante
		this.participante = participante;
		
		//Recebendo pontos por questão
		this.pontosPorQuestao = pontosPorQuestao;
		
		//Imagem pergaminho
		JLabel pergaminho = new JLabel();
		pergaminho.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/com/olimpiadasDeHistoria/imagens/pergaminhoMensagem.png")));
		
		//Caixa Vertical
		Box caixa = Box.createVerticalBox();
		caixa.add(Box.createVerticalStrut(250));
		caixa.add(pergaminho);
		
		//Painel de pergaminho
		JPanel painelPergaminho = new JPanel();
		painelPergaminho.add(caixa);
		painelPergaminho.setBounds(new Rectangle(new Dimension(largura, altura)));
		painelPergaminho.setBackground( new Color(255, 255, 255,80) );
		painelPergaminho.setOpaque(true);
		painelPergaminho.revalidate();
		painelPergaminho.repaint();
		
		//Enunciado
		ShadowText enunciado = new ShadowText("Confirma sua escolha?",new Font("Lucida Calligraphy", Font.BOLD, 28));
		enunciado.setHorizontalTextPosition(SwingConstants.CENTER);	
		enunciado.setMaximumSize(new Dimension(400, 100));
		enunciado.setPreferredSize(new Dimension(400, 100));
		
		//Botao sim
		btnSim.setMaximumSize(new Dimension(400, 90));
		btnSim.setPreferredSize(new Dimension(400, 90));
		btnSim.setFocusPainted(false);
		btnSim.setMargin(new Insets(2, 2, 2, 2));
		btnSim.setContentAreaFilled(false);
		btnSim.setBorderPainted(false);
		btnSim.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSim.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 28));
		btnSim.setForeground(new Color(95,38,5));
		btnSim.setVerticalTextPosition(SwingConstants.CENTER);
		btnSim.setHorizontalTextPosition(SwingConstants.CENTER);

		setOpaque(false);
		btnSim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Ação Sim
				boolean resultado = true;
				tp.removePainelConfirmacao();
				confirmar(alternativa);
				return;
			}

			private void confirmar(String alternativa) {
				if(alternativa.equals("A")){
					
					//Resposta Certa
					if(pergunta.getReposta1().equalsIgnoreCase(pergunta.getRepostaCerta())){
						painelOlimpiada.alternativaA.setForeground(new Color(16, 165, 16));
						painelOlimpiada.alternativaA.removeMouseListener(painelOlimpiada.mouseAdapterA);
						painelOlimpiada.alternativaB.setEnabled(false);
						painelOlimpiada.alternativaC.setEnabled(false);
						painelOlimpiada.alternativaD.setEnabled(false);
						painelOlimpiada.alternativaE.setEnabled(false);
						fachada.pontuar(participante, pontosPorQuestao);
					//Resposta Errada
					} else{
						//Trocando a cor pra vermelho
						painelOlimpiada.alternativaA.setForeground(new Color(250, 4, 4));
						//Removendo o mouse listener
						painelOlimpiada.alternativaA.removeMouseListener(painelOlimpiada.mouseAdapterA);
						//Se a resposta certa for B
						if(pergunta.getReposta2().equals(pergunta.getRepostaCerta())){
							painelOlimpiada.alternativaB.setForeground(new Color(0, 255, 9));
							painelOlimpiada.alternativaB.removeMouseListener(painelOlimpiada.mouseAdapterB);
							painelOlimpiada.alternativaC.setEnabled(false);
							painelOlimpiada.alternativaD.setEnabled(false);
							painelOlimpiada.alternativaE.setEnabled(false);
						//Se a resposta certa for C
						} else if(pergunta.getReposta3().equals(pergunta.getRepostaCerta())){
							painelOlimpiada.alternativaC.setForeground(new Color(0, 255, 9));
							painelOlimpiada.alternativaC.removeMouseListener(painelOlimpiada.mouseAdapterC);
							painelOlimpiada.alternativaB.setEnabled(false);
							painelOlimpiada.alternativaD.setEnabled(false);
							painelOlimpiada.alternativaE.setEnabled(false);
						//Se a resposta certa for D
						}else if(pergunta.getReposta4().equals(pergunta.getRepostaCerta())){
							painelOlimpiada.alternativaD.setForeground(new Color(0, 255, 9));
							painelOlimpiada.alternativaD.removeMouseListener(painelOlimpiada.mouseAdapterD);
							painelOlimpiada.alternativaC.setEnabled(false);
							painelOlimpiada.alternativaB.setEnabled(false);
							painelOlimpiada.alternativaE.setEnabled(false);
						//Se a resposta certa for E
						}else if(pergunta.getReposta5().equals(pergunta.getRepostaCerta())){
							painelOlimpiada.alternativaE.setForeground(new Color(0, 255, 9));
							painelOlimpiada.alternativaE.removeMouseListener(painelOlimpiada.mouseAdapterE);
							painelOlimpiada.alternativaC.setEnabled(false);
							painelOlimpiada.alternativaD.setEnabled(false);
							painelOlimpiada.alternativaB.setEnabled(false);
						}
					}
					tp.removePainelConfirmacao();
					
				}else if(alternativa.equals("B")){
					
					//Resposta Certa				
					if(pergunta.getReposta2().equalsIgnoreCase(pergunta.getRepostaCerta())){
						painelOlimpiada.alternativaB.setForeground(new Color(16, 165, 16));
						painelOlimpiada.alternativaB.removeMouseListener(painelOlimpiada.mouseAdapterB);
						painelOlimpiada.alternativaA.setEnabled(false);
						painelOlimpiada.alternativaC.setEnabled(false);
						painelOlimpiada.alternativaD.setEnabled(false);
						painelOlimpiada.alternativaE.setEnabled(false);
						fachada.pontuar(participante, pontosPorQuestao);
					//Resposta Errada
					} else{
						//Trocando a cor pra vermelho
						painelOlimpiada.alternativaB.setForeground(new Color(250, 4, 4));
						//Removendo o mouse listener
						painelOlimpiada.alternativaB.removeMouseListener(painelOlimpiada.mouseAdapterB);
						//Se a resposta certa for A
						if(pergunta.getReposta1().equals(pergunta.getRepostaCerta())){
							painelOlimpiada.alternativaA.setForeground(new Color(0, 255, 9));
							painelOlimpiada.alternativaA.removeMouseListener(painelOlimpiada.mouseAdapterA);
							painelOlimpiada.alternativaC.setEnabled(false);
							painelOlimpiada.alternativaD.setEnabled(false);
							painelOlimpiada.alternativaE.setEnabled(false);
						//Se a resposta certa for C
						} else if(pergunta.getReposta3().equals(pergunta.getRepostaCerta())){
							painelOlimpiada.alternativaC.setForeground(new Color(0, 255, 9));
							painelOlimpiada.alternativaC.removeMouseListener(painelOlimpiada.mouseAdapterC);
							painelOlimpiada.alternativaA.setEnabled(false);
							painelOlimpiada.alternativaD.setEnabled(false);
							painelOlimpiada.alternativaE.setEnabled(false);
						//Se a resposta certa for D
						}else if(pergunta.getReposta4().equals(pergunta.getRepostaCerta())){
							painelOlimpiada.alternativaD.setForeground(new Color(0, 255, 9));
							painelOlimpiada.alternativaD.removeMouseListener(painelOlimpiada.mouseAdapterD);
							painelOlimpiada.alternativaC.setEnabled(false);
							painelOlimpiada.alternativaA.setEnabled(false);
							painelOlimpiada.alternativaE.setEnabled(false);
						//Se a resposta certa for E
						}else if(pergunta.getReposta5().equals(pergunta.getRepostaCerta())){
							painelOlimpiada.alternativaE.setForeground(new Color(0, 255, 9));
							painelOlimpiada.alternativaE.removeMouseListener(painelOlimpiada.mouseAdapterE);
							painelOlimpiada.alternativaC.setEnabled(false);
							painelOlimpiada.alternativaD.setEnabled(false);
							painelOlimpiada.alternativaA.setEnabled(false);
						}
					}
					tp.removePainelConfirmacao();
					
				}else if(alternativa.equals("C")){
					
					//Resposta certa
					if(pergunta.getReposta3().equalsIgnoreCase(pergunta.getRepostaCerta())){
						painelOlimpiada.alternativaC.setForeground(new Color(16, 165, 16));
						painelOlimpiada.alternativaC.removeMouseListener(painelOlimpiada.mouseAdapterC);
						painelOlimpiada.alternativaB.setEnabled(false);
						painelOlimpiada.alternativaA.setEnabled(false);
						painelOlimpiada.alternativaD.setEnabled(false);
						painelOlimpiada.alternativaE.setEnabled(false);
						fachada.pontuar(participante, pontosPorQuestao);
					//Resposta Errada
					} else{
						//Trocando a cor pra vermelho
						painelOlimpiada.alternativaC.setForeground(new Color(250, 4, 4));
						//Removendo o mouse listener
						painelOlimpiada.alternativaC.removeMouseListener(painelOlimpiada.mouseAdapterC);
						//Se a resposta certa for A
						if(pergunta.getReposta1().equals(pergunta.getRepostaCerta())){
							painelOlimpiada.alternativaA.setForeground(new Color(0, 255, 9));
							painelOlimpiada.alternativaA.removeMouseListener(painelOlimpiada.mouseAdapterA);
							painelOlimpiada.alternativaB.setEnabled(false);
							painelOlimpiada.alternativaD.setEnabled(false);
							painelOlimpiada.alternativaE.setEnabled(false);
						//Se a resposta certa for B
						} else if(pergunta.getReposta2().equals(pergunta.getRepostaCerta())){
							painelOlimpiada.alternativaB.setForeground(new Color(0, 255, 9));
							painelOlimpiada.alternativaB.removeMouseListener(painelOlimpiada.mouseAdapterB);
							painelOlimpiada.alternativaA.setEnabled(false);
							painelOlimpiada.alternativaD.setEnabled(false);
							painelOlimpiada.alternativaE.setEnabled(false);
						//Se a resposta certa for D
						}else if(pergunta.getReposta4().equals(pergunta.getRepostaCerta())){
							painelOlimpiada.alternativaD.setForeground(new Color(0, 255, 9));
							painelOlimpiada.alternativaD.removeMouseListener(painelOlimpiada.mouseAdapterD);
							painelOlimpiada.alternativaB.setEnabled(false);
							painelOlimpiada.alternativaA.setEnabled(false);
							painelOlimpiada.alternativaE.setEnabled(false);
						//Se a resposta certa for E
						}else if(pergunta.getReposta5().equals(pergunta.getRepostaCerta())){
							painelOlimpiada.alternativaE.setForeground(new Color(0, 255, 9));
							painelOlimpiada.alternativaE.removeMouseListener(painelOlimpiada.mouseAdapterE);
							painelOlimpiada.alternativaB.setEnabled(false);
							painelOlimpiada.alternativaD.setEnabled(false);
							painelOlimpiada.alternativaA.setEnabled(false);
						}
					}
					tp.removePainelConfirmacao();
					
				}else if(alternativa.equals("D")){
					
					//Resposta Certa
					if(pergunta.getReposta4().equalsIgnoreCase(pergunta.getRepostaCerta())){
						painelOlimpiada.alternativaD.setForeground(new Color(16, 165, 16));
						painelOlimpiada.alternativaD.removeMouseListener(painelOlimpiada.mouseAdapterD);
						painelOlimpiada.alternativaB.setEnabled(false);
						painelOlimpiada.alternativaC.setEnabled(false);
						painelOlimpiada.alternativaA.setEnabled(false);
						painelOlimpiada.alternativaE.setEnabled(false);
						fachada.pontuar(participante, pontosPorQuestao);
					//Resposta Errada
					} else{
						//Trocando a cor pra vermelho
						painelOlimpiada.alternativaD.setForeground(new Color(250, 4, 4));
						//Removendo o mouse listener
						painelOlimpiada.alternativaD.removeMouseListener(painelOlimpiada.mouseAdapterD);
						//Se a resposta certa for A
						if(pergunta.getReposta1().equals(pergunta.getRepostaCerta())){
							painelOlimpiada.alternativaA.setForeground(new Color(0, 255, 9));
							painelOlimpiada.alternativaA.removeMouseListener(painelOlimpiada.mouseAdapterA);
							painelOlimpiada.alternativaB.setEnabled(false);
							painelOlimpiada.alternativaC.setEnabled(false);
							painelOlimpiada.alternativaE.setEnabled(false);
						//Se a resposta certa for B
						} else if(pergunta.getReposta2().equals(pergunta.getRepostaCerta())){
							painelOlimpiada.alternativaB.setForeground(new Color(0, 255, 9));
							painelOlimpiada.alternativaB.removeMouseListener(painelOlimpiada.mouseAdapterB);
							painelOlimpiada.alternativaA.setEnabled(false);
							painelOlimpiada.alternativaC.setEnabled(false);
							painelOlimpiada.alternativaE.setEnabled(false);
						//Se a resposta certa for C
						}else if(pergunta.getReposta3().equals(pergunta.getRepostaCerta())){
							painelOlimpiada.alternativaC.setForeground(new Color(0, 255, 9));
							painelOlimpiada.alternativaC.removeMouseListener(painelOlimpiada.mouseAdapterC);
							painelOlimpiada.alternativaB.setEnabled(false);
							painelOlimpiada.alternativaA.setEnabled(false);
							painelOlimpiada.alternativaE.setEnabled(false);
						//Se a resposta certa for E
						}else if(pergunta.getReposta5().equals(pergunta.getRepostaCerta())){
							painelOlimpiada.alternativaE.setForeground(new Color(0, 255, 9));
							painelOlimpiada.alternativaE.removeMouseListener(painelOlimpiada.mouseAdapterE);
							painelOlimpiada.alternativaB.setEnabled(false);
							painelOlimpiada.alternativaC.setEnabled(false);
							painelOlimpiada.alternativaA.setEnabled(false);
						}
					}
					tp.removePainelConfirmacao();
					
				}else if(alternativa.equals("E")){
					
					//Resposta Certa
					if(pergunta.getReposta5().equals(pergunta.getRepostaCerta())){
						painelOlimpiada.alternativaE.setForeground(new Color(16, 165, 16));
						painelOlimpiada.alternativaE.removeMouseListener(painelOlimpiada.mouseAdapterE);
						painelOlimpiada.alternativaB.setEnabled(false);
						painelOlimpiada.alternativaC.setEnabled(false);
						painelOlimpiada.alternativaD.setEnabled(false);
						painelOlimpiada.alternativaA.setEnabled(false);
						fachada.pontuar(participante, pontosPorQuestao);
					//Resposta Errada
					} else{
						//Trocando a cor pra vermelho
						painelOlimpiada.alternativaE.setForeground(new Color(250, 4, 4));
						//Removendp o mouse listener
						painelOlimpiada.alternativaE.removeMouseListener(painelOlimpiada.mouseAdapterE);
						//Se a resposta certa for A
						if(pergunta.getReposta1().equals(pergunta.getRepostaCerta())){
							painelOlimpiada.alternativaA.setForeground(new Color(0, 255, 9));
							painelOlimpiada.alternativaA.removeMouseListener(painelOlimpiada.mouseAdapterA);
							painelOlimpiada.alternativaB.setEnabled(false);
							painelOlimpiada.alternativaC.setEnabled(false);
							painelOlimpiada.alternativaD.setEnabled(false);
						//Se a resposta certa for B
						} else if(pergunta.getReposta2().equals(pergunta.getRepostaCerta())){
							painelOlimpiada.alternativaB.setForeground(new Color(0, 255, 9));
							painelOlimpiada.alternativaB.removeMouseListener(painelOlimpiada.mouseAdapterB);
							painelOlimpiada.alternativaA.setEnabled(false);
							painelOlimpiada.alternativaC.setEnabled(false);
							painelOlimpiada.alternativaD.setEnabled(false);
						//Se a resposta certa for C
						}else if(pergunta.getReposta3().equals(pergunta.getRepostaCerta())){
							painelOlimpiada.alternativaC.setForeground(new Color(0, 255, 9));
							painelOlimpiada.alternativaC.removeMouseListener(painelOlimpiada.mouseAdapterC);
							painelOlimpiada.alternativaB.setEnabled(false);
							painelOlimpiada.alternativaA.setEnabled(false);
							painelOlimpiada.alternativaD.setEnabled(false);
						//Se a resposta certa for D
						}else if(pergunta.getReposta4().equals(pergunta.getRepostaCerta())){
							painelOlimpiada.alternativaD.setForeground(new Color(0, 255, 9));
							painelOlimpiada.alternativaD.removeMouseListener(painelOlimpiada.mouseAdapterD);
							painelOlimpiada.alternativaB.setEnabled(false);
							painelOlimpiada.alternativaC.setEnabled(false);
							painelOlimpiada.alternativaA.setEnabled(false);
						}
					}
					tp.removePainelConfirmacao();
				}
				painelOlimpiada.setParticipanteVez(participante.getNome());//Seta o proximo participante na vez
				System.out.println("Dentro do confirmar: " + participante.getNome() + "/Pts.: "+ participante.getPontuacao());
			}
		});
		btnSim.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	//btnIniciar.setForeground(Color.BLACK);
		    	//btnSim.setIcon(icone2);
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	//btnIniciar.setForeground(cor);
		    	//btnSim.setIcon(icone);
		    }

		});
	
		
		//Botao nao
		btnNao.setMaximumSize(new Dimension(400, 90));
		btnNao.setPreferredSize(new Dimension(400, 90));
		btnNao.setFocusPainted(false);
		btnNao.setMargin(new Insets(2, 2, 2, 2));
		btnNao.setContentAreaFilled(false);
		btnNao.setBorderPainted(false);
		btnNao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNao.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 28));
		btnNao.setForeground(new Color(95,38,5));
		btnNao.setVerticalTextPosition(SwingConstants.CENTER);
		btnNao.setHorizontalTextPosition(SwingConstants.CENTER);

		setOpaque(false);
		btnNao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Ação Nao
				boolean resultado = false;
				tp.removePainelConfirmacao();
				painelOlimpiada.confirmar(resultado);
				return;
			}
		});
		btnNao.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	//btnIniciar.setForeground(Color.BLACK);
		    	//btnNao.setIcon(icone2);
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	//btnIniciar.setForeground(cor);
		    	//btnNao.setIcon(icone);
		    }

		});
		
		//Caixa botões
		Box caixaBotoes = Box.createVerticalBox();
		caixaBotoes.add(btnNao);
		caixaBotoes.add(Box.createVerticalStrut(15));
		caixaBotoes.add(btnSim);
		
		//Caixa Conteudo
		Box caixaConteudo = Box.createVerticalBox();
		caixaConteudo.add(Box.createVerticalStrut(300));
		caixaConteudo.add(enunciado);
		caixaConteudo.add(caixaBotoes);
		
		//Painel de conteudo
		JPanel painelConteudo = new JPanel();
		painelConteudo.add(caixaConteudo);
		painelConteudo.setBounds(new Rectangle(new Dimension(largura, altura)));
		painelConteudo.setOpaque(false);
		painelConteudo.revalidate();
		painelConteudo.repaint();
		
		painelCamada.add(painelPergaminho, new Integer(0), 0);
		painelCamada.add(painelConteudo, new Integer(1), 0);
		painelCamada.setPreferredSize(new Dimension(largura,altura));
		painelCamada.setMaximumSize(new Dimension(largura,altura));
		painelCamada.revalidate();
		painelCamada.repaint();
		
		add(painelCamada,BorderLayout.CENTER);
		setOpaque(false);
		
	}
	
	public boolean clicou(){
		boolean resultado = false;
		if(btnSim.isSelected()||btnNao.isSelected()){
			resultado = true;
		}
		return resultado;
	}

}
