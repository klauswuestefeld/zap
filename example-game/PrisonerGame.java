class PrisonerGame extends Game {

	Prisoner prisoner;

	public static void main(String[] args) {
		new PrisonerGame().start();
	}

	String programmerName() {
		return "Klaus";
	}
	
	void start() {
		prisoner = new Prisoner();

		setScene(
			"HHHHHHHH",
			"H   @  H",
			"H      H",
			"HHHHHHHH"
		);
	}
	
	Thing thingRepresentedBy(String character) {
		if (character.equals("H")) return new PrisonWall();
		if (character.equals("@")) return prisoner;
		return null;
	}
	
	void left() {
		prisoner.direction = left;
		prisoner.step();
	}
	void right() {
		prisoner.direction = right;
		prisoner.step();
	}
	void up() {
		prisoner.direction = up;
		prisoner.step();
	}
	void down() {
		prisoner.direction = down;
		prisoner.step();
	}
}
