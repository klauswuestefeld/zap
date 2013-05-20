package zapman;

import static org.junit.Assert.*;

import org.junit.Test;

public class ZapmanTest {

	private Zapman game = new Zapman();
	
	
	
	@Test
	public void rightFirst() {
		screen("..OC...");
		game.right();
		screen("..O C..");
		game.left();
		screen("..OC ..");
		game.left();
		screen("..T  ..");
	}
	
	@Test
	public void wrapScreen() {
		screen("..OC...");
		game.right();
		screen("..O C..");
		game.right();
		screen("..O  C.");
		game.right();
		screen("..O   C");
		game.right();
		screen("C.O    ");
	}

	@Test
	public void leftFirst() {
		screen("..OC...");
		game.left();
		screen("..T ...");
		game.right();
		screen("..T ...");
		
	}

	private void screen(String expected) {
		assertEquals(expected, game.screen()[0]);
	}

}
