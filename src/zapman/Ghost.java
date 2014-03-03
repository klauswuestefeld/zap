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
		
		Square nextSquare;
		nextSquare = strongestSmell(square.right,square.left);
		nextSquare = strongestSmell(nextSquare,square.down);
		nextSquare = strongestSmell(nextSquare,square.up);

		
		if (nextSquare == null) return;
		System.out.println(nextSquare.smell);
		
		if (nextSquare.accept(this)) {
			square.vacate();
			square = nextSquare;
		}
	}

	private Square strongestSmell(Square s1, Square s2) {
		if (s1 == null) return s2;
		if (s2 == null) return s1;
		if (s2.smell > s1.smell) return s2;
		return s1;
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
