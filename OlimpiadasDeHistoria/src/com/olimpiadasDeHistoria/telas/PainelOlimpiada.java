package com.olimpiadasDeHistoria.telas;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.List;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.olimpiadasDeHistoria.fachada.Fachada;
import com.olimpiadasDeHistoria.modelo.participante.Participante;
import com.olimpiadasDeHistoria.modelo.pergunta.Pergunta;
import com.olimpiadasDeHistoria.modelo.pergunta.PerguntaNaoCadastradaException;
import com.olimpiadasDeHistoria.util.Contador;
import com.olimpiadasDeHistoria.util.NomeDaTela;
import com.olimpiadasDeHistoria.util.ShadowText;

public class PainelOlimpiada extends JPanel {

	//TelaPrincipal
	TelaPrincipal tp;
	
	//Criando icone dos botões
    ImageIcon icone = new ImageIcon(TelaPrincipal.class.getResource("/com/olimpiadasDeHistoria/imagens/botao_official.png"));
		
    //Criando icone dos botões
    ImageIcon icone2 = new ImageIcon(TelaPrincipal.class.getResource("/com/olimpiadasDeHistoria/imagens/btn_1.png"));
    
    //Criando icones do botão seta esquerda
    ImageIcon iconeSetaEsquerda = new ImageIcon(TelaPrincipal.class.getResource("/com/olimpiadasDeHistoria/imagens/btn_seta_esquerda.png"));
    ImageIcon iconeSetaEsquerdaGrande = new ImageIcon(TelaPrincipal.class.getResource("/com/olimpiadasDeHistoria/imagens/btn_seta_esquerda_grande.png"));
    
    //Criando icones do botão seta direita
    ImageIcon iconeSetaDireita = new ImageIcon(TelaPrincipal.class.getResource("/com/olimpiadasDeHistoria/imagens/btn_seta_direita.png"));
    ImageIcon iconeSetaDireitaGrande = new ImageIcon(TelaPrincipal.class.getResource("/com/olimpiadasDeHistoria/imagens/btn_seta_direita_grande.png"));
    
    //Criando icones do botão play
    ImageIcon iconePlay = new ImageIcon(TelaPrincipal.class.getResource("/com/olimpiadasDeHistoria/imagens/btn_seta_play.png"));
    ImageIcon iconePlayGrande = new ImageIcon(TelaPrincipal.class.getResource("/com/olimpiadasDeHistoria/imagens/btn_seta_play_grande.png"));
    
    //Criando icones do botão Pause
    ImageIcon iconePause = new ImageIcon(TelaPrincipal.class.getResource("/com/olimpiadasDeHistoria/imagens/btn_seta_pause.png"));
    ImageIcon iconePauseGrande = new ImageIcon(TelaPrincipal.class.getResource("/com/olimpiadasDeHistoria/imagens/btn_seta_pause_grande.png"));
    
    //Criando icone do contador
    ImageIcon iconeContador = new ImageIcon(TelaPrincipal.class.getResource("/com/olimpiadasDeHistoria/imagens/hourglass2.png"));
    
    //Criando icone do contador
    ImageIcon iconeContador2 = new ImageIcon(TelaPrincipal.class.getResource("/com/olimpiadasDeHistoria/imagens/hourglass.gif"));
    
    //Variáveis de Contador
    private static boolean contador = false;  
    private static boolean zerado = false;  
    private JButton iniciar = new JButton("", iconePlay);       
    private JButton pausar = new JButton("", iconePause);
    private static JLabel lConta = new JLabel("00:00:00", SwingConstants.CENTER);
    private static JLabel imagemContador = new JLabel("");
    private Contador cont;
    
	//Largura e Altura
	int largura;
	int altura;
	
	//Criando botões
	JButton btnProxima = new JButton("", iconeSetaDireita);
	JButton btnAnterior = new JButton("", iconeSetaEsquerda);
	JButton btnMenu = new JButton("Menu", icone);
	JButton btnResponder = new JButton("Responder", icone);
	
	//numero de cliques do botão anterior
	static int numeroCliqueAnterior = 0;
	
	boolean resultadoOficial;
	
    //Alternativas 
    JButton alternativaA;
    JButton alternativaB;
    JButton alternativaC;
    JButton alternativaD;
    JButton alternativaE;    
    
    //Mouse Adapter das alternativas
    MouseAdapter mouseAdapterA;
    MouseAdapter mouseAdapterB;
    MouseAdapter mouseAdapterC;
    MouseAdapter mouseAdapterD;
    MouseAdapter mouseAdapterE;
    
    private JLabel enunciado;
    private JLabel vezDoJogador;
    
