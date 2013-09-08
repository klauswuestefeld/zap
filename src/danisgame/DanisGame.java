package danisgame;

import textgame.TextGame;

public class DanisGame implements TextGame {

	private static final int COLUMNS = 7;
	private static final int LINES = 5;

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
		while (column < COLUMNS) {
			lineString = lineString + drawThing(line, column);
			column = column + 1;
		}
		return lineString;
	}


	@Override
	public void pass() {
	}

	private String drawThing(int line, int column) {
		return null;
	}

	public void right() { move( 0,  1); }
	public void left()  { move( 0, -1); }
	public void up()    { move(-1,  0); } 
	public void down()  { move( 1,  0); }

	
	private void move(int stepLine, int stepColumn) {
	}

	@Override
	public void space() {
	}

}
