package zapman;

class Square {

	Object guest;

	Square up;
	Square down;
	Square left;
	Square right;
	
	
	String draw() {
		if (guest == null) return " ";
		if (guest instanceof Ghost) return "!";
		if (guest instanceof Hero) return "<";
		return "?";
	}
	
}
