package zapman;

class Hero {
	boolean isSuper = false;
	Square square;

	Hero(Square square) {
		moveTo(square);
	}

	void right() { moveTo(square.right); }
	void left()  { moveTo(square.left); }
	void up()    { moveTo(square.up); }
	void down()  { moveTo(square.down); }

	private void moveTo(Square nextSquare) {
		if (nextSquare == null) return;
		if (square != null) square.guest = null;
		square = nextSquare;
		square.guest = this;
		square.hasFood = false;
		if (square.hasSuperMentos) isSuper = true;
		square.hasSuperMentos = false;
	}

	@Override
	public String toString() {
		if (isSuper) return "S";
		return "<";
	}
}
