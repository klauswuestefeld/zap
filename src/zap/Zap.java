package zap;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.JFrame;


public class Zap extends JFrame { private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		new Zap();
	}


	Zap() {
		setTitle("Zap - Oi Galera!");
		setResizable(true);
	    setBounds(100, 50, 500, 400);
	    setExtendedState(JFrame.MAXIMIZED_BOTH);
	    setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		repaint();
	}


	@Override
	public void paint(Graphics g) {
		
		
/////////////////////////////
/////////////////////////////		
		g.clearRect(0, 0, 5000, 4000);

		
        flower(g, 97, 39);
        flower(g, -97, -39);
        flower(g, -142, 300);
        flower(g, 306, 80);
        flower(g, 0, 0);
        Random ran = new Random();
        flower(g, ran.nextInt(350), ran.nextInt(350));
        flower(g, ran.nextInt(350), ran.nextInt(350));
        flower(g, ran.nextInt(350), ran.nextInt(350));
      	 /////////////////////////////////	

      	 /////////////////////////////////	

	}


	void flower(Graphics g, int x, int y) {
		Random ran = new Random();
		g.setColor(new Color(ran.nextInt(256),ran.nextInt(256),ran.nextInt(256)));
		g.fillRect(x + 500, y + 400, 9, 200);
          g.fillRect(x + 500, y + 490, 80,30);
  		g.setColor(Color.yellow  );
          g.fillOval(x + 490,y + 390, 40, 38);
      	g.setColor(Color.red  );
      	 g.fillOval(x + 490,y + 354, 40, 38);
      	 g.fillOval(x + 490,y + 423, 40, 38);
      	 g.fillOval(x + 450,y + 390, 40, 38);
      	 g.fillOval(x + 530,y + 390, 40, 38);
	}
	


}
