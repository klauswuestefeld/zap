// To do:
// Super mentos (pastilha)


package zapman;

import java.util.ArrayList;
import java.util.List;

import textgame.GameLoop;
import textgame.TextGame;

public class Zapman implements TextGame {

	private String[] maze0 = new String[] {
		"HHHHHHHHH HHHHHHHHHH",
		"    H   H H   H     ",
		"HHH   H     H    HHH",
		"HHHH HHHHHHHHHH HHHH",
		"H                  H",
		"H HHHHHHH HHHHHHHH H",
		"H       H H        H",
		"HHHH H HH HH HH HHHH",
		"HH     HH HH    HHHH",
		"H  HH HHH     H    H",
		"H HHH HHHHHHH HHHH H",
		"H     H     H      H",
		"HHHHHHH HHH HHHHHHHH",
		"H        <         H",
		"HH H HHHHHHHHHH H HH",
		"   H            H   ",
		"HHHHHHHHH HHHHHHHHHH",
	};
	
	private String[] maze1 = new String[]{
		"HHHHH HHHHHHHH HHHHH",
		"    H          H    ",
		"HHH H HHHHHHHH H HHH",
		"    H          H    ",
		"HHH   HHHHHHHH   HHH",
		"HHH              HHH",
		"HHHHHH HHHHHH HHHHHH",
		"H    H H    H H    H",
		"  HH     HH     HH  ",
		"H    H H    H H    H",
		"HHHHHH HHHHHH HHHHHH",
		"HHH              HHH",
		"HHH   HHHHHHHH   HHH",
		"    H     <    H    ",
		"HHH H HHHHHHHH H HHH",
		"    H          H    ",
		"HHHHH HHHHHHHH HHHHH",
	
	};
	
	private String[] maze2 = new String[]{
		
		"H HHH H HHHHH",
		"H H   H   H H",
		"H H HHHHH H H",
		"             ",
		"HHHH HHHHHH H",
		"HHHH HHHHHH H",
		"H     <     H",
		"  HHHHHHHHH  ",
		"H           H",
		"HHHHHH HHHH H",
		"H           H",
		"H HHHHHHHHHHH"
		
	};
	
	private String[] maze3 = new String[]{

		" HHHHHHH HHH ",
		" H     H   H ",
		"   H H   H HH",
		" HHH HHH H   ",
		" H  <  H HHHo",
		" H HHH H   H ",
		"         H H ",
		"HHHH HHHHH H ",
		"HHHH H   H   ",
		"HHHH   H   HH",
		"  o  H H!HHHH",
		" HHHHH!  H   "

	};
	
	private String[] mazeLines;
	private int LINES;
	private int COLUMNS;
	private Square[][] maze;
	
	List<Ghost> ghosts;
	Hero hero;

	private int turn;

	private String[] mazeLines() {
		if (turn == 4) turn = 0;
		if (turn == 0) return maze0;
		if (turn == 1) return maze1;
		if (turn == 2) return maze2;
		if (turn == 3) return maze3;
		return null;
	}
	

	{
		playTurn();
	}


	private void playTurn() {
		mazeLines = mazeLines();
		LINES = mazeLines.length;
		COLUMNS = mazeLines[0].length();
		
		ghosts = new ArrayList<Ghost>();
		
		Sound.play("plup2");
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

	
	private void connectWithUpperAndLeft(int line, int column) {
		if (line != 0) {
			maze[line    ][column].up = maze[line - 1][column];
			maze[line - 1][column].down = maze[line    ][column];
		}
		if (column != 0) {
			maze[line][column    ].left  = maze[line][column - 1];
			maze[line][column - 1].right = maze[line][column    ];
		}
		
	}


	void putThingsInMaze() {
		for (int line = 0; line < LINES; line++) {
			for (int column = 0; column < COLUMNS; column++) {
				String thing = mazeLines[line].substring(column, column + 1);
				Square square = maze[line][column];
				if (thing.equals("<")) hero = new Hero(square);
				if (thing.equals("!")) ghosts.add(new Ghost(square));
				if (thing.equals("o")) square.hasSuperMentos = true;
				if (thing.equals(" ")) square.hasFood = true;
				if (thing.equals("H")) {
					square.isWall = true;
					square.detachFromNeighbors();
				}
			}
		}
	}


	private void connectBordersForWarping() {
		for (int line = 0; line < LINES; line++)
			connectFirstAndLastIn(line);
		for (int column = 0; column < COLUMNS; column++)
			connectBottomAndTopIn(column);
		
	}


	private void connectBottomAndTopIn(int column) {
		Square top = maze [0][column];
		Square bottom = maze  [LINES -1][column];
		top.up = bottom;
		bottom.down = top;		
	}


	private void connectFirstAndLastIn(int line) {
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
		clearLasers();
		return lines;
	}
	

	private String drawLine(int line) {
		String lineString = "";
		int column = 0;
		while (column < mazeLines[line].length()) {
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
		hero.move();
		hero.spreadSmell();
		for (Ghost ghost : ghosts){
			if (ghost.isDead) ghost.reappear(maze[LINES/2][COLUMNS/2]);
			ghost.move();
		}
		
		if (!stillHasFood()) nextTurn();
	}


	private void nextTurn() {
		turn = turn + 1;
		GameLoop.millis = (int) (GameLoop.millis * 0.85);
		playTurn();
	}


	private boolean stillHasFood() {
		for (int line = 0; line < LINES; line++) {
			for (int column = 0; column < COLUMNS; column++) {
				Square square = maze[line][column];
				if (square.hasFood) return true;
			}
		}
		return false;
	}


	private void clearLasers() {
		for (int line = 0; line < LINES; line++) {
			for (int column = 0; column < COLUMNS; column++) {
				Square square = maze[line][column];
				square.hasLaser = false;
			}
		}
	}


	public void right() { hero.right(); }
	public void left()  { hero.left(); }
	public void up()    { hero.up(); } 
	public void down()  { hero.down(); }
	public void space() { hero.shoot(); }


	@Override
	public String title() {
		return "Zapmain | Points: " + hero.points;
	}

}
