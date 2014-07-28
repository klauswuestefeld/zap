import java.util.HashMap;
import java.util.Map;

class Square {

	Thing thing;

	Map<Direction, Square> neighbors = new HashMap<Direction, Square>();

	
	boolean isEmpty() {	return thing == null; }
	
	
	void put(Thing other) {
		if (thing != null) throw new IllegalStateException("Thomas, you cannot put " + other + " into a square that already contains a " + thing + ".");
		thing = other;
	}
	
	
	void clear() { thing = null; }
	
	
	void accept(Thing other) {
		if (thing == null) {
			thing = other;
			return;
		}
		
		boolean can1 = thing.canCollideWith(other);
		boolean can2 = other.canCollideWith(thing);
		if (!can1) return;
		if (!can2) return;
		
		thing.collideWith(other);
		other.collideWith(thing);
		
		if (thing.hasDisappeared()) thing = thing.droppedThing;
		if (other.hasDisappeared()) other = other.droppedThing;
		if (thing != null && other != null) throw new IllegalStateException("Thomas, " + thing + " and " + other + " cannot occupy the same square.");
		thing = other;
	}

	
	Square neighbor(Direction direction) {
		return neighbors.get(direction);
	}
	
	
	@Override
	public String toString() {
		return getClass().getSimpleName();
	}
}