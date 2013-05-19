package textgame;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class MainDemo {
	
	public static void main(String[] args) throws IOException {
		new GameLoop(new DemoGame(), bitmaps())
			.start();
	}

	private static Map<Character, BufferedImage> bitmaps() throws IOException {
		Map<Character, BufferedImage> cacheBitmaps = new HashMap<Character, BufferedImage>();
		cacheBitmaps.put('1', image("1.jpg"));
		cacheBitmaps.put('2', image("2.jpg"));
		cacheBitmaps.put('3', image("3.jpg"));
		return cacheBitmaps;
	}

	private static BufferedImage image(String filename) throws IOException {
		return ImageIO.read(MainDemo.class.getResourceAsStream(filename));
	}

}