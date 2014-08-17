class Bob extends Thing {

	boolean lookingLeft;
	
	Bob() {
		direction = left;
	}
	
	@Override
	void act() {
		
	}
	
	@Override
	int millisToWait() { return 1000; }


	@Override
	void collideWith(Thing other) {
		if (other instanceof Hero) drop(new HeartContainer());
	}

}
