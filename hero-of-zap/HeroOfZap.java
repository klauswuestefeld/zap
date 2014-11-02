class HeroOfZap extends Game {

	////////////////////////////Fields
	Hero hero;
	BossHead bossHead;
	
	
	
	////////////////////////////Methods
	
	String programmerName() {
		return "Thomas";
	}
	
	void start() {
		hero = new Hero();
		hero.map = 0;
		bossHead = new BossHead(hero);
		
		setScene(
				"HHHHHHHHH",
				"H       H",
				"H       H",
				"H        ",
				"H        ",
				"H        ",
				"H       H",
				"H   V   H",
				"HHHHHHHHH");
	}
	
	Thing thingRepresentedBy(String character) {
		if (character.equals("V")) return hero;
		if (character.equals("Ü")) return bossHead;
		if (character.equals("W")) return bossHead.leg;
		if (character.equals("<")) return bossHead.leftArm;
		if (character.equals(">")) return bossHead.rightArm;
		if (character.equals("H")) return new Tree();
		if (character.equals("O")) return new Chest();
		if (character.equals("B")) return new Bob(hero);
		if (character.equals("F")) return new Flob(hero);
		return null;
	}

	private void checkNextScene() {
		if (hero.square.neighbor(right) != null) return;
		if (hero.map == 0) {
			setScene(
				"HHHHHHHHH",
				"H       H",
				"H  B B  H",
				"         ",
				"V   O    ",
				"         ",
				"H  B B  H",
				"H       H",
				"HHHHHHHHH");
			hero.map = hero.map + 1;
			return;
		}
		
		if (hero.map  == 1) {
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
			hero.map = hero.map + 1;
			return;
		}
		if (hero.map  == 2) {
			setScene(
				"HHHHHHHHH",
				"H       H",
				"H  HHH  H",
				"   F BH  ",
				"V  F OH  ",
				"   F BH  ",
				"H  HHH  H",
				"H       H",
				"HHHHHHHHH");
			hero.map = hero.map + 1;
			return;
		}
		if (hero.map  == 3) {
			setScene(
				"HHHHHHHHH",
				"H  <Ü>  H",
				"H   W   H",
				"        H",
				"V       H",
				"        H",
				"H       H",
				"H       H",
				"HHHHHHHHH");
			hero.map = hero.map + 1;
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
		hero.shootBoomerang();
	}
	
	String title(){
		return "Lives: " + hero.lives + "/"   + hero.livesLimit;
	}
	
	public static void main(String[] args) {
		new HeroOfZap();
	}
}

