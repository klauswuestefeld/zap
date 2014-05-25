package colorcube;
import static java.awt.Color.BLACK;
import static java.awt.event.KeyEvent.VK_DOWN;
import static java.awt.event.KeyEvent.VK_UP;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class RGBColorCube {

	public static void main(String[] args) {
		new Screen();
	}

}

/////////////////////////////////////////////////////////

@SuppressWarnings("serial")
class Screen extends JFrame {
	
	private int zoom = 1;

	
	{
		SwingUtilities.invokeLater(new Runnable() { @Override public void run() {
			init();
		}});
	}

	
	@Override
	public void paint(Graphics g) {
		super.paint(g);

		Dimension size = getSize();
		Insets ins = getInsets();
		int lines = ((size.height - ins.top  - ins.bottom) / zoom) + 1;
		int cols  = ((size.width  - ins.left - ins.right ) / zoom) + 1;

		fillBackground(g, size, BLACK);
		paintAliveCells(g, ins, lines, cols, BLACK);
	}


	private void zoomIn() {
		zoom += 1;
		repaint();
	}

	
	private void zoomOut() {
		if (zoom == 1) return;
		zoom -= 1;
		repaint();
	}

	
	private void paintAliveCells(Graphics g, Insets ins, int lines, int cols, Color color) {
		g.setColor(color);
		for(int lin = 0; lin < lines; lin++)
			for(int col = 0; col < cols; col++)
				paintAliveCell(g, ins, lin, col);
	}

	
	private void paintAliveCell(Graphics g, Insets ins, int lin, int col) {
		g.setColor(new Color(255, lin % 255, 0));
		g.fillRect(ins.left + col * zoom, ins.top + lin * zoom, zoom, zoom);
	}

	
	private void fillBackground(Graphics g, Dimension size, Color color) {
		g.setColor(color);
		g.fillRect(0, 0, size.width, size.height);
	}

	
	private void init() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 600);
		setVisible(true);
		addKeyListener(new KeyAdapter() { @Override public void keyPressed(KeyEvent keyEvent) { int key = keyEvent.getKeyCode();
			if (key == VK_UP) zoomIn();
			if (key == VK_DOWN) zoomOut();
		}});
	}
	
}
