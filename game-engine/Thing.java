class Thing extends Utils {

	Direction direction = none;
	boolean hasDisappeared = false;
	Thing droppedThing = null;

	void act() {}
	int millisToWait() { return -1; }

	void collideWith(Thing other) {}
	
	
	void move(Direction direction) {}
	
	void disappear() { hasDisappeared = true; }
	void drop(Thing other) { droppedThing = other; disappear(); }
	
}
