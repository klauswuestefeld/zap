package zapman;

class Square {

	Object guest;

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
	
}
