package zapman;

import textgame.TextGame;

public class Zapman implements TextGame {

	private int position = 3;
	private String[] mentos = new String[]{".",".","O",".",".",".","."};
	private boolean dead;

	public String[] screen() {
		String screen = "";
		int i = 0;
		while (i < mentos.length) {
			screen = screen + thing(i);
			i = i + 1;
		}
		return new String[]{ screen };
	}

	private String thing(int column) {
		if (column == position) {
			if (dead) return "T";
			return "C";
		}
		return mentos[column];
	}

	public void right() { move(+1); }
	public void left()  { move(-1); }

	
	private void move(int step) {
		if (dead) return;
		mentos[position] = " ";
		position = position + step;
		if (position == mentos.length) position = 0;
		if (position == -1) position = mentos.length - 1;
		if (mentos[position].equals("O")) dead = true;
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

	@Override
	public void pass() {
	}

}
