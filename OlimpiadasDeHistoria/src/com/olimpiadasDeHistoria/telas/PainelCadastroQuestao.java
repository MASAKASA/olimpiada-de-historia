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
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.olimpiadasDeHistoria.fachada.Fachada;
import com.olimpiadasDeHistoria.modelo.pergunta.Pergunta;
import com.olimpiadasDeHistoria.modelo.pergunta.PerguntaJaCadastradaException;
import com.olimpiadasDeHistoria.util.IFactoryCadastro;
import com.olimpiadasDeHistoria.util.NomeDaTela;
import com.olimpiadasDeHistoria.util.ShadowText;
//TELA CONCLUÍDA 29/08/2016
public class PainelCadastroQuestao extends JPanel {

	//Criando icone dos botões
    ImageIcon icone = new ImageIcon(TelaPrincipal.class.getResource("/com/olimpiadasDeHistoria/imagens/botao_official.png"));
		
    //Criando icone dos botões
    ImageIcon icone2 = new ImageIcon(TelaPrincipal.class.getResource("/com/olimpiadasDeHistoria/imagens/btn_1.png"));
	  
	//Criando os botões
	JButton btnCadastrar = new JButton("Cadastrar",icone);
    JButton btnVoltar = new JButton("Voltar",icone);
    
    //Criando os radioButtons
    private final JRadioButton rdbtn1 = new JRadioButton();
    private final JRadioButton rdbtn2 = new JRadioButton();
    private final JRadioButton rdbtn3 = new JRadioButton();
    private final JRadioButton rdbtn4 = new JRadioButton();
    private final JRadioButton rdbtn5 = new JRadioButton();
    
    //Cor Texto Botão
  	Color cor = new Color(81,41,1);	
    
    //Tela Principal
    TelaPrincipal tp;
    
    private static Pergunta pergunta;
	private static Fachada fachada;
	private static IFactoryCadastro factoryCadastro;
    
