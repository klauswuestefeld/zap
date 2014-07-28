

class Thing {

	boolean hasDisappeared = false;
	Thing droppedThing = null;

	String character() { return "?"; }
	
	void act() {}
	int millisToWait() { return -1; }

	boolean canCollideWith(Thing other) { return false; }
	void collideWith(Thing other) {}
	
	
	void move(Direction direction) {}
	
	void disappear() { hasDisappeared = true; }
	void drop(Thing other) { droppedThing = other; disappear(); }
	boolean hasDisappeared() { return false; }
	
}
