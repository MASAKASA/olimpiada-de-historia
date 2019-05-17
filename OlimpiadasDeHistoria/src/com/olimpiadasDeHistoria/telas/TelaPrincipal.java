package com.olimpiadasDeHistoria.telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import com.olimpiadasDeHistoria.modelo.participante.Participante;
import com.olimpiadasDeHistoria.modelo.pergunta.Pergunta;
import com.olimpiadasDeHistoria.util.NomeDaTela;


public class TelaPrincipal extends JFrame {

	//Capturando a resolução do dispositivo
	static GraphicsDevice dispositivo = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
	static int posicao = 0;
	
	//Istanciando painéis
	public static JLayeredPane painelAuxiliarCamada = new JLayeredPane();
	private static JPanel painelPergaminho = new JPanel();
	private static JPanel painelPergaminhoQuadrado = new JPanel();
	private static JPanel painelMadeira = new JPanel();
    private static JPanel painelConteudo = new JPanel();
    private static JPanel painelSuperior = new JPanel();
    private static JLabel lblNewLabel;
    private static JLabel lblNewLabel1;
    private static JLabel lblNewLabel2;
    static int rodadaAtual = 0;

    //Instanciando Tela
    static TelaPrincipal frame = new TelaPrincipal();
	/**
	 * Launch the application.
	 */
    
    //Método que muda o conteúdo da Tela
    public void mudarConteudo(String nomeDaTela){
    	
    	//Tamanho da imagem pergaminho
        int h = lblNewLabel.getIcon().getIconHeight();
        int w = lblNewLabel.getIcon().getIconWidth();
        
    	//DEFININDO O PAINEL CONTEÚDO
        
        //Principal
        if(nomeDaTela.equals(NomeDaTela.TELA_PRINCIPAL)){
        	painelConteudo.removeAll();
        	painelConteudo.add(new PainelPrincipal(frame));
        	painelConteudo.validate();
        	painelConteudo.repaint();
        	
        	painelAuxiliarCamada.add(painelPergaminho, new Integer(1), 0);
        }
	    	
        //Escolha de Participantes
        else if(nomeDaTela.equals(NomeDaTela.TELA_ESCOLHA_PARTICIPANTES)){
        	painelConteudo.removeAll();
        	painelConteudo.add(new PainelEscolhaParticipantes(frame,(w-165),(frame.getHeight()-15)));
        	painelConteudo.validate();
        	painelConteudo.repaint();
        	
        	painelAuxiliarCamada.add(painelPergaminho, new Integer(1), 0);
        }
                
        //Haking
        else if(nomeDaTela.equals(NomeDaTela.TELA_HANKING)){
        	painelConteudo.removeAll();
        	painelConteudo.add(new PainelPontuacao(frame,(w-165),(frame.getHeight()-15)));
        	painelConteudo.validate();
        	painelConteudo.repaint();
        	
        	painelAuxiliarCamada.add(painelPergaminhoQuadrado, new Integer(1), 0);
        }
        
        //Cadastro Questão
        else if(nomeDaTela.equals(NomeDaTela.TELA_CADASTRO_QUESTAO)){
        	painelConteudo.removeAll();
        	painelConteudo.add(new PainelCadastroQuestao(frame));
        	painelConteudo.validate();
        	painelConteudo.repaint();
        	
        	painelAuxiliarCamada.add(painelPergaminho, new Integer(1), 0);
        }
        
        //Cadastro Participante
        else if(nomeDaTela.equals(NomeDaTela.TELA_CADASTRO_PARTICIPANTES)){
        	painelConteudo.removeAll();
        	painelConteudo.add(new PainelCadastroParticipante(frame,(w-165),(frame.getHeight()-15)));
        	painelConteudo.validate();
        	painelConteudo.repaint();
        	
        	painelAuxiliarCamada.add(painelPergaminho, new Integer(1), 0);
        }
        
        //Configurações
        else if(nomeDaTela.equals(NomeDaTela.TELA_CONFIG)){
        	painelConteudo.removeAll();
        	painelConteudo.add(new PainelConfiguracoes(frame));
        	painelConteudo.validate();
        	painelConteudo.repaint();
        	
        	painelAuxiliarCamada.add(painelPergaminho, new Integer(1), 0);
        }
        
        //Sair
        else if(nomeDaTela.equals(NomeDaTela.TELA_SAIR)){
        	painelConteudo.removeAll();
        	painelConteudo.add(new PainelSair(frame));
        	painelConteudo.validate();
        	painelConteudo.repaint();
        	
        	painelAuxiliarCamada.add(painelPergaminho, new Integer(1), 0);
        }
        
        //Definindo o tamanho do painel
        painelConteudo.setBounds((frame.getWidth() - w)/2,0,w,h);
        painelConteudo.setOpaque(false);
        painelConteudo.setBackground(Color.BLACK);
        painelAuxiliarCamada.add(painelConteudo, new Integer(2), 0);
    	    	
    }
    
