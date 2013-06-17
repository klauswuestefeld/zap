package zapman;

import static org.junit.Assert.*;

import org.junit.Test;

public class ZapmanTest {

	private Zapman game = new Zapman();

	
	@Test
	public void rightFirst() {
		screen(".!.<.o.");
		game.right();
		screen("..! <o.");
		game.left();
		screen("...T o.");
		game.left();
		screen("...T o.");
	}
	
	
	@Test
	public void wrapScreen() {
		screen(".!.<.o.");
		game.right();
		screen("..! <o.");
		game.right();
		screen("...! <.");
		game.right();
		screen("... ! <");
		game.right();
		screen("<..!   ");
		game.right();
		screen(" <!    ");
		game.right();
		screen("  <    ");
		game.right();
		screen("   <   ");
	}

	
	@Test
	public void leftFirst() {
		screen(".!.<.o.");
		game.left();
		screen("..T .o.");
	}

	
	private void screen(String expected) {
		game.pass();
		assertEquals(expected, game.screen()[0]);
	}

}
