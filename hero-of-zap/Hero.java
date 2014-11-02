class Hero extends Thing {
	
	int lives = 6;
	int livesLimit = 6;
	int map;
	boolean hasBoomerang = false;

	Hero() {
		direction = down;
	}
	
	@Override
	void act() {
		if (square.neighbor(right) != null && square.neighbor(right).thing instanceof BossPart){
			lives = lives - 1;
			return;
		}
		if (square.neighbor(left) != null && square.neighbor(left) .thing instanceof BossPart){
			lives = lives - 1;
			return;
		}
		if (square.neighbor(up)   .thing instanceof BossPart){
			lives = lives - 1;
			return;
		}
		if (square.neighbor(down) .thing instanceof BossPart) lives = lives - 1;
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
		if (other instanceof Shot) lives = lives - 1;
		if (other instanceof Boomerang){
			other.disappear();
			hasBoomerang = true;
		}
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
		if (punchBag instanceof Flob) {
			if (random(2) == 1)
				punchBag.drop(new Heart());
			else
				punchBag.disappear();
		}
		if (punchBag instanceof Chest){
			if (map == 2) punchBag.drop(new Boomerang(none));
			else punchBag.drop(new HeartContainer());
		}
		if (punchBag instanceof BossPart) {
			((BossPart)punchBag).hit();
		}
	}

	void shootBoomerang() {
		if (hasBoomerang){
			Square neighbor = square.neighbor(direction);
			if (neighbor.thing == null){
				neighbor.accept(new Boomerang(direction));
				hasBoomerang = false;
			}
		}
		
	}
}
