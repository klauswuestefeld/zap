

class BossLeftArm extends Thing {

	boolean lookingLeft;

	@Override
	String character() {
		return "/";
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
