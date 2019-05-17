package com.olimpiadasDeHistoria.util;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.TextLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ShadowText extends JLabel {

  String texto;
  Font fonte;
	
  public ShadowText(String texto, Font fonte) {
	  this.texto = texto;
	  this.fonte = fonte;
  }

  public void paint(Graphics g) {
	
    String texto = this.getTexto();
    int x = 10;
    int y = 45;
    this.getFonte();
    //Font font = new Font("Lucida Calligraphy", Font.BOLD, 45);
    Graphics2D g1 = (Graphics2D) g;

    TextLayout textLayout = new TextLayout(texto, this.getFonte(), g1.getFontRenderContext());
    g1.setPaint(new Color(255,255,255));
    textLayout.draw(g1, x + 1, y + 2);

    Color c = new Color(95,38,5);
    g1.setPaint(c);
    textLayout.draw(g1, x, y);
  }

//  public static void main(String[] args) throws IOException {
//    JFrame f = new JFrame();
//    f.add(new ShadowText("akhsgddkhagsdkhge"));
//    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    f.setSize(450, 150);
//
//    f.setVisible(true);
//
//  }

public String getTexto() {
	return texto;
}

public void setTexto(String texto) {
	this.texto = texto;
}

public Font getFonte() {
	return fonte;
}

public void setFonte(Font fonte) {
	this.fonte = fonte;
}

public void setAlinhamento(int alinhamento){
	this.setHorizontalAlignment(alinhamento);
}
}