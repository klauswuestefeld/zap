

class BossRightArm extends Thing {

	boolean lookingLeft;

	@Override
	String character() {
		return "O";
	}
	
	@Override
	void act() {
		
	}
	
	@Override
	int millisToWait() { return 1000; }


	@Override
	void collideWith(Thing other) {
	}

}
