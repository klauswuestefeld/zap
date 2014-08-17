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
			refreshGraphics();
			refreshTitle();
			waitALittle();
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
		adaptSizeTo(game.scene);
		canvas.repaint();
	}


	private void adaptSizeTo(Square[][] screen) {
		if (screen == null) Utils.oops("you must call setScene().");
		Insets insets = frame.getInsets();
		int width = screen[0].length * 40 + insets.left + insets.right;
		int height = screen.length * 40 + insets.top + insets.bottom;
		frame.setSize(width, height);
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
	
	
	private void waitALittle() {
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
