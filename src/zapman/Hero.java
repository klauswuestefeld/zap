package zapman;

class Hero {

	Square square;

	Hero(Square square) {
		this.square = square;
		square.guest = this;
	}

	void right() { moveTo(square.right); }
	void left()  { moveTo(square.left); }
	void up()    { moveTo(square.up); }
	void down()  { moveTo(square.down); }

	private void moveTo(Square nextSquare) {
		if (nextSquare == null) return;
		square.guest = null;
		square = nextSquare;
		square.guest = this;
	}
	
}
