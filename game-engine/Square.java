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
	
	
	void clear() { thing = null; }
	
	
	boolean accept(Thing other) {
		if (thing != null) {
			thing.collideWith(other);
			other.collideWith(thing);
			
			if (thing.hasDisappeared) thing = thing.droppedThing;
			if (other.hasDisappeared) other = other.droppedThing;
			if (thing != null && other != null) return false;
		}

		other.square.thing = null;
		other.square = this;
		thing = other;
		return true;
	}

	
	Square neighbor(Direction direction) {
		return neighbors.get(direction);
	}
	void setNeighbor(Direction direction, Square neighbor) {
		neighbor.toString();
		neighbors.put(direction, neighbor);
	}
	
}