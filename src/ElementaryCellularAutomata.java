


import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;
import static java.awt.event.KeyEvent.VK_DOWN;
import static java.awt.event.KeyEvent.VK_LEFT;
import static java.awt.event.KeyEvent.VK_RIGHT;
import static java.awt.event.KeyEvent.VK_UP;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class ElementaryCellularAutomata {

	public static void main(String[] args) {
		new Screen();
	}

}

/////////////////////////////////////////////////////////

@SuppressWarnings("serial")
class Screen extends JFrame {
	
	private final Model model = new Model(18);
	private int zoom = 1;
	private boolean isFirstTime = true;

	
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

		model.setSize(cols, lines);
		setTitle(model.name() + help());
		
		fillBackground(g, size, WHITE);
		paintAliveCells(g, ins, lines, cols, BLACK);
	}


	private String help() {
		return isFirstTime	? "   > > Use Arrow Keys: Up, Down, Left, Right < <" : "";
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

	
	private void previousRule() {
		model.previousRule();
		repaint();
	}

	
	private void nextRule() {
		model.nextRule();
		repaint();
	}
	
	
	private void paintAliveCells(Graphics g, Insets ins, int lines, int cols, Color color) {
		g.setColor(color);
		for(int lin = 0; lin < lines; lin++)
			for(int col = 0; col < cols; col++)
				paintAliveCell(g, ins, lin, col);
	}

	
	private void paintAliveCell(Graphics g, Insets ins, int lin, int col) {
		if (model.isAlive(lin, col))
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
			isFirstTime = false;
			if (key == VK_UP) zoomIn();
			if (key == VK_DOWN) zoomOut();
			if (key == VK_LEFT) previousRule();
			if (key == VK_RIGHT) nextRule();
		}});
	}
	
}

//////////////////////////////////////////////

class Rule {

	final int number;

	public Rule(int number) {
		this.number = number;
	}

	public boolean valueFor(boolean a, boolean b, boolean c) {
		if (matches(a, b, c, 0, 0, 0)) return ((number >> 0) & 0x01) > 0;
		if (matches(a, b, c, 0, 0, 1)) return ((number >> 1) & 0x01) > 0;
		if (matches(a, b, c, 0, 1, 0)) return ((number >> 2) & 0x01) > 0;
		if (matches(a, b, c, 0, 1, 1)) return ((number >> 3) & 0x01) > 0;
		if (matches(a, b, c, 1, 0, 0)) return ((number >> 4) & 0x01) > 0;
		if (matches(a, b, c, 1, 0, 1)) return ((number >> 5) & 0x01) > 0;
		if (matches(a, b, c, 1, 1, 0)) return ((number >> 6) & 0x01) > 0;
		if (matches(a, b, c, 1, 1, 1)) return ((number >> 7) & 0x01) > 0;
		throw new IllegalStateException();
	}

	public boolean matches(boolean a, boolean b, boolean c, int aMatch, int bMatch, int cMatch) {
		return a == (aMatch == 1) && b == (bMatch == 1) && c == (cMatch == 1);
	}

}

//////////////////////////////////////////////

class Generator {

	static boolean[][] generateCells(int height, int width, Rule rule) {
		boolean[][] cells = new boolean[height][width];
		seedTopCenterCell(cells, width);
		populate(cells, height, width, rule);
		return cells;
	}


	private static void seedTopCenterCell(boolean[][] data, int width) {
		data[0][width / 2] = true;
	}

	
	private static void populate(boolean[][] cells, int height, int width, Rule rule) {
		for(int lin = 1; lin < height; lin++)
			for(int col = 0; col < width; col++)
				cells[lin][col] = isAlive(lin, col, cells, rule);
	}

	
	private static boolean isAlive(int lin, int col, boolean[][] data, Rule rule) {
		boolean a = col == 0 ? data[lin -1][data[lin -1].length - 1] : data[lin -1][col - 1];
		boolean b = data[lin -1][col];
		boolean c = col == data[lin -1].length - 1 ? data[lin -1][0] : data[lin - 1][col + 1];
		return rule.valueFor(a, b, c);
	}
	
}

/////////////////////////////////////////////

class Model {

	private int ruleNumber;

	private int width;
	private int height;
	
	private boolean[][] cells;

	
	Model(int startingRule) {
		ruleNumber = startingRule;
	}


	String name() {
		return "Rule " + ruleNumber;
	}

	
	void setSize(int width, int height) {
		this.width = width;
		this.height = height;
		refreshCells();
	}

	
	void previousRule() {
		ruleNumber -= 1;
		if (ruleNumber == -1) ruleNumber = 255;
		refreshCells();
	}

	void nextRule() {
		ruleNumber += 1;
		if (ruleNumber == 256) ruleNumber = 0; 
		refreshCells();
	}

	boolean isAlive(int line, int column) {
		return cells[line][column];
	}
	
	private void refreshCells() {
		cells = Generator.generateCells(height, width, new Rule(ruleNumber));
	}

}