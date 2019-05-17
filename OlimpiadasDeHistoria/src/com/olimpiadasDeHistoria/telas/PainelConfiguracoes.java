package com.olimpiadasDeHistoria.telas;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.olimpiadasDeHistoria.util.NomeDaTela;
import com.olimpiadasDeHistoria.util.ShadowText;

//TELA CONCLUÍDA 29/08/2016
public class PainelConfiguracoes extends JPanel {
	
	//Criando icone dos botões
    ImageIcon icone = new ImageIcon(TelaPrincipal.class.getResource("/com/olimpiadasDeHistoria/imagens/botao_official.png"));
		
    //Criando icone dos botões
    ImageIcon icone2 = new ImageIcon(TelaPrincipal.class.getResource("/com/olimpiadasDeHistoria/imagens/btn_1.png"));

	//Criando os botões
	JButton btnCadastrarQuestao = new JButton("+ Questão",icone);
    JButton btnCadastrarParticipante = new JButton("+ Participante",icone);
    JButton btnVoltar = new JButton("Voltar",icone);
    JButton btnHanking = new JButton("Pontuação", icone);
    
    //Cor Texto Botão
  	Color cor = new Color(95,38,5);
  		
    //Tela Principal
    TelaPrincipal tp;
	    
		public PainelConfiguracoes(TelaPrincipal tp) {
			//Recebendo a Tela Principal
			this.tp = tp;
			
			//Criando caixa vertical
			Box caixa = Box.createVerticalBox();
						
			//Label Menu
			ShadowText menu = new ShadowText("   Menu Configurações",new Font("Lucida Calligraphy", Font.BOLD, 45));
			menu.setHorizontalAlignment(SwingConstants.CENTER);
			menu.setHorizontalTextPosition(SwingConstants.CENTER);
			menu.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 30));
			menu.setMaximumSize(new Dimension(610, 120));
			menu.setPreferredSize(new Dimension(610, 120));
			Color c = new Color(95,38,5);
			menu.setForeground(c);
			
			//Botão Cadastrar Questão
			btnCadastrarQuestao.setMaximumSize(new Dimension(610, 90));
			btnCadastrarQuestao.setPreferredSize(new Dimension(610, 90));
			btnCadastrarQuestao.setFocusPainted(false);
			btnCadastrarQuestao.setMargin(new Insets(2, 2, 2, 2));
			btnCadastrarQuestao.setContentAreaFilled(false);
			btnCadastrarQuestao.setBorderPainted(false);
			btnCadastrarQuestao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnCadastrarQuestao.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 25));
			btnCadastrarQuestao.setForeground(cor);
			btnCadastrarQuestao.setVerticalTextPosition(SwingConstants.CENTER);
			btnCadastrarQuestao.setHorizontalTextPosition(SwingConstants.CENTER);
			setOpaque(true);
			btnCadastrarQuestao.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Ação Cadastrar Questão
					tp.mudarConteudo(NomeDaTela.TELA_CADASTRO_QUESTAO);
				}
			});
			btnCadastrarQuestao.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	btnCadastrarQuestao.setIcon(icone2);
			    }
			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	btnCadastrarQuestao.setIcon(icone);
			    }

			});
			
			//Botão Cadastrar Participante
			btnCadastrarParticipante.setMaximumSize(new Dimension(610, 90));
			btnCadastrarParticipante.setPreferredSize(new Dimension(610, 90));
			btnCadastrarParticipante.setFocusPainted(false);
			btnCadastrarParticipante.setMargin(new Insets(0, 0, 0, 0));
			btnCadastrarParticipante.setContentAreaFilled(false);
			btnCadastrarParticipante.setBorderPainted(false);
			btnCadastrarParticipante.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnCadastrarParticipante.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 25));
			btnCadastrarParticipante.setForeground(cor);
			btnCadastrarParticipante.setVerticalTextPosition(SwingConstants.CENTER);
			btnCadastrarParticipante.setHorizontalTextPosition(SwingConstants.CENTER);
	        setOpaque(false);
	        btnCadastrarParticipante.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Ação Cadastrar Participante
					tp.mudarConteudo(NomeDaTela.TELA_CADASTRO_PARTICIPANTES);
				}
			});
	        btnCadastrarParticipante.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	btnCadastrarParticipante.setIcon(icone2);
			    }
			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	btnCadastrarParticipante.setIcon(icone);
			    }

			});
	        
	        //Botão Pontuação
			btnHanking.setMaximumSize(new Dimension(610, 90));
			btnHanking.setPreferredSize(new Dimension(610, 90));
			btnHanking.setAlignmentX(LEFT_ALIGNMENT);
			btnHanking.setFocusPainted(false);
			btnHanking.setMargin(new Insets(2, 2, 2, 2));
			btnHanking.setContentAreaFilled(false);
			btnHanking.setBorderPainted(false);
			btnHanking.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnHanking.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 25));
			btnHanking.setForeground(cor);
			btnHanking.setVerticalTextPosition(SwingConstants.CENTER);
			btnHanking.setHorizontalTextPosition(SwingConstants.CENTER);
			setOpaque(true);
			btnHanking.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Ação Hanking
					tp.mudarConteudo(NomeDaTela.TELA_HANKING);
				}
			});
			btnHanking.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	btnHanking.setIcon(icone2);
			    }
			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	btnHanking.setIcon(icone);
			    }

			});
			
			//Botão Voltar
	        btnVoltar.setMaximumSize(new Dimension(610, 90));
	        btnVoltar.setPreferredSize(new Dimension(610, 90));
	        btnVoltar.setFocusPainted(false);
	        btnVoltar.setMargin(new Insets(0, 0, 0, 0));
	        btnVoltar.setContentAreaFilled(false);
	        btnVoltar.setBorderPainted(false);
			btnVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnVoltar.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 25));
			btnVoltar.setVerticalTextPosition(SwingConstants.CENTER);
			btnVoltar.setHorizontalTextPosition(SwingConstants.CENTER);
			btnVoltar.setForeground(cor);
	        setOpaque(false);
	        btnVoltar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Ação Voltar
					tp.mudarConteudo(NomeDaTela.TELA_PRINCIPAL);
				}
			});
	        btnVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	btnVoltar.setIcon(icone2);
			    }
			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	btnVoltar.setIcon(icone);
			    }

			});
			
			//Adicionando botões à caixa
			caixa.add(Box.createVerticalStrut(100));
			caixa.add(menu,CENTER_ALIGNMENT);
			caixa.add(Box.createVerticalStrut(80));
			caixa.add(btnCadastrarQuestao,CENTER_ALIGNMENT);
			caixa.add(Box.createVerticalStrut(10));
			caixa.add(btnCadastrarParticipante,CENTER_ALIGNMENT);
			caixa.add(Box.createVerticalStrut(10));
			caixa.add(btnHanking,CENTER_ALIGNMENT);
			caixa.add(Box.createVerticalStrut(10));
			caixa.add(btnVoltar,CENTER_ALIGNMENT);
			
			//Adicionando caixa ao Painel
			add(caixa);
		}
		
		//get TelaPrincipal
		public TelaPrincipal getTp() {
			return tp;
		}

}
