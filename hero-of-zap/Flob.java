class Flob extends Thing {

	boolean lookingLeft;

	
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
