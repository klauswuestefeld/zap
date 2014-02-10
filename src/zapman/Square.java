package zapman;

class Square {

	private Being guest;

	Square up;
	Square down;
	Square left;
	Square right;
	
	boolean hasFood = false;
	boolean hasSuperMentos = false;
	boolean isWall = false;
	

	public String toString() {
		if (guest != null) return guest.toString();
		if (hasSuperMentos) return "o";
		if (hasFood) return ".";
		if (isWall) return "H";
		return " ";
	}


	void detachFromNeighbors() {
		if (up    != null) up.down = null;
		if (down  != null) down.up = null;
		if (left  != null) left.right = null;
		if (right != null) right.left = null;
	}


	boolean accept(Being newGuest) {
		if (guest == null) {
			guest = newGuest;
			return true;
		} else {
			newGuest.hit(guest);
			guest.hit(newGuest);
			return false;
		}
	}


	void vacate() {
		guest = null;
	}
	
}
