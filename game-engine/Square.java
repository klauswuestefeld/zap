import java.util.HashMap;
import java.util.Map;

class Square {

	Thing thing;

	Map<Direction, Square> neighbors = new HashMap<Direction, Square>();

	
	boolean isEmpty() {	return thing == null; }
	
	
	void put(Thing newThing) {
		if (thing != null) throw new IllegalStateException("Thomas, you cannot put " + newThing + " into a square that already contains a " + thing + ".");
		thing = newThing;
	}
	
	
	void clear() { thing = null; }
	
	
	void accept(Thing other) {
		if (thing == null) {
			thing = other;
			return;
		}
		
		thing.collideWith(other);
		other.collideWith(thing);
		
		if (thing.hasDisappeared) thing = thing.droppedThing;
		if (other.hasDisappeared) other = other.droppedThing;
		if (thing != null && other != null) return;
		thing = other;
	}

	
	Square neighbor(Direction direction) {
		return neighbors.get(direction);
	}
	
}