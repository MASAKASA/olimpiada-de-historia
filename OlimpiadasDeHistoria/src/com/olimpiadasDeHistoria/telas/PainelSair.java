package com.olimpiadasDeHistoria.telas;

import java.awt.BorderLayout;
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
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.olimpiadasDeHistoria.util.ConexaoBanco;
import com.olimpiadasDeHistoria.util.NomeDaTela;
import com.olimpiadasDeHistoria.util.ShadowText;
import java.awt.FlowLayout;

//TELA CONCLUÍDA 29/08/2016
public class PainelSair extends JPanel {

	//Criando icone dos botões
    ImageIcon icone = new ImageIcon(TelaPrincipal.class.getResource("/com/olimpiadasDeHistoria/imagens/botao_official.png"));
		
    //Criando icone dos botões
    ImageIcon icone2 = new ImageIcon(TelaPrincipal.class.getResource("/com/olimpiadasDeHistoria/imagens/btn_1.png"));
	
	//Criando os botões
	JButton btnSim = new JButton("Sim",icone);
    JButton btnNao = new JButton("Não",icone);
    
    //Cor Texto Botão
  	Color cor = new Color(95,38,5);
  		
    //Tela Principal
    TelaPrincipal tp;
	    
	public PainelSair(TelaPrincipal tp) {
		//Recebendo a Tela Principal
		this.tp = tp;
		
		//Criando caixa vertical
		Box caixaVertical = Box.createVerticalBox();
		
		//Criando caixa horizontal
		Box caixaHorizontal = Box.createHorizontalBox();
		
		//Label Pergunta
		ShadowText pergunta = new ShadowText("Deseja realmente sair?",new Font("Lucida Calligraphy", Font.BOLD, 45));
		pergunta.setHorizontalAlignment(SwingConstants.CENTER);
		pergunta.setHorizontalTextPosition(SwingConstants.CENTER);
		pergunta.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 30));
		pergunta.setMaximumSize(new Dimension(610, 120));
		pergunta.setPreferredSize(new Dimension(610, 120));
		Color c = new Color(95,38,5);
		pergunta.setForeground(c);
				
		//Botão Sim
		btnSim.setMaximumSize(new Dimension(610, 90));
		btnSim.setPreferredSize(new Dimension(610, 90));
		btnSim.setFocusPainted(false);
		btnSim.setMargin(new Insets(2, 2, 2, 2));
		btnSim.setContentAreaFilled(false);
		btnSim.setBorderPainted(false);
		btnSim.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSim.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 30));
		btnSim.setForeground(cor);
		btnSim.setVerticalTextPosition(SwingConstants.CENTER);
		btnSim.setHorizontalTextPosition(SwingConstants.CENTER);
		setOpaque(true);
		btnSim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Ação Sim
				try {
					ConexaoBanco.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.exit(0);
			}
		});
		btnSim.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnSim.setIcon(icone2);
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnSim.setIcon(icone);
		    }

		});
		
		//Botão Não
		btnNao.setMaximumSize(new Dimension(610, 90));
		btnNao.setPreferredSize(new Dimension(610, 90));
		btnNao.setFocusPainted(false);
		btnNao.setMargin(new Insets(0, 0, 0, 0));
		btnNao.setContentAreaFilled(false);
		btnNao.setBorderPainted(false);
		btnNao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNao.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 30));
		btnNao.setForeground(cor);
		btnNao.setVerticalTextPosition(SwingConstants.CENTER);
		btnNao.setHorizontalTextPosition(SwingConstants.CENTER);
        setOpaque(false);
        btnNao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Ação Não
				tp.mudarConteudo(NomeDaTela.TELA_PRINCIPAL);
			}
		});
        btnNao.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnNao.setIcon(icone2);
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnNao.setIcon(icone);
		    }

		});
        
		//Adicionando componentes à caixa vertical
		caixaVertical.add(Box.createVerticalStrut(100));
		caixaVertical.add(pergunta,CENTER_ALIGNMENT);
		caixaVertical.add(Box.createVerticalStrut(180));
		caixaVertical.add(btnSim,CENTER_ALIGNMENT);
		caixaVertical.add(Box.createVerticalStrut(10));
		caixaVertical.add(btnNao,CENTER_ALIGNMENT);
		
		//Adicionando caixa ao Painel
		add(caixaVertical,BorderLayout.CENTER);
	}

	public TelaPrincipal getTp() {
		return tp;
	}

}
