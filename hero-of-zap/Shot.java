
class Shot extends Thing {

	Shot(Direction d) {
		direction = d;
	}
	
	void act() {
		step();
	}
	
	void collideWith(Thing other) {
		if (!(other instanceof Shot)) disappear();
	}
}
