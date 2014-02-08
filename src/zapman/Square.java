package zapman;

class Square {

	private Object guest;

	Square up;
	Square down;
	Square left;
	Square right;
	
	boolean hasFood = true;
	boolean hasSuperMentos = false;
	

	public String toString() {
		if (guest != null) return guest.toString();
		if (hasSuperMentos) return "o";
		if (hasFood) return ".";
		return " ";
	}


	void detachFromNeighbors() {
		if (up    != null) up.down = null;
		if (down  != null) down.up = null;
		if (left  != null) left.right = null;
		if (right != null) right.left = null;
	}


	boolean accept(Object newGuest) {
		if (guest == null) {
			guest = newGuest;
			return true;
		} else {
			return false;
		}
	}


	void vacate() {
		guest = null;
	}
	
}
