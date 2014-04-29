package zapman;

public class Ghost extends Being {

	Square square;
	

	public Ghost(Square square) {
		if (square.accept(this))
			this.square = square;
	}

	@Override
	void die() {
		super.die();
		if (square == null) return;
		square.accept(null);
		square = null;
	}
	
	public void move() {
		if (square == null)
			return;
		
		if (square.hasLaser) die();
		if (isDead) return;
			
		Square nextSquare;
		nextSquare = strongestSmell(square.right,square.left);
		nextSquare = strongestSmell(nextSquare,square.down);
		nextSquare = strongestSmell(nextSquare,square.up);
		
		if (nextSquare.hasLaser) return;
		
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

	void reappear(Square square) {
		if (square.accept(this)) {
			this.square = square;
			isDead = false;
		}
	}

	
}
