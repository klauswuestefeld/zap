

class HeartContainer extends Thing {

	boolean lookingLeft;

	@Override
	String character() {
		return "H";
	}
	

	@Override
	void collideWith(Thing other) {
		if (other instanceof Hero) disappear();
	}

}
