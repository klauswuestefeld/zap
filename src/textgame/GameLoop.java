package textgame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Map;

import javax.swing.JFrame;

public class GameLoop {
	
	private final TextGame game;
	private GraphicCanvas canvas;
	private int lastKey;
	
	
	public GameLoop(TextGame game) {
		this(game, null);
	}

	
	public GameLoop(TextGame game, Map<Character, BufferedImage> sprites) {
		this.game = game; 
		initFrame(sprites);
	}


	public void start()  {
		while (true) {
			handleLastKey();
			game.pass();
			refreshGraphics();
			printToConsole();
			waitALittle();
		}
	}
	
	
	private void handleLastKey() {
		if (lastKey == KeyEvent.VK_SPACE) game.space();
		if (lastKey == KeyEvent.VK_UP) game.up();
		if (lastKey == KeyEvent.VK_DOWN) game.down();
		if (lastKey == KeyEvent.VK_LEFT) game.left();
		if (lastKey == KeyEvent.VK_RIGHT) game.right();
		lastKey = 0;
	}


	private void refreshGraphics() {
		canvas.refresh(game.screen());
	}

	
	private void initFrame(Map<Character, BufferedImage> sprites) {
		JFrame frame = new JFrame();
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		canvas = new GraphicCanvas(sprites);
		canvas.setFocusable(true);
		
		frame.add(canvas);
		frame.setVisible(true);
		
		canvas.addKeyListener(new KeyAdapter() { @Override public void keyPressed(KeyEvent e) {
			lastKey = e.getKeyCode();
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
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
