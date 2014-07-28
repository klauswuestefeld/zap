class HeroOfZap {

	////////////////////////////Fields
	
	Square[][] grid;
	
	
	
	////////////////////////////Methods
	
	void start() {
		grid = Utils.createGrid(9, 9);
		Square square = grid[4][7];
		square.put(new Thing());

		square = grid[3][2];
		square.put(new Bob());

	}

	
	void left() {
		
	}
	void right() {
		
	}
	void up() {
		
	}
	void down() {
		
	}
	void space() {
		
	}
	void shift() {
		
	}

}
