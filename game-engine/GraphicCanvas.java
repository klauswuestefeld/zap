

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JPanel;



public class GraphicCanvas extends JPanel {

	static final int PIXEL_SIZE = 3;
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
		AffineTransform ret = AffineTransform.getTranslateInstance(column*SPRITE_SIZE*PIXEL_SIZE, line*SPRITE_SIZE*PIXEL_SIZE);
		ret.concatenate(AffineTransform.getScaleInstance(PIXEL_SIZE, PIXEL_SIZE));
		return ret;
	}

	
	private RenderedImage sprite(Square square) {
		Thing thing = square.thing;
		if (thing == null)
			return image(game.getClass().getSimpleName(), "Background");
		String suffix = thing.direction.name().toLowerCase();
		return image(thing.getClass().getSimpleName(), suffix);
	}


	private RenderedImage image(String name, String suffix) {
		String fullname = (suffix == null ? name : name + "-" + suffix) + ".png";

		RenderedImage image = imagesByName.get(fullname);
		image = loadImage(fullname);
		if (image == null && suffix != null) { //Example: If "hero-right" is not found, try "hero".
			image = image(name, null);
		}
		
		if (image == null) throw new Oops("Unable to load file " + fullname);
		imagesByName.put(fullname, image);
		return image;
	}


	private RenderedImage loadImage(String filename) {
		InputStream resource = game.getClass().getResourceAsStream(filename);
		if (resource == null) return null;
		try {
			return ImageIO.read(resource);
		} catch (IOException e) {
			throw new Oops("Error reading file " + filename);
		}
	}


	private static final long serialVersionUID = 1L;
}