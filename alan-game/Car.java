
public class Car extends Thing {

	int points = 0;
	
	void collideWith(Thing other) {
		if (other instanceof Pedestrian){
			other.disappear();
			points = points + 1;
		}
		if (other instanceof RoadWall){
			points = points - 1;
			
		}
	}
	
}
