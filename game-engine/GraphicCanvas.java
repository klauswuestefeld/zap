

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.RenderedImage;

import javax.swing.JPanel;



public class GraphicCanvas extends JPanel {

	private final Game game;

	
	public GraphicCanvas(Game game) {
		this.game = game;
		setSize(new Dimension(4000, 4000));
		setBackground(Color.BLACK);
	}


	@Override
	public void paint(Graphics g) {
		Square[][] scene = game.scene;
		Graphics2D g2d = (Graphics2D) g;
		for (int lineNumber = 0; lineNumber < scene.length; lineNumber++) {
			Square[] line = scene[lineNumber];
			for (int columnNumber = 0; columnNumber < line.length; columnNumber++) {
//				g2d.drawRenderedImage(sprite(scene[lineNumber][columnNumber]), position(lineNumber, columnNumber));
			}
		}
	}


	private AffineTransform position(int line, int column) {
		return AffineTransform.getTranslateInstance(column*40, line*40);
	}

	
	private RenderedImage sprite(Square square) {
		Thing thing = square.thing;
		if (thing == null)
			return image("background");
		return null;
	}


	private RenderedImage image(String filename) {
//		return ImageIO.read(game.getClass().getResourceAsStream(filename + ".png"));
		return null;
	}



	private static final long serialVersionUID = 1L;
}