	public PainelCadastroQuestao(TelaPrincipal tp) {
		//Recebendo a Tela Principal
		this.tp = tp;
		
		//Criando caixa vertical maior
		Box caixa = Box.createVerticalBox();
			
		//Criando caixa horizontal com botões
		Box caixaHorizontalBtn = Box.createHorizontalBox();
		caixaHorizontalBtn.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		//Criando caixa vertical com as alternativas
		Box caixaVerticalAlternativa = Box.createVerticalBox();
		caixaVerticalAlternativa.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		//Criando caixa vertical com os radiobuttons
		Box caixaVerticalRadio = Box.createVerticalBox();
		caixaVerticalRadio.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		//Criando caixa horizontal com as alternativas e os radiobuttons
		Box caixaHorizontalAlternativas = Box.createHorizontalBox();
		caixaHorizontalAlternativas.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		//Label Menu Cadastro de Questao
		ShadowText menu = new ShadowText("   Cadastro de Questão", new Font("Lucida Calligraphy", Font.BOLD, 45));
		menu.setHorizontalAlignment(SwingConstants.CENTER);
		menu.setHorizontalTextPosition(SwingConstants.CENTER);
		menu.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 30));
		menu.setMaximumSize(new Dimension(610, 120));
		menu.setPreferredSize(new Dimension(610, 120));
		Color c = new Color(95,38,5);
		menu.setForeground(c);
		
		//Label Enunciado
		ShadowText enunciado = new ShadowText("            Enunciado", new Font("Lucida Calligraphy", Font.BOLD, 40));
		enunciado.setHorizontalAlignment(SwingConstants.CENTER);
		enunciado.setHorizontalTextPosition(SwingConstants.CENTER);
		enunciado.setMaximumSize(new Dimension(610, 50));
		enunciado.setPreferredSize(new Dimension(610, 50));
		
		//TextField Enunciado
		JTextField tfEnunciado = new JTextField();
		tfEnunciado.setAlignmentX(Component.LEFT_ALIGNMENT);
		tfEnunciado.setHorizontalAlignment(SwingConstants.CENTER);
		tfEnunciado.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 20));
		tfEnunciado.setMaximumSize(new Dimension(610, 40));
		tfEnunciado.setPreferredSize(new Dimension(610, 40));
		tfEnunciado.setForeground(Color.BLACK);
		tfEnunciado.setBorder(new LineBorder(new Color(95,38,5),2));
		
		//Label Alternativas
		ShadowText alternativa = new ShadowText("          Alternativas", new Font("Lucida Calligraphy", Font.BOLD, 40));
		alternativa.setHorizontalAlignment(SwingConstants.CENTER);
		alternativa.setHorizontalTextPosition(SwingConstants.CENTER);
		alternativa.setMaximumSize(new Dimension(610, 50));
		alternativa.setPreferredSize(new Dimension(610, 50));
		alternativa.setForeground(Color.BLACK);
		
		//RADIOBUTTONS
		//RadioButton 1
		rdbtn1.setBorder(new LineBorder(new Color(95,38,5),2));
		rdbtn1.setMaximumSize(new Dimension(20, 40));
		rdbtn1.setPreferredSize(new Dimension(20, 40));
		rdbtn1.setOpaque(false);
		
		//RadioButton 1
		rdbtn2.setBorder(new LineBorder(new Color(95,38,5),2));
		rdbtn2.setMaximumSize(new Dimension(20, 40));
		rdbtn2.setPreferredSize(new Dimension(20, 40));
		rdbtn2.setOpaque(false);
		
		//RadioButton 1
		rdbtn3.setBorder(new LineBorder(new Color(95,38,5),2));
		rdbtn3.setMaximumSize(new Dimension(20, 40));
		rdbtn3.setPreferredSize(new Dimension(20, 40));
		rdbtn3.setOpaque(false);
		
		//RadioButton 1
		rdbtn4.setBorder(new LineBorder(new Color(95,38,5),2));
		rdbtn4.setMaximumSize(new Dimension(20, 40));
		rdbtn4.setPreferredSize(new Dimension(20, 40));
		rdbtn4.setOpaque(false);
				
		//RadioButton 1
		rdbtn5.setBorder(new LineBorder(new Color(95,38,5),2));
		rdbtn5.setMaximumSize(new Dimension(20, 40));
		rdbtn5.setPreferredSize(new Dimension(20, 40));
		rdbtn5.setOpaque(false);
		
		//ButtonGroup
		ButtonGroup btnGrupo = new ButtonGroup();
		btnGrupo.add(rdbtn1);
		btnGrupo.add(rdbtn2);
		btnGrupo.add(rdbtn3);
		btnGrupo.add(rdbtn4);
		btnGrupo.add(rdbtn5);
		
		//ALTERNATIVAS
		//TextField Alternativa 1
		JTextField tfAlternativa1 = new JTextField();
		tfAlternativa1.setToolTipText("");
		tfAlternativa1.setAlignmentX(Component.LEFT_ALIGNMENT);
		tfAlternativa1.setHorizontalAlignment(SwingConstants.CENTER);
		tfAlternativa1.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 20));
		tfAlternativa1.setMaximumSize(new Dimension(590, 40));
		tfAlternativa1.setPreferredSize(new Dimension(590, 40));
		tfAlternativa1.setForeground(Color.BLACK);
		tfAlternativa1.setBorder(new LineBorder(new Color(95,38,5),2));
		
		//TextField Alternativa 2
		JTextField tfAlternativa2 = new JTextField();
		tfAlternativa2.setToolTipText("");
		tfAlternativa2.setAlignmentX(Component.LEFT_ALIGNMENT);
		tfAlternativa2.setHorizontalAlignment(SwingConstants.CENTER);
		tfAlternativa2.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 20));
		tfAlternativa2.setMaximumSize(new Dimension(590, 40));
		tfAlternativa2.setPreferredSize(new Dimension(590, 40));
		tfAlternativa2.setForeground(Color.BLACK);
		tfAlternativa2.setBorder(new LineBorder(new Color(95,38,5),2));
		
		//TextField Alternativa 3
		JTextField tfAlternativa3 = new JTextField();
		tfAlternativa3.setToolTipText("");
		tfAlternativa3.setAlignmentX(Component.LEFT_ALIGNMENT);
		tfAlternativa3.setHorizontalAlignment(SwingConstants.CENTER);
		tfAlternativa3.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 20));
		tfAlternativa3.setMaximumSize(new Dimension(590, 40));
		tfAlternativa3.setPreferredSize(new Dimension(590, 40));
		tfAlternativa3.setForeground(Color.BLACK);
		tfAlternativa3.setBorder(new LineBorder(new Color(95,38,5),2));
		
		//TextField Alternativa 4
		JTextField tfAlternativa4 = new JTextField();
		tfAlternativa4.setToolTipText("");
		tfAlternativa4.setAlignmentX(Component.LEFT_ALIGNMENT);
		tfAlternativa4.setHorizontalAlignment(SwingConstants.CENTER);
		tfAlternativa4.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 20));
		tfAlternativa4.setMaximumSize(new Dimension(590, 40));
		tfAlternativa4.setPreferredSize(new Dimension(590, 40));
		tfAlternativa4.setForeground(Color.BLACK);
		tfAlternativa4.setBorder(new LineBorder(new Color(95,38,5),2));
		
		//TextField Alternativa 5
		JTextField tfAlternativa5 = new JTextField();
		tfAlternativa5.setToolTipText("");
		tfAlternativa5.setAlignmentX(Component.LEFT_ALIGNMENT);
		tfAlternativa5.setHorizontalAlignment(SwingConstants.CENTER);
		tfAlternativa5.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 20));
		tfAlternativa5.setMaximumSize(new Dimension(590, 40));
		tfAlternativa5.setPreferredSize(new Dimension(590, 40));
		tfAlternativa5.setForeground(Color.BLACK);
		tfAlternativa5.setBorder(new LineBorder(new Color(95,38,5),2));
		
		//Botão Cadastrar
		btnCadastrar.setMaximumSize(new Dimension(305, 90));
		btnCadastrar.setPreferredSize(new Dimension(305, 90));
		btnCadastrar.setAlignmentX(Component.LEFT_ALIGNMENT);
		btnCadastrar.setFocusPainted(false);
		btnCadastrar.setMargin(new Insets(2, 2, 2, 2));
		btnCadastrar.setContentAreaFilled(false);
		btnCadastrar.setBorderPainted(false);
		btnCadastrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCadastrar.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 30));
		btnCadastrar.setForeground(cor);
		btnCadastrar.setVerticalTextPosition(SwingConstants.CENTER);
		btnCadastrar.setHorizontalTextPosition(SwingConstants.CENTER);
		setOpaque(true);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Ação Cadastrar
				try {
					fachada = Fachada.getFachada();
					
					String enunciado = tfEnunciado.getText();
					String resposta1 = tfAlternativa1.getText();
					String resposta2 = tfAlternativa2.getText();
					String resposta3 = tfAlternativa3.getText();
					String resposta4 = tfAlternativa4.getText();
					String resposta5 = tfAlternativa5.getText();
					String respostaCerta = "";
					if(rdbtn1.isSelected()){
						respostaCerta = tfAlternativa1.getText();
					}else if(rdbtn2.isSelected()){
						respostaCerta = tfAlternativa2.getText();
					}else if(rdbtn3.isSelected()){
						respostaCerta = tfAlternativa3.getText();
					}else if(rdbtn4.isSelected()){
						respostaCerta = tfAlternativa4.getText();
					}else if(rdbtn5.isSelected()){
						respostaCerta = tfAlternativa5.getText();
					}
				
					pergunta = new Pergunta(enunciado, resposta1, resposta2, resposta3, resposta4, resposta5, respostaCerta);//.criarPergunta(enunciado, resposta1, resposta2, resposta3, resposta4, resposta5, respostaCerta);
					
					fachada.cadastrarPergunta(pergunta);
					
					tp.mostrarMensagem("      Questão cadastrada com sucesso!!", "                  Mensagem", NomeDaTela.TELA_CADASTRO_QUESTAO);
				} catch (PerguntaJaCadastradaException exception) {
					tp.mostrarMensagem("    " + exception.getMessage(), "                       Erro", NomeDaTela.TELA_CADASTRO_QUESTAO);
					System.out.println(exception.getMessage());
				}catch (Exception exception) {
					tp.mostrarMensagem("    " + exception.getMessage(), "                       Erro", NomeDaTela.TELA_CADASTRO_QUESTAO);
					System.out.println(exception.getMessage());
				}
				
			}
		});
		btnCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnCadastrar.setIcon(icone2);
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnCadastrar.setIcon(icone);
		    }

		});
		
		//Botão Voltar
        btnVoltar.setMaximumSize(new Dimension(305, 90));
        btnVoltar.setPreferredSize(new Dimension(305, 90));
        btnVoltar.setAlignmentX(Component.LEFT_ALIGNMENT);
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
		
		//Adicionando RadioButtons à caixa vertical de RadioButtons
		caixaVerticalRadio.add(rdbtn1);
		caixaVerticalRadio.add(Box.createVerticalStrut(10));
		caixaVerticalRadio.add(rdbtn2);
		caixaVerticalRadio.add(Box.createVerticalStrut(10));
		caixaVerticalRadio.add(rdbtn3);
		caixaVerticalRadio.add(Box.createVerticalStrut(10));
		caixaVerticalRadio.add(rdbtn4);
		caixaVerticalRadio.add(Box.createVerticalStrut(10));
		caixaVerticalRadio.add(rdbtn5);
		
		//Adicionando Alternativas à caixa vertical de Alternativas
		caixaVerticalAlternativa.add(tfAlternativa1,CENTER_ALIGNMENT);
		caixaVerticalAlternativa.add(Box.createVerticalStrut(10));
		caixaVerticalAlternativa.add(tfAlternativa2,CENTER_ALIGNMENT);
		caixaVerticalAlternativa.add(Box.createVerticalStrut(10));
		caixaVerticalAlternativa.add(tfAlternativa3,CENTER_ALIGNMENT);
		caixaVerticalAlternativa.add(Box.createVerticalStrut(10));
		caixaVerticalAlternativa.add(tfAlternativa4,CENTER_ALIGNMENT);
		caixaVerticalAlternativa.add(Box.createVerticalStrut(10));
		caixaVerticalAlternativa.add(tfAlternativa5,CENTER_ALIGNMENT);
		
		//Adicionando Botões à caixa horizontal de botões 
		caixaHorizontalBtn.add(btnVoltar,CENTER_ALIGNMENT);
		caixaHorizontalBtn.add(btnCadastrar,CENTER_ALIGNMENT);
		
		//Adicionando radioButtons e Alternativas à caixa horizontal de rdbtns e alternativas
		caixaHorizontalAlternativas.add(caixaVerticalRadio,CENTER_ALIGNMENT);
		caixaHorizontalAlternativas.add(caixaVerticalAlternativa,CENTER_ALIGNMENT);
		
		//Adicionando componentes à caixa vertical maior
		caixa.add(Box.createVerticalStrut(100));
		caixa.add(menu,CENTER_ALIGNMENT);
		caixa.add(Box.createVerticalStrut(20));
		caixa.add(enunciado,CENTER_ALIGNMENT);
		caixa.add(Box.createVerticalStrut(10));
		caixa.add(tfEnunciado,CENTER_ALIGNMENT);
		caixa.add(Box.createVerticalStrut(20));
		caixa.add(alternativa,CENTER_ALIGNMENT);
		caixa.add(Box.createVerticalStrut(10));
		caixa.add(caixaHorizontalAlternativas,CENTER_ALIGNMENT);
		caixa.add(Box.createVerticalStrut(10));
		caixa.add(caixaHorizontalBtn);
		
		//Adicionando caixa ao Painel
		add(caixa);
	}
	
	//get TelaPrincipal
	public TelaPrincipal getTp() {
		return tp;
	}

}
