package textgame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Map;

import javax.swing.JFrame;

public class GameLoop {
	
	private final TextGame game;
	private GraphicCanvas canvas;
	
	
	public GameLoop(TextGame game) {
		this(game, null);
	}

	
	public GameLoop(TextGame game, Map<Character, BufferedImage> sprites) {
		this.game = game; 
		initFrame(sprites);
	}


	public void start()  {
		while (true) {
			game.pass();
			refreshGraphics();
			printToConsole();
			waitALittle();
		}
	}
	
	
	private void refreshGraphics() {
		canvas.refresh(game.screen());
	}

	
	private void initFrame(Map<Character, BufferedImage> sprites) {
		JFrame frame = new JFrame();
		frame.setSize(448, 478);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		canvas = new GraphicCanvas(sprites);
		canvas.setFocusable(true);
		
		frame.add(canvas);
		frame.setVisible(true);
		
		canvas.addKeyListener(new KeyAdapter() { @Override public void keyPressed(KeyEvent e) {
			int tecla = e.getKeyCode();
			if (tecla == KeyEvent.VK_SPACE) game.space();
			if (tecla == KeyEvent.VK_UP) game.up();
			if (tecla == KeyEvent.VK_DOWN) game.down();
			if (tecla == KeyEvent.VK_LEFT) game.left();
			if (tecla == KeyEvent.VK_RIGHT) game.right();
		}});
	}
	
	
	private void printToConsole() {
		skipLines();
		for (String line : game.screen()) 
			System.out.println(line);
	}
	
	
	private void skipLines() {
		System.out.println("\n\n\n\n");
	}

	
	private void waitALittle() {
		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}