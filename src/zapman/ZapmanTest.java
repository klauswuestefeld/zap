package zapman;

import static org.junit.Assert.*;

import org.junit.Test;

public class ZapmanTest {

	private Zapman game = new Zapman();

	
	@Test
	public void ghostMove() {
		screen(
				".!.<.o.",
				".......",
				".......",
				".......",
				".....o."
			);
		game.down();
		screen(
				"... .o.",
				"..!<...",
				".......",
				".......",
				".....o."
			);
}
	

	@Test
	public void leftFirst() {
		screen(".!.<.o.");
		game.left();
		screen("..T .o.");
	}

	
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
		game.right();
		screen("    <  ");
		game.right();
		screen("     < ");
		game.right();
		screen("      <");
		game.right();
		screen("<      ");
		game.left();
		screen("      <");
		game.up();
		screen(
			   "       ",
			   ".......",
			   ".......",
			   ".......",
			   ".....o<"
			);
		game.down();
		screen("      <");
	}

	
	private void screen(String... expected) {
		game.pass();
		String[] actual = game.screen();
		for (int i = 0; i < expected.length; i++)
			assertEquals("Line " + i, expected[i], actual[i]);
	}

}
