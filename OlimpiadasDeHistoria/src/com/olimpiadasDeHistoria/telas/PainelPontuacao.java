package com.olimpiadasDeHistoria.telas;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.olimpiadasDeHistoria.fachada.Fachada;
import com.olimpiadasDeHistoria.modelo.participante.Participante;
import com.olimpiadasDeHistoria.util.NomeDaTela;
import com.olimpiadasDeHistoria.util.ShadowText;

public class PainelPontuacao extends JPanel {

	//Criando icone dos botões
    ImageIcon icone = new ImageIcon(TelaPrincipal.class.getResource("/com/olimpiadasDeHistoria/imagens/botao_official.png"));
		
    //Criando icone dos botões
    ImageIcon icone2 = new ImageIcon(TelaPrincipal.class.getResource("/com/olimpiadasDeHistoria/imagens/btn_1.png"));
	
	//Criando o botão Voltar
	JButton btnOk = new JButton("Ok", icone);
	
	//Cor Texto Botão
	Color cor = new Color(81,41,1);
  	
    //Tela Principal
    TelaPrincipal tp;
    
    //Fachada
    Fachada fachada;
    
    //Hanking
    Participante participante;
    
    //Titulo da Tela
    ShadowText tituloTela;
    
    //Nome do Participante
    ShadowText nomeParticipante;
    
    //Pontuacao
    ShadowText pontuacao;
    
	public PainelPontuacao(TelaPrincipal tp, int largura, int altura) {
		//Recebendo a Tela Principal
		this.tp = tp;
		
		//try catch
		try {
			//Fachada
			fachada = Fachada.getFachada();
			
			//Criando caixa de conteúdo
			Box caixaVertical = Box.createVerticalBox();
			
			//Setando o titulo da tela
			tituloTela = new ShadowText("             Painel de Pontuação", new Font("Lucida Calligraphy", Font.BOLD, 45));
			tituloTela.setAlignmentX(Component.LEFT_ALIGNMENT);
			tituloTela.setHorizontalTextPosition(SwingConstants.CENTER);
			tituloTela.setMaximumSize(new Dimension(900, 120));
			tituloTela.setPreferredSize(new Dimension(900, 120));
			
			//Titulo de menu
			ShadowText menuSuperior = new ShadowText("        Classificação                       Pontos", new Font("Lucida Calligraphy", Font.BOLD, 35));
			menuSuperior.setAlignmentY(Component.TOP_ALIGNMENT);
			menuSuperior.setAlignmentX(Component.LEFT_ALIGNMENT);
			menuSuperior.setHorizontalTextPosition(SwingConstants.RIGHT);
			menuSuperior.setMaximumSize(new Dimension(950, 50));
			menuSuperior.setPreferredSize(new Dimension(950, 50));
			menuSuperior.setBackground(Color.BLACK);
			
			ShadowText linha = new ShadowText("  ----------------------------------------------------------------------", new Font("Lucida Calligraphy", Font.BOLD, 35));
			linha.setAlignmentY(Component.TOP_ALIGNMENT);
			linha.setAlignmentX(Component.LEFT_ALIGNMENT);
			linha.setHorizontalTextPosition(SwingConstants.RIGHT);
			linha.setMaximumSize(new Dimension(910, 40));
			linha.setPreferredSize(new Dimension(910, 40));
			
			Box caixaVerticalMenu = Box.createVerticalBox();
			caixaVerticalMenu.setAlignmentY(Component.TOP_ALIGNMENT);
			caixaVerticalMenu.add(Box.createVerticalStrut(5));
			caixaVerticalMenu.add(menuSuperior);
			caixaVerticalMenu.add(linha);
			
//			Box caixaHorizontalMenu = Box.createHorizontalBox();
//			caixaHorizontalMenu.setAlignmentX(Component.LEFT_ALIGNMENT);
//			caixaHorizontalMenu.add(caixaVerticalMenu);
			
			//Adicionando titulo da tela à caixa de conteúdo
			caixaVertical.add(Box.createVerticalStrut(100));
			caixaVertical.add(tituloTela);
			caixaVertical.add(Box.createVerticalStrut(35));
			caixaVertical.add(caixaVerticalMenu);
			
			//Box de lista de participante
			Box caixaVerticalParticipante = Box.createVerticalBox();
			
			//Recuperando a lista de Participantes e suas respecttivas pontuações
			List<Participante> listaParticipantes = fachada.hanking();
			
			//Percorrendo a lista de Participantes
			for(int i=0; i<listaParticipantes.size(); i++){
				
				Participante participante = listaParticipantes.get(i);
				nomeParticipante = new ShadowText(participante.getNome(), new Font("Lucida Calligraphy", Font.BOLD, 35));
				nomeParticipante.setAlignmentX(Component.LEFT_ALIGNMENT);
				nomeParticipante.setHorizontalTextPosition(SwingConstants.CENTER);
				nomeParticipante.setMaximumSize(new Dimension(500, 60));
				nomeParticipante.setPreferredSize(new Dimension(500, 60));
				nomeParticipante.setBackground(Color.BLACK);
				nomeParticipante.setOpaque(true);
				
				pontuacao = new ShadowText(String.valueOf(participante.getPontuacao()), new Font("Lucida Calligraphy", Font.BOLD, 35));
				pontuacao.setAlignmentX(Component.LEFT_ALIGNMENT);
				pontuacao.setHorizontalTextPosition(SwingConstants.RIGHT);
				pontuacao.setMaximumSize(new Dimension(100, 60));
				pontuacao.setPreferredSize(new Dimension(100,60));
				
				JLabel ouro = new JLabel("");
				ouro.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/com/olimpiadasDeHistoria/imagens/ouro.png")));
				
				JLabel prata = new JLabel("");
				prata.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/com/olimpiadasDeHistoria/imagens/prata.png")));
				
				JLabel bronze = new JLabel("");
				bronze.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/com/olimpiadasDeHistoria/imagens/bronze.png")));
				
				JLabel imagem = new JLabel("  " + String.valueOf(i+1));
				imagem.setMaximumSize(new Dimension(ouro.getIcon().getIconWidth(),ouro.getIcon().getIconHeight()));
				imagem.setPreferredSize(new Dimension(ouro.getIcon().getIconWidth(),ouro.getIcon().getIconHeight()));
				imagem.setFont(new Font("Lucida Calligraphy", Font.BOLD, 40));
				imagem.setForeground(cor);
				imagem.setOpaque(false);
				
				Box caixaHorizontal = Box.createHorizontalBox();
				caixaHorizontal.setAlignmentX(Component.LEFT_ALIGNMENT);
				caixaHorizontal.add(Box.createHorizontalStrut(20));
				
				Box caixaHorizontal2 = Box.createHorizontalBox();
				caixaHorizontal2.setAlignmentX(Component.LEFT_ALIGNMENT);
				
				//Medalhas
				if(i == 0){
					caixaHorizontal.add(ouro);
				}else  if(i == 1){
					caixaHorizontal.add(prata);
				}else  if(i == 2){
					caixaHorizontal.add(bronze);
				}else {
					caixaHorizontal.add(imagem);
				}
				
				Box caixaNome = Box.createVerticalBox();
				caixaNome.add(Box.createVerticalStrut(20));
				caixaNome.add(nomeParticipante);
				
				caixaHorizontal.add(caixaNome);
				
				Box caixaPontuacao = Box.createVerticalBox();
				caixaPontuacao.add(Box.createVerticalStrut(20));
				caixaPontuacao.add(pontuacao);
				caixaHorizontal.add(caixaPontuacao);
				
				caixaVerticalParticipante.add(caixaHorizontal);
				
			}
			
			
			//Botão Ok
			btnOk.setAlignmentX(Component.LEFT_ALIGNMENT);
			btnOk.setMaximumSize(new Dimension(880, 90));
			btnOk.setPreferredSize(new Dimension(880, 90));
			btnOk.setFocusPainted(false);
			btnOk.setMargin(new Insets(0, 0, 0, 0));
	        btnOk.setContentAreaFilled(false);
	        btnOk.setBorderPainted(false);
	        btnOk.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	        btnOk.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 30));
	        btnOk.setForeground(cor);
	        btnOk.setVerticalTextPosition(SwingConstants.CENTER);
			btnOk.setHorizontalTextPosition(SwingConstants.CENTER);
	        setOpaque(false);
	        btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Ação Ok
					tp.mudarConteudo(NomeDaTela.TELA_CONFIG);
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

