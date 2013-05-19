package zapman;

import textgame.TextGame;

public class Zapman implements TextGame {

	private int position = 1;
	private String[] mentos = new String[]{"O", ".", "."};
	private boolean dead;

	public String[] screen() {
		String screen = thing(0) + thing(1) + thing(2);
		return new String[]{ screen };
	}

	private String thing(int column) {
		if (column == position) {
			if (dead) return "T";
			return "C";
		}
		return mentos[column];
	}

	public void right() {
		if (dead) return;
		
		mentos[position] = " ";
		position = position +1;
		if (position == 3) position = 0;
		if (position == 0) dead = true;
	}

	public void left() {
		if (dead) return;
		mentos[position] = " ";
		position = position -1;
		if (position == 0) dead = true;
	}

	
	
	@Override
	public void up() {
		// TODO Auto-generated method stub
	}

	@Override
	public void down() {
		// TODO Auto-generated method stub
	}

	@Override
	public void space() {
		// TODO Auto-generated method stub
	}

	@Override
	public void pass() {
		// TODO Auto-generated method stub
	}

}
