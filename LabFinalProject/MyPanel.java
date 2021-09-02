import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.*;

class MyPanel1 extends JPanel{
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.black);
		//대각선과 문자열 그리기
		g.drawString("이미지 없음", getWidth()/2-30, getHeight()/2+5);
		g.drawLine(0, 0, getWidth(), getHeight());		
		g.drawLine(getWidth(), 0, 0, getHeight());		
	}	
}
