import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

class Game {

	Square[][] scene;

	
	Game() {
		start();
		new GameLoop(this).start();
	}


	void setScene(String... lines) {
		int lineCount = lines.length;
		int columnCount = lines[0].length();
		scene = new Square[lineCount][columnCount];
		for (int line = 0; line < lineCount; line++) {
			for (int column = 0; column < columnCount; column++) {
				Square square = new Square();
				scene[line][column] = square;
				String character = lines[line].substring(column, column);
				if (character.equals(" "))
					continue;
				square.put(thingRepresentedBy(character));
			}
		}
	}

	
	void start() {
		mustOveride("start()");
	}
	
	
	Thing thingRepresentedBy(String character) {
		mustOveride("thingRepresentedBy(Character character)");
		return null;
	}


	void mustOveride(String method) {
		throw new RuntimeException(getClass().getSimpleName() + " must override method " + method);
	}

	
	BufferedImage image(String filename) throws IOException {
		return ImageIO.read(getClass().getResourceAsStream(filename));
	}


	public String title() {
		return "Use arrow keys, Space and Enter.";
	}

	
	void up() {}
	void down() {}
	void left() {}
	void right() {}
	void space() {}
	void enter() {}


	String fileNameFor(String character) {
		return null;
	}

}
