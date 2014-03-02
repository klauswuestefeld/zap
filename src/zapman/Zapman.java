// To do:
// Super mentos (pastilha)


package zapman;

import java.util.ArrayList;
import java.util.List;

import textgame.TextGame;

public class Zapman implements TextGame {

	private static String[][] mentos = criarMentos();
	private static final int LINES = mentos.length;
	private static final int COLUMNS = mentos[0].length;
	private static Square[][] maze;
	
	static List<Ghost> ghosts = new ArrayList<Ghost>();
	static Hero hero;

	private static String[][] criarMentos() {
		String[][] mentos = new String[9][];
		mentos[0] = new String[]{".","H","H","H","H","H","H","H","o"};
		mentos[1] = new String[]{".","H",".",".",".",".",".","H","."};
		mentos[2] = new String[]{".",".",".","H",".","H",".",".","."};
		mentos[3] = new String[]{".","H","H","H",".","H","H","H","."};
		mentos[4] = new String[]{".","H",".",".","<",".",".","H","."};
		mentos[5] = new String[]{".","H",".","H","H","H",".","H","."};
		mentos[6] = new String[]{"o",".",".",".",".",".",".",".","."};
		mentos[7] = new String[]{"H","H","H","H",".","H","H","H","H"};
		mentos[8] = new String[]{".",".",".",".","!",".",".",".","!"};
		return mentos;
	}
	

	static {
		Sound.play("som-teste");
		maze = new Square[LINES][];
		
		for (int line = 0; line < LINES; line++) {
			maze[line] = new Square[COLUMNS];
			for (int column = 0; column < COLUMNS; column++) {
				maze[line][column] = new Square();
				connectWithUpperAndLeft(line, column);
			}
		}
		connectBordersForWarping();

		putThingsInMaze();
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


	static void putThingsInMaze() {
		for (int line = 0; line < LINES; line++) {
			for (int column = 0; column < COLUMNS; column++) {
				String thing = mentos[line][column];
				Square square = maze[line][column];
				if (thing.equals("<")) hero = new Hero(square);
				if (thing.equals("!")) ghosts.add(new Ghost(square));
				if (thing.equals("o")) square.hasSuperMentos = true;
				if (thing.equals(".")) square.hasFood = true;
				if (thing.equals("H")) {
					square.isWall = true;
					square.detachFromNeighbors();
				}
			}
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
		for (Ghost ghost : ghosts) {
			ghost.move();
		}
	}


	public void right() { hero.right(); }
	public void left()  { hero.left(); }
	public void up()    { hero.up(); } 
	public void down()  { hero.down(); }
	@Override
	public void space() {
	}

	




}
