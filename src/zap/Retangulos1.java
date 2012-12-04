package zap;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;


public class Retangulos1 extends JFrame { private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		new Retangulos1();
	}


	Retangulos1() {
		setTitle("Zap - Oi Galera!!");
		setResizable(true);
	    setBounds(100, 50, 500, 400);
	    setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		repaint();
	}


	@Override
	public void paint(Graphics g) {
		
		
/////////////////////////////
/////////////////////////////		
		g.clearRect(0, 0, 5000, 4000);
		g.setColor(Color.blue);
		
		g.drawRect(60, 99, 500, 500);
		g.drawRect(60, 99, 500, 500);
		g.drawRect(100, 123, 500, 500);
		g.drawRect(90, 70, 500, 500);
		g.drawRect(80, 345, 500, 500);
		g.drawRect(70, 567, 500, 500);
		

	
	
/////////////////////////////////	
/////////////////////////////////	
	}
	


}
