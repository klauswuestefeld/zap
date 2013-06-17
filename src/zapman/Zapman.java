package zapman;

import textgame.TextGame;

public class Zapman implements TextGame {

	private int zapmanPosition = 3;
	private int ghostPosition = 0;
	private String[] mentos = new String[]{".",".",".",".",".","o","."};
	private boolean isDead;
	private boolean isSuper;

	public String[] screen() {
		String screen = "";
		int i = 0;
		while (i < mentos.length) {
			screen = screen + thing(i);
			i = i + 1;
		}
		return new String[]{ screen };
	}
	
	
	@Override
	public void pass() {
		moveGhost();
	}

	private void moveGhost() {
		if (ghostPosition < zapmanPosition)
			ghostPosition = ghostPosition + 1;
		if (ghostPosition > zapmanPosition)
			ghostPosition = ghostPosition - 1;
		checkDeath();
	}

	private String thing(int column) {
		if (column == zapmanPosition) {
			if (isDead) return "T";
			return "<";
		}
		if (column == ghostPosition) {
			return "!";
		}
		return mentos[column];
	}

	public void right() { move(+1); }
	public void left()  { move(-1); }

	
	private void move(int step) {
		if (isDead) return;
		mentos[zapmanPosition] = " ";
		zapmanPosition = zapmanPosition + step;
		if (zapmanPosition == mentos.length) zapmanPosition = 0;
		if (zapmanPosition == -1) zapmanPosition = mentos.length - 1;
		checkDeath();
		if (mentos[zapmanPosition].equals("o")) isSuper = true;
	}


	private void checkDeath() {
		if (isSuper) return;
		if (ghostPosition == zapmanPosition) isDead = true;
	}



	
	
	
	@Override
	public void up() {
		// TODO Auto-generated method stub
	}

	@Override
	public void down() {
	}

	@Override
	public void space() {
	}

}
