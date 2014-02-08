package zapman;

public class Ghost {

	Square square;
	boolean isDead = false;

	public Ghost(Square square) {
		this.square = square;
		square.guest = this;
	}

	public void move() {
		if (isDead) return;
		square.guest = null;

		if (square.right != null)
			square = square.right;
		
		
		if (square.guest instanceof Hero) {
			Hero maldito = (Hero)square.guest;
			if (maldito.isSuper)
				die();
			else 
				maldito.die();
		}
		square.guest = this;
	}

	@Override
	public String toString() {
		return "!";
	}

	void die() {
		isDead = true;
		square.guest = null;
	}
	
}
