

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.RenderedImage;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JPanel;



public class GraphicCanvas extends JPanel {

	static final int SPRITE_SIZE = 21;
	private final Game game;
	private final Map<String, RenderedImage> imagesByName = new HashMap<String, RenderedImage>();

	
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
				g2d.drawRenderedImage(sprite(scene[lineNumber][columnNumber]), position(lineNumber, columnNumber));
			}
		}
	}


	private AffineTransform position(int line, int column) {
		return AffineTransform.getTranslateInstance(column*SPRITE_SIZE, line*SPRITE_SIZE);
	}

	
	private RenderedImage sprite(Square square) {
		Thing thing = square.thing;
		if (thing == null)
			return image("Background");
		return image(thing.getClass().getSimpleName());
	}


	private RenderedImage image(String name) {
		RenderedImage image = imagesByName.get(name);
		if (image != null) return image;
		
		String filename = name + ".png";
		try {
			InputStream resource = game.getClass().getResourceAsStream(filename);
			image = ImageIO.read(resource);
			imagesByName.put(name, image);
			return image;
		} catch (Exception e) {
			return Utils.oops(" I coud not load image " + filename);
		}
	}



	private static final long serialVersionUID = 1L;
}