package zapman;

public class Ghost {

	Square square;

	public Ghost(Square square) {
		this.square = square;
		square.guest = this;
	}

	public void move() {
		square.guest = null;

		if (square.right != null)
			square = square.right;
		else
			if (square.down != null)
				square = square.down;

		square.guest = this;
	}

	@Override
	public String toString() {
		return "!";
	}
	
}
