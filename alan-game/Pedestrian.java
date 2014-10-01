
class Pedestrian extends Thing {

	
	void act() {
		if (square.neighbor(down)==null){
			direction = up;
			step();
			step();
			step();
			direction = none;
			return;
		}
		direction = down;
	    step();
		direction = none;
	}
	
}
