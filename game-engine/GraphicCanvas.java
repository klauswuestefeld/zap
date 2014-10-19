

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
			return image(game.getClass().getSimpleName()+"-Background");
		String imageName = thing.getClass().getSimpleName();
		if (thing.direction != Direction.none)
			imageName = imageName + "-" + thing.direction.name().toLowerCase();
		try {
			return image(imageName);
		} catch (Oops e) {
			return image(thing.getClass().getSimpleName());
		}
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
			return Utils.oops("I could not load image " + filename);
		}
	}



	private static final long serialVersionUID = 1L;
}