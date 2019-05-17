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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.olimpiadasDeHistoria.fachada.Fachada;
import com.olimpiadasDeHistoria.modelo.participante.NomeParticipanteInvalidoException;
import com.olimpiadasDeHistoria.modelo.participante.Participante;
import com.olimpiadasDeHistoria.modelo.participante.ParticipanteJaCadastradoException;
import com.olimpiadasDeHistoria.modelo.pergunta.Pergunta;
import com.olimpiadasDeHistoria.modelo.pergunta.PerguntaJaCadastradaException;
import com.olimpiadasDeHistoria.util.FactoryCadastro;
import com.olimpiadasDeHistoria.util.IFactoryCadastro;
import com.olimpiadasDeHistoria.util.NomeDaTela;
import com.olimpiadasDeHistoria.util.ShadowText;
//TELA CONCLUÍDA 01/09/2016
public class PainelCadastroParticipante extends JPanel {
	
	//Criando icone dos botões
    ImageIcon icone = new ImageIcon(TelaPrincipal.class.getResource("/com/olimpiadasDeHistoria/imagens/botao_official.png"));
		
    //Criando icone dos botões
    ImageIcon icone2 = new ImageIcon(TelaPrincipal.class.getResource("/com/olimpiadasDeHistoria/imagens/btn_1.png"));
    
	//Criando os botões
	JButton btnCadastrarFinalizar = new JButton("Cadastrar", icone);
    JButton btnVoltar = new JButton("Voltar", icone);
    
    //Cor Texto Botão
  	Color cor = new Color(81,41,1);
  	
  	//Largura e Altura
  	int largura;
  	int altura;
  	
    //Tela Principal
    TelaPrincipal tp;
    
    //Fachada
    private static Fachada fachada;
    
    //FactoryCadastro e Participante
    private static Participante participante;
    private static IFactoryCadastro factoryCadastro;
    
	public PainelCadastroParticipante(TelaPrincipal tp, int largura, int altura) {
		//Recebendo a Tela Principal
		this.tp = tp;
		
		//Criando caixa vertical
		Box caixa = Box.createVerticalBox();
					
		//Label Menu
		ShadowText menu = new ShadowText(" Cadastro de Participantes",new Font("Lucida Calligraphy", Font.BOLD, 45));
		menu.setHorizontalAlignment(SwingConstants.CENTER);
		menu.setHorizontalTextPosition(SwingConstants.CENTER);
		menu.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 30));
		menu.setMaximumSize(new Dimension(700, 120));
		menu.setPreferredSize(new Dimension(700, 120));
		Color c = new Color(95,38,5);
		menu.setForeground(c);
		
		//Label Nome do Participante
		ShadowText lblNomeParticipante = new ShadowText("             Nome do Participante", new Font("Lucida Calligraphy", Font.BOLD, 30));
		lblNomeParticipante.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeParticipante.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNomeParticipante.setMaximumSize(new Dimension(700, 60));
		lblNomeParticipante.setPreferredSize(new Dimension(700, 60));
		
		//TextField Nome do Participante
		JTextField tfNomeParticipante = new JTextField();
		tfNomeParticipante.setAlignmentX(Component.LEFT_ALIGNMENT);
		tfNomeParticipante.setHorizontalAlignment(SwingConstants.CENTER);
		tfNomeParticipante.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 20));
		tfNomeParticipante.setMaximumSize(new Dimension(700, 40));
		tfNomeParticipante.setPreferredSize(new Dimension(700, 40));
		tfNomeParticipante.setForeground(Color.BLACK);
		tfNomeParticipante.setBorder(new LineBorder(new Color(95,38,5),2));
		
		//Botão Cadastrar e Finalizar
		btnCadastrarFinalizar.setMaximumSize(new Dimension(700, 90));
		btnCadastrarFinalizar.setPreferredSize(new Dimension(700, 90));
		btnCadastrarFinalizar.setFocusPainted(false);
		btnCadastrarFinalizar.setMargin(new Insets(2, 2, 2, 2));
		btnCadastrarFinalizar.setContentAreaFilled(false);
		btnCadastrarFinalizar.setBorderPainted(false);
		btnCadastrarFinalizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCadastrarFinalizar.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 30));
		btnCadastrarFinalizar.setForeground(cor);
		btnCadastrarFinalizar.setVerticalTextPosition(SwingConstants.CENTER);
		btnCadastrarFinalizar.setHorizontalTextPosition(SwingConstants.CENTER);
		setOpaque(true);
		btnCadastrarFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Ação Cadastrar e Finalizar
				try {
					//Fachada
					fachada = Fachada.getFachada();
					//Factory Cadastro
					factoryCadastro = new FactoryCadastro();
					participante = factoryCadastro.criarParticipante(tfNomeParticipante.getText());
					
					//Cadastrando Participante
					fachada.cadastrarParticipante(participante);
					
					tp.mostrarMensagem("         Cadastro realizado com sucesso!!", "                  Mensagem", NomeDaTela.TELA_CADASTRO_PARTICIPANTES);
				} catch (PerguntaJaCadastradaException exception) {
					tp.mostrarMensagem("    " + exception.getMessage(), "                       Erro", NomeDaTela.TELA_CADASTRO_PARTICIPANTES);
					System.out.println(exception.getMessage());
				} catch (NomeParticipanteInvalidoException exception) {
					tp.mostrarMensagem("    " + exception.getMessage(), "                       Erro", NomeDaTela.TELA_CADASTRO_PARTICIPANTES);
					System.out.println(exception.getMessage());
				} catch (ParticipanteJaCadastradoException exception) {
					tp.mostrarMensagem("    " + exception.getMessage(), "                       Erro", NomeDaTela.TELA_CADASTRO_PARTICIPANTES);
					System.out.println(exception.getMessage());
				} catch (Exception exception) {
					tp.mostrarMensagem("    " + exception.getMessage(), "                       Erro", NomeDaTela.TELA_CADASTRO_PARTICIPANTES);
					System.out.println(exception.getMessage());
				}
			}
		});
		btnCadastrarFinalizar.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnCadastrarFinalizar.setIcon(icone2);
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnCadastrarFinalizar.setIcon(icone);
		    }

		});
		
		//Botão Voltar
        btnVoltar.setMaximumSize(new Dimension(700, 90));
        btnVoltar.setPreferredSize(new Dimension(700, 90));
        btnVoltar.setFocusPainted(false);
        btnVoltar.setMargin(new Insets(0, 0, 0, 0));
        btnVoltar.setContentAreaFilled(false);
        btnVoltar.setBorderPainted(false);
		btnVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVoltar.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 30));
		btnVoltar.setForeground(cor);
		btnVoltar.setVerticalTextPosition(SwingConstants.CENTER);
		btnVoltar.setHorizontalTextPosition(SwingConstants.CENTER);
        setOpaque(false);
        btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Ação Voltar
				tp.mudarConteudo(NomeDaTela.TELA_CONFIG);
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
		caixa.add(Box.createVerticalStrut(90));
		caixa.add(lblNomeParticipante);
		caixa.add(Box.createVerticalStrut(10));
		caixa.add(tfNomeParticipante);
		caixa.add(Box.createVerticalStrut(60));
		caixa.add(btnCadastrarFinalizar,CENTER_ALIGNMENT);
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
