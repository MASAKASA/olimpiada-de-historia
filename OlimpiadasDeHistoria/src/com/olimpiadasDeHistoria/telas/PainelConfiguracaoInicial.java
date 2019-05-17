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
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.olimpiadasDeHistoria.fachada.Fachada;
import com.olimpiadasDeHistoria.modelo.participante.Participante;
import com.olimpiadasDeHistoria.modelo.pergunta.Pergunta;
import com.olimpiadasDeHistoria.modelo.pergunta.PerguntaNaoCadastradaException;
import com.olimpiadasDeHistoria.util.NomeDaTela;
import com.olimpiadasDeHistoria.util.ShadowText;

public class PainelConfiguracaoInicial extends JPanel {

	//Criando icone dos botões
    ImageIcon icone = new ImageIcon(TelaPrincipal.class.getResource("/com/olimpiadasDeHistoria/imagens/botao_official.png"));
		
    //Criando icone dos botões
    ImageIcon icone2 = new ImageIcon(TelaPrincipal.class.getResource("/com/olimpiadasDeHistoria/imagens/btn_1.png"));
	
	//Criando os botões
    JButton btnSalvar = new JButton("Salvar" ,icone);
    JButton btnVoltar = new JButton("Voltar", icone);
    
    //Cor Texto Botão
  	Color cor = new Color(81,41,1);
  	
    //Tela Principal
    TelaPrincipal tp;
    
    //Fachada
    private static Fachada fachada;
    
