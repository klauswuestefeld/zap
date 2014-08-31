import java.util.HashMap;
import java.util.Map;

class Square extends Utils {

	Thing thing;

	Map<Direction, Square> neighbors = new HashMap<Direction, Square>();

	int line;
	int column;

	
	public Square(int line, int column) {
		this.line = line;
		this.column = column;
	}


	boolean isEmpty() {	return thing == null; }
	
	
	void put(Thing newThing) {
		if (thing != null) oops("you cannot put " + newThing + " into a square that already contains a " + thing + ".");
		thing = newThing;
		thing.square = this;
	}
	
	
	void remove(Thing thing) {
		if (this.thing != thing) oops("Removing the wrong thing.");
		thing.square = null;
		this.thing = null;
	}
	
	
	void accept(Thing other) {
		if (other == null) oops("Square cannot accept a null thing.");

		if (thing == null) {
			put(other);
			return;
		}
		
		Thing t = thing;
		other.collideWith(t);
		t.collideWith(other);

		if (t.hasDisappeared && !other.hasDisappeared)
			put(other);
	}

	
	Square neighbor(Direction direction) {
		return neighbors.get(direction);
	}
	void setNeighbor(Direction direction, Square neighbor) {
		neighbors.put(direction, neighbor);
	}
	
}