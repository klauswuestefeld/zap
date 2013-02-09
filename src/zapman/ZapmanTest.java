package zapman;

import static org.junit.Assert.*;

import org.junit.Test;

public class ZapmanTest {

	private Zapman jogo = new Zapman();

	@Test
	public void test() {
		assertEquals("C  ", jogo.tela());
		jogo.right();
		assertEquals(" C ", jogo.tela());
	}

}