    //Fachada
	private static Fachada fachada;
	private List<Participante>listaParticipantes;
	private Pergunta pergunta;
	private Participante participanteVez = null;  
	private Pergunta perguntaAnterior;
	private Participante participanteAnterior = null;
	private int pontosPorQuestao;
	private int todalRodadas;
	private int rodadaAtual = 0;
	
	//Construtor
	public PainelOlimpiada(TelaPrincipal tp,int largura, int altura,int pontosPorQuestao,int todalRodadas, int rodadaAtual, List<Participante>listaParticipantes) {
		
		this.tp = tp;//Recebendo a tela principal
		this.listaParticipantes = listaParticipantes;//Recebendo listaParticipantes
		this.todalRodadas = todalRodadas;//Recebendo numeroRodadas
		this.pontosPorQuestao = pontosPorQuestao;//Recebendo pontosPorQuestao
		this.altura = altura;//Recebendo altura
		this.largura = largura;//Recebendo largura
		
		//Inicializando o contador
        cont = new Contador(lConta);  
        cont.start();
        
		try{
			fachada = Fachada.getFachada();//Instanciando fachada
			
			fachada.listaPerguntas();//Colocando as perguntas na memoria
			
			pergunta = fachada.proximaPergunta();//Pegando uma pergunta na memoria
			
			getComponentes();//Cria toda a tela
			
			participanteVez = getParticipanteVez();//Pegando o participante da vez
			
			preencherTela();//Preenche os campos com as devidas infomações
		} catch (PerguntaNaoCadastradaException exception) {
			tp.mostrarMensagem("    " + exception.getMessage(), "                       Erro", NomeDaTela.TELA_PRINCIPAL);
			System.out.println(exception.getMessage());
		} catch (Exception exception) {
			tp.mostrarMensagem("    " + exception.getMessage(), "                       Erro", NomeDaTela.TELA_PRINCIPAL);
			System.out.println(exception.getMessage());
			exception.printStackTrace();
		}
	}
	
