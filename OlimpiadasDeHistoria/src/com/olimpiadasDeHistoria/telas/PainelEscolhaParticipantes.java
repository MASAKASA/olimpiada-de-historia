package com.olimpiadasDeHistoria.telas;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.olimpiadasDeHistoria.fachada.Fachada;
import com.olimpiadasDeHistoria.modelo.participante.Participante;
import com.olimpiadasDeHistoria.modelo.pergunta.Pergunta;
import com.olimpiadasDeHistoria.util.IFactoryCadastro;
import com.olimpiadasDeHistoria.util.NomeDaTela;
import com.olimpiadasDeHistoria.util.ShadowText;

public class PainelEscolhaParticipantes extends JPanel {

	//Criando icone dos botões
    ImageIcon icone = new ImageIcon(TelaPrincipal.class.getResource("/com/olimpiadasDeHistoria/imagens/botao_official.png"));
		
    //Criando icone dos botões
    ImageIcon icone2 = new ImageIcon(TelaPrincipal.class.getResource("/com/olimpiadasDeHistoria/imagens/btn_1.png"));
	
	//Criando os botões
	JButton btnSalvar = new JButton("Começar", icone);
	JButton btnZerarPontuacao = new JButton("Zerar Pontos" ,icone);
    JButton btnZerarParticipante = new JButton("Excluir" ,icone);
    JButton btnVoltar = new JButton("Voltar", icone);
    JButton btnEscolher = new JButton("Escolher >>>", icone);
    
    //Cor Texto Botão
  	Color cor = new Color(81,41,1);
  	
    //Tela Principal
    TelaPrincipal tp;
    
    private static Pergunta pergunta;
	private static Fachada fachada;
	private static IFactoryCadastro factoryCadastro;
	private JList listaEscolhidos;
	private JList listaParticipantes;
	private List<Participante> listaParticipante;
	private String[] nomesParticipantes;
	private List<String> listaNome;
    
