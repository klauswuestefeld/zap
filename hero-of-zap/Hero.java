class Hero extends Thing {

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

}
