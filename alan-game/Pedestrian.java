import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;


class Pedestrian extends Thing {

	
	void act() {
		if (square.neighbor(down)==null){
			backToTop();
			return;
		}
		direction = down;
	    step();
		direction = none;
	}

	void backToTop() {
		direction = up;
		step();
		step();
		step();
		direction = left;
		step();
		step();
		step();
		step();
		step();
		direction = right;

		int steps = random(5);
		while (steps > 0){
			step();
			steps = steps - 1;
		}
		direction = none;
	}
	
}
