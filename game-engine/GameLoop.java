import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

class GameLoop {
	
	Game game;
	GraphicCanvas canvas;
	int lastKey;
	
	JFrame frame;
	
	
	GameLoop(Game game) {
		this.game = game; 
		initFrame();
	}


	public void start()  {
		while (true) {
			handleLastKey();
//			game.pass();
			printToConsole();
			refreshGraphics();
			refreshTitle();
//			waitALittle();
		}
	}
	
	
	private void refreshTitle() {
		frame.setTitle(game.title());
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
		Square[][] screen = game.scene;
		Insets insets = frame.getInsets();
		int width = screen[0].length * 40 + insets.left + insets.right;
		int height = screen.length * 40 + insets.top + insets.bottom;
		frame.setSize(width, height);
		canvas.repaint();
	}

	
	private void initFrame() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		canvas = new GraphicCanvas(game);
		canvas.setFocusable(true);
		
		frame.add(canvas);
		frame.setVisible(true);
		
		canvas.addKeyListener(new KeyAdapter() { @Override public void keyPressed(KeyEvent e) {
			lastKey = e.getKeyCode();
		}});
	}
	
	
	private void printToConsole() {
		skipLines();
		for (Square[] line : game.scene) {
			for (Square square : line)
				System.out.print(square.character());
			System.out.println();
		}
	}
	
	
	private void skipLines() {
		System.out.println("\n\n\n\n");
	}

	
	@SuppressWarnings("unused")
	private void waitALittle() {
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
