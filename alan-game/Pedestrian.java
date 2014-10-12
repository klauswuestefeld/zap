class Pedestrian extends Thing {

	
	void act() {
		if (square.neighbor(down)==null){
			disappear();
			return;
		}
		direction = down;
	    step();
		direction = none;
	}

	
	
}
