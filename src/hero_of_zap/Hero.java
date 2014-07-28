package hero_of_zap;

class Hero extends Thing {

	boolean lookingLeft;

	@Override
	String character() {
		if(lookingLeft) return "<";
		return ">";
	}
	
	@Override
	void act() {
		
	}
	
	@Override
	int millisToWait() { return 1000; }

	@Override
	boolean canCollideWith(Thing other) {
		return false;

	}

	@Override
	void collideWith(Thing other) {
	}

}
