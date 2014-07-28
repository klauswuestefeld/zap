package hero_of_zap;

class Thing {

	String character() { return "?"; }
	
	void act() {}
	int millisToWait() { return -1; }

	boolean canCollideWith(Thing other) { return false; }
	void collideWith(Thing other) {}
	
	
	void move(Direction direction) {}
	
	void disappear() {}
	void drop(Thing other) {}
	
}
