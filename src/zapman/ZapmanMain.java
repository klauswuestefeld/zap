package zapman;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import textgame.GameLoop;

public class ZapmanMain {
	
	public static void main(String[] args) throws IOException {
		new GameLoop(new Zapman(), bitmaps())
			.start();
	}

	private static Map<Character, BufferedImage> bitmaps() throws IOException {
		Map<Character, BufferedImage> cacheBitmaps = new HashMap<Character, BufferedImage>();
		cacheBitmaps.put('<', image("1.jpg"));
		cacheBitmaps.put(' ', image("2.jpg"));
		cacheBitmaps.put('H', image("3.jpg"));
		cacheBitmaps.put('.', image("3.jpg"));
		cacheBitmaps.put('!', image("3.jpg"));
		return cacheBitmaps;
	}

	private static BufferedImage image(String filename) throws IOException {
		return ImageIO.read(ZapmanMain.class.getResourceAsStream(filename));
	}

}