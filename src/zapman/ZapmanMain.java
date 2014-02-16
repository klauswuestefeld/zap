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
		cacheBitmaps.put('<', image("packman.png"));
		cacheBitmaps.put(' ', image("nada.png"));
		cacheBitmaps.put('H', image("parede.png"));
		cacheBitmaps.put('.', image("pastilha.png"));
		cacheBitmaps.put('!', image("ghost.png"));
		cacheBitmaps.put('o', image("supermentos.png"));
		cacheBitmaps.put('S', image("superpack.png"));
		cacheBitmaps.put('T', image("morto.png"));
		return cacheBitmaps;
	}

	private static BufferedImage image(String filename) throws IOException {
		return ImageIO.read(ZapmanMain.class.getResourceAsStream(filename));
	}

}