

class Tree extends Thing {


	@Override
	String character() {
		return "T";
	}
	
	@Override
	boolean canCollideWith(Thing other) {
		return false;

	}
}
