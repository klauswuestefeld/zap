package hero_of_zap;

class Chest extends Thing {

	boolean lookingLeft;

	@Override
	String character() {
		return "B";
	}
	
	@Override
	boolean canCollideWith(Thing other) {
//		if (other instanceof Hero) drop(new ?());
		return false;

	}

	@Override
	void collideWith(Thing other) {
	}

}
