package zapman;


class Square {

	Being guest;

	Square up;
	Square down;
	Square left;
	Square right;
	
	boolean hasFood = false;
	boolean hasSuperMentos = false;
	boolean isWall = false;
	boolean hasLaser = false;
	
	int smell;
	

	public String toString() {
		if (isWall) return "H";
		if (guest != null) return guest.toString();
		if (hasSuperMentos) return "o";
//		return "" + (smell % 10);
		if (hasLaser) return "Z";
		if (hasFood) return ".";
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
		}

		if (newGuest == null) {
			guest = newGuest;
			return true;
		}
		
		newGuest.hit(guest);
		guest.hit(newGuest);
		return false;
	}


	void vacate() {
		guest = null;
	}


	void spreadSmell() {
		clearSmell();
		spreadNewSmell(1000);
	}


	private void spreadNewSmell(int strength) {
		if (guest instanceof Ghost) return;
		if (smell >= strength) return;
		smell = strength;
		strength = strength - 1;
		if (right != null) right.spreadNewSmell(strength);
		if (up    != null) up.spreadNewSmell(strength);
		if (left  != null) left.spreadNewSmell(strength);
		if (down  != null) down.spreadNewSmell(strength);
	}


	void clearSmell() {
		if (smell == 0) return;
		smell = 0;
		if (right != null) right.clearSmell();
		if (up    != null) up.clearSmell();
		if (left  != null) left.clearSmell();
		if (down  != null) down.clearSmell();
	}


	void spreadLaser() {
		spreadLaserUp();
		spreadLaserDown();
		spreadLaserLeft();
		spreadLaserRight();
	}


	private void spreadLaserRight() {
		if (right != null) {
			right.hasLaser = true;
			right.spreadLaserRight();
		}
	}


	private void spreadLaserLeft() {
		if (left != null) {
			left.hasLaser = true;
			left.spreadLaserLeft();
		}
	}


	private void spreadLaserDown() {
		if (down != null) {
			down.hasLaser = true;
			down.spreadLaserDown();
		}
	}


	private void spreadLaserUp() {
		if (up != null) {
			up.hasLaser = true;
			up.spreadLaserUp();
		}
	}
	
}
