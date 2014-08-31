class Bob extends Thing {

	Hero hero;
	
	Bob(Hero hero) {
		direction = left;
		this.hero = hero;
	}
	
	@Override
	void act() {
		step();
		if (hero.square.column > square.column) direction = right;
		if (hero.square.column < square.column) direction = left;
		System.out.println(hero.square.column + " " + square.column);
		if (hero.square.line > square.line) direction = down;
		if (hero.square.line < square.line) direction = up;
	}
	
	@Override
	int millisToWait() { return 1000; }


	@Override
	void collideWith(Thing other) {
		if (other instanceof Hero) drop(new HeartContainer());
	}

}
