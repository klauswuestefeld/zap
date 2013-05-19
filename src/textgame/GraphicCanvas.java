package textgame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.util.Map;

import javax.swing.JPanel;



public class GraphicCanvas extends JPanel {

	private final Map<Character, BufferedImage> sprites;
	private volatile String[] screen;

	
	public GraphicCanvas(Map<Character, BufferedImage> sprites) {
		this.sprites = sprites;
		setSize(new Dimension(448, 448));
		setBackground(Color.BLACK);
	}


	public void refresh(String[] screen) {
		this.screen = screen;
		repaint();
	}
	
	
	@Override
	public void paint(Graphics g) {
		if (screen == null) return; 
		
		Graphics2D g2d = (Graphics2D) g;
		for (int line = 0; line < screen.length; line++) {
			String lineContent = screen[line];
			for (int column = 0; column < lineContent.length(); column++)
				g2d.drawRenderedImage(sprite(lineContent, column), position(line, column));
		}
	}


	private AffineTransform position(int line, int column) {
		return AffineTransform.getTranslateInstance(column*64, line*64);
	}

	
	private RenderedImage sprite(String string, int index) {
		return sprite(string.charAt(index));
	}


	private RenderedImage sprite(char character) {
		if (sprites == null) return null;
		RenderedImage bufferedImage = sprites.get(character);
		if (bufferedImage == null) System.out.println("Sprite nao registrada para caracter: '" + character +"'");
		return bufferedImage;
	}

	private static final long serialVersionUID = 1L;
}