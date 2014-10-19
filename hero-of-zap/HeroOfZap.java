class HeroOfZap extends Game {

	////////////////////////////Fields
	Hero hero;
	int map;
	
	
	
	////////////////////////////Methods
	
	String programmerName() {
		return "Thomas";
	}
	
	void start() {
		hero = new Hero();
		map = 0;
		
		setScene(
				"HHHHHHHHH",
				"H       H",
				"H   V   H",
				"H        ",
				"H        ",
				"H        ",
				"H       H",
				"H       H",
				"HHHHHHHHH");
	}
	
	Thing thingRepresentedBy(String character) {
		if (character.equals("V")) return hero;
		if (character.equals("H")) return new Tree();
		if (character.equals("O")) return new Chest();
		if (character.equals("<")) return new Bob(hero);
		if (character.equals("F")) return new Flob(hero);
		return null;
	}

	private void checkNextScene() {
		if (hero.square.neighbor(right) != null) return;
		if (map == 0) {
			setScene(
				"HHHHHHHHH",
				"H       H",
				"H  < <  H",
				"         ",
				"V   O    ",
				"         ",
				"H  < <  H",
				"H       H",
				"HHHHHHHHH");
			map = map + 1;
			return;
		}
		
		if (map  == 1) {
			setScene(
				"HHHHHHHHH",
				"H       H",
				"H  F F  H",
				"         ",
				"V   O    ",
				"         ",
				"H  F F  H",
				"H       H",
				"HHHHHHHHH");
			map = map + 1;
			return;
		}
	}

	
	void left() {
		hero.left();
	}
	void right() {
		checkNextScene();
		hero.right();
	}
	void up() {
		hero.up();
	}
	void down() {
		hero.down();
	}
	void space() {
		hero.hit();
	}
	void shift() {
		
	}
	
	String title(){
		return "Lives: " + hero.lives + "/"   + hero.livesLimit;
	}
	
	public static void main(String[] args) {
		new HeroOfZap();
	}
}

