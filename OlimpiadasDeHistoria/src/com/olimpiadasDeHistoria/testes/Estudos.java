package com.olimpiadasDeHistoria.testes;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;

public class Estudos extends JFrame {
	
	JTextArea textArea;
	  JButton btn;
	
	  public Estudos() {
	    super("Ordenando as linhas de um JTextArea");
	Container c = getContentPane();
	FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
	c.setLayout(layout);
	
	textArea = new JTextArea(10, 20);
	textArea.setLineWrap(true);
	
	btn = new JButton("Ordenar Linhas");
	btn.addActionListener(
	   new ActionListener(){
	      public void actionPerformed(ActionEvent e){
	        int quant = textArea.getLineCount();
	        ArrayList lista = new ArrayList();
	        
	        // obtém todas as linhas de texto do JTextArea
	        for(int i = 0; i < quant; i++){
	            try{
	                int inicio = textArea.getLineStartOffset(i);
	                int fim = textArea.getLineEndOffset(i);
	                String linha = textArea.getText(inicio, fim - inicio);
	                linha = linha.replace("", " ");
	                lista.add(linha);
	            }
	            catch(BadLocationException ble){
	                // possiveis erros são tratados aqui
	            } 
	        }
	        
	        // limpa o JTextArea
	        textArea.setText("");
	        
	        // ordena as linhas
	        Collections.sort(lista);
	        
	        // coloca as linhas de volta no JTextArea
	        StringBuffer texto = new StringBuffer();
	        for(int i = 0; i < lista.size(); i++) { 
	            texto.append(lista.get(i).toString() + ' '); 
	            }
	            
	            textArea.setText(texto.toString());   
	          }
	       });
	       
	    c.add(textArea);
	    c.add(btn);
	    
	    setSize(350, 250);
	    setVisible(true);
	  }
	  
	  public static void main(String args[]){
	    Estudos app = new Estudos();
	    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  }
}
