class Boomerang extends Thing {

	boolean lookingLeft;

	@Override
	String character() {
		return "L";
	}
	
	@Override
	void act() {
		
	}
	
	@Override
	int millisToWait() { return 1000; }


	@Override
	void collideWith(Thing other) {
		if (other instanceof Bob)  disappear();
		if (other instanceof Flob) disappear();
	}

}
