

class Chest extends Thing {

	boolean lookingLeft;

	@Override
	String character() {
		return "B";
	}
	

	@Override
	void collideWith(Thing other) {
//		if (other instanceof Hero) drop(new ?());
	}

}
