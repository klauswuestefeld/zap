package zap;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;


public class Rule39 extends JFrame { private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		new Rule39();
	}


	public Rule39() {
		setTitle("Rule");	  
	    setResizable(true);
	    setBounds(10, 10, _WIDTH, _HEIGHT);
	    setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		repaint();
	}

	private final int[] buffer = new int[_WIDTH * _HEIGHT];


	@Override
	public void paint(Graphics graphics) {
		System.out.println(Color.BLACK.getRGB() + " " + Color.WHITE.getRGB());
		for (int px = _WIDTH - 1; px != 0; px--)
			for (int py = _HEIGHT - 1; py != 0; py--)
				colorPixel(px, py);

		BufferedImage image = new BufferedImage(_WIDTH, _HEIGHT, BufferedImage.TYPE_INT_RGB);
		image.getRaster().setDataElements(0, 0, _WIDTH, _HEIGHT, buffer);
		graphics.drawImage(image, 0, 0, null);
		
	}


	private static final int _WIDTH = 800;
	private static final int _HEIGHT = 800;
	private static final int BLACK = Color.BLACK.getRGB();
	private static final int WHITE = Color.WHITE.getRGB();

	private void colorPixel(int x, int y) {
		buffer[(_HEIGHT - y) * _WIDTH + x] = colorFor(x, y);
	}


	private int colorFor(int x, int y) {
		if (isFirstLine(y))
			return isCenterPixel(x) ? BLACK : WHITE;
		if (isOutOfBounds(y))
			return WHITE;
		int a = previousColor(x - 1, y - 1);
		int b = previousColor(x    , y - 1);
		int c = previousColor(x + 1, y - 1);
		return applyRule(a, b, c);
	}


	private int applyRule(int a, int b, int c) {
		if (matches(a, b, c, BLACK, BLACK, BLACK)) return BLACK;
		if (matches(a, b, c, BLACK, BLACK, WHITE)) return BLACK;
		if (matches(a, b, c, BLACK, WHITE, BLACK)) return BLACK;
		if (matches(a, b, c, BLACK, WHITE, WHITE)) return BLACK;
		if (matches(a, b, c, WHITE, BLACK, BLACK)) return BLACK;
		if (matches(a, b, c, WHITE, BLACK, WHITE)) return BLACK;
		if (matches(a, b, c, WHITE, WHITE, BLACK)) return BLACK;
		if (matches(a, b, c, WHITE, WHITE, WHITE)) return BLACK;
		throw new IllegalStateException();
	}


	private boolean matches(int a, int b, int c, int aMatch, int bMatch, int cMatch) {
		return a == aMatch && b == bMatch && c == cMatch;
	}


	private int previousColor(int x, int y) {
		int result = buffer[(_HEIGHT - y) * _WIDTH + x];
		if (result != WHITE && result != BLACK) throw new IllegalStateException();
		return result;
	}


	private boolean isCenterPixel(int x) {
		return x == _WIDTH / 2;
	}


	private boolean isOutOfBounds(int y) {
		return y < 0 || y > _WIDTH;
	}


	private boolean isFirstLine(int y) {
		return y == 0;
	}

}