    public void mostrarMensagem(String mensagem, String titulo, String nomeDaTela){
    	
    	//Tamanho da imagem pergaminho
        int h = lblNewLabel.getIcon().getIconHeight();
        int w = lblNewLabel.getIcon().getIconWidth();
        
    	//Mensagem
    	painelConteudo.removeAll();
    	painelConteudo.add(new PainelMensagem(frame,mensagem,titulo, nomeDaTela));
    	painelConteudo.validate();
    	painelConteudo.repaint();
        
        //Definindo o tamanho do painel
        painelConteudo.setBounds((frame.getWidth() - w)/2,0,w,h);
        painelConteudo.setOpaque(false);
        painelConteudo.setBackground(Color.BLACK);
        painelAuxiliarCamada.add(painelConteudo, new Integer(2), 0);
        
    }
    
    public boolean irProxima(boolean resultado){
    	return resultado;
    }
    public void iniciarOlimpiada(int numeroRodadas,int rodadaAtual, int pontosPorQuestao, List<Participante> listaParticipantes){
    	
    	//Tamanho da imagem pergaminho
        int h = lblNewLabel.getIcon().getIconHeight();
        int w = lblNewLabel.getIcon().getIconWidth();
        
        
        //while comparando se as rodadas completaram pra poder reiniciar o painelOlimpiada
        //while(rodadaAtual<numeroRodadas){
	        //Como o método iniciar Olimpíada só é chamado ao iniciar a olimpíada, então o jogador da vez é o primeiro da lista
	        //Por isso posição = 0
	        int jogadorDaVez = 0;
	        
			//Olimpíada
	    	painelConteudo.removeAll();
	    	painelConteudo.add(new PainelOlimpiada(frame,(w-165),(frame.getHeight()-15),pontosPorQuestao,numeroRodadas, rodadaAtual, listaParticipantes));
	    	painelConteudo.validate();
	    	painelConteudo.repaint();
			
			painelAuxiliarCamada.add(painelPergaminhoQuadrado, new Integer(1), 0);
	    	
	        //Definindo o tamanho do painel
	        painelConteudo.setBounds((frame.getWidth() - w)/2,0,w,h);
	        painelConteudo.setOpaque(false);
	        painelConteudo.setBackground(Color.BLACK);
	        painelAuxiliarCamada.add(painelConteudo, new Integer(2), 0);
	        
        //}
    }
    
    public void addPainelConfirmacao(PainelOlimpiada painelOlimpiada, TelaPrincipal tp, String alternativa, Pergunta pergunta, Participante participante, int pontosPorQuestao){
    	
    	//Tamanho da imagem pergaminho
        int h = lblNewLabel.getIcon().getIconHeight();
        int w = lblNewLabel.getIcon().getIconWidth();
        
        PainelConfirmacao painelConfirmacao = new PainelConfirmacao(painelOlimpiada, tp, w, h, alternativa, pergunta, participante, pontosPorQuestao); 
    	painelSuperior.removeAll();
    	painelSuperior.add(painelConfirmacao);
    	painelSuperior.validate();
    	painelSuperior.repaint();
    	painelSuperior.setBounds((frame.getWidth() - w)/2,0,w,h);
    	painelSuperior.setOpaque(false);
    	
    	painelAuxiliarCamada.add(painelSuperior, new Integer(3), 0);
    	painelAuxiliarCamada.validate();
    	painelAuxiliarCamada.repaint();
    }
    
    public void addPainelVoltarMenu(PainelOlimpiada painelOlimpiada, TelaPrincipal tp){
    	
    	//Tamanho da imagem pergaminho
        int h = lblNewLabel.getIcon().getIconHeight();
        int w = lblNewLabel.getIcon().getIconWidth();
        
        PainelVoltarMenu painelVoltarMenu = new PainelVoltarMenu(painelOlimpiada, tp, w, h); 
    	painelSuperior.removeAll();
    	painelSuperior.add(painelVoltarMenu);
    	painelSuperior.validate();
    	painelSuperior.repaint();
    	painelSuperior.setBounds((frame.getWidth() - w)/2,0,w,h);
    	painelSuperior.setOpaque(false);
    	
    	painelAuxiliarCamada.add(painelSuperior, new Integer(3), 0);
    	painelAuxiliarCamada.validate();
    	painelAuxiliarCamada.repaint();
    }
    
