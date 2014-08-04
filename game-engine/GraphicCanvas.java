

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.RenderedImage;

import javax.swing.JPanel;



public class GraphicCanvas extends JPanel {

	@SuppressWarnings("unused")
	private final Game game;
	private volatile String[] screen;

	
	public GraphicCanvas(Game game) {
		this.game = game;
		setSize(new Dimension(2000, 2000));
		setBackground(Color.BLACK);
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
		return AffineTransform.getTranslateInstance(column*40, line*40);
	}

	
	private RenderedImage sprite(String string, int index) {
//		return sprite(string.charAt(index));
		throw new RuntimeException("Not ready yet.");
	}


	@SuppressWarnings("unused")
	private RenderedImage sprite(String character) {
//		if (game == null) return null;
//		RenderedImage bufferedImage = game.imageFor(character);
//		if (bufferedImage == null) System.out.println("Sprite nao registrada para caracter: '" + character +"'");
//		return bufferedImage;
		return null;
	}

	private static final long serialVersionUID = 1L;
}