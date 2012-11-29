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

		
      
        Random ran = new Random();
        
        int flor = 1;
        while (flor < 18) {
        	flower(g, ran.nextInt(1366), 100);
        	flor = flor + 1;
        }
        

	}


	private void pause(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
		}
		
	}


	void flower(Graphics g, int x, int y) {
		Random ran = new Random();
		//int size = ran.nextInt(5)+1;
		int size =1;
		randomColor(g);
		g.fillRect(x, y, 9*size, 200*size);
          g.fillRect(x, y + 90*size, 80*size,30*size);
  		randomColor(g);
          g.fillOval(x - 10*size,y -10*size, 40*size, 38*size);
  		randomColor(g);
      	 g.fillOval(x - 10*size,y -46*size, 40*size, 38*size);
      	 g.fillOval(x - 10*size,y + 23*size, 40*size, 38*size);
      	 g.fillOval(x - 50*size,y -10*size, 40*size, 38*size);
      	 g.fillOval(x + 30*size,y -10*size, 40*size, 38*size);
	}


	private void randomColor(Graphics g) {
		Random ran = new Random();
		g.setColor(new Color(ran.nextInt(256),ran.nextInt(256),ran.nextInt(256)));
	}
	


}
