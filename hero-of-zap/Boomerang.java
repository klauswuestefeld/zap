class Boomerang extends Thing {
	Direction[] path;
	private Direction d = down;
	private Direction r = right;
	private Direction u = up;
	private Direction l = left;
	
	Direction[] pathRight = new Direction[]{
			d,r,d,r,d,r,r,u,r,u,r,u,u,l,u,l,u,l,l,d,l,d,l,d};
	Direction[] pathLeft = new Direction[]{
			u,l,u,l,u,l,l,d,l,d,l,d,d,r,d,r,d,r,r,u,r,u,r,u};
	Direction[] pathUp = new Direction[]{
			r,u,r,u,r,u,u,l,u,l,u,l,l,d,l,d,l,d,d,r,d,r,d,r};
	Direction[] pathDown = new Direction[]{
			l,d,l,d,l,d,d,r,d,r,d,r,r,u,r,u,r,u,u,l,u,l,u,l};
	int location = 0;
	
	Boomerang(Direction d) {
		if (d == right)	path = pathRight;
		if (d == left)	path = pathLeft;
		if (d == up)	path = pathUp;
		if (d == down)	path = pathDown;
	}
	
	void act() {
		if (path == null) return;
		direction = path[location];
		step();
		location = location + 1;
		if (location == 23) location = 0;
	}
	
	void collideWith(Thing other) {
		if (other instanceof BossPart) {
			((BossPart)other).hit();
		}
	}
}
