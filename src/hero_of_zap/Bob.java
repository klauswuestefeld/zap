package hero_of_zap;

class Bob extends Thing {

	boolean lookingLeft;

	String character() {
		if(lookingLeft) return "{";
		return "}";
	}

}
