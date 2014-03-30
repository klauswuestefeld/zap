package zapman;

class Hero extends Being {
	
	boolean isSuper = false;
	Square square;

	Hero(Square square) {
		square.accept(this);
		this.square = square;
	}

	void right() { moveTo(square.right); }
	void left()  { moveTo(square.left); }
	void up()    { moveTo(square.up); }
	void down()  { moveTo(square.down); }

	private void moveTo(Square nextSquare) {
		if (isDead) return;
		if (nextSquare == null) return;
		if (!nextSquare.accept(this)) return;
		
		if (square != null)	square.vacate();
		square = nextSquare;
		
		if (square.hasFood)	Sound.play("nham");
		square.hasFood = false;
	
		if (square.hasSuperMentos) isSuper = true;
		square.hasSuperMentos = false;
	}

	@Override
	public String toString() {
		if (isDead) return "T";
		if (isSuper) return "S";
		return "<";
	}
	
	
	@Override
	void hit(Being ghost) {
		if (isSuper) ghost.die();
		else die();
	}

	void spreadSmell() {
		square.spreadSmell();
	}

	void shoot() {
		square.spreadLaser();
	}
}