	        //Adicionando botão na caixa horizontal botão
	        Box caixaBotao = Box.createHorizontalBox();
	        caixaBotao.setAlignmentX(Component.LEFT_ALIGNMENT);
	        caixaBotao.add(btnOk);
	        
	        //Adicionando caixa botão à caixa vertical
	        caixaVerticalParticipante.add(Box.createVerticalStrut(50));
	        caixaVerticalParticipante.add(caixaBotao);
	        
	        ///Painel de Scroll que recebe a caixa
			JScrollPane scrollPane = new JScrollPane(caixaVerticalParticipante);		
			scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
			scrollPane.setMaximumSize(new Dimension(905,380));
	    	scrollPane.setPreferredSize(new Dimension(905,380));
	    	scrollPane.setOpaque(false);
	    	scrollPane.getViewport().setOpaque(false);
	    	scrollPane.setBorder(new LineBorder(Color.BLACK,0));
	    	
	    	Box caixa = Box.createHorizontalBox();
	    	caixa.setAlignmentX(Component.LEFT_ALIGNMENT);
	    	caixa.add(Box.createHorizontalStrut(25));
	    	
	    	caixa.add(scrollPane);
	    	//Adicionando painel a caixa Vertical
	    	caixaVertical.add(caixa);
	    	
			//Adicionando Painel de Scroll ao painel
			add(caixaVertical);
			
			//escondendo background
			setOpaque(false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
