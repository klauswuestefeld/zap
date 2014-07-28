

class HeartContainer extends Thing {

	boolean lookingLeft;

	@Override
	String character() {
		return "H";
	}
	
	@Override
	boolean canCollideWith(Thing other) {
		return false;

	}

	@Override
	void collideWith(Thing other) {
		if (other instanceof Hero) disappear();
	}

}
