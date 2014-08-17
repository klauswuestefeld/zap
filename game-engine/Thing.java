class Thing extends Utils {

	Square square;
	Direction direction = none;
	boolean hasDisappeared = false;
	Thing droppedThing = null;

	////////////////////////////////////////////// Can override:
	
	void act() {}
	int millisToWait() { return -1; }

	void collideWith(Thing other) {}

	
	////////////////////////////////////////////// Can call:

	void step() {
		Square neighbor = square.neighbor(direction);
		if (neighbor == null) return;
		neighbor.accept(this);
	}
	void disappear() { hasDisappeared = true; }
	void drop(Thing other) { droppedThing = other; disappear(); }
	
}
