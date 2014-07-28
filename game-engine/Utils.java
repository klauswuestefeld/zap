

class Utils {

	static Square[][] createGrid(int lines, int columns) {
		return null;
	}

}

class Square {

	Thing thing;

	boolean isEmpty() {	return thing == null; }
	
	void put(Thing other) {
		if (thing != null) throw new IllegalStateException("Thomas, you cannot put " + other + " into a square that already contains a " + thing + ".");
		thing = other;
	}
	
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
	
	@Override
	public String toString() {
		return getClass().getSimpleName();
	}
}

enum Direction {UP, DOWN, LEFT, RIGHT}

