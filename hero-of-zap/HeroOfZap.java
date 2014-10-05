class HeroOfZap extends Game {

	////////////////////////////Fields
	Hero hero;
	
	
	
	////////////////////////////Methods
	
	String programmerName() {
		return "Thomas";
	}
	
	void start() {
		hero = new Hero();
		
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
		return null;
	}
	
	void left() {
		hero.left();
	}
	void right() {
		if (hero.square.neighbor(right) == null) setScene(
				"HHHHHHHHH",
				"H       H",
				"H  < <  H",
				"         ",
				"V   O    ",
				"         ",
				"H  < <  H",
				"H       H",
				"HHHHHHHHH");
				
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

