package textgame;

import static org.junit.Assert.*;


public abstract class TextGameTestBase {

	protected final TextGame game = newGame();
	
	
	protected abstract TextGame newGame();
	
	
	protected void left() {	game.left(); }
	protected void right() { game.right(); }
	protected void up() { game.up(); }
	protected void down() { game.down(); }
	protected void space() { game.space(); }

	
	protected String[] screen(){
		game.pass();
		return game.screen();
	}
	
	
	protected void assertScreen(String[] expectedScreen) {
		assertArrayEquals(expectedScreen, screen());
	}

}