package com.olimpiadasDeHistoria.telas;

import java.awt.Color;
import java.awt.Component;
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

import com.olimpiadasDeHistoria.util.NomeDaTela;
import com.olimpiadasDeHistoria.util.ShadowText;
//TELA CONCLUÍDA 01/09/2016
public class PainelMensagem extends JPanel {
	
	//Criando icone dos botões
    ImageIcon icone = new ImageIcon(TelaPrincipal.class.getResource("/com/olimpiadasDeHistoria/imagens/botao_official.png"));
		
    //Criando icone dos botões
    ImageIcon icone2 = new ImageIcon(TelaPrincipal.class.getResource("/com/olimpiadasDeHistoria/imagens/btn_1.png"));
	
	//Criando o botão
	JButton btnOk = new JButton("Ok", icone);
	
	//Cor Texto Botão
	Color cor = new Color(255,255,255);
		
	//Label Título
	ShadowText tituloTela;
	
	//Label Título
	ShadowText mensagemTela;
	
	String mensagem = "";
	TelaPrincipal tp;
	String titulo = "";
	String nomeDaTela = "";

	public PainelMensagem(TelaPrincipal tp,String mensagem, String titulo, String nomeDaTela) {
		//Recebendo a Tela Principal
		this.tp = tp;
		
		//Recebendo mensagem
		this.mensagem = mensagem;
		
		//Recebendo titulo da tela
		this.titulo = titulo;
		
		//Recebendo a tela
		this.nomeDaTela = nomeDaTela;
	
		//Setando o titulo da tela
		tituloTela = new ShadowText(titulo, new Font("Lucida Calligraphy", Font.BOLD, 45));
		tituloTela.setAlignmentX(Component.LEFT_ALIGNMENT);
		tituloTela.setHorizontalTextPosition(SwingConstants.CENTER);
		tituloTela.setMaximumSize(new Dimension(900, 120));
		tituloTela.setPreferredSize(new Dimension(900, 120));
		
		//Setando a mensagem da tela
		mensagemTela = new ShadowText(mensagem, new Font("Lucida Calligraphy", Font.BOLD, 35));
		mensagemTela.setAlignmentX(Component.LEFT_ALIGNMENT);
		mensagemTela.setHorizontalTextPosition(SwingConstants.CENTER);
		mensagemTela.setMaximumSize(new Dimension(900, 120));
		mensagemTela.setPreferredSize(new Dimension(900, 120));
		
		//Botão Ok
		btnOk.setAlignmentX(Component.LEFT_ALIGNMENT);
		btnOk.setMaximumSize(new Dimension(900, 90));
		btnOk.setPreferredSize(new Dimension(900, 90));
		btnOk.setFocusPainted(false);
		btnOk.setMargin(new Insets(0, 0, 0, 0));
        btnOk.setContentAreaFilled(false);
        btnOk.setBorderPainted(false);
        btnOk.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnOk.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 30));
        btnOk.setVerticalTextPosition(SwingConstants.CENTER);
		btnOk.setHorizontalTextPosition(SwingConstants.CENTER);
        btnOk.setForeground(cor);
        setOpaque(false);
        btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Ação Ok
				tp.mudarConteudo(nomeDaTela);
			}
		});
        btnOk.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnOk.setIcon(icone2);
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnOk.setIcon(icone);
		    }

		});

        //Criando caixa
        Box caixa = Box.createVerticalBox();
        
        //Adicionando conteúdo à caixa
        caixa.add(Box.createVerticalStrut(75));
        caixa.add(tituloTela, CENTER_ALIGNMENT);
        caixa.add(Box.createVerticalStrut(200));
        caixa.add(mensagemTela,CENTER_ALIGNMENT);
        caixa.add(Box.createVerticalStrut(20));
        caixa.add(btnOk,CENTER_ALIGNMENT);
        
        //Adicionando caixa ao painel
        add(caixa);
	}

}