class Flob extends Thing {

	Thing hero;
	int shotCounter = 0;
	
	Flob(Thing hero) {
		direction = left;
		this.hero = hero;
	}

	@Override
	void act() {
		if (hero.square.column < square.column) direction = right;
		if (hero.square.column > square.column) direction = left;
		if (hero.square.line < square.line) direction = down;
		if (hero.square.line > square.line) direction = up;
		step();

		if (shotCounter != 0) {
			shotCounter = shotCounter - 1;
			return;
		}
		if (hero.square.column > square.column)
			if (hero.square.line == square.line) {
				square.neighbor(right).accept(new Shot(right));
				shotCounter = 5;
			}
		if (hero.square.column < square.column)
			if (hero.square.line == square.line) {
				square.neighbor(left).accept(new Shot(left));
				shotCounter = 5;
			}
		if (hero.square.line < square.line)
			if (hero.square.column == square.column) {
				square.neighbor(up).accept(new Shot(up));
				shotCounter = 5;
			}
		if (hero.square.line > square.line)
			if (hero.square.column == square.column) {
				square.neighbor(down).accept(new Shot(down));
				shotCounter = 5;
			}
	}

	@Override
	int millisToWait() { return 1000; }


	@Override
	void collideWith(Thing other) {
		if (other instanceof Boomerang){
			if (random(2) == 1)
				drop(new Heart());
			disappear();
		}
	}

}
