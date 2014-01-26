package zapman;

class Square {

	Ghost guest;

	Square upper;
	Square lower;
	Square left;
	Square right;
	
	
	String draw() {
		if (guest == null)
			return " ";
		else
			return "!";
	}
	
}
