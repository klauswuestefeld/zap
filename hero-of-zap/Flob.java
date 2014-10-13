class Flob extends Thing {

	Thing hero;
	
	Flob(Thing hero) {
		direction = left;
		this.hero = hero;
	}


	
	@Override
	void act() {
		
	}
	
	@Override
	int millisToWait() { return 1000; }


	@Override
	void collideWith(Thing other) {
//		if (other instanceof Hero) drop(new Heart());
	}

}