    public void removePainelConfirmacao(){
    	painelSuperior.removeAll();
    	painelSuperior.validate();
    	painelSuperior.repaint();
    	painelAuxiliarCamada.remove(painelSuperior);
    	painelAuxiliarCamada.validate();
    	painelAuxiliarCamada.repaint();
    }
    //Repetição para não ter que mexer em outros painel
    public void PainelVoltarMenu(){
    	painelSuperior.removeAll();
    	painelSuperior.validate();
    	painelSuperior.repaint();
    	painelAuxiliarCamada.remove(painelSuperior);
    	painelAuxiliarCamada.validate();
    	painelAuxiliarCamada.repaint();
    }

//    public void retomarOlimpiada(int numeroRodadasRestantes, int pontosPorQuestao, List<Participante> listaParticipantes){
//    	//Tamanho da imagem pergaminho
//        int h = lblNewLabel.getIcon().getIconHeight();
//        int w = lblNewLabel.getIcon().getIconWidth();
//        
//    	//Olimpíada
//    	painelConteudo.removeAll();
//    	painelConteudo.add(new PainelOlimpiada(frame,(w-165),(frame.getHeight()-15),pontosPorQuestao,listaParticipantes));
//    	painelConteudo.validate();
//    	painelConteudo.repaint();
//        
//        //Definindo o tamanho do painel
//        painelConteudo.setBounds((frame.getWidth() - w)/2,0,w,h);
//        painelConteudo.setOpaque(false);
//        painelConteudo.setBackground(Color.BLACK);
//        painelAuxiliarCamada.add(painelConteudo, new Integer(2), 0);
//    }
    
    public void configuracaoInicial(List<Participante> listaParticipantes){
    	
    	//Tamanho da imagem pergaminho
        int h = lblNewLabel.getIcon().getIconHeight();
        int w = lblNewLabel.getIcon().getIconWidth();
        
    	//Configuração Inicial
    	painelConteudo.removeAll();
    	painelConteudo.add(new PainelConfiguracaoInicial(frame,listaParticipantes));
    	painelConteudo.validate();
    	painelConteudo.repaint();
    	
    	painelAuxiliarCamada.add(painelPergaminho, new Integer(1), 0);
    	
    	//Definindo o tamanho do painel
    	painelConteudo.setBounds((frame.getWidth() - w)/2,0,w,h);
        painelConteudo.setOpaque(false);
        painelConteudo.setBackground(Color.BLACK);
        painelAuxiliarCamada.add(painelConteudo, new Integer(2), 0);
        
    }
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Escondendo as bordas da tela
				    frame.setUndecorated(true);
				    
				    //Fullscreen
				    dispositivo.setFullScreenWindow(frame);
				    frame.setPreferredSize(frame.getSize());
				    
				    //Layout do frame
			        frame.getContentPane().setLayout(new BorderLayout());
			        
			        //Adicionando painel auxiliar
			        frame.getContentPane().add(painelAuxiliarCamada, BorderLayout.CENTER);
			        
			        //Título
			        frame.setTitle("Olimpíada de História");
			        
			        //Retangulo que guarda o tamanho da tela
			        Rectangle a = frame.getBounds();
			        
			        //Definindo painel pergaminho
			        painelPergaminho.setBounds(a);
			        painelPergaminhoQuadrado.setBounds(a);
			        painelPergaminho.setOpaque(false);
			        painelPergaminhoQuadrado.setOpaque(false);
			        
			        //Definindo painel madeira			        
			        painelMadeira.setBounds(a);
			        painelMadeira.setOpaque(false);

			        //Adicionando painéis de imagem
			        painelAuxiliarCamada.add(painelMadeira, new Integer(0), 0);
			        painelAuxiliarCamada.add(painelPergaminho, new Integer(1), 0);
			        
			        //Mudando conteúdo da tela
			        frame.mudarConteudo(NomeDaTela.TELA_PRINCIPAL);
			        
			        //Juntando tudo no frame
			        frame.pack();
			        
			        //Mostrando a tela
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lblNewLabel = new JLabel("");
		ImageIcon pergaminho = new ImageIcon(TelaPrincipal.class.getResource("/com/olimpiadasDeHistoria/imagens/pergaminhoTeste.png"));
		lblNewLabel.setIcon(pergaminho);
		painelPergaminho.add(lblNewLabel);
		
		lblNewLabel1 = new JLabel("");
		ImageIcon pergaminho2 = new ImageIcon(TelaPrincipal.class.getResource("/com/olimpiadasDeHistoria/imagens/pergaminhoQuadrado.png"));
		lblNewLabel1.setIcon(pergaminho2);
		painelPergaminhoQuadrado.add(lblNewLabel1);
		
		lblNewLabel2 = new JLabel("");
		ImageIcon icone = new ImageIcon(TelaPrincipal.class.getResource("/com/olimpiadasDeHistoria/imagens/background.jpg"));
		Image imagem = icone.getImage(); 
		Image img = imagem.getScaledInstance(1920, 1080, java.awt.Image.SCALE_DEFAULT);  
		icone = new ImageIcon(img);
		lblNewLabel2.setIcon(icone);
		painelMadeira.add(lblNewLabel2);
	}

}
