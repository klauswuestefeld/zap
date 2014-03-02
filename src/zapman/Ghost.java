package zapman;

public class Ghost extends Being {

	Square square;
	

	public Ghost(Square square) {
		if (square.accept(this))
			this.square = square;
	}

	public void move() {
		if (isDead) {
			if (square == null) return;
			square.accept(null);
			square = null;
			return;
		}

		Square nextSquare = square.right;
		if (nextSquare == null) return;
		
		if (nextSquare.accept(this)) {
			square.vacate();
			square = nextSquare;
		}
	}

	@Override
	public String toString() {
		return "!";
	}


	void hit(Hero maldito) {
		if (maldito.isSuper)
			die();
		else
			maldito.die();
	}
	
}
