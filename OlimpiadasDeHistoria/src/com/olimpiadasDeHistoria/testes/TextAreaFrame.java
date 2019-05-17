package com.olimpiadasDeHistoria.testes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextAreaFrame extends JFrame {

	private JTextArea textArea1;
	private JTextArea textArea2;
	private JButton copyButton;
	
	public TextAreaFrame()  {
		
		super("TextArea Demo");
		
		Box box = Box.createHorizontalBox();
		
		String demo = "No Estado Moderno o Rei tinha uma imagem de grandeza, seus súditos o veneravam, isso acontecia devido a:";
		textArea1 = new JTextArea(demo, 10, 15);
		
		/*
		 * 
		 */
		textArea1.setLineWrap(true);//Linha que não esta no exemplo do livro e quebra linha. Não perfeito mas...kkk
		/*
		 * 
		 */
		
		box.add(new JScrollPane(textArea1));
		
		copyButton = new JButton("Copy >>>");
		box.add(copyButton);
		copyButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea2.setText(textArea1.getSelectedText());
			}
		});
		
		textArea2 = new JTextArea(10, 15);
		textArea2.setEditable(false);
		
		/*
		 * 
		 */
		textArea2.setLineWrap(true);//Linha que não esta no exemplo do livro e quebra linha. Não perfeito mas...kkk
		/*
		 * 
		 */
		
		box.add(new JScrollPane(textArea2));
		
		add(box);
	}
}
