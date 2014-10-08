



public class AlanGame extends Game {

	public static void main(String[] args) {
		new AlanGame().start();

	}

	Car car;

	@Override
	String programmerName() {
		return "Alan"; 
	}
	
	@Override
	void start() {
		car = new Car();
		setScene(
				"H      H",
				"H      H",
				"H      H",
				"H    @ H"
			);
	}
	
	Thing thingRepresentedBy(String character) {
		if (character.equals("H")) return new RoadWall();
		if (character.equals("@")) return car;
		// if (character.equals("A")) return new Pedestrian();
		return null;
	}
	void left() {
		car.direction = left;
		car.step();
		car.direction = none;
	}
	void right() {
		car.direction = right;
		car.step();
		car.direction = none;
	}
	void act(){
		if (random(2) == 0) {
			scene[0][random(5) + 1].accept(new Pedestrian());
		}
	}
	String title() {
		return "Your points = "+ car.points;
	}
}
