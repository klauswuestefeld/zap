class Thing {

	Direction direction = Direction.NONE;
	boolean hasDisappeared = false;
	Thing droppedThing = null;

	void act() {}
	int millisToWait() { return -1; }

	void collideWith(Thing other) {}
	
	
	void move(Direction direction) {}
	
	void disappear() { hasDisappeared = true; }
	void drop(Thing other) { droppedThing = other; disappear(); }
	
}
