import java.util.Random;

class Utils {

	static Direction up = Direction.up;
	static Direction down = Direction.down;
	static Direction left = Direction.left;
	static Direction right = Direction.right;
	static Direction none = Direction.none;
	
	static String programmerName = "Programmer";

	static Square[][] createGrid(int lines, int columns) {
		return null;
	}

	static <T> T oops(String message) {
		System.err.println("\n\n");
		throw new Oops(programmerName + ", " + message);
	}

	static Random random = new Random();
	static int random(int max) {
		return random.nextInt(max + 1);
	}
}

