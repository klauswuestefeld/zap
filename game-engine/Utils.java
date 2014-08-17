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
		throw new Oops(programmerName + ", " + message);
	}

}

