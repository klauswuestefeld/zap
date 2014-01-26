package zapman;

public class Ghost {

	Square square;

	public Ghost(Square square) {
		this.square = square;
		
	}

	public void move() {
		square.guest = null;

		if (square.right != null)
			square = square.right;
		else
			if (square.lower != null)
				square = square.lower;

		square.guest = this;
	}

}
