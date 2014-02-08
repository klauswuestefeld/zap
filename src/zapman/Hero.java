package zapman;

class Hero {
	boolean isSuper = false;
	boolean isDead = false;
	Square square;

	Hero(Square square) {
		moveTo(square);
	}

	void right() { moveTo(square.right); }
	void left()  { moveTo(square.left); }
	void up()    { moveTo(square.up); }
	void down()  { moveTo(square.down); }

	private void moveTo(Square nextSquare) {
		if (isDead) return;
		if (nextSquare == null) return;
		if (!nextSquare.accept(this)) return;
		
		if (square != null)	square.vacate();
		square = nextSquare;
		square.hasFood = false;
		if (square.hasSuperMentos) isSuper = true;
		square.hasSuperMentos = false;
	}

	@Override
	public String toString() {
		if (isDead) return "T";
		if (isSuper) return "S";
		return "<";
	}
	void die() {
		System.out.println("Hero morreu");
		isDead = true;
	}
	
}
//if (nextSquare.guest instanceof Ghost) {
//Ghost pentelho = (Ghost)nextSquare.guest;
//if (isSuper)
//	pentelho.die();
//else {
//	System.out.println("Hero vai se matar...");
//	die();
//}
//}