class Hero extends Thing {
	
	int lives = 6;
	int livesLimit = 6;

	Hero() {
		direction = down;
	}
	
	@Override
	void act() {
		
	}
	
	@Override
	int millisToWait() { return 1000; }


	@Override
	void collideWith(Thing other) {
		if (other instanceof Bob) lives = lives - 1;
		if (other instanceof Heart) lives = lives + 1;
		if (lives > livesLimit) lives = livesLimit;
		if (other instanceof HeartContainer) livesLimit = livesLimit + 2;
		if (lives == 0) gameOver();
	}

	void left() {
		direction = left;
		step();
	}

	void right() {
		direction = right;
		
		step();
	}

	void up() {
		direction = up;
		step();
	}

	void down() {
		direction = down;
		step();
	}

	void hit() {
		Square neighbor = square.neighbor(direction);
		if (neighbor == null) return;
		Thing punchBag = neighbor.thing;
		if (punchBag == null) return;
		if (punchBag instanceof Bob) {
			if (random(2) == 1)
				punchBag.drop(new Heart());
			else
				punchBag.disappear();
		}
		if (punchBag instanceof Chest) punchBag.drop(new HeartContainer());
	}
}
