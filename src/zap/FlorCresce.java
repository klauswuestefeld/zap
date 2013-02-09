package zap;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;

public class FlorCresce extends JFrame {
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new FlorCresce();
	}

	FlorCresce() {
		setTitle("Zap - Oi Galera!");
		setResizable(true);
		setBounds(100, 50, 500, 400);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (true) {
			repaint();
			pause(10);
		}
	}

	float tamanho = 0.5f;
	
	@Override
	public void paint(Graphics g) {

		// ///////////////////////////
		// ///////////////////////////
		g.clearRect(0, 0, 5000, 4000);

		flower(g, 300, 467, tamanho);
		tamanho = tamanho + 0.001f;
	}

	private void pause(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
		}

	}

	void flower(Graphics g, int x, int y, float size) {
		randomColor(g);
		rect(g, x, y - 200* size, 9 * size, 200 * size);
		rect(g, x, y - 110 * size, 80 * size, 30 * size);
		randomColor(g);
		oval(g, x - 10 * size, y - 210 * size, 40 * size, 38 * size);
		randomColor(g);
		oval(g, x - 10 * size, y - 246 * size, 40 * size, 38 * size);
		oval(g, x - 10 * size, y - 177 * size, 40 * size, 38 * size);
		oval(g, x - 50 * size, y - 210 * size, 40 * size, 38 * size);
		oval(g, x + 30 * size, y - 210 * size, 40 * size, 38 * size);
	}

	private void oval(Graphics g, float x, float y, float width, float height) {
		g.fillOval((int) x, (int) y, (int) width, (int) height);
	}

	private void rect(Graphics g, float x, float y, float width, float height) {
		g.fillRect((int) x, (int) y, (int) width, (int) height);
	}

	private void randomColor(Graphics g) {
		Random ran = new Random();
		g.setColor(new Color(ran.nextInt(256), ran.nextInt(256), ran
				.nextInt(256)));
	}

}
