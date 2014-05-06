package zapman;


class Hero extends Being {
	
	boolean isSuper = false;
	Square square;
	String direction;
	String nextDirection = "none";
	int points;

	Hero(Square square) {
		square.accept(this);
		this.square = square;
	}

	void right() { nextDirection = "right"; }
	void left()  { nextDirection = "left"; }
	void up()    { nextDirection = "up"; }
	void down()  { nextDirection = "down"; }

	

	@Override
	public String toString() {
		if (isDead) return "T";
		if (isSuper) return "S";
		return "<";
	}
	
	@Override
	void hit(Being ghost) {
		if (isSuper) ghost.die();
		else die();
	}

	void spreadSmell() {
		square.spreadSmell();
	}

	void shoot() {
		square.spreadLaser();
	}

	void move() {
		if (isDead) return;
		
		Square nextSquare = null;
		if (nextDirection.equals("right")) nextSquare = square.right;
		if (nextDirection.equals("left"))  nextSquare = square.left;
		if (nextDirection.equals("up"))    nextSquare = square.up;
		if (nextDirection.equals("down"))  nextSquare = square.down;

		if (nextSquare != null) 
			direction = nextDirection;
		

		if (direction == null) return;
		if (direction.equals("right")) moveTo(square.right);
		if (direction.equals("left"))  moveTo(square.left);
		if (direction.equals("down"))  moveTo(square.down);
		if (direction.equals("up"))    moveTo(square.up);
	}
	
	private void moveTo(Square nextSquare) {
		if (nextSquare == null) return;
		if (!nextSquare.accept(this)) return;
		
		if (square != null)	square.vacate();
		square = nextSquare;
		
		if (square.hasFood){
			Sound.play("nham");
			points = points + 1;
			square.hasFood = false;	
		}
	
		if (square.hasSuperMentos) isSuper = true;
		square.hasSuperMentos = false;
	}
}
