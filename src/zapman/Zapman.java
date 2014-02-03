// To do:
// Super mentos (pastilha)


package zapman;

import textgame.TextGame;

public class Zapman implements TextGame {

	private static String[][] mentos = criarMentos();
	private static final int LINES = mentos.length;
	private static final int COLUMNS = mentos[0].length;
	private static Square[][] maze;
	
	static Ghost ghost;
	static Hero hero;

	private static String[][] criarMentos() {
		String[][] mentos = new String[5][];
		mentos[0] = new String[]{".",".",".",".",".","o","."};
		mentos[1] = new String[]{".",".",".",".",".",".","."};
		mentos[2] = new String[]{".",".",".",".",".",".","."};
		mentos[3] = new String[]{".","H","H","H",".",".","."};
		mentos[4] = new String[]{".",".",".",".",".","o","."};
		return mentos;
	}
	

	static {
		maze = new Square[LINES][];
		
		for (int line = 0; line < LINES; line++) {
			maze[line] = new Square[COLUMNS];
			for (int column = 0; column < COLUMNS; column++) {
				maze[line][column] = new Square();
				connectWithUpperAndLeft(line, column);
			}
		}
		connectBordersForWarping();
		
		ghost = new Ghost(maze[0][0]);
		hero = new Hero(maze[LINES/2][COLUMNS/2]);
	}

	
	private static void connectWithUpperAndLeft(int line, int column) {
		if (line != 0) {
			maze[line    ][column].up = maze[line - 1][column];
			maze[line - 1][column].down = maze[line    ][column];
		}
		if (column != 0) {
			maze[line][column    ].left  = maze[line][column - 1];
			maze[line][column - 1].right = maze[line][column    ];
		}
		
	}


	private static void connectBordersForWarping() {
		for (int line = 0; line < LINES; line++)
			connectFirstAndLastIn(line);
		for (int column = 0; column < COLUMNS; column++)
			connectBottomAndTopIn(column);
		
	}


	private static void connectBottomAndTopIn(int column) {
		Square top = maze [0][column];
		Square bottom = maze  [LINES -1][column];
		top.up = bottom;
		bottom.down = top;		
	}


	private static void connectFirstAndLastIn(int line) {
		Square first = maze [line][0];
		Square last = maze  [line][COLUMNS -1];
		first.left = last;
		last.right = first;
		
	}


	public String[] screen() {
		String[] lines = new String[LINES];
		int line = 0;
		while (line < LINES) {
			lines[line] = drawLine(line);
			line = line + 1;
		}
		return lines;
	}
	

	private String drawLine(int line) {
		String lineString = "";
		int column = 0;
		while (column < mentos[line].length) {
			lineString = lineString + drawThing(line, column);
			column = column + 1;
		}
		return lineString;
	}


	private String drawThing(int line, int column) {
		return maze[line][column].toString();
	}

	
	@Override
	public void pass() {
		ghost.move();
	}


	public void right() { hero.right(); }
	public void left()  { hero.left(); }
	public void up()    { hero.up(); } 
	public void down()  { hero.down(); }
	@Override
	public void space() {
	}

	




}
