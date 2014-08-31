import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

class Game extends Utils {

	Square[][] scene;

	
	Game() {
		Utils.programmerName = programmerName();
		start();
		new GameLoop(this).start();
	}


	String programmerName() {
		mustOverride("programmerName");
		return null;
	}


	void setScene(String... lines) {
		int lineCount = lines.length;
		int columnCount = lines[0].length();
		scene = new Square[lineCount][columnCount];
		for (int line = 0; line < lineCount; line++) {
			for (int column = 0; column < columnCount; column++) {
				Square square = new Square(line, column);
				scene[line][column] = square;
				if (line > 0) connectUpAndDown(scene[line - 1][column], square);
				if (column > 0) connectLeftAndRight(scene[line][column - 1], square);
				String character = lines[line].substring(column, column + 1);
				if (character.equals(" "))
					continue;
				Thing thing = thingRepresentedBy(character);
				if (thing == null) oops("method thingRepresentedBy() must return something for character '" + character + "'.");
				square.put(thing);
			}
		}
	}

	
	private void connectUpAndDown(Square squareUp, Square squareDown) {
		squareUp.setNeighbor(down, squareDown);
		squareDown.setNeighbor(up, squareUp);
	}


	private void connectLeftAndRight(Square squareLeft, Square squareRight) {
		squareLeft.setNeighbor(right, squareRight);
		squareRight.setNeighbor(left, squareLeft);
	}


	void start() {
		mustOverride("start()");
	}
	
	
	Thing thingRepresentedBy(String character) {
		mustOverride("thingRepresentedBy(Character character)");
		return null;
	}


	void mustOverride(String method) {
		oops(getClass().getSimpleName() + " must override method " + method);
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
