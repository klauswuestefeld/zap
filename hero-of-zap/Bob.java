class Bob extends Thing {

	Thing hero;
	
	Bob(Thing hero) {
		direction = left;
		this.hero = hero;
	}
	
	@Override
	void act() {
		if (hero.square.column > square.column) direction = right;
		if (hero.square.column < square.column) direction = left;
		if (hero.square.line > square.line) direction = down;
		if (hero.square.line < square.line) direction = up;
		step();
	}
	
	@Override
	void collideWith(Thing other) {
		if (other instanceof Boomerang){
			if (random(2) == 1)
				drop(new Heart());
			disappear();
		}
	}


}
