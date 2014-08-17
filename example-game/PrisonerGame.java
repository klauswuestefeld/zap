class PrisonerGame extends Game {

	public static void main(String[] args) {
		new PrisonerGame();
	}

	String programmerName() {
		return "Klaus";
	}
	
	void start() {
		setScene(
			"HHHHHHHH",
			"H   @  H",
			"H      H",
			"HHHHHHHH"
		);
	}
	
	Thing thingRepresentedBy(String character) {
		if (character.equals("H")) return new PrisonWall();
		if (character.equals("@")) return new Prisoner();
		return null;
	}
	
}
