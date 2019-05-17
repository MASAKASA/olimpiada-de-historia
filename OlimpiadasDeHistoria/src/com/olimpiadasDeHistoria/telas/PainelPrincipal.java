package com.olimpiadasDeHistoria.telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.omg.CORBA.TypeCodePackage.Bounds;

import com.olimpiadasDeHistoria.util.NomeDaTela;
import com.olimpiadasDeHistoria.util.ShadowText;
import java.awt.Component;
import javax.swing.SwingConstants;

//TELA CONCLUÍDA 29/08/2016
public class PainelPrincipal extends JPanel {
    
      //Criando icone dos botões
      ImageIcon icone = new ImageIcon(TelaPrincipal.class.getResource("/com/olimpiadasDeHistoria/imagens/botao_official.png"));
		
	  //Criando icone dos botões
	  ImageIcon icone2 = new ImageIcon(TelaPrincipal.class.getResource("/com/olimpiadasDeHistoria/imagens/btn_1.png"));
	  
	  //Criando os botões
	  JButton btnIniciar = new JButton("Iniciar", icone);
      JButton btnConfig = new JButton("Opções",icone);
      JButton btnSair = new JButton("Sair",icone);
      
    //Tela Principal
    TelaPrincipal tp;
    
	public PainelPrincipal(TelaPrincipal tp) {
		//Recebendo a Tela Principal
		this.tp = tp;
		
		//Criando caixa vertical
		Box caixa = Box.createVerticalBox();
		
		//Label Olimpíada
		ShadowText olimpiadaTitulo = new ShadowText("  Olimp\u00EDada de Hist\u00F3ria da FAFICA",new Font("Lucida Calligraphy", Font.BOLD, 45));
		olimpiadaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		olimpiadaTitulo.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 30));
		olimpiadaTitulo.setMaximumSize(new Dimension(1000, 100));
		olimpiadaTitulo.setPreferredSize(new Dimension(1000, 100));
		Color c = new Color(95,38,5);
		olimpiadaTitulo.setForeground(c);
	
		//Cor Texto Botão
		Color cor = new Color(81,41,1);
		
		//Logo Fafica
		JLabel labelFafica = new JLabel("                                                                                                       ");
		labelFafica.setMaximumSize(new Dimension(1000, 250));
		labelFafica.setPreferredSize(new Dimension(1000, 250));
		labelFafica.setHorizontalTextPosition(SwingConstants.LEFT);
		ImageIcon fafica = new ImageIcon(TelaPrincipal.class.getResource("/com/olimpiadasDeHistoria/imagens/fafica_grande.png"));
		labelFafica.setIcon(fafica);
		
		Box caixaLogoHorizontal = Box.createHorizontalBox();
		int largura = 700/2-labelFafica.getIcon().getIconWidth();
		caixaLogoHorizontal.add(Box.createHorizontalStrut(largura));
		caixaLogoHorizontal.setAlignmentX(Component.LEFT_ALIGNMENT);
		caixaLogoHorizontal.add(labelFafica);
		
		//Botão Iniciar
		btnIniciar.setMaximumSize(new Dimension(1000, 90));
		btnIniciar.setPreferredSize(new Dimension(1000, 90));
		btnIniciar.setFocusPainted(false);
		btnIniciar.setMargin(new Insets(2, 2, 2, 2));
		btnIniciar.setContentAreaFilled(false);
		btnIniciar.setBorderPainted(false);
		btnIniciar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIniciar.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 30));
		btnIniciar.setForeground(cor);
		btnIniciar.setVerticalTextPosition(SwingConstants.CENTER);
		btnIniciar.setHorizontalTextPosition(SwingConstants.CENTER);

		setOpaque(false);
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Ação Iniciar
				//Direcionar para a tela de escolha de participantes
				tp.mudarConteudo(NomeDaTela.TELA_ESCOLHA_PARTICIPANTES);
			}
		});
		btnIniciar.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	//btnIniciar.setForeground(Color.BLACK);
		    	btnIniciar.setIcon(icone2);
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	//btnIniciar.setForeground(cor);
		    	btnIniciar.setIcon(icone);
		    }

		});
		
		//Botão Configurações
		btnConfig.setMaximumSize(new Dimension(1000, 90));
		btnConfig.setPreferredSize(new Dimension(1000, 90));
		btnConfig.setFocusPainted(false);
		btnConfig.setMargin(new Insets(0, 0, 0, 0));
		btnConfig.setContentAreaFilled(false);
		btnConfig.setBorderPainted(false);
		btnConfig.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConfig.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 30));
		btnConfig.setForeground(cor);
		btnConfig.setVerticalTextPosition(SwingConstants.CENTER);
		btnConfig.setHorizontalTextPosition(SwingConstants.CENTER);
		setOpaque(false);
		btnConfig.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//Ação Configurações
				tp.mudarConteudo(NomeDaTela.TELA_CONFIG);
			}
		});
		btnConfig.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	//btnConfig.setForeground(Color.BLACK);
		    	btnConfig.setIcon(icone2);
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	//btnConfig.setForeground(cor);
		    	btnConfig.setIcon(icone);
		    }

		});
		
		//Botão Sair
		btnSair.setMaximumSize(new Dimension(1000, 90));
		btnSair.setPreferredSize(new Dimension(1000, 90));
		btnSair.setFocusPainted(false);
		btnSair.setMargin(new Insets(0, 0, 0, 0));
		btnSair.setContentAreaFilled(false);
		btnSair.setBorderPainted(false);
		btnSair.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSair.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 30));
		btnSair.setForeground(cor);
		btnSair.setVerticalTextPosition(SwingConstants.CENTER);
		btnSair.setHorizontalTextPosition(SwingConstants.CENTER);
		setOpaque(false);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Ação Sair
				tp.mudarConteudo(NomeDaTela.TELA_SAIR);
			}
		});
		btnSair.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	//btnSair.setForeground(Color.BLACK);
		    	btnSair.setIcon(icone2);
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	//btnSair.setForeground(cor);
		    	btnSair.setIcon(icone);
		    }

		});
		
		//Adicionando botões à caixa
		caixa.add(Box.createVerticalStrut(100));
		caixa.add(olimpiadaTitulo,CENTER_ALIGNMENT);
		caixa.add(Box.createVerticalStrut(17));
		caixa.add(labelFafica,CENTER_ALIGNMENT);
		caixa.add(btnIniciar,CENTER_ALIGNMENT);
		caixa.add(Box.createVerticalStrut(10));
		caixa.add(btnConfig,CENTER_ALIGNMENT);
		caixa.add(Box.createVerticalStrut(10));
		caixa.add(btnSair,CENTER_ALIGNMENT);
		
		//Adicionando caixa ao Painel
		add(caixa, BorderLayout.CENTER);
	}

	//get TelaPrincipal
	public TelaPrincipal getTp() {
		return tp;
	}

}
