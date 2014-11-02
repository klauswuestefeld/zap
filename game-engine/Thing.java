class Thing extends Utils {

	Square square;
	Direction direction = none;
	boolean hasDisappeared;

	////////////////////////////////////////////// Can override:
	
	void act() {}
	int millisToWait() { return -1; }

	void collideWith(Thing other) {}

	
	////////////////////////////////////////////// Can call:

	boolean step() {
		if (hasDisappeared) return false;
		Square neighbor = square.neighbor(direction);
		if (neighbor == null) return false;
		return neighbor.accept(this);
	}
	void disappear() { hasDisappeared = true; if (square != null) square.remove(this); }
	void drop(Thing other) {
		Square s = square;
		disappear();
		s.accept(other);
	}
	
	protected void gameOver() {
		System.exit(0);
	}
	
}