	public void getComponentes() {
		
		Color cor = new Color(95,38,5);//Cor Marrom
						
		//CRIANDO E ADICIONANDO ELEMENTOS NA CAIXA ANTECIPADAMENTE
		Box caixaVertical = Box.createVerticalBox();//Criando caixa
			
		//Vez do Jogador
		vezDoJogador = new JLabel("", SwingConstants.CENTER);
		vezDoJogador.setFont(new Font("Lucida Calligraphy", Font.BOLD, 35));
		vezDoJogador.setAlignmentX(Component.LEFT_ALIGNMENT);
		vezDoJogador.setHorizontalTextPosition(SwingConstants.CENTER);
		vezDoJogador.setMaximumSize(new Dimension(1120, 60));
		vezDoJogador.setPreferredSize(new Dimension(1120, 60));
		vezDoJogador.setForeground(cor);
		vezDoJogador.setText("Vez de: ");
		
		//Botão Anterior 
        btnAnterior.setMaximumSize(new Dimension(100, 70));
        btnAnterior.setPreferredSize(new Dimension(100, 70));
        btnAnterior.setAlignmentX(Component.LEFT_ALIGNMENT);
        btnAnterior.setFocusPainted(false);
        btnAnterior.setMargin(new Insets(0, 0, 0, 0));
        btnAnterior.setContentAreaFilled(false);
        btnAnterior.setBorderPainted(false);
        btnAnterior.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnAnterior.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 30));
        btnAnterior.setForeground(cor);
        btnAnterior.setVerticalTextPosition(SwingConstants.CENTER);
        btnAnterior.setHorizontalTextPosition(SwingConstants.CENTER);
        setOpaque(false);
        
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Ação Anterior
				tp.addPainelVoltarMenu(PainelOlimpiada.this,tp);
			}
		});
		btnAnterior.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnAnterior.setIcon(iconeSetaEsquerdaGrande);
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnAnterior.setIcon(iconeSetaEsquerda);
		    }

		});

        //CONTADOR
        //Números
        lConta.setMaximumSize(new Dimension(200, 40));
        lConta.setPreferredSize(new Dimension(200, 40));
        lConta.setAlignmentX(Component.LEFT_ALIGNMENT);
        lConta.setFont(new Font("Lucida Calligraphy", Font.BOLD, 35));
        lConta.setForeground(cor);
        lConta.setVerticalTextPosition(SwingConstants.CENTER);
        lConta.setHorizontalTextPosition(SwingConstants.CENTER);
        
        //Botão Iniciar
        iniciar.setMaximumSize(new Dimension(100, 70));
        iniciar.setPreferredSize(new Dimension(100, 70));
        iniciar.setAlignmentX(Component.LEFT_ALIGNMENT);
        iniciar.setFocusPainted(false);
        iniciar.setMargin(new Insets(0, 0, 0, 0));
        iniciar.setContentAreaFilled(false);
        iniciar.setBorderPainted(false);
        iniciar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        iniciar.setFont(new Font("Lucida Calligraphy", Font.BOLD, 30));
        iniciar.setForeground(cor);
		iniciar.setVerticalTextPosition(SwingConstants.CENTER);
		iniciar.setHorizontalTextPosition(SwingConstants.CENTER);
        setOpaque(false);
        //Desabilitando botão
        if(numeroCliqueAnterior > fachada.getListaPeguntasRespondidas()){
        	iniciar.setEnabled(false);
        	//zerarActionPerformed();
        }else{
        	
        	iniciar.addActionListener(new java.awt.event.ActionListener() {  
	            public void actionPerformed(java.awt.event.ActionEvent evt) {  
	                iniciarActionPerformed(evt);  
	            }  
	        });
	        iniciar.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	iniciar.setIcon(iconePlayGrande);
			    }
			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	iniciar.setIcon(iconePlay);
			    }
			});
        }
        
        //Botao Pausar
        pausar.setMaximumSize(new Dimension(100, 70));
        pausar.setPreferredSize(new Dimension(100, 70));
        pausar.setAlignmentX(Component.LEFT_ALIGNMENT);
        pausar.setFocusPainted(false);
        pausar.setMargin(new Insets(0, 0, 0, 0));
        pausar.setContentAreaFilled(false);
        pausar.setBorderPainted(false);
        pausar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pausar.setFont(new Font("Lucida Calligraphy", Font.BOLD, 30));
        pausar.setForeground(cor);
        pausar.setVerticalTextPosition(SwingConstants.CENTER);
        pausar.setHorizontalTextPosition(SwingConstants.CENTER);
        setOpaque(false);
        //Desabilitando botão
        if(numeroCliqueAnterior > fachada.getListaPeguntasRespondidas()){
        	pausar.setEnabled(false);
        }else{
	        pausar.addActionListener(new java.awt.event.ActionListener() {  
	            public void actionPerformed(java.awt.event.ActionEvent evt) {  
	                pausarActionPerformed(evt);  
	            }  
	        });
	        pausar.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	pausar.setIcon(iconePauseGrande);
			    }
			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	pausar.setIcon(iconePause);
			    }
			});
        }
        
        //iconeContador
        imagemContador.setIcon(iconeContador);
        imagemContador.setMaximumSize(new Dimension(128, 128));
        imagemContador.setPreferredSize(new Dimension(128, 128));
        imagemContador.setAlignmentX(Component.LEFT_ALIGNMENT);
        //FIM DO CONTADOR
        
        //Botão Próxima
        btnProxima.setMaximumSize(new Dimension(100, 70));
        btnProxima.setPreferredSize(new Dimension(100, 70));
        btnProxima.setAlignmentX(Component.LEFT_ALIGNMENT);
        btnProxima.setFocusPainted(false);
        btnProxima.setMargin(new Insets(0, 0, 0, 0));
        btnProxima.setContentAreaFilled(false);
        btnProxima.setBorderPainted(false);
        btnProxima.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnProxima.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 30));
        btnProxima.setForeground(cor);
        btnProxima.setVerticalTextPosition(SwingConstants.CENTER);
        btnProxima.setHorizontalTextPosition(SwingConstants.CENTER);
        setOpaque(false);
        
        //TODO Desabilitando botão se não tiver respondido a questão ainda
        if(numeroCliqueAnterior > fachada.getListaPeguntasRespondidas()){
        	btnProxima.setEnabled(false);
			
		} else{
			btnProxima.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {//Ação Próxima
					//Zerando o número de cliques
					numeroCliqueAnterior = 0;
					//Analisando se tem rodada ainda
					if(rodadaAtual <= todalRodadas) {
						participanteVez = getParticipanteVez();//Pegando o participante da vez
						
						pergunta = fachada.proximaPergunta();//Pegando uma pergunta na memoria
						
						preencherTela();//Preenche os campos com as devidas infomações
						
						//zerando contador
						zerarActionPerformed(e);
						imagemContador.setIcon(iconeContador);
					} else {
						//zerando contador
						zerarActionPerformed(e);
						cont.stop();
						tp.mostrarMensagem("                          Acabou", "              Fim da Olimpíada", NomeDaTela.TELA_PRINCIPAL);//Monstrar mensagem de jogo
					}
					
				}
			});
			btnProxima.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	btnProxima.setIcon(iconeSetaDireitaGrande);
			    }
			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	btnProxima.setIcon(iconeSetaDireita);
			    }
			});
		}
        
        Box caixaHorizontalBotaoContador = Box.createHorizontalBox();
        caixaHorizontalBotaoContador.setAlignmentX(Component.LEFT_ALIGNMENT);
		caixaHorizontalBotaoContador.add(iniciar);
		caixaHorizontalBotaoContador.add(pausar);
		
		Box caixaVerticalContador = Box.createVerticalBox();
		caixaVerticalContador.setAlignmentX(Component.LEFT_ALIGNMENT);
		caixaVerticalContador.add(lConta);
		caixaVerticalContador.add(caixaHorizontalBotaoContador);
		
		Box caixaHorizontalContador = Box.createHorizontalBox();
		caixaHorizontalContador.setAlignmentY(Component.CENTER_ALIGNMENT);
		caixaHorizontalContador.setAlignmentX(Component.LEFT_ALIGNMENT);
		caixaHorizontalContador.add(imagemContador);
		caixaHorizontalContador.add(caixaVerticalContador);
		
		Box caixaHorizontalMenu = Box.createHorizontalBox();
		caixaHorizontalMenu.setAlignmentX(Component.LEFT_ALIGNMENT);
		caixaHorizontalMenu.add(btnAnterior);
		caixaHorizontalMenu.add(Box.createHorizontalStrut(296));
		caixaHorizontalMenu.add(caixaHorizontalContador);
		caixaHorizontalMenu.add(Box.createHorizontalStrut(296));
		caixaHorizontalMenu.add(btnProxima);
		
		//Adicionando titulo da vez do jogador na caixa				
		caixaVertical.add(Box.createVerticalStrut(35));
		caixaVertical.add(vezDoJogador);
		caixaVertical.add(caixaHorizontalMenu);

		//Adicionando espaço superior da questão
		caixaVertical.add(Box.createVerticalStrut(50));
		
		//Enunciado
		enunciado = new JLabel();
		enunciado.setAlignmentX(Component.LEFT_ALIGNMENT);
		enunciado.setHorizontalTextPosition(SwingConstants.CENTER);
		enunciado.setFont(new Font("Lucida Calligraphy", Font.BOLD, 25));
		enunciado.setForeground(cor);
		if(pergunta.getEnuciado().length() >= 102){
			enunciado.setMaximumSize(new Dimension(900, 100));
			enunciado.setPreferredSize(new Dimension(900, 100));
		}else if(pergunta.getEnuciado().length() >= 52){
			enunciado.setMaximumSize(new Dimension(900, 65));
			enunciado.setPreferredSize(new Dimension(900, 65));
		} else{
			enunciado.setMaximumSize(new Dimension(900, 30));
			enunciado.setPreferredSize(new Dimension(900, 30));
		}
		enunciado.setText("<html>Responta</html>");
		enunciado.setToolTipText(pergunta.getEnuciado());
		
		//ALTERNATIVAS
		//A
		alternativaA = new JButton();
		alternativaA.setAlignmentX(Component.LEFT_ALIGNMENT);
		alternativaA.setHorizontalAlignment(SwingConstants.LEFT);
		alternativaA.setHorizontalTextPosition(SwingConstants.CENTER);
		alternativaA.setForeground(cor);
		alternativaA.setOpaque(false);
		alternativaA.setContentAreaFilled(false);
		alternativaA.setFocusPainted(false);
		alternativaA.setBorder(new LineBorder(cor, 0));
		alternativaA.setToolTipText(pergunta.getReposta1());
		alternativaA.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		alternativaA.setFont(new Font("Lucida Calligraphy", Font.BOLD, 25));
		if(pergunta.getReposta1().length() >= 102){
			alternativaA.setMaximumSize(new Dimension(830, 100));
			alternativaA.setPreferredSize(new Dimension(830, 100));
		}else if(pergunta.getReposta1().length() >= 52){
			alternativaA.setMaximumSize(new Dimension(830, 65));
			alternativaA.setPreferredSize(new Dimension(830, 65));
		} else{
			alternativaA.setMaximumSize(new Dimension(830, 30));
			alternativaA.setPreferredSize(new Dimension(830, 30));
		}
		alternativaA.setText("<html><p style='text-shadow: 2px 2px #ff0000;'>A) </p></html>");
		mouseAdapterA = new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	alternativaA.setText("<html>A) <u>" + pergunta.getReposta1() + "</u></html>");
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	alternativaA.setText("<html>A) " + pergunta.getReposta1() + "</html>");
		    }
		};
		
		alternativaA.addMouseListener(mouseAdapterA);
		alternativaA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Ação Alternativa A
				tp.addPainelConfirmacao(PainelOlimpiada.this,tp, "A", pergunta, participanteVez, pontosPorQuestao);
			}
		});
		
		//B
		alternativaB = new JButton();
		alternativaB.setAlignmentX(Component.LEFT_ALIGNMENT);
		alternativaB.setHorizontalAlignment(SwingConstants.LEFT);
		alternativaB.setHorizontalTextPosition(SwingConstants.CENTER);
		alternativaB.setForeground(cor);
		alternativaB.setOpaque(false);
		alternativaB.setContentAreaFilled(false);
		alternativaB.setFocusPainted(false);
		alternativaB.setBorder(new LineBorder(cor, 0));
		alternativaB.setToolTipText(pergunta.getReposta2());
		alternativaB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		alternativaB.setFont(new Font("Lucida Calligraphy", Font.BOLD, 25));
		if(pergunta.getReposta2().length() >= 102){
			alternativaB.setMaximumSize(new Dimension(830, 100));
			alternativaB.setPreferredSize(new Dimension(830, 100));
		}else if(pergunta.getReposta2().length() >= 52){
			alternativaB.setMaximumSize(new Dimension(830, 65));
			alternativaB.setPreferredSize(new Dimension(830, 65));
		} else{
			alternativaB.setMaximumSize(new Dimension(830, 30));
			alternativaB.setPreferredSize(new Dimension(830, 30));
		}
		alternativaB.setText("<html><p style='text-shadow: 2px 2px #ff0000;'>B) </p></html>");
		mouseAdapterB = new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	alternativaB.setText("<html>B) <u>" + pergunta.getReposta2() + "</u></html>");
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	alternativaB.setText("<html>B) " + pergunta.getReposta2() + "</html>");
		    }
		};
		
		alternativaB.addMouseListener(mouseAdapterB);
		alternativaB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Ação Alternativa B
				tp.addPainelConfirmacao(PainelOlimpiada.this,tp, "B", pergunta, participanteVez, pontosPorQuestao); 
			}
		});
		
		//C
		alternativaC = new JButton();
		alternativaC.setAlignmentX(Component.LEFT_ALIGNMENT);
		alternativaC.setHorizontalAlignment(SwingConstants.LEFT);
		alternativaC.setHorizontalTextPosition(SwingConstants.CENTER);
		alternativaC.setForeground(cor);
		alternativaC.setOpaque(false);
		alternativaC.setContentAreaFilled(false);
		alternativaC.setFocusPainted(false);
		alternativaC.setBorder(new LineBorder(cor, 0));
		alternativaC.setToolTipText(pergunta.getReposta3());
		alternativaC.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		alternativaC.setFont(new Font("Lucida Calligraphy", Font.BOLD, 25));
		if(pergunta.getReposta3().length() >= 102){
			alternativaC.setMaximumSize(new Dimension(830, 100));
			alternativaC.setPreferredSize(new Dimension(830, 100));
		}else if(pergunta.getReposta3().length() >= 52){
			alternativaC.setMaximumSize(new Dimension(830, 65));
			alternativaC.setPreferredSize(new Dimension(830, 65));
		} else{
			alternativaC.setMaximumSize(new Dimension(830, 30));
			alternativaC.setPreferredSize(new Dimension(830, 30));
		}
		alternativaC.setText("<html><p style='text-shadow: 2px 2px #ff0000;'>C) </p></html>");
		mouseAdapterC = new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	alternativaC.setText("<html>C) <u>" + pergunta.getReposta3() + "</u></html>");
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	alternativaC.setText("<html>C) " + pergunta.getReposta3() + "</html>");
		    }
		};
		
		alternativaC.addMouseListener(mouseAdapterC);
		alternativaC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Ação Alternativa C
				tp.addPainelConfirmacao(PainelOlimpiada.this,tp, "C", pergunta, participanteVez, pontosPorQuestao);
			}
		});
		
		//D
		alternativaD = new JButton();
		alternativaD.setAlignmentX(Component.LEFT_ALIGNMENT);
		alternativaD.setHorizontalAlignment(SwingConstants.LEFT);
		alternativaD.setHorizontalTextPosition(SwingConstants.CENTER);
		alternativaD.setForeground(cor);
		alternativaD.setOpaque(false);
		alternativaD.setContentAreaFilled(false);
		alternativaD.setFocusPainted(false);
		alternativaD.setBorder(new LineBorder(cor, 0));
		alternativaD.setToolTipText(pergunta.getReposta4());
		alternativaD.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		alternativaD.setFont(new Font("Lucida Calligraphy", Font.BOLD, 25));
		if(pergunta.getReposta4().length() >= 102){
			alternativaD.setMaximumSize(new Dimension(830, 100));
			alternativaD.setPreferredSize(new Dimension(830, 100));
		}else if(pergunta.getReposta4().length() >= 52){
			alternativaD.setMaximumSize(new Dimension(830, 65));
			alternativaD.setPreferredSize(new Dimension(830, 65));
		} else{
			alternativaD.setMaximumSize(new Dimension(830, 30));
			alternativaD.setPreferredSize(new Dimension(830, 30));
		}
		alternativaD.setText("<html><p style='text-shadow: 2px 2px #ff0000;'>D) </p></html>");
		mouseAdapterD = new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	alternativaD.setText("<html>D) <u>" + pergunta.getReposta4() + "</u></html>");
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	alternativaD.setText("<html>D) " + pergunta.getReposta4() + "</html>");
		    }
		};
		
		alternativaD.addMouseListener(mouseAdapterD);
		alternativaD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Ação Alternativa D
				tp.addPainelConfirmacao(PainelOlimpiada.this,tp, "D", pergunta, participanteVez, pontosPorQuestao);
			}
		});
		
		//E
		alternativaE = new JButton();
		alternativaE.setAlignmentX(Component.LEFT_ALIGNMENT);
		alternativaE.setHorizontalAlignment(SwingConstants.LEFT);
		alternativaE.setHorizontalTextPosition(SwingConstants.CENTER);
		alternativaE.setForeground(cor);
		alternativaE.setOpaque(false);
		alternativaE.setContentAreaFilled(false);
		alternativaE.setFocusPainted(false);
		alternativaE.setBorder(new LineBorder(cor, 0));
		alternativaE.setToolTipText(pergunta.getReposta5());
		alternativaE.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		alternativaE.setFont(new Font("Lucida Calligraphy", Font.BOLD, 25));
		if(pergunta.getReposta5().length() >= 102){
			alternativaE.setMaximumSize(new Dimension(830, 100));
			alternativaE.setPreferredSize(new Dimension(830, 100));
		}else if(pergunta.getReposta5().length() >= 52){
			alternativaE.setMaximumSize(new Dimension(830, 65));
			alternativaE.setPreferredSize(new Dimension(830, 65));
		} else{
			alternativaE.setMaximumSize(new Dimension(830, 30));
			alternativaE.setPreferredSize(new Dimension(830, 30));
		}
		alternativaE.setText("<html><p style='text-shadow: 2px 2px #ff0000;'>E) </p></html>");
		mouseAdapterE = new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	alternativaE.setText("<html>E) <u>" + pergunta.getReposta5() + "</u></html>");
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	alternativaE.setText("<html>E) " + pergunta.getReposta5() + "</html>");
		    }
		};
		
		alternativaE.addMouseListener(mouseAdapterE);
		alternativaE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Ação Alternativa E
				tp.addPainelConfirmacao(PainelOlimpiada.this,tp, "E", pergunta, participanteVez, pontosPorQuestao);
			}
		});

		//Criando caixa Vertical Questao
		Box caixaVerticalQuestao = Box.createVerticalBox();
		caixaVerticalQuestao.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		//Adicionando os elementos de questão na caixa
		caixaVerticalQuestao.add(enunciado);
		caixaVerticalQuestao.add(Box.createVerticalStrut(30));
		caixaVerticalQuestao.add(alternativaA);
		caixaVerticalQuestao.add(Box.createVerticalStrut(10));
		caixaVerticalQuestao.add(alternativaB);
		caixaVerticalQuestao.add(Box.createVerticalStrut(10));
		caixaVerticalQuestao.add(alternativaC);
		caixaVerticalQuestao.add(Box.createVerticalStrut(10));
		caixaVerticalQuestao.add(alternativaD);
		caixaVerticalQuestao.add(Box.createVerticalStrut(10));
		caixaVerticalQuestao.add(alternativaE);
		
		//Criando caixa Horizontal que organiza os elementos
		Box caixaHorizontal = Box.createHorizontalBox();
		caixaHorizontal.setAlignmentY(Component.CENTER_ALIGNMENT);
		caixaHorizontal.setAlignmentX(Component.LEFT_ALIGNMENT);
		caixaHorizontal.add(Box.createHorizontalStrut(113));
		caixaHorizontal.add(caixaVerticalQuestao);
		
		//Adicionando componentes a caixa vertical 
		caixaVertical.add(caixaHorizontal);
		add(caixaVertical);
		
		//escondendo background
		setOpaque(false);
	}
	
	//Método que preenche os campos de acordo com o jogador e a pergunta da vez
	public void preencherTela(){
		//Zerando as alternativas
		Color cor = new Color(95,38,5);
		alternativaA.setForeground(cor);
		alternativaA.setEnabled(true);
		alternativaB.setForeground(cor);
		alternativaB.setEnabled(true);
		alternativaC.setForeground(cor);
		alternativaC.setEnabled(true);
		alternativaD.setForeground(cor);
		alternativaD.setEnabled(true);
		alternativaE.setForeground(cor);
		alternativaE.setEnabled(true);
		
		//Setando o nome do jogador da vez
		vezDoJogador.setText(rodadaAtual + "ª rodada - Vez de: " + participanteVez.getNome());
		if(numeroCliqueAnterior != 0){
			vezDoJogador.setText("Quem jogou foi: " + participanteVez.getNome());
		}
		if(rodadaAtual == todalRodadas) {
			vezDoJogador.setText("Última rodada - Vez de: " + participanteVez.getNome());
		}
		//Setando o enunciado
		if(pergunta.getEnuciado().length() >= 102){
			enunciado.setMaximumSize(new Dimension(900, 100));
			enunciado.setPreferredSize(new Dimension(900, 100));
		}else if(pergunta.getEnuciado().length() >= 52){
			enunciado.setMaximumSize(new Dimension(900, 65));
			enunciado.setPreferredSize(new Dimension(900, 65));
		} else{
			enunciado.setMaximumSize(new Dimension(900, 30));
			enunciado.setPreferredSize(new Dimension(900, 30));
		}
		enunciado.setText("<html>"+ pergunta.getEnuciado() + "</html>");
		enunciado.setToolTipText(pergunta.getEnuciado());
		
		//Setando alternativa A
		if(pergunta.getReposta1().length() >= 102){
			alternativaA.setMaximumSize(new Dimension(830, 100));
			alternativaA.setPreferredSize(new Dimension(830, 100));
		}else if(pergunta.getReposta1().length() >= 52){
			alternativaA.setMaximumSize(new Dimension(830, 65));
			alternativaA.setPreferredSize(new Dimension(830, 65));
		} else{
			alternativaA.setMaximumSize(new Dimension(830, 30));
			alternativaA.setPreferredSize(new Dimension(830, 30));
		}
		alternativaA.setText("<html><p style='text-shadow: 2px 2px #ff0000;'>A) " + pergunta.getReposta1() + "</p></html>");
		alternativaA.setToolTipText(pergunta.getReposta1());
		
		//Setando alternativa B
		if(pergunta.getReposta2().length() >= 102){
			alternativaB.setMaximumSize(new Dimension(830, 100));
			alternativaB.setPreferredSize(new Dimension(830, 100));
		}else if(pergunta.getReposta2().length() >= 52){
			alternativaB.setMaximumSize(new Dimension(830, 65));
			alternativaB.setPreferredSize(new Dimension(830, 65));
		} else{
			alternativaB.setMaximumSize(new Dimension(830, 30));
			alternativaB.setPreferredSize(new Dimension(830, 30));
		}
		alternativaB.setText("<html><p style='text-shadow: 2px 2px #ff0000;'>B) " + pergunta.getReposta2() + "</p></html>");
		alternativaB.setToolTipText(pergunta.getReposta2());
		
		//Setando alternativa C
		if(pergunta.getReposta3().length() >= 102){
			alternativaC.setMaximumSize(new Dimension(830, 100));
			alternativaC.setPreferredSize(new Dimension(830, 100));
		}else if(pergunta.getReposta3().length() >= 52){
			alternativaC.setMaximumSize(new Dimension(830, 65));
			alternativaC.setPreferredSize(new Dimension(830, 65));
		} else{
			alternativaC.setMaximumSize(new Dimension(830, 30));
			alternativaC.setPreferredSize(new Dimension(830, 30));
		}
		alternativaC.setText("<html><p style='text-shadow: 2px 2px #ff0000;'>C) " + pergunta.getReposta3() + "</p></html>");
		alternativaC.setToolTipText(pergunta.getReposta3());
		
		//Setando alternativa D
		if(pergunta.getReposta4().length() >= 102){
			alternativaD.setMaximumSize(new Dimension(830, 100));
			alternativaD.setPreferredSize(new Dimension(830, 100));
		}else if(pergunta.getReposta4().length() >= 52){
			alternativaD.setMaximumSize(new Dimension(830, 65));
			alternativaD.setPreferredSize(new Dimension(830, 65));
		} else{
			alternativaD.setMaximumSize(new Dimension(830, 30));
			alternativaD.setPreferredSize(new Dimension(830, 30));
		}
		alternativaD.setText("<html><p style='text-shadow: 2px 2px #ff0000;'>D) " + pergunta.getReposta4() + "</p></html>");
		alternativaD.setToolTipText(pergunta.getReposta4());
		
		//Setando alternativa E
		if(pergunta.getReposta5().length() >= 102){
			alternativaE.setMaximumSize(new Dimension(830, 100));
			alternativaE.setPreferredSize(new Dimension(830, 100));
		}else if(pergunta.getReposta5().length() >= 52){
			alternativaE.setMaximumSize(new Dimension(830, 65));
			alternativaE.setPreferredSize(new Dimension(830, 65));
		} else{
			alternativaE.setMaximumSize(new Dimension(830, 30));
			alternativaE.setPreferredSize(new Dimension(830, 30));
		}
		alternativaE.setText("<html><p style='text-shadow: 2px 2px #ff0000;'>E) " + pergunta.getReposta5() + "</p></html>");
		alternativaE.setToolTipText(pergunta.getReposta4());
	}
	
	public Participante getParticipanteVez() {
		//Verifica se o participante esta null pois se estiver é o começo do jogo então seta o primeiro participante da lista
		if(participanteVez == null) {
			participanteVez = listaParticipantes.get(0);//Setando o primeiro participante
			rodadaAtual++;//Adicionando a primeira rodada
		}
		return participanteVez;
	}
	
	public void setParticipanteVez(String nome) {
		//For para poder percorer a lista de particioantes
		for (int i = 0; i < listaParticipantes.size(); i++) {
			Participante p = listaParticipantes.get(i);//Capturando o participarte da lista
			//Comparando nome recebido como atributo com participante da lista
			if(nome.equals(p.getNome())) {
				//Comparando se o participante não é o último da lista
				if(i != listaParticipantes.size() - 1) {
					participanteVez = listaParticipantes.get(i + 1);//Setando o próximo participante na vez de jogar
					break;//Break caso não precise que o for rode mais vezes do que necessario
				} else {//Se o participante for o último da lista irá ser setado no participante da vez o primeiro participante da lista o que indica fim de rodada
					participanteVez = listaParticipantes.get(0);//Setando o próximo participante na vez de jogar
					rodadaAtual++;//Fim de rodada. Adicionando a proxima rodada
				}
			}
		}
	}

	//EXEMPLO DE SPLIT POR NUMERO DE CARACTERES
	//Método recebe o texto e a quantidade de caracteres de cada linha
	private String[] dividirPorNumeroDeCaracteres(String texto, int caracteres) {
		//Confere se o texto e a quantidade de caracteres é diferente de nulo 
	    if(texto == null || caracteres <= 0)
	        return null;
	    //Divide o tamanho do texto pela quantidade de caracteres para encontrar a quantidade de linhas
	    int qtdLinhas = texto.length() / caracteres + ((texto.length() % caracteres > 0) ? 1 : 0);
	    //Cria um array de String com o tamanho igual a quantidade de linhas necessárias
	    String[] linhas = new String[qtdLinhas];
	    //Laço que percorre cada caractere do texto passado
	    for(int i = 0, j = 0, l = texto.length(); i < l; i += caracteres, j++)
	    	//Preenche a Linha com os caracteres 
	        linhas[j] = texto.substring(i, Math.min(l, i + caracteres));
	    //Retorna as Linhas de Texto
	    return linhas;
	}
	
	//MÉTODO CONFIRMAR
	public void confirmar(boolean resultado){
		resultadoOficial = resultado;
	}
	
	//MÉTODOS DE CONTADOR
	private void iniciarActionPerformed(ActionEvent evt) {  
        contador = true;  
        iniciar.setEnabled(false);  
        pausar.setEnabled(true);  
        imagemContador.setIcon(iconeContador2);
    }  

    private void pausarActionPerformed(ActionEvent evt) {  
        contador = false;  
        iniciar.setEnabled(true);  
        pausar.setEnabled(false);
        imagemContador.setIcon(iconeContador);
    }  

    private void zerarActionPerformed(ActionEvent evt) {  
        contador = false;  
        lConta.setText("00:00:00");  
        zerado = true;  
        lConta.revalidate();  
        iniciar.setEnabled(true);  
        pausar.setEnabled(false);  
    }  


    public static boolean isContador(){  
        return contador;  
    }  

    public static boolean isZerado(){  
        return zerado;  
    }  

    public static void setZerado(boolean zero){  
        zerado = zero;  
    }
}