	public PainelEscolhaParticipantes(TelaPrincipal tp, int largura, int altura) {
		//Recebendo a Tela Principal
		this.tp = tp;
		
		//Criando caixa horizontal maior
		Box caixaHorizontal = Box.createHorizontalBox();
			
		//Criando caixa vertical com os participantes
		Box caixaVerticalParticipantes = Box.createVerticalBox();
		caixaVerticalParticipantes.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		//Label Menu Seleção de Participantes
		ShadowText menu = new ShadowText("        Seleção de Participantes", new Font("Lucida Calligraphy", Font.BOLD, 45));
		menu.setTexto("                   Sele\u00E7\u00E3o de Participantes");
		menu.setVerticalAlignment(SwingConstants.TOP);
		menu.setHorizontalAlignment(SwingConstants.CENTER);
		menu.setHorizontalTextPosition(SwingConstants.CENTER);
		menu.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 30));
		menu.setMaximumSize(new Dimension(1200, 120));
		menu.setPreferredSize(new Dimension(900, 120));
		Color c = new Color(95,38,5);
		menu.setForeground(c);
		
		//Label Escolha
		ShadowText lblEscolha = new ShadowText("            Escolha os participantes dessa olimpíada:", new Font("Lucida Calligraphy", Font.BOLD, 30));
		lblEscolha.setTexto("                      Escolha os participantes dessa olimp\u00EDada:");
		lblEscolha.setHorizontalAlignment(SwingConstants.CENTER);
		lblEscolha.setHorizontalTextPosition(SwingConstants.CENTER);
		lblEscolha.setMaximumSize(new Dimension(1200, 60));
		lblEscolha.setPreferredSize(new Dimension(120, 60));
		
		//Label Dica
		ShadowText lblDica = new ShadowText("                   Pressione 'Ctrl' para selecionar mais de um participante", new Font("Lucida Calligraphy", Font.BOLD, 20));
		lblDica.setTexto("                                      Pressione 'Ctrl' para selecionar mais de um participante");
		lblDica.setHorizontalAlignment(SwingConstants.CENTER);
		lblDica.setHorizontalTextPosition(SwingConstants.CENTER);
		lblDica.setMaximumSize(new Dimension(1200, 50));
		lblDica.setPreferredSize(new Dimension(900, 50));
		
		try {
			//Fachada
			fachada = Fachada.getFachada();
			
			//Recebendo a Lista de Participantes
			listaParticipante = fachada.listarParticipantes();
			
			nomesParticipantes = new String[listaParticipante.size()];
			
			//Percorrendo a lista e adicionando os nomes em um array
			for (int i = 0; i < listaParticipante.size(); i++) {
				Participante p = listaParticipante.get(i);
				nomesParticipantes[i] = p.getNome();
			}
			listaParticipantes = new JList(nomesParticipantes);
			listaParticipantes.setVisibleRowCount(1);
			listaParticipantes.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			listaParticipantes.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 20));
			listaParticipantes.setForeground(cor);
			
			//Botão Escolher
			btnEscolher.setMaximumSize(new Dimension(300, 90));
			btnEscolher.setPreferredSize(new Dimension(300, 90));
			btnEscolher.setFocusPainted(false);
			btnEscolher.setMargin(new Insets(2, 2, 2, 2));
			btnEscolher.setContentAreaFilled(false);
			btnEscolher.setBorderPainted(false);
			btnEscolher.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnEscolher.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 30));
			btnEscolher.setForeground(cor);
			btnEscolher.setVerticalTextPosition(SwingConstants.CENTER);
			btnEscolher.setHorizontalTextPosition(SwingConstants.CENTER);

			setOpaque(false);
			btnEscolher.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Ação Escolher
					//Colocar o nome na outra lista
					listaEscolhidos.setListData(listaParticipantes.getSelectedValues());
					ArrayList<String> participantesEscolhidos = new ArrayList<>();
					
					listaNome = listaParticipantes.getSelectedValuesList();      // gets values from your jList and added it to a list
					for(int i = 0; i<listaNome.size(); i++) {      //  this for-loop adds the values of the list to the array list
					    participantesEscolhidos.add(listaNome.get(i).toString());
					}
					if(!listaNome.isEmpty()){
						btnZerarParticipante.setEnabled(true);
						btnZerarPontuacao.setEnabled(true);
						btnSalvar.setEnabled(true);
					}
					
				}
			});
			btnEscolher.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	//btnIniciar.setForeground(Color.BLACK);
			    	btnEscolher.setIcon(icone2);
			    }
			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	//btnIniciar.setForeground(cor);
			    	btnEscolher.setIcon(icone);
			    }

			});
			
			listaEscolhidos = new JList();
			listaEscolhidos.setVisibleRowCount(4);
			listaEscolhidos.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);			
			listaEscolhidos.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 20));
			listaEscolhidos.setForeground(cor);
			
		}catch (Exception exception) {
			tp.mostrarMensagem("    " + exception.getMessage(), "                       Erro", NomeDaTela.TELA_CONFIG);
			exception.printStackTrace();
		}
		
		//Adicionando componentes à caixa
		caixaVerticalParticipantes.add(Box.createVerticalStrut(100));
		caixaVerticalParticipantes.add(menu);
		caixaVerticalParticipantes.add(Box.createVerticalStrut(35));
		caixaVerticalParticipantes.add(lblEscolha);
		caixaVerticalParticipantes.add(lblDica);
		caixaVerticalParticipantes.add(Box.createVerticalStrut(40));
		JScrollPane scrollPane = new JScrollPane(listaParticipantes);
		scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		scrollPane.setBorder(new LineBorder(new Color(95, 38,5),2));
		scrollPane.setPreferredSize(new Dimension(350,200));
		scrollPane.setMaximumSize(new Dimension(350,200));
		
		JScrollPane scrollPane2 = new JScrollPane(listaEscolhidos);
		scrollPane2.setAlignmentX(Component.LEFT_ALIGNMENT);
		scrollPane2.setBorder(new LineBorder(new Color(95, 38,5),2));
		scrollPane2.setPreferredSize(new Dimension(350,200));
		scrollPane2.setMaximumSize(new Dimension(350,200));
		
		Box caixaHorizontalLista = Box.createHorizontalBox();
		caixaHorizontalLista.setAlignmentX(Component.LEFT_ALIGNMENT);
		caixaHorizontalLista.add(Box.createHorizontalStrut(105));
		caixaHorizontalLista.add(scrollPane);
		caixaHorizontalLista.add(Box.createHorizontalStrut(25));
		caixaHorizontalLista.add(btnEscolher);
		caixaHorizontalLista.add(Box.createHorizontalStrut(25));
		caixaHorizontalLista.add(scrollPane2);
		
		caixaVerticalParticipantes.add(caixaHorizontalLista);
		caixaVerticalParticipantes.add(Box.createVerticalStrut(40));
					
		//Botão Salvar
		btnSalvar.setMaximumSize(new Dimension(330, 90));
		btnSalvar.setPreferredSize(new Dimension(330, 90));
		btnSalvar.setEnabled(false);
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
					//Ação Salvar
					//Percorrendo a lista e adicionando os nomes em um array
				
					List<Participante> lista = new ArrayList<>();
					
					for (String nome : listaNome) {
						System.out.println(nome);
						for (Participante  participante: listaParticipante) {
							if (nome.equals(participante.getNome())) {
								lista.add(participante);
							}
						}
					}
					System.out.println(lista.size());
					tp.configuracaoInicial(lista);
					
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
		
		//Botão Zerar Participante
        btnZerarParticipante.setMaximumSize(new Dimension(300, 90));
        btnZerarParticipante.setPreferredSize(new Dimension(300, 90));
        btnZerarParticipante.setEnabled(false);
        btnZerarParticipante.setFocusPainted(false);
        btnZerarParticipante.setMargin(new Insets(0, 0, 0, 0));
        btnZerarParticipante.setContentAreaFilled(false);
        btnZerarParticipante.setBorderPainted(false);
		btnZerarParticipante.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnZerarParticipante.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 30));
		btnZerarParticipante.setForeground(cor);
		btnZerarParticipante.setVerticalTextPosition(SwingConstants.CENTER);
		btnZerarParticipante.setHorizontalTextPosition(SwingConstants.CENTER);
        setOpaque(false);
        btnZerarParticipante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Ação Excluir todos participantes
				
				//Percorrendo a lista e adicionando os nomes
				List<Participante> lista = new ArrayList<>();
				
				for (String nome : listaNome) {
					System.out.println(nome);
					
					for (Participante  participante: listaParticipante) {
						if (nome.equals(participante.getNome())) {
							lista.add(participante);
						}
					}
				}
				fachada.excluirTodosParticipante(lista);
				tp.mostrarMensagem("Participante(s) excluído(s) com Sucesso!!", "                    Exclusão", NomeDaTela.TELA_ESCOLHA_PARTICIPANTES);
			}
		});
        btnZerarParticipante.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnZerarParticipante.setIcon(icone2);
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnZerarParticipante.setIcon(icone);
		    }

		});
        
        //Botão Zerar Pontuacao
		btnZerarPontuacao.setMaximumSize(new Dimension(300, 90));
		btnZerarPontuacao.setPreferredSize(new Dimension(300, 90));
		btnZerarPontuacao.setEnabled(false);
		btnZerarPontuacao.setFocusPainted(false);
		btnZerarPontuacao.setMargin(new Insets(0, 0, 0, 0));
		btnZerarPontuacao.setContentAreaFilled(false);
		btnZerarPontuacao.setBorderPainted(false);
		btnZerarPontuacao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnZerarPontuacao.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 30));
		btnZerarPontuacao.setForeground(cor);
		btnZerarPontuacao.setVerticalTextPosition(SwingConstants.CENTER);
		btnZerarPontuacao.setHorizontalTextPosition(SwingConstants.CENTER);
        setOpaque(false);
        btnZerarPontuacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Ação Zerar Pontuação
				//Percorrendo a lista e adicionando os nomes
				List<Participante> lista = new ArrayList<>();
				
				for (String nome : listaNome) {
					System.out.println(nome);
					
					for (Participante  participante: listaParticipante) {
						if (nome.equals(participante.getNome())) {
							lista.add(participante);
						}
					}
				}
				fachada.zerarPontos(lista);
				tp.mostrarMensagem("        Pontuação zerada com sucesso!!", "               Zerar Pontuação", NomeDaTela.TELA_ESCOLHA_PARTICIPANTES);
			}
		});
        btnZerarPontuacao.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnZerarPontuacao.setIcon(icone2);
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnZerarPontuacao.setIcon(icone);
		    }

		});
		
		//Botão Voltar
        btnVoltar.setMaximumSize(new Dimension(300, 90));
        btnVoltar.setPreferredSize(new Dimension(300, 90));
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
        
        Box caixaHorizontalBotoes = Box.createHorizontalBox();
        caixaHorizontalBotoes.setAlignmentX(Component.LEFT_ALIGNMENT);
        caixaHorizontalBotoes.add(Box.createHorizontalStrut(26));
        caixaHorizontalBotoes.add(btnVoltar);
        caixaHorizontalBotoes.add(btnZerarParticipante);
		caixaHorizontalBotoes.add(btnZerarPontuacao);
        caixaHorizontalBotoes.add(btnSalvar);
        caixaVerticalParticipantes.add(caixaHorizontalBotoes);
        caixaVerticalParticipantes.add(Box.createVerticalStrut(10));
		//Adicionando caixa ao Painel
		add(caixaVerticalParticipantes);
	}

}
