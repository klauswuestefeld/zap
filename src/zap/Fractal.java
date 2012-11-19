package zap;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;


public class Fractal extends JFrame { private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		new Fractal();
	}


	public Fractal() {
		setTitle("Graph");	  
	    setResizable(true);
	    setBounds(10, 10, _WIDTH, _HEIGHT);
	    setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		repaint();
	}

	private final int[] buffer = new int[_WIDTH * _HEIGHT];
	private long ops;


	@Override
	public void paint(Graphics graphics) {
		long t0 = System.currentTimeMillis();
		ops = 0;
		
		for (int px = _WIDTH - 1; px != 0; px--)
			for (int py = _HEIGHT - 1; py != 0; py--)
				colorPixel(px, py);

		System.out.println("Operations: " + ops + "  Millis ellapsed: " + (System.currentTimeMillis() - t0));

		BufferedImage image = new BufferedImage(_WIDTH, _HEIGHT, BufferedImage.TYPE_INT_RGB);
		image.getRaster().setDataElements(0, 0, _WIDTH, _HEIGHT, buffer);
		graphics.drawImage(image, 0, 0, null);
		
	}


	private static final int _WIDTH = 800;
	private static final int _HEIGHT = 800;

	private void colorPixel(int xPixel, int yPixel) {
		//Brinque c estes numeros:
		float xMin = -1f;
		float yMin = -1f;
		float scale = 2f;
		
		float xReal = xMin + (scale * xPixel / _WIDTH);
		float yReal = yMin + (scale * yPixel / _HEIGHT);

		buffer[(_HEIGHT - yPixel) * _WIDTH + xPixel] = colorFor(xReal, yReal);
		ops += 9;
	}


	private int colorFor(float xReal, float yReal) {
		float x = 0;
		float y = 0;
		
		int blue = 0;
		while ( x*x + y*y < 4 && ++blue < 255) { //Remember: 4 == 2*2
			float temp = x*x - y*y + xReal;
			y = 2*x*y + yReal;
			x = temp;
		}

		ops += 10;
		
		return blue == 255 ? 0 : blue;
	}

}
