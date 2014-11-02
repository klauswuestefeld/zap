class Heart extends Thing {

	int heartTime = 5;
			
	void collideWith(Thing other) {
		if (other instanceof Hero) disappear();
	}
	
	void act() {
		if (heartTime != 0) {
			heartTime = heartTime - 1;
			return;
		}else disappear();
	}
}
