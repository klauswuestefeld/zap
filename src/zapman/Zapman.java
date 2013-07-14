package zapman;

import textgame.TextGame;

public class Zapman implements TextGame {

	private static final int COLUMNS = 7;
	private static final int LINES = 5;

	private int zapmanLine = 0;
	private int zapmanColumn = 3;
	private int ghostLine = 0;
	private int ghostColumn = 0;
	private String[][] mentos = criarMentos();
	private boolean isDead;
	private boolean isSuper;
	private boolean ghostDead;

	public String[] screen() {
		String[] lines = new String[LINES];
		int line = 0;
		while (line < LINES) {
			lines[line] = drawLine(line);
			line = line + 1;
		}
		return lines;
	}
	
	
	private String[][] criarMentos() {
		String[][] mentos = new String[LINES][];
		mentos[0] = new String[]{".",".",".",".",".","o","."};
		mentos[1] = new String[]{".",".",".",".",".",".","."};
		mentos[2] = new String[]{".",".",".",".",".",".","."};
		mentos[3] = new String[]{".",".",".",".",".",".","."};
		mentos[4] = new String[]{".",".",".",".",".","o","."};
		return mentos;
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


	@Override
	public void pass() {
		moveGhost();
	}

	private void moveGhost() {
		if (ghostColumn < zapmanColumn) ghostColumn++;
		if (ghostColumn > zapmanColumn)	ghostColumn--;
		if (ghostLine < zapmanLine) ghostLine++;
		if (ghostLine > zapmanLine)	ghostLine--;
		checkDeath();
	}

	private String drawThing(int line, int column) {
		if (line == zapmanLine && column == zapmanColumn) {
			if (isDead) return "T";
			return "<";
		}
		if (line == ghostLine && column == ghostColumn && !ghostDead) {
			return "!";
		}
		return mentos[line][column];
	}

	public void right() { move( 0,  1); }
	public void left()  { move( 0, -1); }
	public void up()    { move(-1,  0); } 
	public void down()  { move( 1,  0); }

	
	private void move(int stepLine, int stepColumn) {
		if (isDead) return;
		mentos[zapmanLine][zapmanColumn] = " ";
		zapmanColumn = zapmanColumn + stepColumn;
		zapmanLine   = zapmanLine   + stepLine;
		checkWrap();
		checkDeath();
		if (mentos[zapmanLine][zapmanColumn].equals("o")) isSuper = true;
	}


	private void checkWrap() {
		if (zapmanColumn >= COLUMNS) zapmanColumn = 0;
		if (zapmanColumn <= -1) zapmanColumn = COLUMNS - 1;

		if (zapmanLine >= LINES) zapmanLine = 0;
		if (zapmanLine <= -1) zapmanLine = LINES - 1;
	}


	private void checkDeath() {
		if (ghostColumn != zapmanColumn) return;
		if (ghostLine != zapmanLine) return;
		if (isSuper)
			ghostDead = true;
		else
			isDead = true;
	}



	
	
	

	@Override
	public void space() {
	}

}