	public PainelConfiguracaoInicial(TelaPrincipal tp, List<Participante> listaParticipantes) {
		//Recebendo a Tela Principal
		this.tp = tp;
		
		//Criando caixa vertical
		Box caixaVertical = Box.createVerticalBox();
					
		//Label Titulo
		ShadowText titulo = new ShadowText("   Antes de Iniciar",new Font("Lucida Calligraphy", Font.BOLD, 45));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setHorizontalTextPosition(SwingConstants.CENTER);
		titulo.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 30));
		titulo.setMaximumSize(new Dimension(610, 120));
		titulo.setPreferredSize(new Dimension(610, 120));
		
		//Label Quantidade de Rodadas
		ShadowText numRodadas = new ShadowText("          Número de Rodadas:",new Font("Lucida Calligraphy", Font.BOLD, 30));
		numRodadas.setHorizontalAlignment(SwingConstants.CENTER);
		numRodadas.setHorizontalTextPosition(SwingConstants.CENTER);
		numRodadas.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 30));
		numRodadas.setMaximumSize(new Dimension(610, 60));
		numRodadas.setPreferredSize(new Dimension(610, 60));
		
		
		try {
			//Instanciando fachada
			fachada = Fachada.getFachada();
			
			//Lista Perguntas
			List<Pergunta> listaPerguntas;
			listaPerguntas = fachada.listaPerguntas();
			
			//Guardando a quantidade de rodadas que podem ser escolhidas de acordo com o número de perguntas e jogadores cadastrados
			int qtdadeRodadasDisponiveis = listaPerguntas.size()/listaParticipantes.size();
			
			//ComboBox Quantidade de Rodadas
			JComboBox comboRodadas = new JComboBox();;
			comboRodadas.setAlignmentX(LEFT_ALIGNMENT);
			comboRodadas.setAlignmentY(CENTER_ALIGNMENT);
			comboRodadas.setMaximumSize(new Dimension(610,40));
			comboRodadas.setPreferredSize(new Dimension(610,40));
			comboRodadas.setFont(new Font("Lucida Calligraphy", Font.BOLD, 30));
			comboRodadas.setBorder(new LineBorder(new Color(95, 38,5),2));
			comboRodadas.setBackground(new Color(255,255,255));
			
			//For pra preencher o combobox
			for(int i = 0; i<qtdadeRodadasDisponiveis;i++){
				comboRodadas.addItem(i + 1);
			}
			
			//Label Pontos por acerto
			ShadowText pontosAcerto = new ShadowText("   Pontos por questão acertada:",new Font("Lucida Calligraphy", Font.BOLD, 30));
			pontosAcerto.setHorizontalAlignment(SwingConstants.CENTER);
			pontosAcerto.setHorizontalTextPosition(SwingConstants.CENTER);
			pontosAcerto.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 30));
			pontosAcerto.setMaximumSize(new Dimension(610, 60));
			pontosAcerto.setPreferredSize(new Dimension(610, 60));
			
			//ComboBox Pontos por acerto
			JComboBox comboPontos = new JComboBox();;
			comboPontos.setAlignmentX(LEFT_ALIGNMENT);
			comboPontos.setMaximumSize(new Dimension(610,40));
			comboPontos.setPreferredSize(new Dimension(610,40));
			comboPontos.setFont(new Font("Lucida Calligraphy", Font.BOLD, 30));
			comboPontos.setBorder(new LineBorder(new Color(95, 38,5),2));
			comboPontos.setBackground(new Color(255,255,255));
			
			//For pra preencher o combobox
			for(int i = 0; i<100;i++){
				comboPontos.addItem(i + 1);
			}
			
			//Botão Salvar
			btnSalvar.setMaximumSize(new Dimension(610, 90));
			btnSalvar.setPreferredSize(new Dimension(610, 90));
			btnSalvar.setFocusPainted(false);
			btnSalvar.setMargin(new Insets(2, 2, 2, 2));
			btnSalvar.setContentAreaFilled(false);
			btnSalvar.setBorderPainted(false);
			btnSalvar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnSalvar.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 30));
			btnSalvar.setForeground(cor);
			btnSalvar.setVerticalTextPosition(SwingConstants.CENTER);
			btnSalvar.setHorizontalTextPosition(SwingConstants.CENTER);
			setOpaque(true);
			btnSalvar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Ação Salvar Configurações
					Integer pontosPorQuestao = (Integer) comboPontos.getSelectedItem();
					Integer numeroRodadas = (Integer) comboRodadas.getSelectedItem();
					int rodadaAtual = 1;
					tp.iniciarOlimpiada(numeroRodadas,rodadaAtual,pontosPorQuestao, listaParticipantes);
				}
			});
			btnSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	btnSalvar.setIcon(icone2);
			    }
			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	btnSalvar.setIcon(icone);
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
			btnVoltar.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 30));
			btnVoltar.setForeground(cor);
			btnVoltar.setVerticalTextPosition(SwingConstants.CENTER);
			btnVoltar.setHorizontalTextPosition(SwingConstants.CENTER);
	        setOpaque(false);
	        btnVoltar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Ação Voltar
					tp.mudarConteudo(NomeDaTela.TELA_ESCOLHA_PARTICIPANTES);
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
			
			//Adicionando componentes á caixa vertical
			caixaVertical.add(Box.createVerticalStrut(75));
			caixaVertical.add(titulo,CENTER_ALIGNMENT);
			caixaVertical.add(Box.createVerticalStrut(65));
			caixaVertical.add(numRodadas);
			caixaVertical.add(Box.createVerticalStrut(10));
			caixaVertical.add(comboRodadas);
			caixaVertical.add(Box.createVerticalStrut(20));
			caixaVertical.add(pontosAcerto);
			caixaVertical.add(Box.createVerticalStrut(10));
			caixaVertical.add(comboPontos);
			caixaVertical.add(Box.createVerticalStrut(60));
			caixaVertical.add(btnSalvar,CENTER_ALIGNMENT);
			caixaVertical.add(btnVoltar,CENTER_ALIGNMENT);
			
			Box caixaHorizontal = Box.createHorizontalBox();
			caixaHorizontal.add(Box.createHorizontalStrut(35));
			caixaHorizontal.add(caixaVertical);
			
			//Adicionando caixa ao Painel
			add(caixaHorizontal);
		} catch (PerguntaNaoCadastradaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

}
